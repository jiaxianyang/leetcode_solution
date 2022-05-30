//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1608 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

//java:从前序与中序遍历序列构造二叉树
class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args){
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

//    /**
//     * 前序遍历 【根】    【-------------------左子树-----------------】 【----------------------右子树------------------】
//     *          preLeft  preLeft + 1   (pIndex - inLeft + preLeft)  （pIndex - inLeft + preLeft + 1）          preRight
//     * 中序遍历 【-------------------左子树-----------------】   【根】  【----------------------右子树------------------】
//     *          inLeft                           pIndex - 1    pIndex  pIndex + 1                              inRight
//     * 能获取左子树和右子树
//     *
//     * @param preorder
//     * @param inorder
//     * @return
//     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int preLen = preorder.length;
//        int inLen = inorder.length;
//        if (preLen != inLen) {
//            throw new RuntimeException("Incorrect input data.");
//        }
//        Map<Integer, Integer> map = new HashMap<>(preLen);
//        for (int i = 0; i < inLen; i++) {
//            map.put(inorder[i], i);
//        }
//        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
//    }
//
//    /**
//     *
//     *
//     * @param preorder 前序遍历序列
//     * @param preLeft  前序遍历序列子区间的左边界， 可以取到
//     * @param preRight 前序遍历序列子区间的右边界， 可以取到
//     * @param map      在中序遍历序列里，数值与下标的对应关系
//     * @param inLeft   中序遍历序列子区间的左边界，可以取到
//     * @param inRight  中序遍历序列子区间的右边界， 可以取到
//     * @return
//     */
//    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
//        if (preLeft > preRight || inLeft > inRight) {
//            return null;
//        }
//        int rootVal = preorder[preLeft];
//        TreeNode root = new TreeNode(rootVal);
//        Integer pIndex = map.get(rootVal);
//        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft,
//                map, inLeft, pIndex - 1);
//        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight,
//                map, pIndex + 1, inRight);
//        return root;
//    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        Integer iRootIndex = map.get(rootVal);
        int leftNum = iRootIndex - iStart;
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + leftNum, iStart, iRootIndex - 1, map);
        root.right = buildTreeHelper(preorder, pStart + leftNum + 1, pEnd, iRootIndex + 1, iEnd, map);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
