package com.bichel.systemdesign;

/*
Design a stack-like data structure to push
elements to the stack and pop the most frequent
element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val
onto the top of the stack.
int pop() removes and returns the most frequent
element in the stack.
If there is a tie for the most frequent element,
the element closest to the stack's top is removed
and returned.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z -> new Stack<>()).push(val);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}
