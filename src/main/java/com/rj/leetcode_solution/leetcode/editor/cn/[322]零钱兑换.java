//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2316 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.Arrays;

//java:零钱兑换
class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();

        int minCoin = solution.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(minCoin);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        f(n)= min{f(n-k),for kin[1，2，5]})+ 1
        public int coinChange(int[] coins, int amount) {
            //动态规划类似爬楼梯  f(n)= min{f(n-k),for kin[1，2，5]})+ 1
            //当前值 肯定是从 减去 conins 中 任意值 得来的,把当前硬币加进来 再 + 1
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
//
//            int[] dp = new int[amount + 1];
//            for (int i = 1; i <= amount; i++) {
//                dp[i] = -1;
//            }
//            for (int i = 1; i <= amount; i++) {
//                for (int coin : coins) {
//                    if (i < coin) continue;
//                    if (dp[i - coin] == - 1) continue;
//                    if (dp[i] == - 1 || dp[i] > dp[i - coin] + 1) dp[i] = dp[i - coin] + 1;
//                }
//            }
//            return dp[amount];
        }

//        public int coinChange(int[] coins, int amount) {
//            if (amount < 1) {
//                return 0;
//            }
//            return coinChange(coins, amount, new int[amount]);
//        }
//
//        private int coinChange(int[] coins, int rem, int[] count) {
//            if (rem < 0) {
//                return -1;
//            }
//            if (rem == 0) {
//                return 0;
//            }
//            if (count[rem - 1] != 0) {
//                return count[rem - 1];
//            }
//            int min = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                int res = coinChange(coins, rem - coin, count);
//                if (res >= 0 && res < min) {
//                    min = 1 + res;
//                }
//            }
//            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//            return count[rem - 1];
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
