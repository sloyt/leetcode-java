package com.sloyt.leetcode.java.p1718;

import java.util.Arrays;

public class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];

        backtrack(result, 0, n, used);

        System.out.println("### RESULT : " + Arrays.toString(result));

        return result;
    }

    private boolean backtrack(int[] result, int index, int n, boolean[] used) {
        if (index == result.length) {
            return true;
        }

        if (result[index] != 0) {
            return backtrack(result, index + 1, n, used);
        }

        for (int i = n; i >= 1; i--) {
            if (!used[i]) {
                if (i == 1) {
                    result[index] = i;
                    used[i] = true;

                    if (backtrack(result, index + 1, n, used)) {
                        return true;
                    }

                    used[i] = false;
                    result[index] = 0;
                } else if (index + i < result.length && result[index + i] == 0) {
                    result[index] = i;
                    result[index + i] = i;
                    used[i] = true;

                    if (backtrack(result, index + 1, n, used)) {
                        return true;
                    }

                    used[i] = false;
                    result[index] = 0;
                    result[index + i] = 0;
                }
            }
        }

        return false;
    }
}
