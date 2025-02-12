package com.sloyt.leetcode.java.p2342;

import java.util.*;

public class Solution {
    private int getSumOfDigits(int num) {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int sum = getSumOfDigits(num);

            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }

            map.get(sum).add(num);
        }

        int result = -1;

        for (List<Integer> list : map.values()) {
            if (list.size() >= 2) {
                list.sort(Comparator.comparingInt(a -> a));

                int sum = list.get(list.size() - 1) + list.get(list.size() - 2);

                if (sum > result) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
