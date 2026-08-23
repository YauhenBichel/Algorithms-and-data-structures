---
title: "Insertion Sort in Java"
description: "Insertion sort in Java - stable in-place sorting, O(n) on nearly sorted input, O(n squared) worst case. Source code and complexity."
category: "Sorting"
---

# Insertion Sort in Java

<span class="tag">Sorting</span><span class="tag">Java</span>

Insertion sort grows a sorted prefix one element at a time, shifting larger elements right. On nearly sorted data it approaches linear time, which is why production sorts fall back to it for small subarrays. Stable and in place.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `best` | O(n) | O(1) |
| `average` | O(n²) | O(1) |
| `worst` | O(n²) | O(1) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.sort.insertion;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 8, 5, 9, 6, 0, 7, 3, 2};

        sort(arr);

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/sort/insertion/InsertionSort.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/main/src/main/java/com/bichel/algorithms/problemsheap/sort/insertion/InsertionSort.java) on GitHub.
