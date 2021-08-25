package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    private static Logger logger = LoggerFactory.getLogger(PalindromeNumber.class);

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();

        logger.info("121 :" + solution.isPalindrome(121));
        logger.info("-121 :" + solution.isPalindrome(-121));
        logger.info("0 :" + solution.isPalindrome(0));
        logger.info("10 :" + solution.isPalindrome(10));
        logger.info("1232112321 :" + solution.isPalindrome(1232112321));
        logger.info("12321 :" + solution.isPalindrome(12321));
    }
}