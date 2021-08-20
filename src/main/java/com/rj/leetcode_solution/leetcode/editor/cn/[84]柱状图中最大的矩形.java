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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
//            int length = heights.length;
//            int ans = 0;
//            for (int left = 0; left < length; left++) {
//                int minHeight = Integer.MAX_VALUE;
//                for (int right = left; right < length; right++) {
//                    minHeight = Math.min(minHeight, heights[right]);
//                    ans = Math.max(ans, (right - left + 1) * minHeight);
//                }
//            }
//            return ans;


//            2. 暴力方法： 枚举高度
//            int length = heights.length;
//            int ans = 0;
//            for (int mid = 0; mid < length; mid++) {
//                //枚举高
//                int height = heights[mid];
//                int left = mid;
//                int right = mid;
//                //确定左右边界
//                while (left - 1 >= 0 && heights[left - 1] >= height) {
//                    --left;
//                }
//                while (right + 1 < length && heights[right + 1] >= height) {
//                    ++right;
//                }
//                ans = Math.max(ans, (right - left + 1) * height);
//            }
//            return ans;

            //3.单调栈
//            int len = heights.length;
//            if (len == 0) {
//                return 0;
//            }
//            if (len == 1) {
//                return heights[0];
//            }
//            int area = 0;
//            Deque<Integer> stack = new ArrayDeque<>();
//            for (int i = 0; i < len; i++) {
//                while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
//                    int height = heights[stack.removeLast()];
//                    while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
//                        stack.removeLast();
//                    }
//                    int width;
//                    if (stack.isEmpty()) {
//                        width = i;
//                    } else {
//                        width = i - stack.peekLast() - 1;
//                    }
//                    area = Math.max(area, width * height);
//                }
//                stack.addLast(i);
//            }
//
//            while (!stack.isEmpty()) {
//                int height = heights[stack.removeLast()];
//                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
//                    stack.removeLast();
//                }
//                int width;
//                if (stack.isEmpty()) {
//                    width = len;
//                } else {
//                    width = len - stack.peekLast() - 1;
//                }
//                area = Math.max(area, width * height);
//            }
//            return area;

            //4 单调栈，哨兵，空间换时间
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return heights[0];
            }
            int[] newHeights = new int[len + 2];
            for (int i = 0; i < len; i++) {
                newHeights[i + 1] = heights[i];
            }
            len += 2;
            heights = newHeights;
            int area = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addLast(0);
            for (int i = 1; i < len; i++) {
                while (heights[stack.peekLast()] > heights[i]) {
                    int height = heights[stack.removeLast()];
                    int width = i - stack.peekLast() - 1;
                    area = Math.max(area, width * height);
                }
                stack.addLast(i);
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
