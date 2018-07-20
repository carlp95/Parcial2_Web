package main;

import util.Filters;
import util.ViewUtil;
import util.BootStrapServices;
import dao.UserDAO;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        //Instantiate dependencies
        UserDAO userDAO = new UserDAO();
        BootStrapServices bootStrapServices = new BootStrapServices();

        // Configure Spark
        staticFiles.location("/public");
//        staticFiles.expireTime(600L);

        // Route filters
        Filters.filters();

        // Handling errors
        internalServerError("<html><body><h1 style='color: red'>Custom 500 handling</h1></body></html>");
        notFound("<html><body><h1 style='color: red'>Custom 500 handling</h1></body></html>");

        // Home routes
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Banagreen");
            return ViewUtil.render(model, "home.ftl");
        });

        post("/", (request, response) -> {

            return null
        });
    }
}

