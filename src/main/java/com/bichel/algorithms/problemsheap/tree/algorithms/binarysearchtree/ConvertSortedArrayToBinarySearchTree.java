package com.bichel.algorithms.problemsheap.tree.algorithms.binarysearchtree;

/*
Given an integer array nums where the elements are sorted
in ascending order, convert it to
a height-balanced binary search tree.

A height-balanced binary tree is a binary tree
in which the depth of the two subtrees of every node
never differs by more than one.
 */

import com.bichel.algorithms.problemsheap.tree.datastructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r)
            return null;

        int middle = (l + r) / 2;

        TreeNode node = new TreeNode(nums[middle]);

        node.left = build(nums, l, middle - 1);
        node.right = build(nums, middle + 1, r);

        return node;
    }
}
