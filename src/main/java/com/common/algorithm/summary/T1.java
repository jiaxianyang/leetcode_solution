package com.common.algorithm.summary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1 {
    public static void main(String[] args) {
       int[] arr = {5,7,1,1,7,7,6,6};
        int k = 2;
        System.out.println(calaluete(arr, 2));
    }

    public static int calaluete(int[] nums,int k) {
        Map<Integer, Integer> countSumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countSumMap.containsKey(nums[i])) {
                countSumMap.put(nums[i], 1);
            } else {
                Integer count = countSumMap.get(nums[i]);
                countSumMap.put(nums[i], ++count);
            }
        }

        int[] a = new int[countSumMap.size()];
        int index = 0;
        for (Integer value : countSumMap.values()) {
           a[index++] = value;
        }

        Arrays.sort(a);

        int revomeValue = 0;
        for (int av : a) {
            int i = k - av;
            if (i > 0) {
                revomeValue++;
            }
        }

        return countSumMap.size() - revomeValue;
    }
}
