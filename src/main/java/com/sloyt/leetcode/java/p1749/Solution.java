package com.sloyt.leetcode.java.p1749;

public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sumMax = 0;
        int sumMin = 0;
        int max = 0;

        for (int n : nums) {
            sumMax = Math.max(sumMax + n, n);
            sumMin = Math.min(sumMin + n, n);

            max = Math.max(max, Math.max(Math.abs(sumMax), Math.abs(sumMin)));
        }

        return max;
    }
}
