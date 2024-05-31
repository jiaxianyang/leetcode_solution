package com.common.algorithm.sort;

import com.common.utils.ArrayUtil;

/**
 * 排序公共方法抽取
 *
 * @author jiaxianyang
 * @date 2024/5/31 22:34
 */
public abstract class ArraySortHandler {

    public void elapsedSortTime(ArraySort arraySort, int arrSize) {
        int[] array = ArrayUtil.randomIntArray(arrSize);
        System.out.println("=============排序前==============");
        for (int j : array) {
            System.out.print(j + " ");
        }
        long start = System.currentTimeMillis();
        arraySort.sortIntArray(array);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("=============排序后==============");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("elapsed ：" + (end - start) + " millis");
    }

    abstract void sortTry();

}
