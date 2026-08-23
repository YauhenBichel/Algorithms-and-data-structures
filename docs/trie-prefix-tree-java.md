---
title: "Trie (Prefix Tree) in Java"
description: "Trie / prefix tree implemented in Java - insert, search and startsWith in O(m) time. Source code, complexity analysis and use cases."
category: "Data Structures"
---

# Trie (Prefix Tree) in Java

<span class="tag">Data Structures</span><span class="tag">Java</span>

A trie stores strings by shared prefix, so lookup cost depends on key length rather than on how many keys are stored. It is the structure behind autocomplete, spell-checking and IP routing tables. Each node holds one character and a map of children; a terminal flag marks the end of a complete word.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `insert` | O(m) | O(m·Σ) |
| `search` | O(m) | O(1) |
| `startsWith` | O(m) | O(1) |

## Implementation

```java
package com.bichel.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        TrieNode() {
            children = new HashMap<>();
            end = false;
        }

        public boolean end;
        public Map<Character, TrieNode> children;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char newLetter = word.charAt(i);
            if(!node.children.containsKey(newLetter)) {
                node.children.put(newLetter, new TrieNode());
            }
            node = node.children.get(newLetter);
        }

        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = search(word, root);
        if(node != null && node.end == true) {
            return true;
        }

        return false;
    }

    private TrieNode search(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                node = node.children.get(word.charAt(i));
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean startsWith(String prefix) {
        return search(prefix, root) != null;
    }
}
```

## Source

[`src/main/java/com/bichel/datastructure/Trie.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/main/src/main/java/com/bichel/datastructure/Trie.java) on GitHub.
