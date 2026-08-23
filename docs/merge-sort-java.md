---
title: "Merge Sort in Java"
description: "Merge sort in Java - stable divide and conquer sorting with guaranteed O(n log n). Source code, complexity and comparison with quicksort."
category: "Sorting"
---

# Merge Sort in Java

<span class="tag">Sorting</span><span class="tag">Java</span>

Merge sort splits the array in half, sorts each half, then merges the two sorted runs. The O(n log n) bound holds in every case, and the merge preserves the relative order of equal elements, making it stable. The cost is O(n) auxiliary space.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `best` | O(n log n) | O(n) |
| `average` | O(n log n) | O(n) |
| `worst` | O(n log n) | O(n) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.sort.merge;

/*
There are 2 approaches to implement the merge sort: top down or bottom up.
- In the first step, we divide the list into two sublists.  (Divide)
- Then in the next step, we recursively sort the sublists in the previous step.  (Conquer)
- Finally we merge the sorted sublists in the above step repeatedly to obtain
the final list of sorted elements.  (Combine)

time complexity O(NlogN)
space complexity of the merge sort algorithm is O(N)
 */

import java.util.Arrays;

public class MergeSort {
    //top down merge sort
    public int[] mergeSort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int pivot = input.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(input, 0, pivot));
        int[] right = mergeSort(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

        while (left_cursor < left.length &&
                right_cursor < right.length) {
            if (left[left_cursor] < right[right_cursor]) {
                ret[ret_cursor++] = left[left_cursor++];
            } else {
                ret[ret_cursor++] = right[right_cursor++];
            }
        }
        // append what is remain the above lists
        while (left_cursor < left.length) {
            ret[ret_cursor++] = left[left_cursor++];
        }
        while (right_cursor < right.length) {
            ret[ret_cursor++] = right[right_cursor++];
        }
        return ret;
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/sort/merge/MergeSort.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/problemsheap/sort/merge/MergeSort.java) on GitHub.
