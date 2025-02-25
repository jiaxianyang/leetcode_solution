package com.common.algorithm.mt;

/**
 * 美团面试题   算法 a 开 b 次方 的值
 */
public class RootCalculation {

    public static void main(String[] args) {
        int a = 8; // 被开方数
        int b = 3; // 根次

        double result = nthRoot(a, b);
        System.out.println(result);
    }


    public static double nthRoot(int a, int b) {
        double low = 0;
        double high = a;
        double epsilon = 0.01;
        double guess = (low + high) / 2;

        // 直接比较计算值与目标的误差
        while (Math.abs(Math.pow(guess, b) - a) > epsilon) {
            if (Math.pow(guess, b) > a) {
                high = guess;
            } else {
                low = guess;
            }
            guess = (low + high) / 2;
        }
        return guess;
    }
}