package com.sloyt.leetcode.java.p2570;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i1 = 0;
        int i2 = 0;

        List<Integer[]> result = new ArrayList<>();

        while ((i1 < nums1.length) || (i2 < nums2.length)) {
            if (i1 == nums1.length) {
                result.add(new Integer[]{nums2[i2][0], nums2[i2][1]});

                i2 += 1;

                continue;
            }

            if (i2 == nums2.length) {
                result.add(new Integer[]{nums1[i1][0], nums1[i1][1]});

                i1 += 1;
                continue;
            }

            if (nums1[i1][0] == nums2[i2][0]) {
                result.add(new Integer[]{nums1[i1][0], nums1[i1][1] + nums2[i2][1]});

                i1 += 1;
                i2 += 1;
            } else if (nums1[i1][0] < nums2[i2][0]) {
                result.add(new Integer[]{nums1[i1][0], nums1[i1][1]});

                i1 += 1;
            } else {
                result.add(new Integer[]{nums2[i2][0], nums2[i2][1]});

                i2 += 1;
            }
        }

        return result.stream()
                .map(x -> new int[]{x[0], x[1]})
                .toArray(int[][]::new);
    }
}
