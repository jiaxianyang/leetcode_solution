package com.rj.leetcode_solution.common.entity;

/**
 * TreeNode简介
 *
 * 二叉树公用实体
 * @author jiaxianyang
 * @date 2021-10-26 14:51
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}