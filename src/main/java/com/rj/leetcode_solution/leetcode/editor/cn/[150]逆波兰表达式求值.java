//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。 
//
// 请你计算该表达式。返回一个表示表达式值的整数。 
//
// 注意： 
//
// 
// 有效的算符为 '+'、'-'、'*' 和 '/' 。 
// 每个操作数（运算对象）都可以是一个整数或者另一个表达式。 
// 两个整数之间的除法总是 向零截断 。 
// 表达式中不含除零运算。 
// 输入是一个根据逆波兰表示法表示的算术表达式。 
// 答案及所有中间计算结果可以用 32 位 整数表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 提示： 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数 
// 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中 
// 
//
// Related Topics 栈 数组 数学 👍 896 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//java:逆波兰表达式求值
class P150EvaluateReversePolishNotation{
    public static void main(String[] args){
        Solution solution = new P150EvaluateReversePolishNotation().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *
         * 该题的思路，只是逆波兰表达式的一部分
         * 完整的解题思路如下：
         *      1、将中缀表达式转换成，后缀表达式，
         *      通过符号栈（栈中的优先级小于当前要入栈，直接加入栈顶，如果大于则将栈内元素弹出，拼接到后缀表达式中）
         *      2、根据最终拼接的后缀表达式（逆波兰表达式），通过栈：
         *      遇到数字直接入栈，遇到操作符，则弹出两个项进行运算，将运算结果再入栈，最后栈底元素值则为最终结果
         */
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            int n = tokens.length;
            for (int i = 0; i < n; i++) {
                String token = tokens[i];
                if (isNumber(token)) {
                    stack.push(Integer.parseInt(token));
                } else {
                    Integer num2 = stack.pop();
                    Integer num1 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                        default:
                    }
                }
            }
            return stack.pop();
        }

        public boolean isNumber(String token) {
            return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}