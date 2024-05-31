package com.common.algorithm.sort;

/**
 * MergeSort简介
 * <p>
 * 归并排序
 *
 * @author jiaxianyang
 * @date 2021-11-12 11:39
 */
public class MergeSort extends ArraySortHandler implements ArraySort {

    public static void main(String[] args) {
        new MergeSort().sortTry();
    }

    @Override
    void sortTry() {
        super.elapsedSortTime(this::sortIntArray, 15);
    }


    /**
     * 归并排序
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1; // (left + right) / 2
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
//        for (int l = 0; l < temp.length; l++) {
//            array[left + l] = temp[l];
//        }
        //jdk 提供的数组copy
        System.arraycopy(temp, 0, array, left, temp.length);
    }

    @Override
    public void sortIntArray(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}
