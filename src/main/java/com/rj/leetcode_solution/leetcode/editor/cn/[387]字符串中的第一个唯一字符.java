//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 769 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:字符串中的第一个唯一字符
class P387FirstUniqueCharacterInAString{
    public static void main(String[] args){
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
//        Map<Character, Integer> frequency = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (frequency.get(s.charAt(i)) == 1) {
//                return i;
//            }
//        }
//        return -1;

        char[] cs = s.toCharArray();
        char[] chars = new char[128];
        for (int i = 0; i < cs.length; i++) {
            chars[cs[i]]++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (chars[cs[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}