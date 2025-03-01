package com.sloyt.leetcode.java.p2460;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertTrue(Arrays.equals(
                new int []{1,4,2,0,0,0},
                solution.applyOperations(new int[] {1,2,2,1,1,0})
        ));
        assertTrue(Arrays.equals(
                new int []{1,0},
                solution.applyOperations(new int[] {0,1})
        ));
    }
}
