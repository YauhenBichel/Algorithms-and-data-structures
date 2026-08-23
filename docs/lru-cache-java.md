---
title: "LRU Cache in Java"
description: "Least Recently Used (LRU) cache in Java with O(1) get and put using a hash map plus doubly linked list. Classic system design interview problem."
category: "Caching"
---

# LRU Cache in Java

<span class="tag">Caching</span><span class="tag">Java</span>

An LRU cache evicts whatever was accessed longest ago. The O(1) solution pairs a hash map (key to node) with a doubly linked list ordered by recency: the map finds the node, the list splices it to the front. Both operations touch a constant number of pointers.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `get` | O(1) | O(capacity) |
| `put` | O(1) | O(capacity) |

## Implementation

```java
package com.bichel.systemdesign;

import java.util.HashMap;
import java.util.Map;

// Least Recently Used (LRU) cache
class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node) {
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    private void moveToHead(DLinkedNode node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }
    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if (size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}
```

## Source

[`src/main/java/com/bichel/systemdesign/LRUCache.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/systemdesign/LRUCache.java) on GitHub.
