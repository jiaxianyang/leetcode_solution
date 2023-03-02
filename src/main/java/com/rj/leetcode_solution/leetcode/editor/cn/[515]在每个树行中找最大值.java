//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 302 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:在每个树行中找最大值
class P515FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            //1、dfs解法
//            return dfsSolution(root);
            //2、bfs解法
            return bfsSolution(root);
        }

        private List<Integer> bfsSolution(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                int maxValue = Integer.MIN_VALUE;
                //当前层处理
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode treeNode = queue.poll();
                    maxValue = Math.max(treeNode.val, maxValue);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                res.add(maxValue);
            }
            return res;
        }

        private List<Integer> dfsSolution(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            dfs(root, 0, res);
            return res;
        }

        private void dfs(TreeNode root, int level, List<Integer> res) {
            if (level == res.size()) {
                res.add(root.val);
            } else {
                res.set(level, Math.max(res.get(level), root.val));
            }
            if (root.left != null) {
                dfs(root.left, level + 1, res);
            }
            if (root.right != null) {
                dfs(root.right, level + 1, res);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
