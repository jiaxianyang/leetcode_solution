package com.common.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * array N 个组合
 *
 * @author jiaxianyang
 * @date 2025/2/18 21:42
 */
public class PrintArrayNCombine {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int n = 2;
        List<List<Integer>> combinations = findCombinations(array, n);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    private static List<List<Integer>> findCombinations(int[] array, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(array, n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backTrace(int[] array, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < array.length; i++) {
            current.add(array[i]);
            backTrace(array, n, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
