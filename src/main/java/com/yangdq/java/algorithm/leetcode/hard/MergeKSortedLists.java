package com.yangdq.java.algorithm.leetcode.hard;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        if (l > r) {
            return null;
        }

        int mid = (r - l) / 2 + l;
        return merge2ListNode(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode merge2ListNode(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        ListNode ans = new ListNode();
        ListNode prev = ans;
        ListNode aPtr = a;
        ListNode bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                prev.next = aPtr;
                aPtr = aPtr.next;
            } else {
                prev.next = bPtr;
                bPtr = bPtr.next;
            }
            prev = prev.next;
        }

        prev.next = aPtr == null ? bPtr : aPtr;

        return ans.next;
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
