package com.sloyt.leetcode.java.p1415;

import java.util.Arrays;

public class Solution {
    char[] chars = {'a', 'b', 'c'};
    char[] result;
    int counter;

    public String getHappyString(int n, int k) {
        result = new char[n];
        counter = k;

        boolean hasResult = backtrack(0);

        StringBuffer sb = new StringBuffer();

        if (hasResult) {
            for (char c: this.result) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean backtrack(int pos) {
        char[] used = new char[pos > 0 ? this.chars.length - 1 : this.chars.length];
        int usedIndex = 0;

        char guess;
        boolean isTimeToExit = false;

        do {
            guess = 0;

            for (char c : this.chars) {
                if (((pos == 0) || (c != this.result[pos - 1]))
                        && !contains(used, c)
                ) {
                    guess = c;
                    break;
                }
            }

            if (guess != 0) {
                this.result[pos] = guess;

                if (pos < (this.result.length - 1)) {
                    isTimeToExit = backtrack(pos + 1);
                }
                else {
                    if (--counter == 0) {
                        isTimeToExit = true;
                    }
                }

                used[usedIndex++] = guess;
            }
        }
        while((guess != 0) && !isTimeToExit);

        return isTimeToExit;
    }

    private static boolean contains(char[] array, char target) {
        for (char c : array) {
            if (c == target) {
                return true;
            }
        }

        return false;
    }
}
