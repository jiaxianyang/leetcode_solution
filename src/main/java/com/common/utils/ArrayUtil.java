package com.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ArrayUtil简介
 *
 * @author jiaxianyang
 * @date 2021-11-15 12:44
 */
public class ArrayUtil {

    /**
     *
     * 私有构造器
     */
    private ArrayUtil() {
    }

    private static final   Random random = new Random();
    /**
     * 生成随机数组
     *
     * @param arrSize 大小
     * @return 数组
     */
    public static int[] randomIntArray(int arrSize) {
        List<Integer> res = new ArrayList<>(arrSize);

        for (int j = 0; j < arrSize; j++) {
            res.add(random.nextInt(100));
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
