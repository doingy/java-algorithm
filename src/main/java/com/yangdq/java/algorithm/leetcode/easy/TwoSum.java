package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    private static Logger logger = LoggerFactory.getLogger(TwoSum.class);

    // 哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }

    // 暴力
    public int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        logger.info("{2, 7, 11, 15} 9 : " + Arrays.toString(solution.twoSum(new int[]{3, 2 ,4}, 6)));
    }
}
