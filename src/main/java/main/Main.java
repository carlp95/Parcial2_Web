package main;

import dao.DAOImpl;
import entities.User;
import org.jasypt.util.password.BasicPasswordEncryptor;
import util.Filters;
import util.Path;
import util.ViewUtil;
import util.BootStrapServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    // Declare dependencies
    public static DAOImpl<User, String> userDAO;
    public static BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();


    public static void main(String[] args) {

        //Instantiate dependencies
        userDAO = new DAOImpl<>(User.class);

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
        get("/", (request, response) -> ViewUtil.render(request, new HashMap<>(), Path.INDEX));

        get("/wall", (request, response) ->
                ViewUtil.render(request, new HashMap<>(), Path.WALL));

        get("/register", (request, response) -> ViewUtil.render(request, new HashMap<>(), Path.HOME));

        // Serve login
        get("/login", (request, response) ->  ViewUtil.render(request, new HashMap<>(), Path.LOGIN));

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

            response.redirect("/");

            return null;
        });

        post("/logout", (request, response) -> {
            request.session().removeAttribute("currentUser");
            request.session().attribute("loggedOut", true);
            response.redirect(Path.LOGIN);
            return null;
        });

        post("/register",(request,response)->{
           User user = new User();
           BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();
           user.setUsername(request.queryParams("username"));

           user.setPassword(encryptor.encryptPassword(request.queryParams("passwd")));
           user.setName(request.queryParams("personName"));
           user.setLastname(request.queryParams("lastName"));
           user.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.queryParams("born")));
           user.setAdministrator(false);

           userDAO.persist(user);
           response.redirect("/");
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

