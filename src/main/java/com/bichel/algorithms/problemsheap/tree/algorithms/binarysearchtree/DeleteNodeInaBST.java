package com.bichel.algorithms.problemsheap.tree.algorithms.binarysearchtree;

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class DeleteNodeInaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    // One step right and then always left
    private int successor(TreeNode root) {
        root = root.right;

        while (root.left != null)
            root = root.left;

        return root.val;
    }

    // One step left and then always right
    private int predecessor(TreeNode root) {
        root = root.left;

        while (root.right != null)
            root = root.right;

        return root.val;
    }
}
