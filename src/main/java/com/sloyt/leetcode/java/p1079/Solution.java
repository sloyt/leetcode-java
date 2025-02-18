package com.sloyt.leetcode.java.p1079;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ++res;
                --cnt[i];
                res += dfs(cnt);
                ++cnt[i];
            }
        }
        return res;
    }

//    public int numTilePossibilities(String tiles) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (char c: tiles.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        return (int)Math.pow(2, map.size()) - 1;

//        int dividend = factorial(tiles.length());
//        int divisor = 1;
//
//        for (Integer repeats: map.values()) {
//            divisor *= factorial(repeats);
//        }
//
//        return dividend / divisor;

//        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
//            int letters = map.keySet().size() - 1 + entry.getValue();
//
//            result += 1;    // self
//
//            for (int i = 1; i < letters; i++) {
//                result += letters - 1;
//            }
//        }
//    }

    int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

// AB:
// A, AB
// B, BA

// ABC:
// A, AB, AC, ABC, ACB
// B, BA, BC, BAC, BCA
// C, CB, CA, CBA, CAB


// AAB:
// A, AA, AB, AAB, ABA,
// B, BA, BA, BAA, BAA,
