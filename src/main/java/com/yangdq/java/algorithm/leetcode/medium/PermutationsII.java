package com.yangdq.java.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, output, vis);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, int pos, List<Integer> output, boolean[] vis) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            output.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, pos + 1, output, vis);
            vis[i] = false;
            output.remove(pos);
        }
    }
}
