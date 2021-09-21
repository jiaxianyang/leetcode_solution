////给定一个 N 叉树，返回其节点值的 前序遍历 。 
////
//// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
////
//// 
//// 
//// 
////
//// 进阶： 
////
//// 递归法很简单，你可以使用迭代法完成此题吗? 
////
//// 
////
//// 示例 1： 
////
//// 
////
//// 
////输入：root = [1,null,3,2,4,null,5,6]
////输出：[1,3,5,6,2,4]
//// 
////示例 2：
////
//// 
////
//// 
////输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,1
//2,
////null,13,null,null,14]
////输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// N 叉树的高度小于或等于 1000 
//// 节点总数在范围 [0, 10^4] 内 
//// 
//// 
//// 
//// Related Topics 栈 树 深度优先搜索 👍 178 👎 0
//

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//java:N 叉树的前序遍历
class P589NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
    class Solution {

        public List<Integer> preorder(Node root) {
            //方法1.递归
            return preorder1(root);
            //方法2. 迭代
//      return preorder2(root);
        }

        //==================方法2.迭代====================================
        private List<Integer> preorder2(Node root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                res.add(node.val);
                //后进先出
                Collections.reverse(node.children);
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
            return res;
        }

        //==================方法1.递归============================
        private List<Integer> preorder1(Node root) {
            List<Integer> res = new ArrayList<>();
            preNodeOrder(root, res);
            return res;
        }

        private void preNodeOrder(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            for (Node child : root.children) {
                if (child != null) {
                    preNodeOrder(child, res);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
