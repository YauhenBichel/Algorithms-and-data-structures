package com.bichel.algorithms.problemsheap.math;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int greatestCommonDivisor = gcd(357, 234);

        System.out.println(greatestCommonDivisor);
    }

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }
}
