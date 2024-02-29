//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2931 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:打家劫舍
class P198HouseRobber{
    public static void main(String[] args){
        Solution solution = new P198HouseRobber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    //滚动数组 + 动态规划
//        public int rob(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return 0;
//            }
//            int length = nums.length;
//            if (length == 1) {
//                return nums[0];
//            }
//            int first = nums[0], second = Math.max(nums[0], nums[1]);
//            for (int i = 2; i < length; i++) {
//                int temp = second;
//                second = Math.max(first + nums[i], second);
//                first = temp;
//            }
//            return second;
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}