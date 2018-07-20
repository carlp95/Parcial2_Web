package util;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

public class ViewUtil {

    public static String render(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }
}
