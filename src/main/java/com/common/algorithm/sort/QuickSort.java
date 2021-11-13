package com.common.algorithm.sort;

/**
 * QuickSort简介
 *
 * 快速排序
 * @author jiaxianyang
 * @date 2021-11-10 13:12
 */
public class QuickSort implements ArraySort {

    public static void quickSort(int[] arr,int begin,int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        //pivot 标杆位置 ，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter]; arr[counter] = arr[i]; arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot]; arr[pivot] = arr[counter]; arr[counter] = temp;
        return counter;
    }

    @Override
    public void sortIntArray(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
