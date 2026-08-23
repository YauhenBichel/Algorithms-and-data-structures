---
title: "Dijkstra's Shortest Path Algorithm in Java"
description: "Dijkstra's shortest path algorithm in Java using a priority queue - O((V+E) log V). Implementation, complexity and why negative weights break it."
category: "Graph Algorithms"
---

# Dijkstra's Shortest Path Algorithm in Java

<span class="tag">Graph Algorithms</span><span class="tag">Java</span>

Dijkstra grows a set of settled vertices, always expanding the unsettled vertex with the smallest tentative distance. A binary heap makes selection logarithmic, giving O((V+E) log V). It assumes non-negative edge weights - a negative edge could improve a distance already treated as final.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `shortestPath` | O((V+E) log V) | O(V) |

## Implementation

```java
package com.bichel.algorithms.popularproblems.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraWithPriorityQueue {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<NodeWithCost> priorityQueue;
    private int numV;
    private List<List<NodeWithCost>> adj;

    public DijkstraWithPriorityQueue(int numV) {
        this.numV = numV;
        dist = new int[numV];
        settled = new HashSet<>();
        priorityQueue = new PriorityQueue<>(numV, Comparator.comparingInt(o -> o.cost));
    }

    public void dijkstra(List<List<NodeWithCost>> adj, int src) {
        this.adj = adj;

        //by default set max value
        for (int i = 0; i < numV; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        priorityQueue.add(new NodeWithCost(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != numV) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (priorityQueue.isEmpty()) {
                return;
            }

            // Removing the minimum distance node from the priority queue
            int u = priorityQueue.remove().node;

            // Adding the node whose distance is finalized
            if (settled.contains(u)) {
                // Continue keyword skips execution for
                // following check
                continue;
            }

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            traverseNeighbours(u);
        }
    }

    private void traverseNeighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        List<NodeWithCost> neighbors = adj.get(u);

        for (int i = 0; i < neighbors.size(); i++) {
            NodeWithCost nextNode = neighbors.get(i);

            // If current node hasn't already been processed
            if (!settled.contains(nextNode.node)) {
                edgeDistance = nextNode.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[nextNode.node]) {
                    dist[nextNode.node] = newDistance;
                }

                // Add the current node to the queue
                priorityQueue.add(new NodeWithCost(nextNode.node, dist[nextNode.node]));
            }
        }
    }

    public static void main(String arg[]) {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node2>
        List<List<NodeWithCost>> adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<NodeWithCost> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph
        adj.get(0).add(new NodeWithCost(1, 9));
        adj.get(0).add(new NodeWithCost(2, 6));
        adj.get(0).add(new NodeWithCost(3, 5));
        adj.get(0).add(new NodeWithCost(4, 3));

        adj.get(2).add(new NodeWithCost(1, 2));
        adj.get(2).add(new NodeWithCost(3, 4));

        // Calculating the single source shortest path
        DijkstraWithPriorityQueue dpq = new DijkstraWithPriorityQueue(V);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }
}

class NodeWithCost {
    public int node;
    public int cost;

    public NodeWithCost(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/popularproblems/graph/DijkstraWithPriorityQueue.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/popularproblems/graph/DijkstraWithPriorityQueue.java) on GitHub.
