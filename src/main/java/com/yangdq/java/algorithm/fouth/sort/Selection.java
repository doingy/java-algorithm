package com.yangdq.java.algorithm.fouth.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Selection {
    public static Logger logger = LoggerFactory.getLogger(Selection.class);

    public static void sorted(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                var tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        var a = new Integer[]{2, 3, 5, 1, 4};
        Selection.sorted(a);
        logger.info(Arrays.toString(a));
    }
}
