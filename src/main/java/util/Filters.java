package util;

import spark.Request;
import spark.Response;

import static spark.Spark.before;

public class Filters {
    public static void filters() {
        before("/", Filters::verifyUserIsLogged);
        before("/wall", Filters::verifyUserIsLogged);
        before("/album", Filters::verifyUserIsLogged);
    }

    private static void verifyUserIsLogged(Request request, Response response) {
        if (request.session().attribute("currentUser") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect("/register");
        }
    }
}
