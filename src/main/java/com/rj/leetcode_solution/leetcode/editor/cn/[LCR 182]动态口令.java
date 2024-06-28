//某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤： 
//
// 
// 设定一个正整数目标值 target 
// 将 password 前 target 个字符按原顺序移动至字符串末尾 
// 
//
// 请返回更新后的密码字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: password = "s3cur1tyC0d3", target = 4
//输出: "r1tyC0d3s3cu"
// 
//
// 示例 2： 
//
// 
//输入: password = "lrloseumgh", target = 6
//输出: "umghlrlose"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target < password.length <= 10000 
// 
//
// 
//
// Related Topics 数学 双指针 字符串 👍 476 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:动态口令
class PLCR182ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args){
        Solution solution = new PLCR182ZuoXuanZhuanZiFuChuanLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 翻转三次做法：
         * 例如：abcdefg k = 2
         * 第一次：gfedcba
         * 第二次：cdefgba
         * 第三次：cdefgab
         *
         * @param password
         * @param target
         * @return
         */
        public String dynamicPassword(String password, int target) {
            char[] c = password.toCharArray();
            int l = c.length;
            //整个字符串翻转
            reverse(c, 0, l - 1);
            //翻转不需要处理的字符串
            reverse(c, 0, l - target - 1);
            //翻转需要处理的字符串
            reverse(c, l - target, l - 1);
            return new String(c);
        }

        public void reverse(char[] c, int left, int right) {
            while (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}