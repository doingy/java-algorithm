package com.yangdq.java.algorithm.leetcode.hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int median1 = 0, median2 = 0;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1_im1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1_i = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2_jm1 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2_j = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (nums1_im1 <= nums2_j) {
                median1 = Math.max(nums1_im1, nums2_jm1);
                median2 = Math.min(nums1_i, nums2_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
