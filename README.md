# Algorithms and Data Structures in Java

**928 Java implementations · 54 JUnit test classes · 121 pages of notes**

A working reference of classic **algorithms and data structures implemented in Java** — sorting,
searching, graphs, trees, heaps, tries, dynamic programming, backtracking, sliding window and
bit manipulation — alongside **system design** implementations and **NP-complete problem** notes.
Built as coding-interview and technical-interview preparation, organised by pattern so a problem
can be found by the technique it needs.

`Java` · `Gradle` · `JUnit 5`

📖 **Browse as a website: [yauhenbichel.github.io/Algorithms-and-data-structures](https://yauhenbichel.github.io/Algorithms-and-data-structures/)**

---

## Data Structures

| Structure | Operations | Complexity | Source |
|---|---|---|---|
| **Trie (prefix tree)** | insert, search, startsWith | O(m) per op, m = key length | [Trie.java](src/main/java/com/bichel/datastructure/Trie.java) |
| **Union-Find / Disjoint Set** | union, find (path compression) | ~O(α(n)) amortised | [UnionFind.java](src/main/java/com/bichel/datastructure/UnionFind.java) |
| **Min-Heap / Priority Queue** | insert, extractMin, buildHeap | O(log n) / O(n) build | [MinHeap.java](src/main/java/com/bichel/datastructure/MinHeap.java) |
| **Bloom Filter** | add, mightContain | O(k) hashes, no false negatives | [BloomFilter.java](src/main/java/com/bichel/datastructure/BloomFilter.java) |
| **Binary Search Tree** | insert, search, delete, iterator | O(h), O(log n) balanced | [tree/datastructure](src/main/java/com/bichel/algorithms/problemsheap/tree/datastructure) |
| **Linked List** | traversal, reversal, cycle detection | O(n) | [collections/LinkedList](src/main/java/com/bichel/java/collections/LinkedList) |
| **HashMap / HashSet (from scratch)** | bucket with list vs. bucket with tree | O(1) avg, O(log n) worst | [HashMapDesign.java](src/main/java/com/bichel/systemdesign/HashMapDesign.java) |
| **LRU Cache** | get, put | O(1) via hashmap + doubly linked list | [LRUCache.java](src/main/java/com/bichel/systemdesign/LRUCache.java) |
| **LFU Cache** | get, put | O(1) | [LFUCache.java](src/main/java/com/bichel/algorithms/unsorted/LFUCache.java) |

## Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Stable | Source |
|---|---|---|---|---|---|---|
| **Quicksort** | O(n log n) | O(n log n) | O(n²) | O(log n) | No | [quicksort/](src/main/java/com/bichel/algorithms/problemsheap/sort/quicksort) |
| **Merge sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | [merge/](src/main/java/com/bichel/algorithms/problemsheap/sort/merge) |
| **Insertion sort** | O(n) | O(n²) | O(n²) | O(1) | Yes | [insertion/](src/main/java/com/bichel/algorithms/problemsheap/sort/insertion) |
| **Selection sort** | O(n²) | O(n²) | O(n²) | O(1) | No | [Selection.java](src/main/java/com/bichel/algorithms/problemsheap/sort/basic/Selection.java) |
| **Bubble sort** | O(n) | O(n²) | O(n²) | O(1) | Yes | [Bubble.java](src/main/java/com/bichel/algorithms/problemsheap/sort/basic/Bubble.java) |
| **Counting sort** | O(n + k) | O(n + k) | O(n + k) | O(k) | Yes | [counting/](src/main/java/com/bichel/algorithms/problemsheap/sort/counting) |
| **Topological sort** | O(V + E) | O(V + E) | O(V + E) | O(V) | — | [Toposort.java](src/main/java/com/bichel/algorithms/problemsheap/sort/Toposort.java) |

## Graph Algorithms

| Algorithm | Complexity | Source |
|---|---|---|
| **Dijkstra's shortest path** (with priority queue) | O((V + E) log V) | [DijkstraWithPriorityQueue.java](src/main/java/com/bichel/algorithms/popularproblems/graph/DijkstraWithPriorityQueue.java) |
| **Kruskal's minimum spanning tree** | O(E log E) | [KruskalsAlg.java](src/main/java/com/bichel/algorithms/popularproblems/graph/KruskalsAlg.java) |
| **Prim's minimum spanning tree** | O(E log V) | [PrimsAlg.java](src/main/java/com/bichel/algorithms/popularproblems/graph/PrimsAlg.java) |
| **Breadth-first search (BFS)** | O(V + E) | [BFS.java](src/main/java/com/bichel/algorithms/problemsheap/graph/BFS.java) |
| **Depth-first search (DFS)** | O(V + E) | [DFS.java](src/main/java/com/bichel/algorithms/problemsheap/graph/DFS.java) |
| **Cycle detection / acyclicity** | O(V + E) | [Acyclicity.java](src/main/java/com/bichel/algorithms/problemsheap/graph/Acyclicity.java) |
| **Bipartite check (graph colouring)** | O(V + E) | [IsGraphBipartite.java](src/main/java/com/bichel/algorithms/problemsheap/graph/IsGraphBipartite.java) |
| **Connected components / provinces** | ~O(V + E) with union-find | [disjoint_set_union/](src/main/java/com/bichel/algorithms/problemsheap/disjoint_set_union) |

## Algorithm Patterns

Problems are filed by the **technique** that solves them, not by source — the way they are
actually recalled in an interview.

| Pattern | Problems | Directory |
|---|---|---|
| **Dynamic programming** | 59 | [dynamic_programming/](src/main/java/com/bichel/algorithms/problemsheap/dynamic_programming) |
| **Arrays** | 76 | [arrays/](src/main/java/com/bichel/algorithms/problemsheap/arrays) |
| **Strings** | 68 | [strings/](src/main/java/com/bichel/algorithms/problemsheap/strings) |
| **Binary tree** | 43 | [tree/algorithms/binarytree/](src/main/java/com/bichel/algorithms/problemsheap/tree/algorithms/binarytree) |
| **Math** | 36 | [math/](src/main/java/com/bichel/algorithms/problemsheap/math) |
| **Graphs** | 34 | [graph/](src/main/java/com/bichel/algorithms/problemsheap/graph) |
| **Backtracking** | 32 | [backtracking/](src/main/java/com/bichel/algorithms/problemsheap/backtracking) |
| **Linked list** | 25 | [list/](src/main/java/com/bichel/algorithms/problemsheap/list) |
| **Binary search tree** | 24 | [binarysearchtree/](src/main/java/com/bichel/algorithms/problemsheap/tree/algorithms/binarysearchtree) |
| **BFS / DFS traversal** | 21 | [bfs_dfs/](src/main/java/com/bichel/algorithms/problemsheap/bfs_dfs) |
| **Combinations, permutations, subsets** | 20 | [combinations_permutations_subsets/](src/main/java/com/bichel/algorithms/problemsheap/combinations_permutations_subsets) |
| **Binary search** | 17 | [search/](src/main/java/com/bichel/algorithms/problemsheap/search) |
| **Heap / priority queue** | 15 | [heap/](src/main/java/com/bichel/algorithms/problemsheap/heap) |
| **Stacks & monotonic stack** | 11 | [stacks/](src/main/java/com/bichel/algorithms/problemsheap/stacks) |
| **Sliding window** | 10 | [sliding_window/](src/main/java/com/bichel/algorithms/problemsheap/sliding_window) |
| **Hash map / set** | 10 | [map_set/](src/main/java/com/bichel/algorithms/problemsheap/map_set) |
| **Tries** | 7 | [tries/](src/main/java/com/bichel/algorithms/problemsheap/tries) |
| **Intervals** | 7 | [interval/](src/main/java/com/bichel/algorithms/problemsheap/interval) |
| **Bit manipulation** | 7 | [bits/](src/main/java/com/bichel/algorithms/problemsheap/bits) |
| **Two pointers** | 6 | [two_pointers/](src/main/java/com/bichel/algorithms/problemsheap/two_pointers) |
| **Greedy** | 4 | [greedy/](src/main/java/com/bichel/algorithms/problemsheap/greedy) |
| **Prefix sum** | 2 | [prefix_sum/](src/main/java/com/bichel/algorithms/problemsheap/prefix_sum) |
| **Kadane's algorithm** | 1 | [kadane/](src/main/java/com/bichel/algorithms/kadane) |

## System Design

Working Java implementations of common **system design interview** problems, plus notes.

- [**Design a URL shortener**](src/main/java/com/bichel/systemdesign/DesignURLShortener.md) — four encode/decode implementations ([1](src/main/java/com/bichel/systemdesign/EncodeAndDecodeTinyURL.java), [2](src/main/java/com/bichel/systemdesign/EncodeAndDecodeTinyURL2.java), [3](src/main/java/com/bichel/systemdesign/EncodeAndDecodeTinyURL3.java), [4](src/main/java/com/bichel/systemdesign/EncodeAndDecodeTinyURL4.java))
- [**Design search typeahead / autocomplete**](src/main/java/com/bichel/systemdesign/DesignSearchTypeahead.md)
- [**Design a messenger**](src/main/java/com/bichel/systemdesign/DesignMessenger.md)
- [**Design an in-memory file system**](src/main/java/com/bichel/systemdesign/DesignInMemoryFileSystem.java) · [log storage system](src/main/java/com/bichel/systemdesign/DesignLogStorageSystem.java) · [time-based key-value store](src/main/java/com/bichel/systemdesign/TimeBasedKeyValueStore.java)
- [**Cassandra**](src/main/java/com/bichel/systemdesign/Cassandra.md) — partition keys, clustering keys, coordinator nodes
- [**Kafka**](src/main/java/com/bichel/systemdesign/Kafka) · [**Kubernetes**](src/main/java/com/bichel/systemdesign/kubernetes) · [**microservices**](src/main/java/com/bichel/systemdesign/microservices) · [**big data**](src/main/java/com/bichel/systemdesign/bigdata) · [**databases**](src/main/java/com/bichel/systemdesign/database)
- N-tier architecture: [single](src/main/java/com/bichel/systemdesign/SingleTier.java) · [two](src/main/java/com/bichel/systemdesign/TwoTier.java) · [three](src/main/java/com/bichel/systemdesign/ThreeTier.java)

## NP-Complete Problems

Reduction notes for the classic [**NP-complete**](src/main/java/com/bichel/np-complete) set:
3-SAT · Vertex Cover · Independent Set · Set Cover · Set Packing · Subset Sum ·
3-D Matching · K-Colouring · Hamiltonian Cycle · Travelling Salesman (TSP).

## Java Language & Concurrency

- [**Threads & concurrency**](src/main/java/com/bichel/java/threads) — 20 examples: `ExecutorService`, locks, coordination
- [**Collections**](src/main/java/com/bichel/java/collections) · [**Streams**](src/main/java/com/bichel/java/streams) · [**Lambdas & method references**](src/main/java/com/bichel/java/lambdamethodref) · [**Comparators**](src/main/java/com/bichel/java/compare)
- [**Spring**](src/main/java/com/bichel/java/Spring) — container/DI/IoC, AOP, transactions, Spring Boot
- [**Hibernate**](src/main/java/com/bichel/java/hibernate)

## Company-Tagged Problems

[Amazon](src/main/java/com/bichel/algorithms/companies/amazon) · [Meta](src/main/java/com/bichel/algorithms/companies/meta) · [Google](src/main/java/com/bichel/algorithms/companies/google) · [Apple](src/main/java/com/bichel/algorithms/companies/apple) · [Netflix](src/main/java/com/bichel/algorithms/companies/netflix) · [IBM](src/main/java/com/bichel/algorithms/companies/ibm) · [Adobe](src/main/java/com/bichel/algorithms/companies/adobe) · [top interview questions](src/main/java/com/bichel/algorithms/topinterview)

---

## Build & Test

```bash
./gradlew build     # compile
./gradlew test      # run the JUnit 5 suite
```

Requires a JDK and uses the bundled Gradle wrapper. Tests live under
[`src/test/java`](src/test/java) and use **JUnit 5 (Jupiter)**.

## Repository Layout

```
src/main/java/com/bichel/
├── algorithms/
│   ├── problemsheap/     # problems filed by pattern (DP, graphs, sliding window, …)
│   ├── popularproblems/  # islands, graphs, caches, fibonacci
│   ├── companies/        # tagged by interviewing company
│   ├── topinterview/     # frequently asked
│   └── kadane/
├── datastructure/        # Trie, UnionFind, MinHeap, BloomFilter
├── systemdesign/         # LRU/LFU cache, HashMap, Cassandra, Kafka, k8s notes
├── np-complete/          # reduction notes
└── java/                 # language, concurrency, Spring, Hibernate
```

---

## About

Maintained by **[Yauhen Bichel](https://github.com/YauhenBichel)** — Founding Staff Engineer,
London. Also on [LeetCode](https://leetcode.com/ybichel/) ·
[LinkedIn](https://www.linkedin.com/in/yauhen-bichel) ·
[Medium](https://medium.com/@yauhen.bichel).

---

## Contributors

Thank you to everyone who has helped this project. Your code, reviews, issues, and pull requests are appreciated.

- [@YauhenBichel](https://github.com/YauhenBichel)

See the [full contributor graph](https://github.com/YauhenBichel/Algorithms-and-data-structures/graphs/contributors).
