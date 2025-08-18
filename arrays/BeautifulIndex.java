package arrays;

import java.util.Arrays;

public class BeautifulIndex{

    /*
     * ====================================================================
     * Problem Statement: Beautiful Index (Equilibrium Point)
     * ====================================================================
     *
     * You are given an array of integers. Your task is to find a "beautiful index"
     * in the array. A beautiful index is defined as an index where the sum of
     * elements to its left is equal to the sum of elements to its right.
     *
     * The element at the beautiful index itself is not included in either sum.
     * The function should return the 1-based index of the first beautiful index
     * found. If no such index exists, it should return -1.
     *
     * For the first element (index 0), the left sum is considered 0.
     * For the last element, the right sum is considered 0.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: n = 6, arr = [1, 7, 3, 6, 5, 6]
     * Output: 4
     * Explanation: At index 3 (which is the 4th element), the element is 6.
     * Left sum = 1 + 7 + 3 = 11.
     * Right sum = 5 + 6 = 11.
     * Since the sums are equal, the 1-based index 4 is returned.
     *
     * Example 2:
     * Input: n = 3, arr = [1, 2, 3]
     * Output: -1
     * Explanation: There is no index where the left sum equals the right sum.
     *
     * Example 3:
     * Input: n = 3, arr = [2, 0, 2]
     * Output: 2
     * Explanation: At index 1 (the 2nd element), the element is 0.
     * Left sum = 2.
     * Right sum = 2.
     * The 1-based index 2 is returned.
     */

    /**
     * Finds the first 1-based "beautiful index" in an array where the sum of
     * left elements equals the sum of right elements.
     *
     * @param n   The size of the array.
     * @param arr The input array of integers.
     * @return The 1-based beautiful index, or -1 if none exists.
     */
    public static int beautifulIndex(int n, int[] arr) {
        // First, calculate the total sum of all elements in the array.
        int totalSum = Arrays.stream(arr).sum();

        // Initialize the sum of elements to the left of the current index.
        int leftSum = 0;

        // Iterate through the array to find the beautiful index.
        for (int i = 0; i < n; i++) {
            // Calculate the sum of elements to the right of the current index.
            // rightSum = totalSum - (sum of elements to the left) - (current element)
            int rightSum = totalSum - leftSum - arr[i];

            // Check if the sums are equal.
            if (leftSum == rightSum) {
                // If they are, we've found the beautiful index. Return the 1-based index.
                return i + 1;
            }

            // Add the current element to the leftSum for the next iteration.
            leftSum += arr[i];
        }

        // If the loop completes without finding a beautiful index, return -1.
        return -1;
    }

    // Main method to test the beautifulIndex function with static inputs.
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Beautiful Index: " + beautifulIndex(arr1.length, arr1)); // Expected output: 4
        System.out.println("--------------------");

        // Test Case 2
        int[] arr2 = {1, 2, 3};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Beautiful Index: " + beautifulIndex(arr2.length, arr2)); // Expected output: -1
        System.out.println("--------------------");

        // Test Case 3
        int[] arr3 = {2, 0, 2};
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Beautiful Index: " + beautifulIndex(arr3.length, arr3)); // Expected output: 2
        System.out.println("--------------------");

        // Test Case 4
        int[] arr4 = {10};
        System.out.println("Array: " + Arrays.toString(arr4));
        System.out.println("Beautiful Index: " + beautifulIndex(arr4.length, arr4)); // Expected output: 1
        System.out.println("--------------------");
    }
}
