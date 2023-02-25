//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1582 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:二叉树的层序遍历
class P102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args){
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //1、 广度优先解法
//        return bfs(root);
        //2、 深度优先解法
        List<List<Integer>> result = new ArrayList<>();
        printNode(root, 0, result);
        return result;
    }

    private void printNode(TreeNode treeNode, Integer level, List<List<Integer>> result) {
        if (treeNode == null) {
            return;
        }
        //因为level 是从 第 0层开始的，所以是<=。 例如开始  level： 0  result.size() = 0 这个时候需要创建一个空list。
        //正确的存放结果对应关系是  level ：0 对应 result.size() = 1   level: 1 对应的result.size() = 2 依次类推。
        // result.size() 比 level 大于 1。当result的size 小于等于 level 的时候都是需要创建结果集的 。
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(treeNode.val);
        printNode(treeNode.left, level + 1, result);
        printNode(treeNode.right, level + 1, result);
    }


//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        printNode(root, 0, result);
//        return result;
//    }
//
//    public void printNode(TreeNode treeNode, Integer level, List<List<Integer>> result) {
//        if (treeNode == null) {
//            return;
//        }
//        if (result.size() <= level) {
//            result.add(new ArrayList<Integer>());
//        }
//        printNode(treeNode.left, level + 1, result);
//        result.get(level).add(treeNode.val);
//        printNode(treeNode.right, level + 1, result);
//    }


    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //这一层的数量
            int currentLevelSize = queue.size();
            List<Integer> currentLevelbResult = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelbResult.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(currentLevelbResult);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
