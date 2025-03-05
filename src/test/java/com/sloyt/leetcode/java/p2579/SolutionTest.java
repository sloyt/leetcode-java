package com.sloyt.leetcode.java.p2579;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(1, solution.coloredCells(1));
        assertEquals(5, solution.coloredCells(2));
    }
}
