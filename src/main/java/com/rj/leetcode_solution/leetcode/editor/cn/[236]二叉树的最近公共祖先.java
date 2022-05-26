//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1705 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//java:二叉树的最近公共祖先
class P236LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args){
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public Solution() {
    }

    /**
     * 从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
     * 从 p 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
     * 同样，我们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //除跟节点外，每个节点的值为key, value为父节点 放入到map中，取跟节点的父节点为null，为终止条件
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

//    /**
//     * 递归
//     * 解题思路：
//     * 从根节点触发开始判断：
//     * 1、如果当前节点 左子树和右子树 分别包含 p, q，那么 当前节点root就是最近公共祖先
//     * 2、如果当前节点的值 root.val 等于p.val 或者 q.val 那么 另外一个节点不是在右子树就是在做子树里面，所以当前节点也是 最近公共祖先
//     *
//     * 解题关键点：当前 p 和 q 均存在于给定的二叉树中。所有 Node.val 互不相同 。p != q
//     *
//     * @return
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return null;
//        }
//        if (root.val == p.val || root.val == q.val) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) {
//            return root;
//        }
//        if (left == null) {
//            return right;
//        }
//        if (right == null) {
//            return left;
//        }
//        return null;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
