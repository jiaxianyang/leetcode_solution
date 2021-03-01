package com.rj.leetcode_solution.leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3004 👎 0


import java.util.*;

// 1. 暴力求解 三重循环
// 2. hash表来记录 a, b a + b =  -c
// 3.
//leetcode submit region begin(Prohibit modification and deletion)
class SolutionT15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //1 . 暴力
//        if (nums == null || nums.length < 3)
//            return new ArrayList<>();
//
//        Set<List<Integer>> setResult = new HashSet<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
//                        Collections.sort(temp);
//                        setResult.add(temp);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(setResult);
//
//        if (nums == null || nums.length < 3)
//            return new ArrayList<>();
//
//        Set<List<Integer>> res = new HashSet<>();
//
//        Arrays.sort(nums); // O(nlogn)
//
//        // O(n^3)
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(res);
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
