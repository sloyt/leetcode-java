package com.sloyt.leetcode.java.p2965;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertTrue(Arrays.equals(
                new int[]{2, 4},
                solution.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})
        ));
        assertTrue(Arrays.equals(
                new int[]{9, 5},
                solution.findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})
        ));
    }
}
