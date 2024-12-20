package codingninjas;

import java.util.HashMap;
//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//        Example 1:
//
//Input: nums = [1,1,1], k = 2
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3], k = 3
//Output: 2
public class NoSubArraysWithSumK {
    public int subarraySum(int[] arr, int tar) {
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Initializing the prefix sum and the number of subarrays
        int prefixSum = 0;
        int count = 0;

        // To handle the case where a subarray starts from index 0 and sums to target
        prefixSumFreq.put(0, 1);

        for (int num : arr) {
            prefixSum += num;

            // Check if prefixSum - target exists in the map
            if (prefixSumFreq.containsKey(prefixSum - tar)) {
                count += prefixSumFreq.get(prefixSum - tar);
            }

            // Update the frequency of the current prefixSum
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int tar = 33;
        System.out.println("Number of subarrays with sum " + tar + ": " + new NoSubArraysWithSumK().subarraySum(arr, tar));
    }
}
