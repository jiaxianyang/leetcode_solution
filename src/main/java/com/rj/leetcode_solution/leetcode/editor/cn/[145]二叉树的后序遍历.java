//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 690 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

//java:二叉树的后序遍历
class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            //1. 递归
//        return postorderTraversalRecursion(root);
            //2. 迭代
            return postorderTraversalIteration(root);
        }

//   好的解法     https://leetcode.cn/problems/binary-tree-postorder-traversal/solutions/367420/bang-ni-dui-er-cha-shu-bu-zai-mi-mang-che-di-chi-t/
        private List<Integer> postorderTraversalIteration(TreeNode root) {
//            List<Integer> ans = new ArrayList<>();
//            if (root == null) {
//                return ans;
//            }
//            Deque<TreeNode> stack = new ArrayDeque<>();
//            TreeNode prev = null;
//            while (!stack.isEmpty() || root != null) {
//                while (root != null) {
//                    stack.push(root);
//                    root = root.left;
//                }
//                root = stack.pop();
//                if (root.right == null || root.right == prev) {
//                    ans.add(root.val);
//                    prev = root;
//                    root = null;
//                } else {
//                    stack.push(root);
//                    root = root.right;
//                }
//            }
//            return ans;
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            Collections.reverse(result);
            return result;
        }

        /**
         * 后序遍历，递归方法 左  右   根
         *
         * @param root 节点
         * @return 结果
         */
        private List<Integer> postorderTraversalRecursion(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            helper(root.left, result);
            helper(root.right, result);
            result.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
