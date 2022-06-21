//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2076 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:全排列
class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> output = new ArrayList<>();
            for (int num : nums) {
                output.add(num);
            }
            int length = nums.length;
            backTrack(length, output, 0, res);
            return res;
        }

        private void backTrack(int length, List<Integer> output, int begin, List<List<Integer>> res) {
            //所有数都填完了
            if (begin == length) {
                res.add(new ArrayList<>(output));
            }
            for (int i = begin; i < length; i++) {
                //维护动态数组
                Collections.swap(output, begin, i);
                //继续递归填下一个数
                backTrack(length, output, begin + 1, res);
                //撤销操作
                Collections.swap(output, begin, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
