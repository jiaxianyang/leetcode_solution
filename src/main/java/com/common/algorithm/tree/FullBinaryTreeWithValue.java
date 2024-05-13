package com.common.algorithm.tree;

import java.util.Queue;

/**
 * @author jiaxianyang
 * @date 2024/5/13 15:49
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class FullBinaryTreeWithValue {

    private static int currentValue = 1; // 用于节点值的全局计数器

    public static TreeNode createFullBinaryTree(int depth) {
        if (depth <= 0) {
            return null;
        }
        return createFullBinaryTreeHelper(depth);
    }

    private static TreeNode createFullBinaryTreeHelper(int depth) {
        if (depth == 0) {
            return null;
        }
        TreeNode node = new TreeNode(currentValue++);
        node.left = createFullBinaryTreeHelper(depth - 1);
        node.right = createFullBinaryTreeHelper(depth - 1);
        return node;
    }

    // 用于层序遍历打印树的方法
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = createFullBinaryTree(4); // 以深度3为例
        printTree(root); // 应该打印出：1 2 3 4 5 6 7
    }
}



