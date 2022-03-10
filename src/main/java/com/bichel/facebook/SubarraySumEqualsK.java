package com.bichel.facebook;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k,
return the total number of subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 */

public class SubarraySumEqualsK {

    //using cumulative sum
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum == k)
                count++;

            count += map.getOrDefault(sum-k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
