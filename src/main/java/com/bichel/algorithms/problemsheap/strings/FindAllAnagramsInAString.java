package com.bichel.algorithms.problemsheap.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
Given two strings s and p,
return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging
the letters of a different word or phrase,
typically using all the original letters exactly once.
 */

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();

        if (ns < np)
            return new ArrayList<Integer>();

        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        // build reference hashmap using string p
        for (char ch : p.toCharArray()) {
            if (pCount.containsKey(ch)) {
                pCount.put(ch, pCount.get(ch) + 1);
            } else {
                pCount.put(ch, 1);
            }
        }

        List<Integer> output = new ArrayList<>();
        // sliding window on the string s
        for (int i = 0; i < ns; i++) {
            // add one more letter
            // on the right side of the window
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            } else {
                sCount.put(ch, 1);
            }

            // remove one letter
            // from the left side of the window
            if (i >= np) {
                ch = s.charAt(i - np);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            // compare hashmap in the sliding window
            // with the reference hashmap
            if (pCount.equals(sCount)) {
                output.add(i - np + 1);
            }
        }

        return output;
    }
}
