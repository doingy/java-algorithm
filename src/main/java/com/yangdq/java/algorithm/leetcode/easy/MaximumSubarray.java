package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    private static Logger logger = LoggerFactory.getLogger(MaximumSubarray.class);

    // 分治
    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private class Status {
        // 表示 [l,r] 内以 l 为左端点的最大子段和
        public int lSum;
        // 表示 [l,r] 内以 r 为右端点的最大子段和
        public int rSum;
        // 表示 [l,r] 内的最大子段和
        public int mSum;
        // 表示 [l,r] 的区间和
        public int iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    private Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }

        int m = (l + r) / 2;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);

        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rSum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
        int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    // 动态规划
    public int maxSubArray2(int[] nums) {
        int ans = nums[0], prev = 0;

        for (int n : nums) {
            prev = Math.max(prev + n, n);
            ans = Math.max(prev, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        logger.info("2,1,-3,4,-1,2,1,-5,4: " + solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
