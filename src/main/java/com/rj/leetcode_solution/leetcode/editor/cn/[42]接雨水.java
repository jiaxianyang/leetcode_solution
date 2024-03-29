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

import java.util.ArrayDeque;
import java.util.Deque;

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
//            return trapMethod2(height);
            //3.栈应用
//            return trapMethod3(height);
            //4.双指针
            return trapMethod4(height);
        }

        /**
         * 4.双指针
         * 解法详解：
         * leftMax: 左边的最大值，它是从左往右遍历找到的
         * rightMax: 右边的最大值，它是从右往左遍历找到的
         * left: 从左往右处理的当前下标
         * right: 从右往左处理的当前下表
         * <p>
         * 定理1：在某个位置i处，它能存的水，取决于它左右俩边最大值中较小的一个。
         * 定理2：当我们从左往右处理left下标时，左边的最大值leftMax是可信的，但rightMax对它而言是不可信的。(由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值)
         * 定理3：当我们从右往左处理right下标时，右边的最大值rightMax是可信的，但是leftMax对它而言是不可信的。
         * <p>
         * 对于left而言，它左边的最大值一定是leftMax，右边的最大值>= rigthMax, 如果leftMax < rightMax 成立，那么就可以确定当前坐标能存多少水了。无论右边将来会不会出现更大的rightMax，
         * 都不影响结果。所以当leftMax < rightMax 时，我们就希望去处理left下标，反之，我们希望去处理right下标
         */
        private int trapMethod4(int[] height) {
//            双指针1. 由leftMax与rightMax 决定从左还是右侧开始遍历计算面积
            int left = 0;
            int right = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            int ans = 0;
            while (left <= right) {
                // 左边最大高度小于右边最大高度，左最大高度可靠，可以计算左边的当前i的装水量
                if (leftMax < rightMax) {
                    if (leftMax < height[left]) {
                        //当前下标的高度大于左边界的最大高度，更新leftMax，不能装水
                        leftMax = height[left];
                    } else {
                        ans += leftMax - height[left];
                    }
                    left++;
                } else {
                    //右边最大高度小于左边最大高度，所以右侧最大高度可靠，计算计算当前右侧i的装水量
                    if (rightMax < height[right]) {
                        //当前下标的高度大右边界的最大高度，更新rightMax，不能装水
                        rightMax = height[right];
                    } else {
                        ans += rightMax - height[right];
                    }
                    right--;
                }
            }
            return ans;
        }

        /**
         * 3. 栈应用，后面的柱子高与前面的柱子才能计算出当前柱子是否能够盛水，所以能够想到用栈
         */
        private int trapMethod3(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0;
            int ans = 0;
            while (i < height.length) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int distance = i - stack.peek() - 1;
                    int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                    ans += distance * boundedHeight;
                }
                stack.push(i++);
            }
            return ans;
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
