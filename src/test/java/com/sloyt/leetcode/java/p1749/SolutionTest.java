package com.sloyt.leetcode.java.p1749;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(5, solution.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        assertEquals(8, solution.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));

        assertEquals(1, solution.maxAbsoluteSum(new int[]{0,-1}));
        assertEquals(1, solution.maxAbsoluteSum(new int[]{1}));
    }
}
