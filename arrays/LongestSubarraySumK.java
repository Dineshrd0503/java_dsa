package arrays;

import java.util.HashMap;

public class LongestSubarraySumK {

    // Function to find the longest subarray with sum K
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        // HashMap to store (cumulative sum, index)
        HashMap<Integer, Integer> map = new HashMap<>();

        int currentSum = 0;  // Cumulative sum
        int maxLength = 0;    // Length of the longest subarray

        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the cumulative sum
            currentSum += arr[i];

            // If current sum is equal to k, the subarray starts from index 0
            if (currentSum == k) {
                maxLength = i + 1;
            }

            // If (currentSum - k) exists in the map, it means we have found a subarray with sum k
            if (map.containsKey(currentSum - k)) {
                // Update maxLength with the length of the subarray
                maxLength = Math.max(maxLength, i - map.get(currentSum - k));
            }

            // If the current cumulative sum is not in the map, store it with the index
            // We only store the first occurrence to maximize the length of the subarray
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println("Length of the longest subarray with sum " + k + ": " + longestSubarrayWithSumK(arr, k));
    }
}
