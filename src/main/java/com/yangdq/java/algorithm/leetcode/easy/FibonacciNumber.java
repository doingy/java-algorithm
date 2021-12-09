package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode-cn.com/problems/fibonacci-number
 */
public class FibonacciNumber {
    private static Logger logger = LoggerFactory.getLogger(FibonacciNumber.class);

    // dp
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int x = 0, y = 0, z = 1;
        for (int i = 2; i <= n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }

    public static void main(String[] args) {
        FibonacciNumber fib = new FibonacciNumber();
        logger.info("" + fib.fib(3));
    }
}
