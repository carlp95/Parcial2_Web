package main;

import entities.User;
import freemarker.template.Configuration;
import org.jasypt.util.password.BasicPasswordEncryptor;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;
import util.Filters;
import util.Path;
import util.ViewUtil;
import util.BootStrapServices;
import dao.UserDAO;

import javax.swing.text.View;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    // Declare dependencies
    public static UserDAO userDAO;
    public static BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();


    public static void main(String[] args) {

        //Instantiate dependencies
        userDAO = new UserDAO();

        // Configure Spark
        staticFiles.location("/public");
//        staticFiles.expireTime(600L);

        // Launch Database
        BootStrapServices.getInstance().init();
        // Create default admin if needed


        // Creating default user if there are none
        if (userDAO.findAll().isEmpty()) {
            User user = new User("admin", "Escanor", "Castilla",
                    new Date(), encryptor.encryptPassword("admin123"), true);
            userDAO.persist(user);
        }

        // Route filters
        Filters.filters();

        // Handling errors
        notFound(ViewUtil.notFound);
        internalServerError(ViewUtil.internalServerError);

        // Home routes
        get("/", (request, response) -> ViewUtil.render(request, new HashMap<>(), Path.HOME));

        get("/portfolio", (request, response) ->
                ViewUtil.render(request, new HashMap<>(), Path.PORTFOLIO));

        get("/timeline", (request, response) -> ViewUtil.render(request, new HashMap<>(), Path.TIMELINE));

        // Serve login
        get("/login", (request, response) ->
                ViewUtil.render(request, new HashMap<>(), Path.LOGIN));

        // Handle login
        post("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            if (!authenticate(request.queryParams("username"), request.queryParams("password"))) {
                model.put("authenticationFailed", true);

                return ViewUtil.render(request, model, Path.LOGIN);
            }
                model.put("authenticationSucceeded", true);

            request.session().attribute("currentUser", request.queryParams("username"));

            // Si es necesario chekiar si esta logueado antes de una accion esto es util.
            // Cuando verifiques en un filtro que el currentUser == null (osea que el user no esta logueado)
            // Ahi podras guardar en la sesion la direccion de la pagina en la que te encuentras antes de
            // ir a esta pagina de logue y aqui se encargara de devorte luego de loguerte
            if (request.queryParams("loginRedirect") != null) {
                response.redirect(request.queryParams("loginRedirect"));
            }

            return ViewUtil.render(request, model, Path.TIMELINE);
        });

        post("/logout", (request, response) -> {
            request.session().removeAttribute("currentUser");
            request.session().attribute("loggedOut", true);
            response.redirect(Path.LOGIN);
            return null;
        });

    }

    // User Controller
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty())
            return false;

        User user = userDAO.find(username);

        if (user == null) {
            return false;
        }

        return encryptor.checkPassword(password, user.getPassword());
    }

}

