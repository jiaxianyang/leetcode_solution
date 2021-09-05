//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2634 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:接雨水
class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = solution.trap(height);
        System.out.println(trap);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            //1. 暴力法，当前坐标的装水量获取，左边界最大值，右边界最大值 取俩边最小值，来确定当前柱子能装的水量
//            return trapMethod1(height);
            //2. 动态规划：暴力法，每次都要从新计算左边界、右边界的最大值，存在重复计算，我们是否可以缓存起来
            return trapMethod2(height);
            //3.栈应用
        }

        /**
         * 1. 暴力法，当前坐标的装水量获取，左边界最大值，右边界最大值 取俩边最小值，来确定当前柱子能装的水量
         */
        private int trapMethod1(int[] height) {
            int ans = 0;
            int size = height.length;
            for (int i = 1; i < size - 1; i++) {
                int maxLeft = 0;
                int maxRight = 0;
                //获取左边的最大值, 从i开始，如果左边没有大于当前柱子，那么计算的装水体积为0
                for (int j = i; j >= 0; j--) {
                    maxLeft = Math.max(maxLeft, height[j]);
                }
                //获取右边的最大值, 从i开始, 如果右边没有柱子高度没有大于当前柱子的，那么计算出的装水体积为0
                for (int j = i; j < size; j++) {
                    maxRight = Math.max(maxRight, height[j]);
                }
                ans += Math.min(maxLeft, maxRight) - height[i];
            }
            return ans;
        }

        /**
         * 2. 动态规划：暴力法，每次都要从新计算左边界、右边界的最大值，存在重复计算，我们是否可以缓存起来
         */
        private int trapMethod2(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int ans = 0;
            int length = height.length;
            //存储左边界最大高度数组
            int[] leftMaxArr = new int[length];
            //存储右边界最大高度数据
            int[] rightMaxArr = new int[length];
            //左边界的最大值，当前柱子高度与左边--,位置的高度进行比较，计算每一个位置的最大柱子高度
            leftMaxArr[0] = height[0];
            for (int i = 1; i < length; i++) {
                leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
            }
            //右边界的最大值，当前柱子高度与右边++,位置的高度进行比较，计算每一个位置的最大柱子高度
            rightMaxArr[length - 1] = height[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
            }
            //利用缓存后的左右边界的最大高度，可以计算每一个位置的存储水的体积，进而计算出总的装水的体积
            for (int i = 0; i < length; i++) {
                ans += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
