package com.bichel.algorithms.problemsheap.math;

import java.util.*;

public class GCD2 {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for (int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd(int a, int b) {
    if (b == 0)
      return a;

    if (a == b)
      return a;

    if (a < b)
      gcd(b, a);

    return gcd(b, a % b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
