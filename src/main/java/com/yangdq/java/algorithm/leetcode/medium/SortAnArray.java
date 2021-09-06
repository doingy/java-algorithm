package com.yangdq.java.algorithm.leetcode.medium;

/**
 * https://leetcode.com/problems/sort-an-array
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = partition2(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (nums[j] > pivot && i < j) {
                j--;
            }
            while (nums[i] <= pivot && i < j) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, l, i);
        return i;
    }

    private static int partition2(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
