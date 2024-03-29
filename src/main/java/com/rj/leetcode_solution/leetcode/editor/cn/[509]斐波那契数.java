//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//
//
// 给定 n ，请计算 F(n) 。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
//
//
// 示例 2：
//
//
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
//
//
// 示例 3：
//
//
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 30
//
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 654 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:斐波那契数
class P509FibonacciNumber{
    public static void main(String[] args){
        Solution solution = new P509FibonacciNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        //1、最优解
//        if (n < 2) {
//            return n;
//        }
//        int p = 0, q = 0, r = 1;
//        for (int i = 1; i < n; i++) {
//            p = q;
//            q = r;
//            r = p + q;
//        }
//        return r;

        //2、暴力递归, 重复计算，不推荐
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 2);

        //3、带备忘录的递归解法
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

        private int helper(int[] memo, int n) {
            //base case
            if (n == 1 || n == 2) {
                return 1;
            }
            //已经计算过
            if (memo[n] != 0) {
                return memo[n];
            }
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
