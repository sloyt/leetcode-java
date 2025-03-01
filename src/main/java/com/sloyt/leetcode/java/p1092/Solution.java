package com.sloyt.leetcode.java.p1092;

public class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // create DP
        for (int i = 0; i < (len1 + 1); i++) {
            for (int j = 0; j < (len2 + 1); j++) {
                if ((i == 0) || (j == 0)) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // print DP
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();

        // walk from bottom-right
        while ((len1 > 0) && (len2 > 0)) {
            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                sb.append(str1.charAt(len1 - 1));
                len1 -= 1;
                len2 -= 1;
            } else if (dp[len1 - 1][len2] > dp[len1][len2 - 1]) {
                sb.append(str1.charAt(len1 - 1));
                len1 -= 1;
            } else {
                sb.append(str2.charAt(len2 - 1));
                len2 -= 1;
            }
        }

        // append leftovers
        while (len1 > 0) {
            sb.append(str1.charAt(len1 - 1));
            len1 -= 1;
        }

        while (len2 > 0) {
            sb.append(str2.charAt(len2 - 1));
            len2 -= 1;
        }

        return sb.reverse().toString();
    }
}
