package com.common.algorithm.sort;

import com.common.utils.ArrayUtil;

/**
 * QuickSort简介
 * <p>
 * 快速排序
 *
 * @author jiaxianyang
 * @date 2021-11-10 13:12
 */
public class QuickSort implements ArraySort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.randomIntArray(15);
        System.out.println("=============排序前==============");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
        quickSort(array, 0, array.length - 1);
        System.out.println("=============排序后==============");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    /**
     * 快速排序也是分治的思想，每个元素的左边都是小于当前元素，右侧都是大于当前元素，那么这个数组自然是有序的
     *
     * @param arr   数组
     * @param begin 起始位置
     * @param end   末端位置
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    /**
     * 1.取标杆位置，标杆左边的元素都小于标杆元素，标杆右侧的元素都大于标杆元素
     * 2.最后返回标杆标杆的位置
     *
     * @param arr   数组
     * @param begin 起始位置
     * @param end   末端位置
     * @return 标杆的位置
     */
    private static int partition(int[] arr, int begin, int end) {
        //pivot 标杆位置 ，counter: 小于pivot的元素的个数
        int pivot = end;
        //小于标杆的坐标
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        //counter位置左边都是小于arr[pivot]， 右边都是大于 arr[pivot]， 将arr[pivot] 互换 arr[counter]， counter就是新计算出来的标杆位置
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }

    @Override
    public void sortIntArray(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
