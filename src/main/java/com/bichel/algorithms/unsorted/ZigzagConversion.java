package com.bichel.algorithms.unsorted;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
 */

public class ZigzagConversion {
    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();

        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));

                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }

        return ret.toString();
    }
}
