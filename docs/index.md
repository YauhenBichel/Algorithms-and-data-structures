---
title: "Algorithms and Data Structures in Java"
description: "Classic algorithms and data structures implemented in Java - sorting, searching, graphs, tries, heaps and dynamic programming - with Big-O complexity analysis, source code and JUnit tests."
---

# Algorithms and Data Structures in Java

**928 Java implementations · 54 JUnit test classes · 121 pages of notes**

A working reference of classic algorithms and data structures in Java, each page carrying the
implementation, its Big-O complexity and an explanation of why it behaves that way. Built as
coding-interview and technical-interview preparation, organised by the technique a problem needs.

## Data Structures

- [**Trie (Prefix Tree) in Java**]({{ '/trie-prefix-tree-java' | relative_url }}) — A trie stores strings by shared prefix, so lookup cost depends on key length rather than on how many keys are stored.
- [**Union-Find (Disjoint Set Union) in Java**]({{ '/union-find-disjoint-set-java' | relative_url }}) — Union-Find tracks a partition of elements into disjoint sets and answers 'are these two in the same set?'.
- [**Min-Heap and Priority Queue in Java**]({{ '/min-heap-priority-queue-java' | relative_url }}) — A binary heap is a complete tree kept in an array, where every parent compares less than or equal to its children.
- [**Bloom Filter in Java**]({{ '/bloom-filter-java' | relative_url }}) — A Bloom filter answers 'have I definitely not seen this?' using a bit array and k hash functions.

## Caching

- [**LRU Cache in Java**]({{ '/lru-cache-java' | relative_url }}) — An LRU cache evicts whatever was accessed longest ago.
- [**LFU Cache in Java**]({{ '/lfu-cache-java' | relative_url }}) — LFU evicts the least frequently accessed entry, breaking ties by recency.

## Graph Algorithms

- [**Dijkstra's Shortest Path Algorithm in Java**]({{ '/dijkstra-shortest-path-java' | relative_url }}) — Dijkstra grows a set of settled vertices, always expanding the unsettled vertex with the smallest tentative distance.
- [**Kruskal's Minimum Spanning Tree in Java**]({{ '/kruskal-minimum-spanning-tree-java' | relative_url }}) — Kruskal sorts every edge by weight and adds each one whose endpoints are not already connected, using Union-Find to test connectivity in near-constant time.
- [**Prim's Minimum Spanning Tree in Java**]({{ '/prim-minimum-spanning-tree-java' | relative_url }}) — Prim grows a single tree from an arbitrary root, repeatedly taking the cheapest edge that leaves the tree.
- [**Breadth-First Search (BFS) in Java**]({{ '/breadth-first-search-java' | relative_url }}) — BFS explores a graph level by level using a FIFO queue, so the first time it reaches a vertex it has done so along a path with the fewest edges.
- [**Depth-First Search (DFS) in Java**]({{ '/depth-first-search-java' | relative_url }}) — DFS follows one path as far as it goes before backtracking, naturally expressed by recursion or an explicit stack.
- [**Topological Sort in Java**]({{ '/topological-sort-java' | relative_url }}) — A topological sort linearises a directed acyclic graph so every edge points forward.
- [**Cycle Detection in a Graph (Java)**]({{ '/graph-cycle-detection-java' | relative_url }}) — Cycle detection runs DFS while tracking which vertices are on the current recursion stack.
- [**Bipartite Graph Check (Two-Colouring) in Java**]({{ '/bipartite-graph-check-java' | relative_url }}) — A graph is bipartite exactly when its vertices can be two-coloured with no edge joining same-coloured vertices - equivalently, when it contains no odd cycle.

## Sorting

- [**Quicksort in Java**]({{ '/quicksort-java' | relative_url }}) — Quicksort partitions around a pivot and recurses on both sides, sorting in place.
- [**Merge Sort in Java**]({{ '/merge-sort-java' | relative_url }}) — Merge sort splits the array in half, sorts each half, then merges the two sorted runs.
- [**Insertion Sort in Java**]({{ '/insertion-sort-java' | relative_url }}) — Insertion sort grows a sorted prefix one element at a time, shifting larger elements right.
- [**Counting Sort in Java**]({{ '/counting-sort-java' | relative_url }}) — Counting sort tallies occurrences of each key and reconstructs the output from a prefix sum of those counts.

## Searching

- [**Binary Search in Java**]({{ '/binary-search-java' | relative_url }}) — Binary search halves the candidate range each step, giving O(log n).

## Dynamic Programming

- [**Kadane's Algorithm (Maximum Subarray) in Java**]({{ '/kadane-maximum-subarray-java' | relative_url }}) — Kadane's algorithm scans once, keeping the best sum ending at the current index: either extend the previous run or start fresh.
- [**Coin Change (Dynamic Programming) in Java**]({{ '/coin-change-dynamic-programming-java' | relative_url }}) — Coin change asks for the fewest coins summing to a target.
- [**Climbing Stairs (Dynamic Programming) in Java**]({{ '/climbing-stairs-dynamic-programming-java' | relative_url }}) — The number of ways to reach step n is the ways to reach n-1 plus the ways to reach n-2 - the Fibonacci recurrence.

## The Full Repository

These pages cover the core algorithms in depth. The repository holds much more — 23 problem
patterns (dynamic programming, backtracking, sliding window, two pointers, intervals, bit
manipulation), 38 system design implementations, NP-complete reduction notes, and Java
concurrency and Spring material.

→ [**Browse the repository on GitHub**](https://github.com/YauhenBichel/Algorithms-and-data-structures)
