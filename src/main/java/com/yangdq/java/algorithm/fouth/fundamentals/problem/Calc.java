package com.yangdq.java.algorithm.fouth.fundamentals.problem;

import com.yangdq.java.algorithm.fouth.fundamentals.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 计算器
 * Dijkstra的双栈算术表达式求值算法
 */
public class Calc {
    public static Logger logger = LoggerFactory.getLogger(Calc.class);

    /**
     * 计算
     * 表达式用空格分隔，只能包含 + - * / sqrt ( ) 0-9
     * e.g ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
     */
    public static Double calc(String expression) {

        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();

        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if ("(".equals(token)) {
                continue;
            }

            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) || "sqrt".equals(token)) {
                ops.push(token);
            } else if (")".equals(token)) {
                String op = ops.pop();
                Double value = values.pop();
                if ("+".equals(op)) {
                    value = values.pop() + value;
                } else if ("-".equals(op)) {
                    value = values.pop() - value;
                } else if ("*".equals(op)) {
                    value = values.pop() * value;
                } else if ("/".equals(op)) {
                    value = values.pop() / value;
                } else if ("sqrt".equals(op)) {
                    value = Math.sqrt(value);
                }
                values.push(value);
            } else {
                values.push(Double.parseDouble(token));
            }
        }

        return values.pop();
    }

    public static void main(String[] args) {
        Double result = calc("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        logger.info(String.valueOf(result));
    }
}
