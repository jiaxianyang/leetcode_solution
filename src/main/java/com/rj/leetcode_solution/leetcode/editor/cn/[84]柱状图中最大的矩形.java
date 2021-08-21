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

//java:柱状图中最大的矩形
class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int area = solution.largestRectangleArea(heights);
        System.out.println(area);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            //1. 暴力方法：枚举宽度
//            int len = heights.length;
//            int area = 0;
//            for (int left = 0; left < len; left++) {
//                //从左开始从新计算最小高度
//                int minHeight = Integer.MAX_VALUE;
//                for (int right = left; right < len; right++) {
//                    minHeight = Math.min(minHeight, heights[right]);
//                    area = Math.max(area, (right - left + 1) * minHeight);
//                }
//            }
//            return area;

//======================================================================================================================

            //2.暴力方法： 枚举高度
//            int len = heights.length;
//            int area = 0;
//            for (int mid = 0; mid < len; mid++) {
//                //枚举高
//                int height = heights[mid];
//                int left = mid;
//                int right = mid;
//                //确定左右边界
//                while (left - 1 >= 0 && heights[left - 1] >= height) {
//                    --left;
//                }
//                while (right + 1 < len && heights[right + 1] >= height) {
//                    ++right;
//                }
//                area = Math.max(area, (right - left + 1) * height);
//            }
//            return area;

//======================================================================================================================

            //3 思路：后面的柱状图能够先前面的柱状图先算出面积，满足后进先出 想到用使用栈 Stack
//            int len = heights.length;
//            if (len == 0) {
//                return 0;
//            }
//            if (len == 1) {
//                return heights[0];
//            }
//            int area = 0;
//            //java 推荐stack 使用 ArrayDeque
//            Deque<Integer> stack = new ArrayDeque<>();
//            for (int i = 0; i < len; i++) {
//                //栈顶元素高度大于新栈顶元素， 可计算出面积
//                while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
//                    int height = heights[stack.removeLast()];
//                    //前面有相同高度的柱子
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
//            //如果栈非空
//            while (!stack.isEmpty()) {
//                int height = heights[stack.removeLast()];
//                //前面有相同高度的柱子
//                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
//                    stack.removeLast();
//                }
//                int width;
//                if (stack.isEmpty()) {
//                    //高度最低的元素
//                    width = len;
//                } else {
//                    //当前被remove的元素，到后面柱形图没有比它高度低的故用len
//                    width = len - stack.peekLast() - 1;
//                }
//                area = Math.max(area, width * height);
//            }
//            return area;

//======================================================================================================================
            //4.单调栈优化、哨兵(去除空判断，优化代码)、空间换时间
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
            //java 推荐stack 使用 ArrayDeque
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addLast(0);
            for (int i = 1; i < len; i++) {
                //栈顶元素高度大于新栈顶元素， 可计算出面积
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
