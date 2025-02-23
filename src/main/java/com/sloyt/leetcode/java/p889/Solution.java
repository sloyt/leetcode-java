package com.sloyt.leetcode.java.p889;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Map for quick look-up of postorder index of elements
        Map<Integer, Integer> postIndexMap = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        // Call the helper function to build the tree
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, postIndexMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> postIndexMap) {
        // Base case: If no nodes to process
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        // The first node in preorder is the root
        TreeNode root = new TreeNode(preorder[preStart]);

        // If there is only one element, it's a leaf node
        if (preStart == preEnd) {
            return root;
        }

        // The second element in preorder is the left child of the root
        int leftRootValue = preorder[preStart + 1];

        // Find the position of the left child in postorder
        int leftRootPostIndex = postIndexMap.get(leftRootValue);

        // The number of nodes in the left subtree
        int leftSubtreeSize = leftRootPostIndex - postStart + 1;

        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, postorder, postStart, leftRootPostIndex, postIndexMap);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, leftRootPostIndex + 1, postEnd - 1, postIndexMap);

        return root;
    }
}
