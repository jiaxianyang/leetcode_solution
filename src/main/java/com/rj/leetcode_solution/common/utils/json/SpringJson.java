package com.rj.leetcode_solution.common.utils.json;

import java.lang.reflect.Type;
import java.util.List;


/**
 * SpringJson简介
 * Json工具类接口定义
 * @author lindong20
 * @date 2020-07-07 18:27
 */
public interface SpringJson {


    /**
     * Json字符串转换为对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T parseObject(String json, Class<T> clazz);


    /**
     * Json对象转泛型对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    <T> T parseObject(String json, Type type);

    /**
     * Json字符串转换为list对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    <T> List<T> parseArray(String json, Class<T> clazz);

    /**
     * 对象转换Json字符串
     *
     * @param object
     * @return
     */
    String toJsonString(Object object);
}
