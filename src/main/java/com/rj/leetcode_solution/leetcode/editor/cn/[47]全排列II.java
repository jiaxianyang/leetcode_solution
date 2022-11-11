//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1102 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:全排列 II
class P47PermutationsIi{
    public static void main(String[] args){
        Solution solution = new P47PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> perm = new ArrayList<>();
            boolean[] vis = new boolean[nums.length];
            Arrays.sort(nums);
            backTrack(nums, ans, 0, perm, vis);
            return ans;
        }

        private void backTrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm, boolean[] vis) {
            if (idx == nums.length) {
                ans.add(new ArrayList<>(perm));
            }
            for (int i = 0; i < nums.length; i++) {
                //当前索引已经填充到排列中 或者 当前节点和前一个节点相同并且前一个节点没有填充到排列中（前一个节点和当前节点相同，并且前一个节点 已经试过 vis[i] = false）
                if (vis[i] || (i > 0 && nums[i - 1] == nums[i] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backTrack(nums, ans, idx + 1, perm, vis);
                //前一个节点为已经试用过为false
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
