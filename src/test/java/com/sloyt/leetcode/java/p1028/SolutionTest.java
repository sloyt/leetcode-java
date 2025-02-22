package com.sloyt.leetcode.java.p1028;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.*;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals("[1, 2, 5, 3, 4, 6, 7]", printTree(solution.recoverFromPreorder("1-2--3--4-5--6--7")));
        assertEquals("[1, 2, 5, 3, null, 6, null, 4, null, 7]", printTree(solution.recoverFromPreorder("1-2--3---4-5--6---7")));
        assertEquals("[1, 401, null, 349, 88, 90]", printTree(solution.recoverFromPreorder("1-401--349---90--88")));
        assertEquals("[3]", printTree(solution.recoverFromPreorder("3")));
        assertEquals("[1, 2, 3, 4, 7, 5, 6]", printTree(solution.recoverFromPreorder("1-2-3--4---5---6--7")));
    }

    private String printTree(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        walkTree(root, 0, map);

        List<Integer> result = new ArrayList<>();

        for (List<Integer> l : map.values()) {
            for (Integer i : l) {
                result.add(i);
            }
        }

        if (result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return Arrays.toString(result.toArray());
    }

    private void walkTree(TreeNode node, int depth, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<>());
        }

        map.get(depth).add(node == null ? null : node.val);

        if (node != null) {
            if (node.left != null) {
                walkTree(node.left, depth + 1, map);
                walkTree(node.right, depth + 1, map);
            }
        }
    }
}
