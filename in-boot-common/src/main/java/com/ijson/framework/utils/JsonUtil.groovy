package com.ijson.framework.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import org.apache.commons.io.IOUtils

import java.lang.reflect.Type

/**
 * desc:
 * version: 6.7
 * Created by cuiyongxu on 2019/10/31 12:25 AM
 */
class JsonUtil {

    private static Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, (JsonSerializer<Double>) { src, typeOfSrc, context ->
                if (src == src.longValue())
                    return new JsonPrimitive(src.longValue());
                return new JsonPrimitive(src);
            }).create();

    private static Gson withNullGson = new GsonBuilder().serializeNulls().
            registerTypeAdapter(Double.class, (JsonSerializer<Double>) { src, typeOfSrc, context ->
                if (src == src.longValue())
                    return new JsonPrimitive(src.longValue());
                return new JsonPrimitive(src);
            }).create();

    private static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

    static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    static String toPrettyJson(Object obj) {
        return prettyGson.toJson(obj);
    }

    static String toJsonWithNull(Object obj) {
        return withNullGson.toJson(obj);
    }

    static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }


    static <T> T fromFile(String file, Class<T> clazz) throws IOException {
        return fromJson(
                IOUtils.toString(JsonUtil.class.getClassLoader().getResourceAsStream(file))
                , clazz);
    }

    static <T> T fromJson(String json, Type clazz) {
        return gson.fromJson(json, clazz);
    }
}
