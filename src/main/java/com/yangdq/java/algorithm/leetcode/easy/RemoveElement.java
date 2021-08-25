package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    private static Logger logger = LoggerFactory.getLogger(RemoveElement.class);

    // 双指针优化
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int right = nums.length;
        int left = 0;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }

    // 双指针
    public int removeElement2(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] a = new int[]{0,1,2,2,3,0,4,2};
        logger.info("" + solution.removeElement(a, 2) + Arrays.toString(a));
    }
}
