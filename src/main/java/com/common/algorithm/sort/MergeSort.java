package com.common.algorithm.sort;

/**
 * MergeSort简介
 * <p>
 * 归并排序- 分治
 * 1、把长度为n的输入序列分成俩个长度为n/2的子序列
 * 2、对这俩个子序列分别采取归并排序
 * 3、将俩个排序好的子序列合并成一个最终的排序序列
 *
 * 归并 和 快排具有相似性，但步骤顺序相反
 * 归并：先排序左右子数组，然后合并俩个有序子数组
 * 快排：先调配出左右子数组，然后对于左右子数据进行排序。
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
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        mergeArray(array, left, mid, right);
    }

    private static void mergeArray(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k  = 0;
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
        System.arraycopy(temp, 0, array, left, temp.length);
    }

    @Override
    public void sortIntArray(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}
