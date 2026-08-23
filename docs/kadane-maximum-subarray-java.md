---
title: "Kadane's Algorithm (Maximum Subarray) in Java"
description: "Kadane's algorithm in Java - maximum contiguous subarray sum in O(n) time and O(1) space. Source code and complexity analysis."
category: "Dynamic Programming"
---

# Kadane's Algorithm (Maximum Subarray) in Java

<span class="tag">Dynamic Programming</span><span class="tag">Java</span>

Kadane's algorithm scans once, keeping the best sum ending at the current index: either extend the previous run or start fresh. It is the smallest convincing example of dynamic programming, reducing an apparently O(n²) search to a single linear pass with constant space.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `maxSubArray` | O(n) | O(1) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.dynamic_programming;

/*
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Complexity Analysis
Time complexity: O(N), where N is the length of nums.
We iterate through every element of nums exactly once.

Space complexity: O(1)
No matter how long the input is,
we are only ever using 2 variables: currSubarray and maxSubarray
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            currSubarray = Math.max(num, currSubarray + num);
            maxSubarray = Math.max(maxSubarray, currSubarray);
        }

        return maxSubarray;
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/dynamic_programming/MaximumSubarray.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/main/src/main/java/com/bichel/algorithms/problemsheap/dynamic_programming/MaximumSubarray.java) on GitHub.
