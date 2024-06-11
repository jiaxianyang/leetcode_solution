package com.common.utils;

import java.util.ArrayList;

/**
 * List工具类
 *
 * @author jiaxianyang
 * @date 2024/6/11 15:28
 */
public class ListUtils {

    //forbid instance
    private ListUtils() {
    }

    // 获取 ArrayList 的容量（通过反射）
    public static int getCapacity(ArrayList<?> list) {
        try {
            java.lang.reflect.Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(list);
            return elementData.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
