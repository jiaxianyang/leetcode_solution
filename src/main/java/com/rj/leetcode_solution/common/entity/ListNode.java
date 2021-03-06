package com.rj.leetcode_solution.common.entity;

/**
 * ListNode简介
 * <p>
 * 单链表
 *
 * @author jiaxianyang
 * @date 2021-03-04 13:24
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
