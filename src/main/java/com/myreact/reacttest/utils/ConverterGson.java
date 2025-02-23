package com.myreact.reacttest.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConverterGson {
    public static <T> T cloneThroughJson(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return (T) gson.fromJson(json, t.getClass());
    }

    public static <T> T converterJsonToObject(String stringJson, T t) {
        return new Gson()
                .fromJson(stringJson, new TypeToken<T>() {}.getType());
    }
}
