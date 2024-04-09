//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2309 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:和为 K 的子数组
class P560SubarraySumEqualsK{
    public static void main(String[] args){
        Solution solution = new P560SubarraySumEqualsK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int subarraySum(int[] nums, int k) {
//            //1、暴力法
//            int count = 0;
//            for (int start = 0; start < nums.length; start++) {
//                int sum = 0;
//                for (int end = start; end >= 0; end--) {
//                    sum += nums[end];
//                    if (sum == k) {
//                        count++;
//                    }
//                }
//            }
//            return count;
            //2、前缀和 + hash表
            // 我们可以理解为 当前值的数组和，我们可以往前找，满足  当前值 cur + pre = k, pre代表的是前面多少项相加。在处理i的时候，我们 可以知道前面所有的连续的和
            //通过 cur + pre = k  pre - k = (上一个满足的连续和)  pre[i]=pre[i−1]+nums[i]   pre[i]−pre[j−1]==k    pre[j−1]==pre[i]−k
            int count = 0;
            int pre = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}