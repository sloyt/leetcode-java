package com.sloyt.leetcode.java.p1780;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    static List<Integer> cache = new LinkedList<>();

    public boolean checkPowersOfThree(int n) {
        int startIdx = -1;

        // find cached first power of three that is bigger than "n"
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i) > n) {
                startIdx = i;
                break;
            }
        }

        if (startIdx < 0) {
            // calculate all powers of three until we overcome "n"
            int num;

            while ((num = (int)Math.pow(3, cache.size())) < n) {
                cache.add(num);
            }

            startIdx = cache.size() - 1;
        }

        // if "n" is power of three - return
        if (cache.get(startIdx) == n) return true;

        // backtrack to get sum of powers of three
        return backtrack(startIdx, 0, n);
    }

    private boolean backtrack(int startIdx, int sum, int n) {
        if (startIdx < 0) return false;

        int current = cache.get(startIdx);
        boolean result = false;

        if ((sum + current) == n) {
            result = true;
        }

        if (!result && ((sum + current) < n)) {
            result = backtrack(startIdx - 1, sum + current, n);
        }

        if (!result) {
            result = backtrack(startIdx - 1, sum, n);
        }

        return result;
    }
}
