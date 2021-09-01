//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 👍 419 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:有效的字母异位词
class P242ValidAnagram{
    public static void main(String[] args){
        Solution solution = new P242ValidAnagram().new Solution();
        String s1 = "anagram";
        String s2 = "nagaram";
        solution.isAnagram(s1, s2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        //1. 排序
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        return Arrays.equals(sArray, tArray);

        //2.哈希表  长度相同，
        // 1. 如果 t 比 s 字母多，那么会出现负数
        // 2. 如果 t 比 s 字段少， 那么长度一定会不一样
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] table = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            table[s.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            table[t.charAt(i) - 'a']--;
//            if (table[t.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;

        //3. 哈希表， 个人认为比较好的解法
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] arr = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            arr[s.charAt(i) - 'a']++;
//            arr[t.charAt(i) - 'a']--;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (arr[i] != 0) {
//                return false;
//            }
//        }
//        return true;

        //4. 哈希表
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
