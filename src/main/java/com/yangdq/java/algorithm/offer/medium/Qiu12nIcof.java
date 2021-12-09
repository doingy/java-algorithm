package com.yangdq.java.algorithm.offer.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class Qiu12nIcof {
    private static Logger logger = LoggerFactory.getLogger(Qiu12nIcof.class);

    public int sumNums(int n) {
        boolean flag = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }

    // Recursion
    public int sumNums2(int n) {
        if (n <= 0) {
            return n;
        }
        return n + sumNums2(n - 1);
    }

    public static void main(String[] args) {
        Qiu12nIcof solution = new Qiu12nIcof();
        logger.info("" + solution.sumNums(100));
    }
}
