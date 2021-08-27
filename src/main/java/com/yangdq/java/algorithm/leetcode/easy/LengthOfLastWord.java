package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    private static Logger logger = LoggerFactory.getLogger(LengthOfLastWord.class);

    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                ans++;
            }
            if (s.charAt(i) == ' ' && ans != 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        logger.info(" " + solution.lengthOfLastWord("    "));
        logger.info(" " + solution.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
