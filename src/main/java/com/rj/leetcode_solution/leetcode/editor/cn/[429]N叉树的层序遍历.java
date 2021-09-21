//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 👍 174 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:N 叉树的层序遍历
class P429NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P429NAryTreeLevelOrderTraversal().new Solution();
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

        public List<List<Integer>> levelOrder(Node root) {
            //方法1. 利用队列实现广度优先遍历
//            return levelOrderBfs(root);
            //方法2. 简化版的广度优先搜索
//            return levelOrderSampleBfs(root);
            //方法3. 递归
            return recursionLevelOrder(root);
        }

        /**
         * 我们可以使用递归来解决这个问题，通常我们不能使用递归进行广度优先搜索。这是因为广度优先搜索基于
         * 队列，而递归运行时使用的堆栈，适合深度优先遍历。
         * <p>
         * 但是在本题中，只要我们知道节点在哪一层并确保在那一层的列表顺序正确就可以了
         *
         * @param root
         * @return
         */
        private List<List<Integer>> recursionResult = new ArrayList<>();

        private List<List<Integer>> recursionLevelOrder(Node root) {
            if (root != null) {
                traverseNode(root, 0);
            }
            return recursionResult;
        }

        private void traverseNode(Node node, int level) {
            if (recursionResult.size() <= level) {
                recursionResult.add(new ArrayList<>());
            }
            recursionResult.get(level).add(node.val);
            for (Node child : node.children) {
                traverseNode(child, level + 1);
            }
        }

        /**
         * 简单的BFS(广度优先遍历)
         *
         * @param root 树根节点
         * @return List<List < Integer>>
         */
        private List<List<Integer>> levelOrderSampleBfs(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<Node> previousLayer = Arrays.asList(root);
            while (!previousLayer.isEmpty()) {
                List<Node> currentLayer = new ArrayList<>();
                List<Integer> previousVals = new ArrayList<>();
                for (Node node : previousLayer) {
                    previousVals.add(node.val);
                    currentLayer.addAll(node.children);
                }
                result.add(previousVals);
                previousLayer = currentLayer;
            }
            return result;
        }

        /**
         * 利用队列实现广度优先遍历
         *
         * @param root 树根节点
         * @return List<List < Integer>>
         */
        private List<List<Integer>> levelOrderBfs(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    levelList.add(node.val);
                    queue.addAll(node.children);
                }
                result.add(levelList);
            }
            return result;
        }

        private void bfsTemplate(Node root) {
            List<Integer> values = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node nextNode = queue.remove();
                values.add(nextNode.val);
                for (Node child : nextNode.children) {
                    queue.add(child);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
