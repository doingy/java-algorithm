package com.yangdq.java.algorithm.leetcode.medium;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String lastStr = countAndSay(n - 1);

            StringBuilder sb = new StringBuilder();
            int i = 0, j = 1, len = lastStr.length();
            while (j < len) {
                if (lastStr.charAt(i) != lastStr.charAt(j)) {
                    sb.append(j - i).append(lastStr.charAt(i));
                    i = j;
                }
                j++;
            }
            sb.append(j - i).append(lastStr.charAt(i));
            return sb.toString();
        }
    }
}
