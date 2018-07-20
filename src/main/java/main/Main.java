package main;

import entities.User;
import freemarker.template.Configuration;
import org.jasypt.util.password.BasicPasswordEncryptor;
import spark.template.freemarker.FreeMarkerEngine;
import util.Filters;
import util.ViewUtil;
import util.BootStrapServices;
import dao.UserDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    // Declare dependencies
    public static UserDAO userDAO;

    public static void main(String[] args) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
        configuration.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freemarkerEngine = new FreeMarkerEngine(configuration);
        //Instantiate dependencies
        userDAO = new UserDAO();

        // Configure Spark
        staticFiles.location("/public");
//        staticFiles.expireTime(600L);

        // Launch Database
        BootStrapServices.getInstance().init();
        // Create default admin if needed
        BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();

        // Creating default user if there are none
        if (userDAO.findAll().isEmpty()) {
            User user = new User("admin", "Godin", "God",
                    new Date(), encryptor.encryptPassword("admin123"), true);
            userDAO.persist(user);
        }

        // Route filters
        Filters.filters();

        // Handling errors
        internalServerError("<html><body><h1 style='color: red'>Custom 500 handling</h1></body></html>");
        notFound("<html><body><h1 style='color: red'>Custom 500 handling</h1></body></html>");

        // Home routes
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Banagreen");
            return modelAndView(model, "/HomePage/home.ftl");
        }, freemarkerEngine);

    }
}

