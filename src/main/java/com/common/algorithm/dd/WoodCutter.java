package com.common.algorithm.dd;

/**
 *
 * /    给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
 * //    输入两行，第一行n,k，第二行为数组序列。输出最大值。
 * //
 * //    输入:
 * //    n=5 k=5
 * //    arr=[4,7,2,10,5]
 * //    输出:4
 * //    解释：最多可以把它分成5段长度为4的木头
 *
 * @author jiaxianyang
 * @date 2025/3/1 16:06
 */
public class WoodCutter {


    // 测试示例
    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 10, 5};
        int n = 5;
        int k = 5;
        System.out.println(maxM(n, k, arr)); // 输出: 4
    }

    public static int maxM(int n, int k, int[] arr) {
        int left = 1, right = 0;
        for (int num : arr) right = Math.max(right, num); // 初始化右边界为数组最大值

        while (left <= right) {
            int mid = left + (right - left) / 2; // 避免整数溢出
            int total = 0;
            for (int num : arr) total += num / mid; // 计算总段数

            if (total >= k) {
                left = mid + 1; // 尝试更大的 m
            } else {
                right = mid - 1; // 需要减小 m
            }
        }
        return right; // 返回最后一个可行解
    }


}