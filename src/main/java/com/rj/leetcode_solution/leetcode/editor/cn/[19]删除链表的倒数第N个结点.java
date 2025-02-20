//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2873 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import com.rj.leetcode_solution.common.entity.ListNode;

//java:删除链表的倒数第 N 个结点
class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args){
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(new ListNode(1), 1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //2、双指针
        ListNode dummy = new ListNode(-1, head);
        ListNode fist = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            fist = fist.next;
        }
        while (fist != null) {
            fist = fist.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;

        //1、循环取值
//        ListNode virtualNode = new ListNode(-1);
//        virtualNode.next = head;
//        int len = getLen(head);
//        ListNode curNode = virtualNode;
//        for (int i = 1; i < len - n + 1; i++) {
//            curNode = curNode.next;
//        }
//        curNode.next = curNode.next.next;
//        return virtualNode.next;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}