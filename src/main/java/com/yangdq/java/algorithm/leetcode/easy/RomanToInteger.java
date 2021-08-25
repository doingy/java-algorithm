package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    private static Logger logger = LoggerFactory.getLogger(RomanToInteger.class);

    /*
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    IV IX  4   9
    XL XC  40  90
    CD CM  400 900
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i < s.length() - 1) && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        logger.info("" + solution.romanToInt("MCMXCIV"));
    }
}
