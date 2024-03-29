package com.bichel.algorithms.problemsheap.sort.insertion;

public class InsertionSort_DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        sort(a);
        sort(b);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }

        return result;
    }

    private static void sort(int[] arr) {
        int N = arr.length;

        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
