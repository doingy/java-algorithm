package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    private static Logger logger = LoggerFactory.getLogger(ImplementStrStr.class);

    // KMP
    public int strStr2(String haystack, String needle) {
        // TODO: Implement strStr() KMP
        return -1;
    }

    // 暴力
    public int strStr(String haystack, String needle) {
        int m = needle.length();

        if (m == 0) {
            return 0;
        }

        int n = haystack.length();

        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr solution = new ImplementStrStr();
        logger.info("a a: " + solution.strStr("a", "a"));
        logger.info("hello ll: " + solution.strStr("hello", "ll"));
        logger.info("hello low: " + solution.strStr("hello", "low"));
    }
}
