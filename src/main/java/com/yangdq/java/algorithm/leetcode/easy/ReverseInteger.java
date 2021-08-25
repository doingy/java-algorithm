package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    private static Logger logger = LoggerFactory.getLogger(ReverseInteger.class);

    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
//            if (reversed < Integer.MIN_VALUE / 10 || reversed > Integer.MAX_VALUE / 10) {
//                return 0;
//            }
            int tmp = reversed * 10 + x % 10;

            if (tmp / 10 != reversed) {
                return 0;
            }
            reversed = tmp;

            x = x / 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        logger.info("MIN_VALUE : " + solution.reverse(Integer.MIN_VALUE));
        logger.info("-123 : " + solution.reverse(-123));

    }
}
