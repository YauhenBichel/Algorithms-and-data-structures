---
title: "Topological Sort in Java"
description: "Topological sort in Java for directed acyclic graphs - O(V+E) ordering via DFS. Source code, complexity and cycle detection."
category: "Graph Algorithms"
---

# Topological Sort in Java

<span class="tag">Graph Algorithms</span><span class="tag">Java</span>

A topological sort linearises a directed acyclic graph so every edge points forward. It exists precisely when the graph has no cycle, which makes the algorithm double as a cycle detector - the standard tool behind build ordering, task scheduling and dependency resolution.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `sort` | O(V + E) | O(V) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean used[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();

        for(int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        dfs(adj, used, order);

        Collections.reverse(order);

        return order;
    }

    private static void explore(ArrayList<Integer>[] adj, boolean[] used, ArrayList<Integer> postOrder, int s) {
        used[s] = true;
        ArrayList<Integer> list = adj[s];
        int N = list.size();

        for(int i = 0; i < N; i++) {
            int curr = list.get(i);

            if(used[curr] == false) {
                explore(adj, used, postOrder, curr);
            }
        }

        postOrder.add(s);
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] used, ArrayList<Integer> order) {
        for(int i = 0; i < adj.length; i++) {
            if(used[i] == false) {
                explore(adj, used, order, i);
            }
        }


    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/sort/Toposort.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/main/src/main/java/com/bichel/algorithms/problemsheap/sort/Toposort.java) on GitHub.
