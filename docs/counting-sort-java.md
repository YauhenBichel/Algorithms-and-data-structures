---
title: "Counting Sort in Java"
description: "Counting sort in Java - non-comparison stable sorting in O(n+k) time. Source code, complexity and when it beats comparison sorts."
category: "Sorting"
---

# Counting Sort in Java

<span class="tag">Sorting</span><span class="tag">Java</span>

Counting sort tallies occurrences of each key and reconstructs the output from a prefix sum of those counts. Because it never compares two elements it sidesteps the O(n log n) comparison lower bound, but it only pays off when the key range k is comparable to n.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `best` | O(n + k) | O(k) |
| `average` | O(n + k) | O(k) |
| `worst` | O(n + k) | O(k) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.sort.counting;

public class Counting {
    public static int[] sort(int[] arr, int range) {
        int N = arr.length;
        int[] counting = new int[range];

        for (int i = 0; i < N; i++) {
            counting[arr[i]] += 1;
        }

        int index = 0;
        for (int j = 0; j < range; j++) {
            while (counting[j] > 0) {
                arr[index++] = j;
                counting[j] -= 1;
            }
        }

        return arr;
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/sort/counting/Counting.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/problemsheap/sort/counting/Counting.java) on GitHub.
