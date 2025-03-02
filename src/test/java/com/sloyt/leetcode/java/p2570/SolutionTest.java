package com.sloyt.leetcode.java.p2570;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(
                "[[1, 6], [2, 3], [3, 2], [4, 6]]",
                arrayToString(solution.mergeArrays(
                        new int[][]{new int[]{1,2},new int[]{2,3},new int[]{4,5}},
                        new int[][]{new int[]{1,4},new int[]{3,2},new int[]{4,1}}
                ))
        );
        assertEquals(
                "[[1, 3], [2, 4], [3, 6], [4, 3], [5, 5]]",
                arrayToString(solution.mergeArrays(
                        new int[][]{new int[]{2,4},new int[]{3,6},new int[]{5,5}},
                        new int[][]{new int[]{1,3},new int[]{4,3}}
                ))
        );
    }

    private String arrayToString(int[][] array) {
        return Arrays.toString(
                Arrays.stream(array).map(a -> Arrays.toString(a)).toArray()
        );
    }
}
