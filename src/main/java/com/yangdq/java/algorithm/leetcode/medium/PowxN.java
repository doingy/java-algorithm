package com.yangdq.java.algorithm.leetcode.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class PowxN {
    private static Logger logger = LoggerFactory.getLogger(PowxN.class);

    public double myPow(double x, int n) {
        double ans = 1.0;

        boolean flag = n >= 0;
        long N = n; // N = -N 有可能溢出
        if (N < 0) {
            N = -N;
        }

        double t = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= t;
            }

            t *= t;
            N /= 2;
        }

        return flag ? ans : (1.0 / ans);
    }

    public static void main(String[] args) {
        PowxN solution = new PowxN();
        logger.info("" + solution.myPow(2, -2147483648));
//        logger.info("" + solution.myPow2(2, -2147483648));
    }
}
