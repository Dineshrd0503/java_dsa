package geeksforgeeks;

//Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.
//
//Examples:
//
//Input: arr[] = [10, 2, -2, -20, 10] , tar = -10
//Output: 3
//Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
//Input: arr[] = [1, 4, 20, 3, 10, 5] , tar = 33
//Output: 1
//Explanation: Subarray with sum 33 is: [20,3,10].
import java.util.HashMap;

public class SubArraySum {
    public static int subArraySum(int arr[], int tar) {
        // HashMap to store prefix sums and their frequencies
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
        int arr1[] = {10, 2, -2, -20, 10};
        int tar1 = -10;
        System.out.println("Number of subarrays: " + subArraySum(arr1, tar1));  // Output: 3

        int arr2[] = {1, 4, 20, 3, 10, 5};
        int tar2 = 33;
        System.out.println("Number of subarrays: " + subArraySum(arr2, tar2));  // Output: 1
    }
}



