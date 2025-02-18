package com.sloyt.leetcode.java.p1079;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(1, solution.numTilePossibilities("A"));
        assertEquals(4, solution.numTilePossibilities("AB"));
        assertEquals(15, solution.numTilePossibilities("ABC"));
        assertEquals(8, solution.numTilePossibilities("AAB"));
        assertEquals(188, solution.numTilePossibilities("AAABBC"));
    }
}
