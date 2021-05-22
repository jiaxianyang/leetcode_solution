//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
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
// 👍 3363 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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

            //暴力2
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

            //双指针
//        if (nums == null || nums.length < 3) {
//            return new ArrayList<>();
//        }
//
//        Set<List<Integer>> res = new HashSet<>();
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = - nums[i];
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int sum = nums[left] + nums[right];
//                if (sum == target) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    left++;
//                    right--;
//                } else if (sum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return new ArrayList<>(res);
            // 双指针 优化版本
//        if (nums == null || nums.length < 3) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            int target = -nums[i];
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int sum = nums[left] + nums[right];
//                if (target == sum) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//
//                    while (left < right && nums[left] == nums[++left]) ;
//                    while (left < right && nums[right] == nums[--right]) ;
//                } else if (sum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//
//        }
//        return res;

            //双指针优化1
            if (nums == null || nums.length < 3) {
                return new ArrayList<>();
            }

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (target == sum) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
