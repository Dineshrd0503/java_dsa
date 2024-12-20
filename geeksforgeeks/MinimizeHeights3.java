package geeksforgeeks;

import java.util.Arrays;
//Given an array arr[] denoting heights of N towers and a positive integer K.
//
//For each tower, you must perform exactly one of the following operations exactly once.
//
//Increase the height of the tower by K
//Decrease the height of the tower by K
//Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
//
//You can find a slight modification of the problem here.
//Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.
//
//        Examples :
//
//Input: k = 2, arr[] = {1, 5, 8, 10}
//Output: 5
//Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
//Input: k = 3, arr[] = {3, 9, 12, 16, 20}
//Output: 11
//Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11.

public class MinimizeHeights3 {
    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0; // Single element case

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Compute the initial difference
        int diff = arr[n - 1] - arr[0];

        // Step 3: Adjust the smallest and largest elements
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(arr[i] + k, arr[n - 1] - k);
            int min = Math.min(arr[0] + k, arr[i + 1] - k);

            // Skip invalid cases (negative heights)
            if (min < 0) continue;

            // Update the minimum difference
            diff = Math.min(diff, max - min);
        }

        return diff;
    }

    public static void main(String[] args) {


        // Example: Large Input
        int[] arr = {380, 705, 706, 177, 710, 416, 853, 147, 957, 693, 631, 891, 287, 277, 976, 210, 876, 77, 205, 172, 741, 810, 959, 399, 710, 157, 222, 934, 887, 413, 617, 72, 503, 390, 489, 373, 34, 944, 719, 832, 726, 115, 803, 827, 920, 306, 455, 104, 956, 301};
        int k = 494;
        System.out.println(getMinDiff(arr, k)); // Output: 973
    }
}

