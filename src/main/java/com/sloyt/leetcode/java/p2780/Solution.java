package com.sloyt.leetcode.java.p2780;

import java.util.*;

public class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> diversity = new HashMap<>();
        int dominant = -1;
        int max = -1;

        // look for dominant number

        for (int i : nums) {
            int value = diversity.getOrDefault(i, 0);

            diversity.put(i, ++value);

            if (value > max) {
                max = value;
                dominant = i;
            }
        }

        // look for slice

        int current = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) {
                current++;
            }

            if (current > (i + 1) / 2) {
                // we need to check the right part
                if ((nums.size() - (i + 1)) / 2 < (max - current)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
