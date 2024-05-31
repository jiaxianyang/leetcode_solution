package com.common.algorithm.sort;

/**
 * SelectionSort简介
 * <p>
 * 选择排序
 *
 * @author jiaxianyang
 * @date 2021-11-12 15:52
 */
public class SelectionSort extends ArraySortHandler implements ArraySort {

    public static void main(String[] args) {
        new SelectionSort().sortTry();
    }

    @Override
    void sortTry() {
        super.elapsedSortTime(this::sortIntArray, 15);
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    @Override
    public void sortIntArray(int[] array) {
        selectionSort(array);
    }

//
//    public void  test9(){
//        int[] array = { 20, 38, 39, 90, 57 };
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if(array[i] > array[j]) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(array));
//    }
}
