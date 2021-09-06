package com.yangdq.java.algorithm.leetcode.aaaa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 练习
 */
public class Solution {
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode prev = ans;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

        }

        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode r = new ListNode(1, new ListNode(3, new ListNode(4)));
        logger.info("" + solution.mergeTwoLists(l, r));
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
