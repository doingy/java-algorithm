package com.yangdq.java.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int begin) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        for (int idx = begin; idx < candidates.length; idx++) {
            if (idx > begin && candidates[idx] == candidates[idx - 1]) {
                continue;
            }
            int rs = target - candidates[idx];
            if (rs < 0) {
                break;
            }
            combine.add(candidates[idx]);
            dfs(candidates, rs, ans, combine, idx + 1);
            combine.remove(combine.size() - 1);
        }
    }
}
