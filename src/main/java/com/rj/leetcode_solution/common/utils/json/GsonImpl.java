package com.rj.leetcode_solution.common.utils.json;


import com.google.gson.*;
import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * GsonImpl简介
 * Gson实现JSON处理
 *
 * @author lindong20
 * @date 2020-07-07 17:44
 */
class GsonImpl implements SpringJson {

    /**
     * gson 对象
     */
    private Gson gson;

    /**
     * Gson初始化
     * 1.日期时间格式化
     * 2.允许null值输出
     */
    public GsonImpl() {
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                    @Override
                    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                        return  new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    }
                })
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    }
                })
                .setDateFormat("yyyy-MM-dd HH:mm:ss")//日期时间格式
                .serializeNulls()//null值输出
                .create();
    }

    @Override
    public <T> T parseObject(String json, Class<T> clazz) {
        T t = gson.fromJson(json, clazz);
        return t;
    }

    @Override
    public <T> T parseObject(String json, Type type) {
        T t = gson.fromJson(json, type);
        return t;
    }

    @Override
    public <T> List<T> parseArray(String json, Class<T> clazz) {
        Type type = $Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, clazz);
        List<T> list = gson.fromJson(json, type);
        return list;
    }

    @Override
    public String toJsonString(Object object) {
        String gsonString = gson.toJson(object);
        return gsonString;
    }
}