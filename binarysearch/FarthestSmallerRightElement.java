package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FarthestSmallerRightElement{

    /*
     * ====================================================================
     * Problem Statement: Farthest Smaller Element to the Right
     * ====================================================================
     *
     * You are given an array arr[]. For each element at index i (0-based),
     * find the farthest index j to the right (i.e., j > i) such that
     * arr[j] < arr[i].
     *
     * If no such index exists for a given position, return -1 for that index.
     * Return the resulting array of answers.
     *
     * Constraints:
     * 1 ≤ arr.size() ≤ 10^6
     * 1 ≤ arr[i] ≤ 10^6
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: arr[] = [2, 5, 1, 3, 2]
     * Output: [2, 4, -1, 4, -1]
     * Explanation:
     * arr[0] = 2: Farthest smaller element is arr[2] = 1.
     * arr[1] = 5: Farthest smaller element is arr[4] = 2.
     * arr[2] = 1: No smaller element to the right.
     * arr[3] = 3: Farthest smaller element is arr[4] = 2.
     * arr[4] = 2: No elements to the right.
     *
     * Example 2:
     * Input: arr[] = [2, 3, 5, 4, 1]
     * Output: [4, 4, 4, 4, -1]
     * Explanation: arr[4]=1 is the farthest smaller element for the first four elements.
     */

    /**
     * For each element, finds the farthest index to the right with a smaller value.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     *
     * @param arr The input array of integers.
     * @return An ArrayList containing the farthest smaller index for each element.
     */
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        // 1. Preprocessing Step: Create the suffix minimum array (O(n))
        // suffixMin[i] stores the minimum value from index i to the end of the array.
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 2. Searching Step: Iterate through each element
        for (int i = 0; i < n; i++) {
            // Perform binary search on the suffixMin array for the range to the right of i
            int low = i + 1;
            int high = n - 1;
            int farthestIndex = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                // If we find a suffix that contains an element smaller than arr[i]...
                if (suffixMin[mid] < arr[i]) {
                    // This is a potential answer. Store it and try to find an even
                    // farther one to the right.
                    farthestIndex = mid;
                    low = mid + 1;
                } else {
                    // This suffix's minimum is not smaller, so we must search
                    // in the left half to find a smaller value.
                    high = mid - 1;
                }
            }
            result.add(farthestIndex);
        }

        return result;
    }

    // Main method to test the farMin function with static inputs.
    public static void main(String[] args) {
        FarthestSmallerRightElement sol = new FarthestSmallerRightElement();


        // Test Case 1
        int[] arr1 = {2, 5, 1, 3, 2};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + sol.farMin(arr1)); // Expected: [2, 4, -1, 4, -1]
        System.out.println("--------------------");

        // Test Case 2
        int[] arr2 = {2, 3, 5, 4, 1};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + sol.farMin(arr2)); // Expected: [4, 4, 4, 4, -1]
        System.out.println("--------------------");

        // Test Case 3
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + sol.farMin(arr3)); // Expected: [-1, -1, -1, -1, -1]
        System.out.println("--------------------");
    }
}
