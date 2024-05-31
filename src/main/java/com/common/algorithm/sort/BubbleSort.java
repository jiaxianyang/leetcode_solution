package com.common.algorithm.sort;

/**
 * @author jiaxianyang
 * @date 2024/5/31 20:32
 */
public class BubbleSort extends ArraySortHandler implements ArraySort {

    public static void main(String[] args) {
        new BubbleSort().sortTry();
    }

    @Override
    void sortTry() {
        super.elapsedSortTime(this::sortIntArray, 15);
    }

    @Override
    public void sortIntArray(int[] array) {
        int length = array.length;
        boolean swapped;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, then the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
