package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    private static Logger logger = LoggerFactory.getLogger(LongestCommonPrefix.class);

    // 二分查找
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }

        int low = 0;
        int high = minLength;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String ans = strs[0].substring(0, length);
        for (int i = 0; i < length; i++) {
            char c = ans.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return false;
                }
            }
        }
        return true;
    }

    // 分治
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }

        int mid = (start + end) / 2;
        String left = longestCommonPrefix(strs, start, mid);
        String right = longestCommonPrefix(strs, mid + 1, end);
        int index = 0;
        int length = Math.min(left.length(), right.length());
        while (index < length && left.charAt(index) == right.charAt(index)) {
            index++;
        }
        return left.substring(0, index);
    }

    // 纵向扫描
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 0; i < ans.length(); i++) {
            char c = ans.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return ans.substring(0, i);
                }
            }
        }

        return ans;
    }

    // 横向扫描
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];

            // str ans
            int length = Math.min(ans.length(), str.length());
            int index = 0;
            while (index < length && ans.charAt(index) == str.charAt(index)) {
                index++;
            }
            ans = ans.substring(0, index);

            if (ans.length() == 0) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        logger.info("" + solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        logger.info("" + solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
