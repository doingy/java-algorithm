package com.yangdq.java.algorithm.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode n1 = prev.next;
            ListNode n2 = prev.next.next;
            prev.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            prev = n1;
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
