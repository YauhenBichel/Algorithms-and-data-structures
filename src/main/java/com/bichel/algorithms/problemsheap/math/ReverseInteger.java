package com.bichel.algorithms.problemsheap.math;

public class ReverseInteger {
    public int withoutLong(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse(int x) {
        long rev = 0;
        int sign = 1;

        if (x < 0) {
            sign = -1;
        }
        x = Math.abs(x);

        int i = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        rev *= sign;

        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}
