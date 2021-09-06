package com.yangdq.java.algorithm.leetcode.medium;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int [] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                sb.append(symbol);
                num -= value;
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
