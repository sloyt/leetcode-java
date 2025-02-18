package com.sloyt.leetcode.java.p2375;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals("123549876", solution.smallestNumber("IIIDIDDD"));
        assertEquals("4321", solution.smallestNumber("DDD"));
    }
}
