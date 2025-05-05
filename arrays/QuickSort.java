package arrays;

import java.util.*;

public class QuickSort {

    /**
     * Problem Statement:
     * You’re given an array/list 'ARR' of N elements, where each element is at most K away from its
     * target position (Position if the array was sorted). Your task is to devise an algorithm that
     * sorts the given array in O(N log K) time.
     *
     * Input Format:
     * The first line of input contains an integer T denoting the number of test cases.
     * The first line of each test case contains two space-separated integers N and K.
     * The second line of each test case contains N space-separated integers.
     *
     * Output Format:
     * For each test case, the output is a single line containing N space-separated integers
     * representing the sorted array.
     */

    public static int[] nearlySorted(int[] arr, int n, int k) {
        quicksort(arr, 0, n - 1); // Apply quicksort on the entire array
        return arr; // Return the sorted array
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) { // Check if there are elements to sort
            int pi = partition(arr, start, end); // Get the pivot index
            quicksort(arr, start, pi - 1); // Recursively sort left subarray
            quicksort(arr, pi + 1, end); // Recursively sort right subarray
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; // Choose the last element as the pivot
        int i = start - 1; // Pointer for the smaller element
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) { // If current element is smaller than or equal to pivot
                i++; // Increment index of smaller element
                swap(arr, i, j); // Swap elements
            }
        }
        swap(arr, i + 1, end); // Swap the pivot element to its correct position
        return i + 1; // Return the index of the pivot
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; // Perform the swap
    }

    public static void main(String[] args) {
        // Sample test cases to demonstrate functionality

        // Test case 1
        int n1 = 7;
        int k1 = 3;
        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        System.out.println("Sorted Array 1: " + Arrays.toString(nearlySorted(arr1, n1, k1)));

        // Test case 2
        int n2 = 8;
        int k2 = 4;
        int[] arr2 = {10, 9, 8, 7, 4, 70, 60, 50};
        System.out.println("Sorted Array 2: " + Arrays.toString(nearlySorted(arr2, n2, k2)));

        // Additional test case
        int n3 = 5;
        int k3 = 2;
        int[] arr3 = {4, 3, 2, 1, 0};
        System.out.println("Sorted Array 3: " + Arrays.toString(nearlySorted(arr3, n3, k3)));
    }
}
