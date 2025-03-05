package com.sloyt.leetcode.java.p2579;

public class Solution {
    public long coloredCells(int n) {
        long outer = (long)Math.pow(n, 2);
        long inner = (long)Math.pow(n - 1, 2);

        return outer + inner;
    }
}
