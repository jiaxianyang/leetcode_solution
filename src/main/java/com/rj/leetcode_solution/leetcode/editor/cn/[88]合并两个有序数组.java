//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 967 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.Arrays;

//java:合并两个有序数组
class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //1.时间复杂度暴力
//            for (int i = 0; i < n; i++) {
//                nums1[m + i] = nums2[i];
//            }
//            Arrays.sort(nums1);

            //2.双指针
//            int p1 = 0, p2 = 0;
//            int[] sorted = new int[m + n];
//            int cur;
//            while (p1 < m || p2 < n) {
//                if (p1 == m) {
//                    cur = nums2[p2++];
//                } else if (p2 == n) {
//                    cur = nums1[p1++];
//                } else if (nums1[p1] < nums2[p2]) {
//                    cur = nums1[p1++];
//                } else {
//                    cur = nums2[p2++];
//                }
//                sorted[p1 + p2 - 1] = cur;
//            }
//            for (int i = 0; i < m + n; i++) {
//                nums1[i] = sorted[i];
//            }

            //3.逆向双指针
            int p1 = m - 1, p2 = n - 1;
            int tail = m + n - 1;
            int cur;
            while (p1 > -1 || p2 > -1) {
                if (p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] < nums2[p2]) {
                    cur = nums2[p2--];
                } else {
                    cur = nums1[p1--];
                }
                nums1[tail--] = cur;
            }




















//            int p1 = m - 1, p2 = n - 1;
//            int tail = m + n - 1;
//            int cur;
//            while (p1 >= 0 || p2 >= 0) {
//                if (p1 == -1) {
//                    cur = nums2[p2--];
//                } else if (p2 == -1) {
//                    cur = nums1[p1--];
//                } else if (nums1[p1] > nums2[p2]) {
//                    cur = nums1[p1--];
//                } else {
//                    cur = nums2[p2--];
//                }
//                nums1[tail--] = cur;
//            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
