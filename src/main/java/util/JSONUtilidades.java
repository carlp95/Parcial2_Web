package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class JSONUtilidades {
    private static Gson gson = new GsonBuilder().serializeNulls().create();
    public static String toJson(Object object){ return gson.toJson(object);}
    public static ResponseTransformer json(){ return JSONUtilidades::toJson; }
}
