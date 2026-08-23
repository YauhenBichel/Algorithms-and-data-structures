---
title: "Union-Find (Disjoint Set Union) in Java"
description: "Union-Find / Disjoint Set Union in Java with path compression and union by rank - near O(1) amortised union and find. Source and complexity."
category: "Data Structures"
---

# Union-Find (Disjoint Set Union) in Java

<span class="tag">Data Structures</span><span class="tag">Java</span>

Union-Find tracks a partition of elements into disjoint sets and answers 'are these two in the same set?'. With path compression and union by rank the amortised cost is the inverse Ackermann function - effectively constant. It underpins Kruskal's MST and connected-component counting.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `union` | ~O(α(n)) | O(n) |
| `find` | ~O(α(n)) | O(1) |
| `connected` | ~O(α(n)) | O(1) |

## Implementation

```java
package com.bichel.datastructure;

public class UnionFind {
    private int[] group;
    private int[] rank;

    public UnionFind(int size) {
        this.group = new int[size];
        this.rank = new int[size];

        for (int node = 0; node < size; node++) {
            this.group[node] = node;
            this.rank[node] = 0;
        }
    }

    public int find(int node) {
        if (this.group[node] != node) {
            int parent = this.find(this.group[node]);
            this.group[node] = parent;
        }

        return this.group[node];
    }

    public boolean union(int a, int b) {
        int groupA = this.find(a);
        int groupB = this.find(b);

        if (groupA == groupB) {
            return false;
        }

        // Otherwise, merge the two groups.
        // Merge the lower-rank group into the higher-rank group.
        if (this.rank[groupA] > this.rank[groupB]) {
            this.group[groupB] = groupA;
        } else if (this.rank[groupA] < this.rank[groupB]) {
            this.group[groupA] = groupB;
        } else {
            this.group[groupA] = groupB;
            this.rank[groupB] += 1;
        }

        return true;
    }
}
```

## Source

[`src/main/java/com/bichel/datastructure/UnionFind.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/datastructure/UnionFind.java) on GitHub.
