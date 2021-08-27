package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    private static Logger logger = LoggerFactory.getLogger(PlusOne.class);

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        logger.info("" + Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        logger.info("" + Arrays.toString(solution.plusOne(new int[]{1, 9})));
        logger.info("" + Arrays.toString(solution.plusOne(new int[]{1, 1, 9})));
        logger.info("" + Arrays.toString(solution.plusOne(new int[]{1, 9, 9})));
    }
}
