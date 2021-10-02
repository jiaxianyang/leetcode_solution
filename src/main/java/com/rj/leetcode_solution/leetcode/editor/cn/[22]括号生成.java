//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2055 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            //1. 暴力法
//            return generateParenthesisMethod(n);

            //2.递归
//            List<String> result = new ArrayList<>();
//            generate(0, 0, n, "", result);
//            return result;

            //3.回溯法
            List<String> ans = new ArrayList<>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append("(");
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(")");
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }

        /**
         * 解题思路：我们想象成有很多格子，我们往里面放入左右括号，如果想要最终满足结果，那么要同事符合以下规则：
         * 1. 我们在组装结果的时候，放入的右边的括号数量不能大于左边，如果大于那么就会组装成无用的结果 所以（right < left）
         * 2. 我们放入的左括号数量不能大于n,如果大于n，最终组装的结果也是不满足的
         * 3. 当左括号数量和右括号数量相当并且都等于n的时候，为我们想要的结果
         *
         * @param left   左括号数量
         * @param right  有括号数量
         * @param max    n
         * @param str    字符串
         * @param result 结果集
         */
        private void generate(int left, int right, int max, String str, List<String> result) {
            //terminator
            if (left == max && right == max) {
                result.add(str);
                return;
            }
            //process

            //drill down
            if (left < max) {
                generate(left + 1, right, max, str + "(", result);
            }
            if (right < left) {
                generate(left, right + 1, max, str + ")", result);
            }
            //reverse status
        }


        public List<String> generateParenthesisMethod(int n) {
            List<String> result = new ArrayList<>();
            generateAll(new char[2 * n], 0, result);
            return result;
        }

        private void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        /**
         * 校验是否是正确的括号
         */
        private boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
