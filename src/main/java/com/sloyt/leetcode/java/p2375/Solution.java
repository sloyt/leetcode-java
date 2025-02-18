package com.sloyt.leetcode.java.p2375;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    char[] pattern;
    Set<Integer> result;

    public String smallestNumber(String pattern) {
        this.result = new LinkedHashSet<>();
        this.pattern = pattern.toCharArray();

        backtrack(0, 0);

        StringBuffer sb = new StringBuffer();
        Iterator<Integer> iter = this.result.iterator();

        while (iter.hasNext()) sb.append(iter.next());

        return sb.toString();
    }

    public boolean backtrack(int pos, int prev) {
        if (pos > this.pattern.length) {
            return true;
        }

        boolean result = false;
        Set<Integer> used = new HashSet<>();
        int num = prev;

        do {
            if (pos == 0) {
                num++;
            } else {
                num = (this.pattern[pos - 1] == 'I') ? num + 1 : num - 1;
            }

            if ((num > 0) && (num < 10) &&
                    !this.result.contains(num) && !used.contains(num)
            ) {
                this.result.add(num);
                result = backtrack(pos + 1, num);

                if (!result) {
                    this.result.remove(num);
                }
            }
        }
        while ((num > 0) && (num < 10) && !result);

        return result;
    }
}
