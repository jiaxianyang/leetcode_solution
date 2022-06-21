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
import java.util.List;

//java:全排列
class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //方法 2 深度优先
        public List<List<Integer>> permute(int[] nums) {
            //首先是特判
            int len = nums.length;
            //使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();
            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         List<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                // 3、不用拷贝，因为每一层传递下来的path 变量都是新建的
                res.add(path);
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    //1、每一次尝试都创建新的变量标识当前的"状态"
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nums[i]);
                    boolean[] newUsed = new boolean[len];
                    System.arraycopy(used, 0, newUsed, 0, len);
                    newUsed[i] = true;
                    dfs(nums, len, depth + 1, newPath, newUsed, res);
                }
            }
        }


        //方法 1 官方题解
//        public List<List<Integer>> permute(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            List<Integer> output = new ArrayList<>();
//            for (int num : nums) {
//                output.add(num);
//            }
//            int length = nums.length;
//            backTrack(length, output, 0, res);
//            return res;
//        }
//
//        private void backTrack(int length, List<Integer> output, int begin, List<List<Integer>> res) {
//            //所有数都填完了
//            if (begin == length) {
//                res.add(new ArrayList<>(output));
//            }
//            for (int i = begin; i < length; i++) {
//                //维护动态数组
//                Collections.swap(output, begin, i);
//                //继续递归填下一个数
//                backTrack(length, output, begin + 1, res);
//                //撤销操作
//                Collections.swap(output, begin, i);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
