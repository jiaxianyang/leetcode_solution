package com.common.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 题目描述：
 * 在一个递增的二维数组中查找某个数字的位置是一个经典的问题。
 * 假设你有一个二维数组，其中每行和每列都是递增的（即每行中的元素从左到右递增，每列中的元素从上到下递增），
 * 可以使用一种高效的算法来查找目标数字的位置。
 * <p>
 * 算法思路：
 * 从数组的右上角开始查找：
 * <p>
 * 1、如果当前元素等于目标值，则返回其位置。
 * 2、 如果当前元素大于目标值，则移动到左边一列。
 * 3、如果当前元素小于目标值，则移动到下一行。
 * 这种方法的时间复杂度是 O(m + n)，其中 m 是行数，n 是列数。
 *
 * @author jiaxianyang
 * @date 2024/5/8 16:43
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = buildSorted2DArray();
        int target = 11;
        int[] result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found at position: [" + result[0] + ", " + result[1] + "]");
    }

    /**
     * 算法思路：
     * 从数组的右上角开始查找：
     * <p>
     * 1、如果当前元素等于目标值，则返回其位置。
     * 2、 如果当前元素大于目标值，则移动到左边一列。
     * 3、如果当前元素小于目标值，则移动到下一行。
     * 这种方法的时间复杂度是 O(m + n)，其中 m 是行数，n 是列数。
     */
    private static int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 使用多种方式构建二维数组，增强薄弱点
     *
     * @return 构建二维数组
     */
    private static int[][] buildSorted2DArray() {
        // 1、
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 10},
                {21, 22, 23, 24, 25}
        };

        // 2、
        int rows = 5;
        int cols = 5;
        int[][] matrix2 = new int[5][5];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = i * cols + j + 1;
            }
        }
        //3、java 8 流
//        int[][] matrix3 = IntStream.range(0, rows)
//                .mapToObj(i -> new int[cols])
//                .toArray(int[][]::new);

        // 使用 Java 8 流创建并初始化二维数组
        int[][] matrix3 = IntStream.range(0, rows)
                .mapToObj(i -> IntStream.range(0, cols)
                        .map(j -> i * cols + j + 1)
                        .toArray())
                .toArray(int[][]::new);

        //4、使用ArrayList 模拟二维数组
        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(i * cols + j + 1);
            }
            array.add(row);
        }

        return matrix;
    }

}