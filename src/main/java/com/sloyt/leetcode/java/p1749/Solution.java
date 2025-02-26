package com.sloyt.leetcode.java.p1749;

public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxPos = 0;
        int maxNeg = 0;
        int sum;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;

            int j = i;

            while (j < nums.length) {
                sum += nums[j];

                if (sum > maxPos) maxPos = sum;
                if (sum < maxNeg) maxNeg = sum;

                j++;
            }
        }

        return (maxPos > -maxNeg) ? maxPos : -maxNeg;
    }
}
