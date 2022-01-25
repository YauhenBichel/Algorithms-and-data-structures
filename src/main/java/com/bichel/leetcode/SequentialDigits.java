package com.bichel.leetcode;

/*
An integer has sequential digits if and only if each digit in the number
is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high]
inclusive that have sequential digits.

Example 1:
Input: low = 100, high = 300
Output: [123,234]

Example 2:
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 */

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList<>();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int length = lowLen; length < highLen + 1; length++) {
            for (int start = 0; start < n - length; start++) {
                int num = Integer.parseInt(sample.substring(start, start + length));

                if (num >= low && num <= high)
                    nums.add(num);
            }
        }

        return nums;
    }
}
