package com.bichel.algorithms.problemsheap.combinations_permutations_subsets;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();

        List<Integer> origin = new ArrayList<>();
        for (int num : nums) {
            origin.add(num);
        }

        int n = nums.length;
        backtrack(n, origin, output, 0);
        return output;
    }

    private void backtrack(int n, List<Integer> nums,
                           List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
            return;
        }

        for (int i = first; i < n; i++) {
            // place i-th integer first in the current permutation
            Collections.swap(nums, first, i);

            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);

            // backtrack
            Collections.swap(nums, first, i);
        }
    }
}
