package com.sloyt.leetcode.java.p1780;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertTrue(solution.checkPowersOfThree(12));
        assertTrue(solution.checkPowersOfThree(91));
        assertFalse(solution.checkPowersOfThree(21));
    }
}
