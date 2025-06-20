package arrays;

import java.util.*;

/*
 * Problem: Valid Group of Consecutive Integers
 * Given an array of integers and an integer K, determine if the array can be divided into groups of size K,
 * where each group contains K consecutive integers (e.g., [x, x+1, ..., x+k-1]).
 *
 * Input:
 * - T: Number of test cases (hardcoded as 3)
 * - For each test case:
 *   - N: Array length (1 <= N <= 10^5)
 *   - K: Group size (1 <= K <= N)
 *   - arr: N integers (0 <= arr[i] <= 10^9)
 *
 * Output:
 * - For each test case, print "YES" if the array can be divided into valid groups, "NO" otherwise.
 *
 * Example:
 * Test Case 1: arr = [1, 2, 3, 2, 3, 4, 3, 4, 5], K = 3
 * Output: YES (Groups: [1,2,3], [2,3,4], [3,4,5])
 *
 * Test Case 2: arr = [1, 2, 4], K = 3
 * Output: NO (Missing 3 for group [1,2,3])
 *
 * Test Case 3: arr = [1, 2, 1, 2, 3, 4], K = 2
 * Output: YES (Groups: [1,2], [1,2], [3,4])
 *
 * Constraints:
 * - 1 <= T <= 10^5
 * - 1 <= N <= 10^5
 * - 1 <= K <= N
 * - 0 <= arr[i] <= 10^9
 * - Time Limit: 1 sec
 */
public class GroupBallsBySequence{
    /*
     * Checks if the array can be divided into groups of size K with consecutive integers.
     * @param arr Input array
     * @param k Group size
     * @return true if valid division is possible, false otherwise
     */
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length;
        // Check if array length is divisible by k
        if (n % k != 0) {
            return false;
        }

        // Count frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Sort unique numbers
        List<Integer> sortedKeys = new ArrayList<>(freqMap.keySet());
        Collections.sort(sortedKeys);

        // Try forming groups starting from each number
        for (int num : sortedKeys) {
            int frequency = freqMap.get(num);
            if (frequency > 0) {
                // Check if k consecutive numbers exist with enough frequency
                for (int i = 0; i < k; i++) {
                    int nextNum = num + i;
                    if (!freqMap.containsKey(nextNum) || freqMap.get(nextNum) < frequency) {
                        return false;
                    }
                    freqMap.put(nextNum, freqMap.get(nextNum) - frequency);
                }
            }
        }

        return true;
    }

    /*
     * Main method with static inputs for test cases.
     */
    public static void main(String[] args) {
        GroupBallsBySequence solution = new GroupBallsBySequence();

        // Define static test cases
        int[][] testArrays = {
                {1, 2, 3, 2, 3, 4, 3, 4, 5}, // Test Case 1
                {1, 2, 4},                    // Test Case 2
                {1, 2, 1, 2, 3, 4}           // Test Case 3
        };
        int[] kValues = {3, 3, 2}; // Corresponding K values

        // Process each test case
        for (int t = 0; t < testArrays.length; t++) {
            int[] arr = testArrays[t];
            int k = kValues[t];
            System.out.println("Test Case " + (t + 1) + ": " + (solution.validgroup(arr, k) ? "YES" : "NO"));
        }
    }
}