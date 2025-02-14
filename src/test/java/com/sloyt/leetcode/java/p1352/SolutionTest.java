package com.sloyt.leetcode.java.p1352;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.Arrays;

public class SolutionTest extends TestCase implements TestSolution {
    private int[] processCommands(String[] commands, int[] values) {
        Solution solution = new Solution();
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "add":
                    solution.add(values[i]);
                    result[i] = values[i];

                    break;
                case "getProduct":
                    result[i] = solution.getProduct(values[i]);

                    break;
                default:
                    result[i] = -1;
            }
        }

        return result;
    }

    public void testRun() {
        String[] commands = new String[]{"ProductOfNumbers", "add", "add", "add", "add", "add", "getProduct", "getProduct", "getProduct", "add", "getProduct"};
        int[] values = new int[]{-1, 3, 0, 2, 5, 4, 2, 3, 4, 8, 2};

        assertTrue(Arrays.equals(
                new int[]{-1, 3, 0, 2, 5, 4, 20, 40, 0, 8, 32},
                processCommands(commands, values)
        ));
    }
}
