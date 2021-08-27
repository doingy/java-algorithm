package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchInsertPosition {
    private static Logger logger = LoggerFactory.getLogger(SearchInsertPosition.class);

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        logger.info("" + solution.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
