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

public class BookAllocation {
    public static int findPages(int[] arr, int k) {
        // Check if number of students exceeds number of books
        int n = arr.length;
        if (n < k) return -1;

        // Binary search on the maximum pages
        long sum = 0;
        int max = 0;
        for (int pages : arr) {
            sum += pages;
            max = Math.max(max, pages);
        }

        int left = max, right = (int)sum;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAllocate(arr, mid, k)) {
                result = mid;
                right = mid - 1; // Try a smaller max
            } else {
                left = mid + 1; // Need a larger max
            }
        }

        return result;
    }

    private static boolean canAllocate(int[] arr, int maxPages, int k) {
        int students = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            } else {
                students++;
                currentPages = pages;
                if (currentPages > maxPages) return false;
            }
        }

        return students <= k;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {12, 34, 67, 90};
        int k1 = 2;
        System.out.println("Minimum max pages for arr1 with k = " + k1 + ": " + findPages(arr1, k1)); // Expected: 113

        // Test Case 2
        int[] arr2 = {15, 17, 20};
        int k2 = 5;
        System.out.println("Minimum max pages for arr2 with k = " + k2 + ": " + findPages(arr2, k2)); // Expected: -1
    }
}
