package com.sloyt.leetcode.java.p1718;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertTrue(Arrays.equals(
                new int[]{2, 1, 2},
                solution.constructDistancedSequence(2)
        ));

        assertTrue(Arrays.equals(
                new int[]{3, 1, 2, 3, 2},
                solution.constructDistancedSequence(3)
        ));

        assertTrue(Arrays.equals(
                new int[]{5,3,1,4,3,5,2,4,2},
                solution.constructDistancedSequence(5)
        ));

        assertTrue(Arrays.equals(
                new int[0],
                solution.constructDistancedSequence(15)
        ));

//        assertTrue(Arrays.equals(
//                new int[]{3, 1, 2, 3, 2},
//                solution.constructDistancedSequence(20)
//        ));
    }
}
