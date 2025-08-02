package prefixsumandhashing;

/**
 * Problem Statement:
 * Given an array of integers arr and an integer k, find the total number of
 * continuous subarrays whose sum equals k.
 *
 * Constraints:
 * - 1 <= arr.length <= 10^5
 * - -10^9 <= arr[i] <= 10^9
 * - -10^9 <= k <= 10^9
 *
 * Examples:
 * Example 1:
 * Input: arr = [1, 1, 1], k = 2
 * Output: 2
 * Explanation: Subarrays [1, 1] (indices 0 to 1) and [1, 1] (indices 1 to 2) have sum = 2.
 *
 * Example 2:
 * Input: arr = [1, 2, 3], k = 3
 * Output: 2
 * Explanation: Subarrays [1, 2] (indices 0 to 1) and [3] (index 2) have sum = 3.
 */
import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] arr, int k) {
        // Initialize HashMap to store frequency of prefix sums
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Initialize sum 0 with frequency 1 for subarrays starting at index 0

        long sum = 0; // Running prefix sum
        int count = 0; // Count of subarrays with sum k

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update prefix sum

            // Check if (sum - k) exists, indicating subarrays ending at i with sum k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Update frequency of current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // Main method to test the solution with example test cases
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        // Test Case 1: arr = [1, 1, 1], k = 2
        int[] arr1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1:");
        System.out.print("Input: arr = [");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + (i < arr1.length - 1 ? ", " : ""));
        }
        System.out.println("], k = " + k1);
        System.out.println("Output: " + solution.subarraySum(arr1, k1));
        System.out.println("Expected: 2");

        // Test Case 2: arr = [1, 2, 3], k = 3
        int[] arr2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("\nTest Case 2:");
        System.out.print("Input: arr = [");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + (i < arr2.length - 1 ? ", " : ""));
        }
        System.out.println("], k = " + k2);
        System.out.println("Output: " + solution.subarraySum(arr2, k2));
        System.out.println("Expected: 2");
    }
}