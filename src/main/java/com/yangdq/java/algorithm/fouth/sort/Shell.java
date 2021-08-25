package com.yangdq.java.algorithm.fouth.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Shell {
    public static Logger logger = LoggerFactory.getLogger(Shell.class);

    public static void sorted(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j].compareTo(a[j - h]) < 0) {
                        Comparable tmp = a[j - h];
                        a[j - h] = a[j];
                        a[j] = tmp;
                    }
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        var a = new Integer[]{2, 3, 5, 1, 4};
        Selection.sorted(a);
        logger.info(Arrays.toString(a));
    }
}
