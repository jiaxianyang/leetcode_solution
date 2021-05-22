//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1658 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:爬楼梯
class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
            // 解法1
//        if (n <= 2) {
//            return n;
//        }
//        int first = 1;
//        int second = 2;
//        for (int i = 3; i <= n; i++) {
//            int third = second + first;
//            first = second;
//            second = third;
//        }
//        return second;
            // 解法2
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
