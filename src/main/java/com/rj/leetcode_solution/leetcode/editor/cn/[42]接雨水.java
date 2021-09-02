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
class P42TrappingRainWater{
    public static void main(String[] args){
        Solution solution = new P42TrappingRainWater().new Solution();
        int[] height = new int[]{2, 4, 0, 3, 2, 5};
        int trap = solution.trap(height);
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //1. 暴力法，当前坐标的装水量，左边界最大值，右边界做大值中 最小值，来确定所能装的谁
//        int ans = 0;
//        int size = height.length;
//        for (int i = 1; i < size - 1; i++) {
//            int max_left = 0, max_right = 0;
//            for (int j = i; j >= 0; j--) {
//                max_left = Math.max(max_left, height[j]);
//            }
//            for (int j = i; j < size; j++) {
//                max_right = Math.max(max_right, height[j]);
//            }
//            ans += Math.min(max_left, max_right) - height[i];
//        }
//        return ans;

        //2. 动态规划 暴力法，每次都要从新计算左面和右面最高的柱子，是否可以计算出来
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMaxArr = new int[size];
        int[] rightMaxArr = new int[size];
        leftMaxArr[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }
        rightMaxArr[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
