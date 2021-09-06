package com.yangdq.java.algorithm.leetcode.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {

    private static Logger logger = LoggerFactory.getLogger(StringToIntegerAtoi.class);

    public int myAtoi(String s) {
        Automaton auto = new Automaton();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            auto.get(ch);
        }
        return (int) (auto.sign * auto.ans);
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;

        private String state  = "start";
        private Map<String, String[]> table = new HashMap<>() {
            {
                put("start", new String[]{"start", "signed", "in_number", "end"});
                put("signed", new String[]{"end", "end", "in_number", "end"});
                put("in_number", new String[]{"end", "end", "in_number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };

        public void get(char ch) {
            state = table.get(state)[get_col(ch)];
            if ("in_number" == state) {
                ans = ans * 10 + ( ch - '0');
                ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
            } else if ("signed" == state) {
                sign = '+' == ch ? 1 : -1;
            }
        }

        private int get_col(char ch) {
            if (' ' == ch) {
                return 0;
            }
            if ('+' == ch || '-' == ch) {
                return 1;
            }
            if ('0' <= ch && ch <= '9') {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        StringToIntegerAtoi solution = new StringToIntegerAtoi();
        logger.info("" + solution.myAtoi("+12311"));
    }
}
