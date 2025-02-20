package com.sloyt.leetcode.java.p1980;

public class Solution {
    StringBuffer sb;
    String[] used;

    public String findDifferentBinaryString(String[] nums) {
        sb = new StringBuffer();
        used = nums;

        backtrack();

        return sb.toString();
    }

    public boolean backtrack() {
        int trial = 0;
        boolean result;

        do {
            if (sb.length() == used[0].length()) {
                result = true;
                String match = sb.toString();

                for (String s : used) {
                    if (s.equals(match)) {
                        result = false;
                        break;
                    }
                }
            } else {
                sb.append("" + trial);

                result = backtrack();

                if (!result) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        while(!result && (++trial < 2));

        return result;
    }
}
