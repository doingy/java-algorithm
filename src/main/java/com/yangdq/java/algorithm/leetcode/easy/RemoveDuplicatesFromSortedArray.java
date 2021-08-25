package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    private static Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArray.class);

    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int fast = 1;
        int slow = 1;

        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;
    };

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        logger.info("" + solution.removeDuplicates(new int[]{}));
    }
}
