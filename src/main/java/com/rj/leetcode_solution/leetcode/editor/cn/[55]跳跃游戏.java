//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2217 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:跳跃游戏
class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) {
                return false;
            }
            //能到达最后节点的下标，先赋值成最后一个下标
            int canReachable = nums.length - 1;
            //从后往前找
            for (int i = nums.length - 1; i >= 0; i--) {
                //如果当前节点能够到达，可以到达最后节点的坐标，那么当前节点也可以到达最后坐标
                if (nums[i] + i >= canReachable) {
                    canReachable = i;
                }
            }
            //从后往前，如果最后第0个坐标也是能够到达最后的位置，那么canReachable 为 0
            return canReachable == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
