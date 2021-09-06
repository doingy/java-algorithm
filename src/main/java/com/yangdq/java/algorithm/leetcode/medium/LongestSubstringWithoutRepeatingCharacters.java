package com.yangdq.java.algorithm.leetcode.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    private static Logger logger = LoggerFactory.getLogger(LongestSubstringWithoutRepeatingCharacters.class);

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int r = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
