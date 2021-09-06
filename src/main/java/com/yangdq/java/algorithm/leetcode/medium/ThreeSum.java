package com.yangdq.java.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int f = 0; f < n; f++) {
            if (f > 0 && nums[f] == nums[f-1]) {
                continue;
            }
            int target = -nums[f];
            for (int s = f + 1; s < n; s++) {
                if (s > f + 1 && nums[s] == nums[s-1]) {
                    continue;
                }
                int t = n - 1;
                while(s < t && nums[s] + nums[t] > target) {
                    t--;
                }

                if (s == t) {
                    break;
                }

                if (nums[s] + nums[t] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[f]);
                    list.add(nums[s]);
                    list.add(nums[t]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
