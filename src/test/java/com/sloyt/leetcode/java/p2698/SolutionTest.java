package com.sloyt.leetcode.java.p2698;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {
    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(182, solution.punishmentNumber(10));
        assertEquals(1478, solution.punishmentNumber(37));
        assertEquals(41334, solution.punishmentNumber(166));
        assertEquals(1478, solution.punishmentNumber(37));
        assertEquals(2725885, solution.punishmentNumber(768));
    }
}
