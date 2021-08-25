package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    private static Logger logger = LoggerFactory.getLogger(ValidParentheses.class);

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        logger.info("()[]{} : " + solution.isValid("()[]{}"));
        logger.info("([)] : " + solution.isValid("([)]"));
    }
}
