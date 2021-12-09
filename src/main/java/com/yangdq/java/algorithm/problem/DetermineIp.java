package com.yangdq.java.algorithm.problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// 判断字符串是否是IP
public class DetermineIp {

    private static Logger logger = LoggerFactory.getLogger(DetermineIp.class);

    public static boolean isIp(String str) {
        // 255.255.255.255
        // 0.0.0.0
        if (str.length() < 7 || str.length() > 15) {
            return false;
        }

        int cnt = 0;
        int number = 0;
        Character last = ' ';
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if ((ch < '0' || ch > '9') && ch != '.') {
                return false;
            }

            if (ch == '.') {
                if (cnt > 3 || last == '.') {
                    return false;
                }
                cnt = 0;
                number = 0;
            } else {
                if (last == '0' && ch == '0' && number == 0) {
                    return false;
                }
                number = number * 10 + (ch - '0');
                cnt++;
            }

            if (number < 0 || number > 255 || cnt > 3) {
                return false;
            }
            last = ch;
        }

        return true;
    }

    public static void main(String[] args) {
        logger.info("" + DetermineIp.isIp("200.200.."));
    }
}
