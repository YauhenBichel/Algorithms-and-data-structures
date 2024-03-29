package com.bichel.algorithms.problemsheap.dynamic_programming;

public class FibonacciNumber {
    public int fib(int n) {
        if (n < 2) return n;

        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }
}
