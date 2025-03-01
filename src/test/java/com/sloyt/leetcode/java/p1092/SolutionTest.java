package com.sloyt.leetcode.java.p1092;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals("cabac", solution.shortestCommonSupersequence("abac", "cab"));
        assertEquals("aaaaaaaa", solution.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));

        // leetcode extra
        assertEquals("bbbaaababbb", solution.shortestCommonSupersequence("bbbaaaba", "bbababbb"));

        // ai suggested (w corrected answer)
        assertEquals("abcdef", solution.shortestCommonSupersequence("abc", "def"));
        assertEquals("abc", solution.shortestCommonSupersequence("abc", "abc"));
        assertEquals("abc", solution.shortestCommonSupersequence("abc", "ac"));
    }
}
