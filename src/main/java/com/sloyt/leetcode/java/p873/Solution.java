package com.sloyt.leetcode.java.p873;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        int last = arr[arr.length - 1];

        // prepare lookup set
        Set<Integer> lookupSet = new TreeSet<>();

        for (int num : arr) lookupSet.add(num);

        // walk through array
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int num1 = arr[i];
                int num2 = arr[j];

                // optimization
                if ((num1 + num2) > last) break;

                int count = 2;

                int next;

                while ((next = nextFibonacci(num1, num2)) <= last) {
                    if (lookupSet.contains(next)) {
                        count++;
                        num1 = num2;
                        num2 = next;
                    } else {
                        break;
                    }
                }

                if (count > max) {
                    max = count;
                }
            }
        }

        return max < 3 ? 0 : max;
    }

    private int nextFibonacci(int num1, int num2) {
        return num1 + num2;
    }
}
