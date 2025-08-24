package binarysearch;

// Problem Statement:
// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book.
// You also have an integer k representing the number of students. The task is to allocate books to each student such that:
// - Each student receives at least one book.
// - Each student is assigned a contiguous sequence of books.
// - No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student.
// If it is not possible to allocate books to all students, return -1.
//
// Examples:
// Input: arr[] = {12, 34, 67, 90}, k = 2
// Output: 113
// Explanation: Allocation can be [12, 34, 67] and [90] with max pages 113.
//
// Input: arr[] = {15, 17, 20}, k = 5
// Output: -1
// Explanation: More students than books, impossible.
//
// Constraints:
// 1 ≤ arr.size() ≤ 10^6
// 1 ≤ arr[i], k ≤ 10^3

import java.util.*;

// Problem Statement:
// You have a row of flowers, where each flower blooms after a specific day. The array arr[] represents the blooming schedule:
// arr[i] is the day the flower at position i will bloom. To create a bouquet, you need to collect k adjacent bloomed flowers.
// Each flower can only be used in one bouquet. Your goal is to find the minimum number of days required to make exactly m bouquets.
// If it is not possible to make m bouquets with the given arrangement, return -1.
//
// Examples:
// Input: m = 3, k = 2, arr[] = {3, 4, 2, 7, 13, 8, 5}
// Output: 8
// Explanation: We need 3 bouquets and each bouquet should have 2 flowers. After day 8: [x, x, x, x, _, x, x],
// we can make first bouquet from the first 2 flowers, second from the next 2, and third from the last 2.
//
// Input: m = 2, k = 3, arr[] = {5, 5, 5, 5, 10, 5, 5}
// Output: 10
// Explanation: We need 2 bouquets and each bouquet should have 3 flowers. After day 5: [x, x, x, x, _, x, x],
// one bouquet is possible, but not two. After day 10: [x, x, x, x, x, x, x], two bouquets are possible.
//
// Input: m = 3, k = 2, arr[] = {1, 10, 3, 10, 2}
// Output: -1
// Explanation: We need 6 flowers (3 bouquets * 2 flowers), but only 5 are available, so impossible.
//
// Constraints:
// 1 ≤ k ≤ arr.size() ≤ 10^5
// 1 ≤ m ≤ 10^5
// 1 ≤ arr[i] ≤ 10^9
//
// Expected Complexities:
// Time Complexity: O(n * log(max(arr[i])))
// Auxiliary Space: O(1)

import java.util.*;

public class MinDaystoMakeMBouquets {
    public static int minDaysBloom(int[] arr, int k, int m) {
        // Check if total flowers required exceed available flowers
        int n = arr.length;
        if ((long)n < (long)m * k) return -1;

        // Binary search on days
        int left = 1, right = 1000000000; // Constraints: arr[i] ≤ 10^9
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(arr, mid, k, m)) {
                result = mid;
                right = mid - 1; // Try a smaller day
            } else {
                left = mid + 1; // Need a larger day
            }
        }

        return result;
    }

    private static boolean canMakeBouquets(int[] arr, int day, int k, int m) {
        int bouquets = 0;
        int flowers = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // Reset for next bouquet
                }
            } else {
                flowers = 0; // Reset if flower hasn't bloomed
            }
        }

        return bouquets >= m;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {3, 4, 2, 7, 13, 8, 5};
        int k1 = 2, m1 = 3;
        System.out.println("Minimum days for arr1 with k = " + k1 + ", m = " + m1 + ": " + minDaysBloom(arr1, k1, m1)); // Expected: 8

        // Test Case 2
        int[] arr2 = {5, 5, 5, 5, 10, 5, 5};
        int k2 = 3, m2 = 2;
        System.out.println("Minimum days for arr2 with k = " + k2 + ", m = " + m2 + ": " + minDaysBloom(arr2, k2, m2)); // Expected: 10

        // Test Case 3
        int[] arr3 = {1, 10, 3, 10, 2};
        int k3 = 2, m3 = 3;
        System.out.println("Minimum days for arr3 with k = " + k3 + ", m = " + m3 + ": " + minDaysBloom(arr3, k3, m3)); // Expected: -1

}}