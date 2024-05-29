//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 1326 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:回文子串
class P647PalindromicSubstrings{
    public static void main(String[] args){
        Solution solution = new P647PalindromicSubstrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


//        情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
//        情况二：下标i 与 j相差为1，例如aa，也是回文子串
//        情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = len - 1; i >=0 ; i--) {
            for (int j = i; j <  len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        // 情况一 和 情况二
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        // 情况三
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}