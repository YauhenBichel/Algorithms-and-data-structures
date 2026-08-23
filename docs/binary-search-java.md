---
title: "Binary Search in Java"
description: "Binary search in Java - O(log n) search on sorted arrays, with three reusable templates for boundary conditions. Source and complexity."
category: "Searching"
---

# Binary Search in Java

<span class="tag">Searching</span><span class="tag">Java</span>

Binary search halves the candidate range each step, giving O(log n). Nearly all of its difficulty is in the boundary conditions - whether the range is inclusive, which half to discard, and how to find the first rather than any match. The templates here cover those three variants.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `search` | O(log n) | O(1) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.search.binary;

/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int pivot = l + (r - l) / 2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        return -1;
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/search/binary/BinarySearch.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/main/src/main/java/com/bichel/algorithms/problemsheap/search/binary/BinarySearch.java) on GitHub.
