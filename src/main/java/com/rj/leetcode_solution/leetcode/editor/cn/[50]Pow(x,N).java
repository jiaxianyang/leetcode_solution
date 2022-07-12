//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 982 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:Pow(x, n)
class P50PowxN{
    public static void main(String[] args){
        Solution solution = new P50PowxN().new Solution();
        System.out.println(solution.myPow(1.00000 ,-2147483648));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //分治
        //template: 1. terminator 2.process(split your big problem) 3.drill down(subproblems)， merge(subsult) 4. reverse states
        public double myPow(double x, int n) {
            long N = n;
            return n > 0 ? quickMul(x, N) : 1 / quickMul(x, -N);
        }

        private double quickMul(double x, long n) {
            if (n == 0) {
                return 1.0;
            }
            double y = quickMul(x, n / 2);
            return n % 2 == 0 ? y * y : y * y * x;
        }

        //1.迭代法，关键点 int 的取值范围 为【-2147483648，2147483647】
        // -2^31 - 2^31 - 1
//        public double myPow(double x, int n) {
//            long dn = n;
//            return calMyPow(x, dn);
//        }
//
//        public double calMyPow(double x, long n) {
//            if (n < 0) {
//                return 1.0 / calMyPow(x, -n);
//            }
//            double res = 1.0;
//            for (long i = n; i !=0 ; i /= 2) {
//                if (i % 2 != 0) {
//                    res *= x;
//                }
//                x *= x;
//            }
//            return res;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
