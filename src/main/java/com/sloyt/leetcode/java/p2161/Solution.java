package com.sloyt.leetcode.java.p2161;

import java.util.*;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Deque<Integer> lesser = new ArrayDeque<>();
        Deque<Integer> greater = new ArrayDeque<>();
        int equal = 0;

        for (int num : nums) {
            if (num < pivot) {
                lesser.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal += 1;
            }
        }

        int[] result = new int[nums.length];
        int resultIndex = 0;

        while(lesser.size() > 0) {
            result[resultIndex++] = lesser.poll();
        }

        while (equal-- > 0) result[resultIndex++] = pivot;

        while(greater.size() > 0) {
            result[resultIndex++] = greater.poll();
        }

        return result;
    }
}
