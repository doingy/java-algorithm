package com.yangdq.java.algorithm.fouth.fundamentals.problem;

import java.util.Arrays;

/**
 * @see TwoSum
 */
public class ThreeSum {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                //
//                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
//                    cnt++;
//                }
            }
        }
        return cnt;
    }
}
