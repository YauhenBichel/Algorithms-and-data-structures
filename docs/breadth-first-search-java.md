---
title: "Breadth-First Search (BFS) in Java"
description: "Breadth-first search in Java - queue-based graph traversal in O(V+E), shortest paths on unweighted graphs. Source code and complexity."
category: "Graph Algorithms"
---

# Breadth-First Search (BFS) in Java

<span class="tag">Graph Algorithms</span><span class="tag">Java</span>

BFS explores a graph level by level using a FIFO queue, so the first time it reaches a vertex it has done so along a path with the fewest edges. That makes it the shortest-path algorithm for unweighted graphs, and the basis for level-order tree traversal and grid flood fill.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `traverse` | O(V + E) | O(V) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.graph;

import java.util.LinkedList;

public class BFS {
    private static boolean searchBFS(LinkedList<Integer>[] adjList, int a) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(a);

        while (!queue.isEmpty()) {

            int node = queue.pop();
            LinkedList<Integer> adjs = adjList[node];

            for (int i = 0; i < adjs.size(); i++) {

                if (adjs.get(i) == a) {
                    return true;
                }

                queue.push(adjs.get(i));
            }
        }
        return false;
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/graph/BFS.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/problemsheap/graph/BFS.java) on GitHub.
