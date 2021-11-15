package com.common.algorithm.sort;

import com.common.utils.ArrayUtil;

public class SortTest {
    public static void main(String[] args) {
        //        int[] arr = {1, 2, 4, 3, 100, 90, 88, 11, 99};
        testSortTime(new QuickSort(), 100000);
        testSortTime(new MergeSort(), 100000);
        testSortTime(new SelectionSort(), 100000);
    }

    private static void testSortTime(ArraySort arraySort, int arrSize) {
        for (int i = 0; i < 100; i++) {
            int[] arr = ArrayUtil.randomIntArray(arrSize);
            long start = System.currentTimeMillis();
            arraySort.sortIntArray(arr);
            long end = System.currentTimeMillis();
            System.out.println("elapsed ：" + (end - start) + " millis");
        }
    }
}
