package com.yangdq.java.algorithm.problem;

/// 判断字符串是否是IP
public class DetermineIp {
    public static boolean isIp(String str) {
        boolean result = false;

        // 255.255.255.255
        if (str.length() < 7 || str.length() > 15) {
            return false;
        }

        
        for (int i = 0; i < str.length(); i++) {

        }

        return result;

    }
}
