package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    private static Logger logger = LoggerFactory.getLogger(ClimbingStairs.class);

    // 动态规划
    public int climbStairs(int n) {
        // f(x) = f(x-1) + f(x-2);
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        logger.info("" + solution.climbStairs(2));
    }
}
