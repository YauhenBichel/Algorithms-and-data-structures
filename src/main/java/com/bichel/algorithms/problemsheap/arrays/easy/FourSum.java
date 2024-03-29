package com.bichel.algorithms.problemsheap.arrays.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Given an array nums of n integers, return an array of all
the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */

public class FourSum {
    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<List<Integer>> findFourElements(int arr[], int target) {

        List<List<Integer>> sets = new ArrayList<>();
        int n = arr.length;

        HashMap<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(map.containsKey(arr[i] + arr[j])) {
                    List<Pair> pairs = map.get(arr[i] + arr[j]);
                    pairs.add(new Pair(i, j));
                    map.put(arr[i] + arr[j], pairs);
                } else {
                    List<Pair> pairs = new ArrayList<>();
                    pairs.add(new Pair(i, j));
                    map.put(arr[i] + arr[j], pairs);
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                if (map.containsKey(target - sum)) {
                    List<Pair> pairs = map.get(target - sum);

                    for(Pair p : pairs) {
                        if (i != j && j != p.first && j != p.second &&
                                p.first != p.second &&
                                i != p.first && i != p.second) {

                            List<Integer> set = new ArrayList<>();
                            set.add(arr[i]);
                            set.add(arr[j]);
                            set.add(arr[p.first]);
                            set.add(arr[p.second]);

                            Collections.sort(set);

                            if (!sets.contains(set))
                                sets.add(set);
                        }
                    }
                }
            }
        }

        return sets;
    }
}
