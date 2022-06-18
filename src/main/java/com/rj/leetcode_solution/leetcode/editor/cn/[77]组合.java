//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 996 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:组合
class P77Combinations{
    public static void main(String[] args){
        Solution solution = new P77Combinations().new Solution();
        List<List<Integer>> res = solution.combine(4, 2);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, res);
            return res;
        }

        private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            //剪枝叶，去除不必要的计算
            for (int i = index; i <= n - (k - path.size()) + 1; i++) {
                path.addLast(i);
                dfs(n, k, i + 1, path, res);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
