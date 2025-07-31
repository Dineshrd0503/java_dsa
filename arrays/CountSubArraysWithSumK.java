package arrays;

/**
 * Problem Statement:
 * Find the number of subarrays in an unsorted integer array whose sum equals a given number k.
 * 
 * Examples:
 * - Input: arr[] = [10, 2, -2, -20, 10], k = -10 -> Output: 3
 * - Input: arr[] = [9, 4, 20, 3, 10, 5], k = 33 -> Output: 2
 * - Input: arr[] = [1, 3, 5], k = 0 -> Output: 0
 * 
 * Constraints:
 * - 1 ≤ arr.size() ≤ 10^5
 * - -10^3 ≤ arr[i] ≤ 10^3
 * - -10^5 ≤ k ≤ 10^5
 * 
 * Date: 11:14 AM IST, Wednesday, July 30, 2025
 */

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithSumK {
    /**
     * Counts the number of subarrays with sum equal to k.
     * 
     * @param arr The input integer array
     * @param k The target sum
     * @return The number of subarrays with sum equal to k
     */
    public int cntSubarrays(int[] arr, int k) {
        // Initialize prefix sum and count
        int prefixSum = 0;
        int count = 0;
        
        // Map to store frequency of prefix sums
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with 0 sum occurring once (empty subarray)

        // Traverse the array
        for (int n : arr) {
            prefixSum += n; // Update prefix sum with current element
            
            // Check if there is a prefix sum such that (prefixSum - k) exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            
            // Update the frequency of the current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }

    /**
     * Main method to test the cntSubarrays method with static inputs.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        CountSubArraysWithSumK solution = new CountSubArraysWithSumK();

        // Test Case 1: arr[] = [10, 2, -2, -20, 10], k = -10
        int[] arr1 = {10, 2, -2, -20, 10};
        System.out.println("Test Case 1 - Count: " + solution.cntSubarrays(arr1, -10)); // Expected: 3

        // Test Case 2: arr[] = [9, 4, 20, 3, 10, 5], k = 33
        int[] arr2 = {9, 4, 20, 3, 10, 5};
        System.out.println("Test Case 2 - Count: " + solution.cntSubarrays(arr2, 33)); // Expected: 2

        // Test Case 3: arr[] = [1, 3, 5], k = 0
        int[] arr3 = {1, 3, 5};
        System.out.println("Test Case 3 - Count: " + solution.cntSubarrays(arr3, 0)); // Expected: 0
    }
}
