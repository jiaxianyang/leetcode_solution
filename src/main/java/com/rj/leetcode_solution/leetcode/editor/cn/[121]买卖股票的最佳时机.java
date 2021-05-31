//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1645 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:买卖股票的最佳时机
class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            //1. 暴力
//            int maxprofit = 0;
//            for (int i = 0; i < prices.length - 1; i++) {
//                for (int j = i + 1; j < prices.length; j++) {
//                    int profit = prices[j] - prices[i];
//                    if (profit > maxprofit) {
//                        maxprofit = profit;
//                    }
//                }
//            }
//            return maxprofit;

            //2. 一次遍历 假设我们在弟 i 天卖股票，利润最大肯定是 在前面所有天价格最便宜的时候买入。
//            int minPrice = Integer.MAX_VALUE;
//            int maxProfit = 0;
//            for (int i = 0; i < prices.length; i++) {
//                //获取前面i 天的，价格最便宜的一天
//                if (prices[i] < minPrice) {
//                    minPrice = prices[i];
//                    //比较每一天的利润
//                } else if (prices[i] - minPrice > maxProfit) {
//                    maxProfit = prices[i] - minPrice;
//                }
//            }
//            return maxProfit;

            //3. 动态规划

            int length = prices.length;
            if (length < 2) {
                return 0;
            }
            int[][] dp = new int[length][2];

            //dp[i][0]：规定了今天不持股，有以下两种情况：
                //昨天不持股，今天什么都不做；
                //昨天持股，今天卖出股票（现金数增加），

            //dp[i][1]：规定了今天持股，有以下两种情况：
                  //昨天持股，今天什么都不做（现金数与昨天一样）；
                  //昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。

//            dp[i][0] 下标为 i 这天结束的时候， 不持股，手上拥有的现金数
//            dp[i][1] 下标为 i 这天结束的时候， 持股，手上拥有的现金数

            //初始化：不持股显然为0 ，持股就需要减去第一天（下标为 0）的股价
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            //从第2天开始便利
            for (int i = 1; i < length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
