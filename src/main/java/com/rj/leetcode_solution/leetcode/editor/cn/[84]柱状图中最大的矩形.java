//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 Monotonic Stack 
// 👍 1410 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:柱状图中最大的矩形
class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        int[] heights = new int[]{2,1,5,6,2,3};
        int area = solution.largestRectangleArea(heights);
        System.out.println(area);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
//            1. 暴力方法 ： 枚举宽度
            int length = heights.length;
            int ans = 0;
            //枚举左边界
            for (int left = 0; left < length - 1; left++) {
                int minHeight = Integer.MAX_VALUE;
                //枚举右边界
                for (int right = left + 1; right < length; right++) {
                    //确定高度
                    minHeight = Math.min(minHeight, heights[right]);
                    //计算面积
                    ans = Math.max(ans, (right - left) * minHeight);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
