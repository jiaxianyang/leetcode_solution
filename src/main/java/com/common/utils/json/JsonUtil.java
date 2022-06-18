package com.common.utils.json;

import java.util.List;

/**
 * JsonUtil简介
 * Json工具类，支持：
 * 1.Json字符串转换为对象
 * 2.Json对象转泛型对象
 * 3.对象转换Json字符串
 * 4.Json字符串转换为list对象
 * @author lindong20
 * @date 2020-07-07 18:27
 */
public final class JsonUtil {
    /**
     * springJson
     */
    private static SpringJson springJson;

    static {
          springJson = new JacksonImpl();
        //  springJson= new GsonImpl();
    }

    /**
     * Json字符串转换为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        return springJson.parseObject(json, clazz);
    }


    /**
     * Json对象转泛型对象
     * @param json
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String json, TypeReference typeReference) {
        return springJson.parseObject(json, typeReference.getType());
    }


    /**
     * 对象转换Json字符串
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        return springJson.toJsonString(object);
    }

    /**
     * Json字符串转换为list对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return springJson.parseArray(json, clazz);
    }
}
