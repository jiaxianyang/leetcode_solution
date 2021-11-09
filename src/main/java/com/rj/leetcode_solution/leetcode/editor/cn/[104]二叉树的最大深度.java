//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1017 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//java:二叉树的最大深度
class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
            //深度优先
//            return dfsMaxDepth(root);

            //广度优先
            return bfsMaxDepth(root);
        }

        private int bfsMaxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }

        private int dfsMaxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
