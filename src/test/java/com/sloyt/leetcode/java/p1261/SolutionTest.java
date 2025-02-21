package com.sloyt.leetcode.java.p1261;

import com.sloyt.leetcode.java.TestSolution;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest extends TestCase implements TestSolution {

    @Override
    public void testRun() {
        test1();
        test2();
        test3();
    }

    public void test1() {
        TreeNode root = buildTree(new Integer[]{-1, null, -1});
        Solution solution = new Solution(root);

        assertFalse(solution.find(1));
        assertTrue(solution.find(2));
    }

    public void test2() {
        TreeNode root = buildTree(new Integer[]{-1, -1, -1, -1, -1});
        Solution solution = new Solution(root);

        assertTrue(solution.find(1));
        assertTrue(solution.find(3));
        assertFalse(solution.find(5));
    }

    public void test3() {
        TreeNode root = buildTree(new Integer[]{-1,null,-1,-1,null,-1});
        Solution solution = new Solution(root);

        assertTrue(solution.find(2));
        assertFalse(solution.find(3));
        assertFalse(solution.find(4));
        assertTrue(solution.find(5));
    }

    private TreeNode buildTree(Integer[] input) {
        if ((input.length == 0) || (input[0] == null)) return null;

        List<TreeNode> currentLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        TreeNode root = new TreeNode(input[0]);
        currentLevel.add(root);

        boolean isLeft = true;
        int currentLevelIndex = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] != null) {
                TreeNode node = new TreeNode(input[i]);

                if (isLeft) {
                    currentLevel.get(currentLevelIndex).left = node;
                } else {
                    currentLevel.get(currentLevelIndex).right = node;
                }

                nextLevel.add(node);
            }

            isLeft = !isLeft;

            if (isLeft) {
                currentLevelIndex++;
            }

            if (currentLevelIndex == currentLevel.size()) {
                currentLevel = nextLevel;
                nextLevel = new ArrayList<>();

                currentLevelIndex = 0;
            }
        }

        return root;
    }

    private void printTree(TreeNode node) {
        if (node.left != null) {
            System.out.println("left : " + node.left.val);
            printTree(node.left);
        } else {
            System.out.println("left : null");
        }

        if (node.right != null) {
            System.out.println("right : " + node.right.val);
            printTree(node.right);
        } else {
            System.out.println("right : null");
        }

        System.out.println("up");
    }
}
