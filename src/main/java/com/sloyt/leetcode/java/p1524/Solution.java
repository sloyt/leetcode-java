package com.sloyt.leetcode.java.p1524;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1;   // 0 is also even
        int odd = 0;
        int sum = 0;
        int result = 0;

        for (int n : arr) {
            sum += n;

            if ((sum % 2) == 0) {
                result = (result + odd) % 1000000007;
                even++;
            } else {
                result = (result + even) % 1000000007;
                odd++;
            }
        }

        return result;
    }
}
