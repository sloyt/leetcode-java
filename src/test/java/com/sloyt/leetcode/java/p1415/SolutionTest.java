package com.sloyt.leetcode.java.p1415;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals("c", solution.getHappyString(1, 3));
        assertEquals("", solution.getHappyString(1, 4));
        assertEquals("cab", solution.getHappyString(3, 9));
    }
}
