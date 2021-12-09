package com.yangdq.java.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrack(nums, output, ans, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> output, List<List<Integer>> ans, int pos) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(output));
        }
        for (int i = pos; i < nums.length; i++) {
            Collections.swap(output, i, pos);
            backtrack(nums, output, ans, pos + 1);
            Collections.swap(output, i, pos);
        }

    }
}
