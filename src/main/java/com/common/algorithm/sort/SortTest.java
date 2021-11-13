package com.common.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        //        int[] arr = {1, 2, 4, 3, 100, 90, 88, 11, 99};
        testSortTime(new QuickSort(), 100000);
        testSortTime(new MergeSort(), 100000);
        testSortTime(new SelectionSort(), 100000);
    }

    private static void testSortTime(ArraySort arraySort, int arrSize) {
        for (int i = 0; i < 100; i++) {
            List<Integer> res = new ArrayList<>(arrSize);
            for (int j = 0; j < arrSize; j++) {
                Random random = new Random();
                res.add(random.nextInt(arrSize));
            }
            int[] arr = res.stream().mapToInt(Integer::valueOf).toArray();
            long start = System.currentTimeMillis();
            arraySort.sortIntArray(arr);
            long end = System.currentTimeMillis();
            System.out.println("elapsed ：" + (end - start) + " millis");
        }
    }
}
