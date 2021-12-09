package com.yangdq.java.algorithm.leetcode.aaaa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 练习
 */
public class Solution {
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public int[] test(int[] nums) {

        int j = 0, i = 0;

        while (nums[i] != nums[i+1]) {
            i++;
        }
        while (nums[j] == nums[j-1]) {
            j++;
        }
        while (j < nums.length) {
            
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        logger.info("" + Arrays.toString(solution.test(new int[]{1, 2, 3, 3})));
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
