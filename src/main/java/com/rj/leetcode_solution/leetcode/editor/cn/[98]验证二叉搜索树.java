//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1231 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//java:验证二叉搜索树
class P98ValidateBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //方法1. 递归
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        //方法2. 中序遍历
        return isValidBSTinOrder(root);
    }

    /**
     * 中序遍历是左 —— 根 —— 右 根据二叉搜索树的特性，遍历的结果是递增的，根据这一特性。我们可以校验出是否是二叉搜索树
     *
     * @param root
     * @return
     */
    private boolean isValidBSTinOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //如果中序遍历得到的节点的值小于等于前一个inOrder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 解题思路：二叉搜索树：节点的左子树小于右子树
     *  1. 所以左子树节点的最大不能超过当前节点
     *  2. 所以右子树节点要大于当前节点的值，但是不能大于当前跟节点的右父亲
     *
     * @param node 节点
     * @param lower 最小边界
     * @param upper 最大边界
     * @return boolean
     */
    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}
