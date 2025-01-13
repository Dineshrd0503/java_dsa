package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

//Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.
//
//Examples:
//
//Input: k = -10, arr = [10, 2, -2, -20, 10]
//Output: 3
//Explaination:  Subarrays: arr[0...3], arr[1...4], arr[3..4] have sum exactly equal to -10.
//Input: k = 33, arr = [9, 4, 20, 3, 10, 5]
//Output: 2
//Explaination:  Subarrays : arr[0...2], arr[2...4] have sum exactly equal to 33.
//Input: k = 1, arr = [1]
//Output: 1
//Explaination: Since the required sum is 1 and the array also has a single element equal to 1, hence there is only one subarray.

public class SubArraysSumK {
    public static int findSubArraySum(int k, int arr[]) {
        int count = 0; // To count the number of subarrays with sum k
        int prefixsum = 0; // To store the cumulative sum
        Map<Integer, Integer> map = new HashMap<>(); // To store prefix sums and their frequencies

        map.put(0, 1); // Base case: To handle subarrays starting from index 0

        for (int n : arr) {
            prefixsum += n; // Update the cumulative sum

            // Check if there exists a prefix sum that forms a subarray with sum k
            if (map.containsKey(prefixsum - k)) {
                count += map.get(prefixsum - k); // Add the frequency of the required prefix sum
            }

            // Update the frequency of the current prefix sum
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }

        return count; // Return t
        // code here
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println("Number of subarrays with sum " + k + ": " + findSubArraySum(k, arr)); // Output: 2
    }
}
