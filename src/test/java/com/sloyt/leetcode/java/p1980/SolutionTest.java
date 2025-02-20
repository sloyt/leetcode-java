package com.sloyt.leetcode.java.p1980;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        String result1 = solution.findDifferentBinaryString(new String[] { "01", "10" });
        assertTrue(Arrays.stream(new String[] { "11", "00" }).anyMatch(s -> s.equals(result1)));

        String result2 = solution.findDifferentBinaryString(new String[] { "00", "01" });
        assertTrue(Arrays.stream(new String[] { "11", "10" }).anyMatch(s -> s.equals(result2)));

        String result3 = solution.findDifferentBinaryString(new String[] { "111", "011", "001" });
        assertTrue(Arrays.stream(new String[] { "101", "000", "010", "100", "110" }).anyMatch(s -> s.equals(result3)));

        String result4 = solution.findDifferentBinaryString(new String[] { "0" });
        assertTrue(Arrays.stream(new String[] { "1" }).anyMatch(s -> s.equals(result4)));

        String result5 = solution.findDifferentBinaryString(new String[] { "00", "10", "01" });
        assertTrue(Arrays.stream(new String[] { "11" }).anyMatch(s -> s.equals(result5)));
    }
}
