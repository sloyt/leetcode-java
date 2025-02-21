package com.sloyt.leetcode.java.p1261;

public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
        this.root.val = 0;

        fixTree(root, 0);
    }

    private void fixTree(TreeNode node, int level) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            fixTree(node.left, level + 1);
        }

        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            fixTree(node.right, level + 1);
        }
    }

    public boolean find(int target) {
        return find(root, target);
    }

    private boolean find(TreeNode node, int target) {
        if (node == null) return false;
        if (node.val == target) return true;

        return backtrack(2 * node.val + 1, target)
                ? find(node.left, target)
                : find(node.right, target);
    }

    private boolean backtrack(int value, int target) {
        if (value > target) return false;
        if (value == target) return true;

        boolean result = backtrack(value * 2 + 1, target);

        return result ? result : backtrack(value * 2 + 2, target);
    }
}
