//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1470 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:多数元素
class P169MajorityElement{
    public static void main(String[] args){
        Solution solution = new P169MajorityElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 3、分治
         * 思路：
         * 如果数 a是数组nums的众数，如果我们将nums分成俩部分，那么a必定是至少一部分的众数。
         * 这样一来，我们就可以使用分治法解决这个问题： 将数组分成左右俩部分
         *
         * 算法：
         * 1、我们使用经典的分治算法递归求解，直到所有的子问题都是长度为1的数组。长度为1的子数组中唯一的数显然是众数，直接返回即可。
         * 2、如果回溯后某区间的长度大于1，我们必须将左右子区间的值合并。如果他们的众数相同，那么显然这一段区间的众数是他们相同的值，
         * 否则，我们需要比较俩个众数在整个区间内出现的次数来决定该区间的众数。
         */
        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length - 1);
        }

        private int majorityElementRec(int[] nums, int lo, int hi) {
            // base case; the only element in an array of size 1 is the majority
            // element.
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi - lo) / 2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid + 1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }


        //2、排序方法
//        public int majorityElement(int[] nums) {
//            Arrays.sort(nums);
//            return nums[nums.length / 2];
//        }

        //1、hash 方法
//        public int majorityElement(int[] nums) {
//            Map<Integer, Integer> counts = countNums(nums);
//            Map.Entry<Integer, Integer> majorityEntry = null;
//            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//                    majorityEntry = entry;
//                }
//            }
//            return majorityEntry.getKey();
//        }
//
//        private Map<Integer, Integer> countNums(int[] nums) {
//            Map<Integer, Integer> counts = new HashMap<>();
//            for (int num : nums) {
//                if (!counts.containsKey(num)) {
//                    counts.put(num, 1);
//                } else {
//                    counts.put(num, counts.get(num) + 1);
//                }
//            }
//            return counts;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
