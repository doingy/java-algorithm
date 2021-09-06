package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    private static Logger logger = LoggerFactory.getLogger(ReverseLinkedList.class);

    static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode list = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return list;
    }

    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = ans;
            ans = cur;

            cur = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        logger.info("" + solution.reverseList(list));
    }
}
