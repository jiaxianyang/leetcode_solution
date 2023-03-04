//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[
//i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 10⁴ 
// 0 <= s.length <= 3 * 10⁴ 
// 1 <= g[i], s[j] <= 2³¹ - 1 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 657 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.Arrays;

//java:分发饼干
class P455AssignCookies {
    public static void main(String[] args) {
        Solution solution = new P455AssignCookies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心算法， 每一步都选最优的，难点在于怎么证明适用于贪心算法
         *
         * @param g
         * @param s
         * @return
         */
        public int findContentChildren(int[] g, int[] s) {
//            return findContentChildrenMethod1(g, s);
            return findContentChildrenMethod2(g, s);
        }

        private int findContentChildrenMethod2(int[] g, int[] s) {
            //g: 孩子可满足的胃口大小 s:饼干的尺寸
            Arrays.sort(g);
            Arrays.sort(s);
            int gLength = g.length;
            int sLength = s.length;
            int count = 0;
            for (int i = 0, j = 0; i < gLength && j < s.length; i++, j++) {
                while (j < sLength && g[i] > s[j]) {
                    j++;
                }
                if (j < sLength) {
                    count++;
                }
            }
            return count;
        }

        private int findContentChildrenMethod1(int[] g, int[] s) {
            //g：孩子可满足的胃口  s：饼干的尺寸
            Arrays.sort(g);
            Arrays.sort(s);
            int gLength = g.length, sLength = s.length;
            int count = 0;
            int i = 0, j = 0;
            while (i < gLength && j < sLength) {
                if (g[i] <= s[j]) {
                    count++;
                    i++;
                    j++;
                } else {
                    //尺寸不够满足孩子胃口，向后移动
                    j++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
