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
            //1、合并后直接排序
//            merge1(nums1, m, nums2, n);
            //2、双指针
//            merge2(nums1, m, nums2, n);
            //3、逆向双指针
//            merge3(nums1, m, nums2, n);
            //4、逆向简洁版本
//            merge4(nums1, m, nums2, n);
            //5、while循环
            merge5(nums1, m, nums2, n);
        }

        //1、直接合并后排序
        private void merge1(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);
        }

        //2、双指针
        private void merge2(int[] nums1, int m, int[] nums2, int n) {
           int p1 = 0, p2 = 0, len = 0;
            int[] sorted = new int[m + n];
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    sorted[len++] = nums2[p2++];
                } else if (p2 == n) {
                    sorted[len++] = nums1[p1++];
                } else if (nums1[p1] < nums2[p2]) {
                    sorted[len++] = nums1[p1++];
                } else {
                    sorted[len++] = nums2[p2++];
                }
            }
            for (int i = 0; i < (m + n); i++) {
                nums1[i] = sorted[i];
            }
        }

        //3、逆向双指针
        private void merge3(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            int tail =  m + n - 1;
            while (p1 > -1 || p2 > -1) {
                if (p1 == -1) {
                    nums1[tail--] = nums2[p2--];
                } else if (p2 == -1) {
                    nums1[tail--] = nums1[p1--];
                } else if (nums1[p1] < nums2[p2]) {
                    nums1[tail--] = nums2[p2--];
                } else {
                    nums1[tail--] = nums1[p1--];
                }
            }
        }

        //4、逆向双指针简洁版
        private void merge4(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0) {
                // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2 + 1
            //只要len2 有值都是小于 nums1 的值，并且nums1所有的值都放在数组后面了
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }

        private void merge5(int[] nums1, int m, int[] nums2, int n) {
            int i = 0, j = 0, k = 0;
            int[] result = new int[m + n];
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    result[k++] = nums1[i++];
                } else {
                    result[k++] = nums2[j++];
                }
            }
            while (i < m) {
                result[k++] = nums1[i++];
            }
            while (j < n) {
                result[k++] = nums2[j++];
            }
            System.arraycopy(result, 0, nums1, 0, m + n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
