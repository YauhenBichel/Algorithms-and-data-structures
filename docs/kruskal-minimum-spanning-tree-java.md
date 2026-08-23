---
title: "Kruskal's Minimum Spanning Tree in Java"
description: "Kruskal's minimum spanning tree algorithm in Java - sort edges, union-find cycle detection, O(E log E). Source code and complexity."
category: "Graph Algorithms"
---

# Kruskal's Minimum Spanning Tree in Java

<span class="tag">Graph Algorithms</span><span class="tag">Java</span>

Kruskal sorts every edge by weight and adds each one whose endpoints are not already connected, using Union-Find to test connectivity in near-constant time. The sort dominates, giving O(E log E). It works naturally on disconnected graphs, producing a spanning forest.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `mst` | O(E log E) | O(V) |

## Implementation

```java
package com.bichel.algorithms.popularproblems.graph;

public class KruskalsAlg {
    
}
```

## Source

[`src/main/java/com/bichel/algorithms/popularproblems/graph/KruskalsAlg.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/popularproblems/graph/KruskalsAlg.java) on GitHub.
