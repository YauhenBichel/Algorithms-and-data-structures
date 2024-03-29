package com.bichel.algorithms.unsorted;

/*
Implement next permutation, which rearranges numbers into
the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it
as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Complexity Analysis
Time complexity : O(n). In worst case, only two scans of the whole array are needed.
Space complexity : O(1). No extra space is used. In place replacements are done.
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //find the 1st pair of 2 nums a[i] and a[i-1] from the right,
        //which satisfy a[i] > a[i-1]
        int indUpToDown = nums.length - 2;
        while (indUpToDown >= 0 && nums[indUpToDown] >= nums[indUpToDown + 1] ) {
            indUpToDown--;
        }

        //we want to create the permutation just larger that the current one
        //find the num, which larger than a[indUpToDown]
        if (indUpToDown >= 0) {
            int indNumLargerThanUpToDown = nums.length - 1;
            while (indNumLargerThanUpToDown >= 0 &&
                    nums[indNumLargerThanUpToDown] <= nums[indUpToDown]) {
                indNumLargerThanUpToDown--;
            }

            //switch them
            swap(nums, indUpToDown, indNumLargerThanUpToDown);
        }

        //now they are in decreasing order
        //set to increasing order
        reverse(nums, indUpToDown + 1);
    }

    private void reverse(int[] nums, int start) {
        int l = start;
        int r = nums.length - 1;

        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
