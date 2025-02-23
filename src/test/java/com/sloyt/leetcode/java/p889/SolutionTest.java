package com.sloyt.leetcode.java.p889;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.*;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        Solution solution = new Solution();

        assertEquals("[1, 2, 3, 4, 5, 6, 7]", printTree(solution.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1})));
        assertEquals("[1]", printTree(solution.constructFromPrePost(new int[]{1}, new int[]{1})));
        assertEquals("[2, 1]", printTree(solution.constructFromPrePost(new int[]{2,1}, new int[]{1,2})));
        assertEquals("[2, 1, 3]", printTree(solution.constructFromPrePost(new int[]{2,1,3}, new int[]{3,1,2})));
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
