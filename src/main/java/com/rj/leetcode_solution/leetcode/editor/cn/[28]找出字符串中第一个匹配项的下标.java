//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2166 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:找出字符串中第一个匹配项的下标
class P28FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args){
        Solution solution = new P28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //初始化
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return  - 1;

    }

        private void getNext(int[] next, String needle) {
            int j = 0;
            next[0] = 0;
            for (int i = 1; i < needle.length(); i++) {
                while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                    j = next[j - 1];
                }
                if (needle.charAt(j) == needle.charAt(i)) {
                    j++;
                }
                next[i] = j;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}