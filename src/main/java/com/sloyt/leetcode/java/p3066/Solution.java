package com.sloyt.leetcode.java.p3066;

import java.util.*;

public class Solution {
    private Map<Integer, Integer> map;

    public int minOperations(int[] nums, int k) {
        map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.compute(num, (_k, _v) -> _v == null ? 1 : _v + 1));
        }

        int operationsCount = 0;

        while (true) {
            Iterator<Integer> iter = map.keySet().iterator();

            int num1 = iter.next();

            if (num1 >= k || (map.size() == 1 && map.get(num1) == 1)) {
                break;
            }

            int num2 = map.get(num1) == 1
                    ? iter.next()
                    : num1;

            long preRes = num1 * 2L + num2;

            int res = preRes > Integer.MAX_VALUE
                    ? Integer.MAX_VALUE
                    : (int)preRes;

            if (num1 == num2) {
                if (map.get(num1) - 2 > 0) {
                    map.put(num1, map.get(num1) - 2);
                }
                else {
                    map.remove(num1);
                }
            } else {
                map.remove(num1);

                if (map.get(num2) - 1 > 0) {
                    map.put(num2, map.get(num2) - 1);
                }
                else {
                    map.remove(num2);
                }
            }

            map.put(res, map.compute(res, (_k, _v) -> _v == null ? 1 : _v + 1));
            operationsCount++;
        }

        return operationsCount;
    }
}
