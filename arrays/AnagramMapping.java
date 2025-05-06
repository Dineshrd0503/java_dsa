package arrays;

import java.util.HashMap;

/**
 * This program finds the index mapping of two arrays 'A' and 'B'.
 * An array 'B' is an anagram of array 'A', which means that both arrays
 * contain the same elements but in a different order. The task is to
 * find the index in array 'B' for every element in array 'A'.
 *
 * Problem Statement:
 * Given two arrays A and B, each containing N distinct integers, where B
 * is an anagram of A, find the index mapping from array A to array B.
 *
 * Sample Input and Output:
 * Input:
 * 1
 * 5
 * 10 20 30 40 50
 * 20 10 40 50 30
 * Output:
 * 1 0 4 2 3
 * Explanation:
 * A[0] occurs at index 1 in array B,
 * A[1] occurs at index 0 in array B,
 * A[2] occurs at index 4 in array B,
 * A[3] occurs at index 2 in array B,
 * A[4] occurs at index 3 in array B.
 */
public class AnagramMapping{

    /**
     * This method finds the index mapping from array A to B
     * @param n Length of the arrays
     * @param a Array A
     * @param b Array B (anagram of A)
     * @return An array containing indices of elements from A in B
     */
    public static int[] anagramMapping(int n, int[] a, int[] b) {
        int[] result = new int[n]; // Result array to store index mapping
        HashMap<Integer, Integer> map = new HashMap<>(); // HashMap to store index of elements in B

        // Populate the HashMap with values from array B
        for (int i = 0; i < n; i++) {
            map.put(b[i], i); // Key: value in B, Value: index of that value in B
        }

        // Populate the result array by finding indices in B for elements in A
        for (int i = 0; i < n; i++) {
            result[i] = map.get(a[i]); // Get the index of a[i] from the HashMap
        }

        return result; // Return the resulting index mapping
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] a1 = {10, 20, 30, 40, 50};
        int[] b1 = {20, 10, 40, 50, 30};
        int[] result1 = anagramMapping(a1.length, a1, b1);
        System.out.print("Test Case 1 Output: ");
        for (int index : result1) {
            System.out.print(index + " ");
        }
        System.out.println();

        // Sample Test Case 2
        int[] a2 = {10, 20, 30, 40, 50};
        int[] b2 = {10, 20, 30, 40, 50};
        int[] result2 = anagramMapping(a2.length, a2, b2);
        System.out.print("Test Case 2 Output: ");
        for (int index : result2) {
            System.out.print(index + " ");
        }
        System.out.println();

        // Sample Test Case 3
        int[] a3 = {1, 2, 3};
        int[] b3 = {3, 2, 1};
        int[] result3 = anagramMapping(a3.length, a3, b3);
        System.out.print("Test Case 3 Output: ");
        for (int index : result3) {
            System.out.print(index + " ");
        }
        System.out.println();
    }
}
