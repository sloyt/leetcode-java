package com.sloyt.leetcode.java.p1524;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(4, solution.numOfSubarrays(new int[]{1, 3, 5}));
        assertEquals(0, solution.numOfSubarrays(new int[]{2, 4, 6}));
        assertEquals(16, solution.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
