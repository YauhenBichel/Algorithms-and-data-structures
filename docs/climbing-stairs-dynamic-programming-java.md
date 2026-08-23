---
title: "Climbing Stairs (Dynamic Programming) in Java"
description: "Climbing stairs problem in Java - O(n) dynamic programming with O(1) space. The Fibonacci recurrence in disguise, with source code."
category: "Dynamic Programming"
---

# Climbing Stairs (Dynamic Programming) in Java

<span class="tag">Dynamic Programming</span><span class="tag">Java</span>

The number of ways to reach step n is the ways to reach n-1 plus the ways to reach n-2 - the Fibonacci recurrence. Because only the last two values matter, the DP table collapses to two variables and constant space. Usually the first DP problem worth writing out.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `climbStairs` | O(n) | O(1) |

## Implementation

```java
package com.bichel.algorithms.problemsheap.dynamic_programming;

public class ClimbingStairs {
    private int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    private int usingDP(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];

        dp[1] = 1; // if 1 stair then 1 combination
        dp[2] = 2; // if 2 stairs then 2 comb

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private int climbStairs(int i, int n, int[] memo) {

        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];

        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);

        return memo[i];
    }
}
```

## Source

[`src/main/java/com/bichel/algorithms/problemsheap/dynamic_programming/ClimbingStairs.java`](https://github.com/YauhenBichel/Algorithms-and-data-structures/blob/master/src/main/java/com/bichel/algorithms/problemsheap/dynamic_programming/ClimbingStairs.java) on GitHub.
