package com.sloyt.leetcode.java.p2460;

public class Solution {
    public int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue; // we don;t need zeroes

            if ((i < (nums.length - 1)) && (nums[i] == nums[i + 1])) {
                result[resultIndex++] = (nums[i] * 2);
                i += 1;
            } else {
                result[resultIndex++] = nums[i];
            }
        }

        for (int i = 0; i < (nums.length - resultIndex); i++) {
            result[resultIndex++] = 0;
        }

        return result;
    }
}
