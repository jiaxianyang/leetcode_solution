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
            List<String> result = new ArrayList<>();
            generate(0, 0, n, "", result);
            return result;
        }

        private void generate(int left, int right, int n, String s, List<String> result) {
            //terminator
            if (left == n && right == n) {
                result.add(s);
                return;
            }
            //process

            //drill down
            if (left < n) {
                generate(left + 1, right, n, s + "(", result);
            }
            if (right < left) {
                generate(left, right + 1, n, s + ")", result);
            }
            //reverse status
        }


        public List<String> generateParenthesisMethod(int n) {
            List<String> combinations = new ArrayList<>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
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
