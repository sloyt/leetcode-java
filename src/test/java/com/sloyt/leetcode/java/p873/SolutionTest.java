package com.sloyt.leetcode.java.p873;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals(5, solution.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        assertEquals(3, solution.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));

//        assertEquals(5, solution.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
//        assertEquals(3, solution.lenLongestFibSubseq(new int[]{7,7,7,7,7,7,7}));
    }
}
