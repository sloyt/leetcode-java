package com.sloyt.leetcode.java.p2965;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> arr = new HashSet<>();
        int n = grid.length;
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr.contains(grid[i][j])) result[0] = grid[i][j];
                else arr.add(grid[i][j]);
            }
        }

        for (int i = 1; i <= (n * n); i++) {
            if (!arr.contains(i)) {
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
