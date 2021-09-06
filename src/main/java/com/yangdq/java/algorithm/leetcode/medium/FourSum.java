package com.yangdq.java.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int f = 0; f < n - 3; f++) {
            if (f > 0 && nums[f] == nums[f - 1]) {
                continue;
            }
            if (nums[f] + nums[f + 1] + nums[f + 2] + nums[f + 3] > target) {
                break;
            }
            if (nums[f] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int s = f + 1; s < n - 2; s++) {
                if (s > f + 1 && nums[s] == nums[s - 1]) {
                    continue;
                }
                if (nums[f] + nums[s] + nums[s + 1] + nums[s + 2] > target) {
                    break;
                }
                if (nums[f] + nums[s] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int left = s + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[f] + nums[s] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[f], nums[s], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
