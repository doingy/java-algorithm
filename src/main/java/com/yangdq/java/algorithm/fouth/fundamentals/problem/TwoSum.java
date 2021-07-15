package com.yangdq.java.algorithm.fouth.fundamentals.problem;

import java.util.Arrays;

public class TwoSum {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            // 如果二分查找不成功则会返回-1，因此我们不会增加计数器的值；
            // 如果二分查找返回的j＞i，我们就有a[i] + a[j] = 0，增加计数器的值；
            // 如果二分查找返回的j在0和i之间，我们也有a[i] + a[j] = 0，但不能增加计数器的值，以避免重复计数。
//            if (BinarySearch.rank(-a[i], a) > i) {
//                cnt++;
//            }
        }
        return cnt;
    }
}
