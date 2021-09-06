package com.yangdq.java.algorithm.leetcode.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    private static Logger logger = LoggerFactory.getLogger(AddTwoNumbers.class);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();

        ListNode head = ans;

        int prev = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                prev += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                prev += l2.val;
                l2 = l2.next;
            }
            ans.next = new ListNode(prev % 10);
            ans = ans.next;
            prev /= 10;
        }

        if (prev != 0) {
            ans.next = new ListNode(prev);
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode left = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode right = new ListNode(5, new ListNode(6, new ListNode(4)));
        logger.info("" + solution.addTwoNumbers(left, right));
    }

    public static class ListNode {
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
}
