//给定一个 N 叉树，返回其节点值的 后序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 栈 树 深度优先搜索 👍 158 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//java:N 叉树的后序遍历
class P590NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P590NAryTreePostorderTraversal().new Solution();
        Node node = new Node();
        node.val = 1;
//        children1 ==========================================
        Node children1 = new Node();
        children1.val = 3;

//        subChildren1 ==========================================
        Node subChildren1 = new Node();
        subChildren1.val = 5;
        subChildren1.children = new ArrayList<>();

//        subChildren2 ==========================================
        Node subChildren2 = new Node();
        subChildren2.val = 6;
        subChildren2.children = new ArrayList<>();

        children1.children = Arrays.asList(subChildren1, subChildren2);
//        =============================================
        Node children2 = new Node();
        children2.val = 2;
        children2.children = new ArrayList<>();
//        ===============================================
        Node children3 = new Node();
        children3.val = 4;
        children3.children = new ArrayList<>();

        node.children = Arrays.asList(children1, children2, children3);
        List<Integer> postorder = solution.postorder(node);
        System.out.println(postorder);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> postorder(Node root) {
            return postorder2(root);
        }

        /**
         * 迭代方法解决
         *
         * @param root
         * @return
         */
        private List<Integer> postorder2(Node root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                res.addFirst(node.val);
                for (int i = 0; i < node.children.size(); i++) {
                    stack.push(node.children.get(i));
                }
            }
            return res;
        }

        /**
         * N 叉树的后序遍历  左右根
         *
         * @param root
         * @return
         */
        public List<Integer> postorder1(Node root) {
            List<Integer> res = new ArrayList<>();
            postNodeOrder(root, res);
            return res;
        }

        private void postNodeOrder(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }
            for (Node child : root.children) {
                if (child != null) {
                    postNodeOrder(child, res);
                }
            }
            res.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
