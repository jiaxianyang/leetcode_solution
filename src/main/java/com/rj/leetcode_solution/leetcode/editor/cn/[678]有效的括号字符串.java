//给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是 有效 字符串返回 true 。
// 
//
// 有效 字符串符合如下规则： 
//
// 
// 任何左括号 '(' 必须有相应的右括号 ')'。 
// 任何右括号 ')' 必须有相应的左括号 '(' 。 
// 左括号 '(' 必须在对应的右括号之前 ')'。 
// '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串 ""。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "(*)"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(*))"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 为 '('、')' 或 '*' 
// 
//
// Related Topics 栈 贪心 字符串 动态规划 👍 657 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//java:有效的括号字符串
class P678ValidParenthesisString{
    public static void main(String[] args){
        Solution solution = new P678ValidParenthesisString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean checkValidString(String s) {
        //思路如下：
        // 1、左括号和星号放入栈，如果出现右括号，那么栈里一定是有左括号或者星号的
        // 2、遍历完成后，如果左括号不为空，那么一定是有比左括号更大index 的 星号，否则不是有效括号字符传例如：*( 无法组成有效括号，只能是 （*
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            Integer leftIndex = leftStack.pop();
            Integer asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}