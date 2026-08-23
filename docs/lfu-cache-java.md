---
title: "LFU Cache in Java"
description: "Least Frequently Used (LFU) cache in Java with O(1) get and put. Frequency buckets, tie-breaking by recency, and full source code."
category: "Caching"
---

# LFU Cache in Java

<span class="tag">Caching</span><span class="tag">Java</span>

LFU evicts the least frequently accessed entry, breaking ties by recency. Achieving O(1) requires a map of frequency to a linked list of keys at that frequency, plus a pointer to the current minimum frequency - incrementing a key moves it one bucket along.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `get` | O(1) | O(capacity) |
| `put` | O(1) | O(capacity) |

## Implementation

```java
package com.bichel.algorithms.unsorted;

/*
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.
 */

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private class Node {
        int key, val, cnt;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }

    private class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            } else return null;
        }
    }

    private int capacity, size, min;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DLList> countMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLList newList = countMap.getOrDefault(node.cnt, new DLList());
            newList.add(node);
            countMap.put(node.cnt, newList);
        }
    }

    private void update(Node node) {
        DLList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        if (node.cnt == min && oldList.size == 0) min++;
        node.cnt++;
        DLList newList = countMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        countMap.put(node.cnt, newList);
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/unsorted/LFUCache.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/unsorted/LFUCache.java) on GitHub.
