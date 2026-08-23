---
title: "Prim's Minimum Spanning Tree in Java"
description: "Prim's minimum spanning tree algorithm in Java with a priority queue - O(E log V). Implementation and comparison with Kruskal's algorithm."
category: "Graph Algorithms"
---

# Prim's Minimum Spanning Tree in Java

<span class="tag">Graph Algorithms</span><span class="tag">Java</span>

Prim grows a single tree from an arbitrary root, repeatedly taking the cheapest edge that leaves the tree. With a priority queue keyed on the cheapest known connection it runs in O(E log V). Prim tends to win on dense graphs, Kruskal on sparse ones.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `mst` | O(E log V) | O(V) |

## Implementation

```java
package com.bichel.algorithms.popularproblems.graph;

public class PrimsAlg {

}
```

## Source

[`src/main/java/com/bichel/algorithms/popularproblems/graph/PrimsAlg.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/popularproblems/graph/PrimsAlg.java) on GitHub.
