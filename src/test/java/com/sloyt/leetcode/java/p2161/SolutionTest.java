package com.sloyt.leetcode.java.p2161;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals("[9, 5, 3, 10, 10, 12, 14]", Arrays.toString(
                solution.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)
        ));
        assertEquals("[-3, 2, 4, 3]", Arrays.toString(
                solution.pivotArray(new int[]{-3, 4, 3, 2}, 2)
        ));
        assertEquals("[4, 0, 4, -11, 5]", Arrays.toString(
                solution.pivotArray(new int[]{4, 0, 4, 5, -11}, 5)
        ));

        // my
        assertEquals("[2, 4, 3]", Arrays.toString(
                solution.pivotArray(new int[]{2, 4, 3}, 2)
        ));
        assertEquals("[2, 3, 4]", Arrays.toString(
                solution.pivotArray(new int[]{2, 4, 3}, 4)
        ));
        assertEquals("[2]", Arrays.toString(
                solution.pivotArray(new int[]{2}, 2)
        ));
    }
}
