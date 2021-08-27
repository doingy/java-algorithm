package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrtx {
    private static Logger logger = LoggerFactory.getLogger(Sqrtx.class);

    // 二分查找
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (((long) mid * mid) <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Sqrtx solution = new Sqrtx();
        logger.info(solution.mySqrt(2147395599) + "");
    }
}
