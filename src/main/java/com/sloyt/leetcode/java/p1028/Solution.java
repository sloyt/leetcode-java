package com.sloyt.leetcode.java.p1028;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    private Deque<int[]> queue;

    public TreeNode recoverFromPreorder(String traversal) {
        queue = new ArrayDeque<>();

        int depth = 0;
        StringBuffer numBuf = new StringBuffer();

        for (char c : traversal.toCharArray()) {
            if (c == '-') {
                if (numBuf.length() > 0) {
                    queue.add(new int[] { depth, Integer.parseInt(numBuf.toString()) });

                    // reset buffers
                    numBuf.setLength(0);
                    depth = 0;
                }

                depth++;
            } else {
                numBuf.append(c);
            }
        }

        // add last number

        queue.add(new int[] { depth, Integer.parseInt(numBuf.toString()) });

        // grab queue into tree

        TreeNode root = new TreeNode(queue.pollFirst()[1]);

        buildTree(root, 0);

        return root;
    }

    private void buildTree(TreeNode node, int depth) {
        boolean isLeftSubtree = true;

        while ((queue.size() > 0) && ((queue.peekFirst()[0] - depth) >= 1)) {
            if ((queue.peekFirst()[0] - depth) == 1) {
                if (node.left == null) {
                    node.left = new TreeNode(queue.pollFirst()[1]);
                } else {
                    node.right = new TreeNode(queue.pollFirst()[1]);
                    isLeftSubtree = false;
                }
            } else {
                if ((queue.peekFirst()[0] - depth) > 1) {
                    buildTree(isLeftSubtree ? node.left : node.right, depth + 1);
                }
            }
        }
    }
}
