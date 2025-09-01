package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ====================================================================
 * Problem Statement: Sum of Modes in Subarrays
 * ====================================================================
 *
 * You are given an integer array `arr` and an integer `k`. Your task is to find
 * the sum of the modes of all contiguous subarrays of size `k`.
 *
 * The "mode" is defined as the most frequently occurring element in a subarray.
 * If there is a tie for the most frequent element, the smaller element is
 * considered the mode.
 *
 * ====================================================================
 * Sample Test Cases
 * ====================================================================
 *
 * Example 1:
 * Input: arr[] = {2, 2, 1, 3}, k = 3
 * Output: 3
 * Explanation:
 * - Subarray 1: [2, 2, 1]. Mode is 2 (frequency 2).
 * - Subarray 2: [2, 1, 3]. Three numbers have frequency 1. The smallest is 1, so the mode is 1.
 * - The sum of modes is 2 + 1 = 3.
 *
 * Example 2:
 * Input: arr[] = {1, 2, 2, 3, 3}, k = 2
 * Output: 6
 * Explanation:
 * - Subarray 1: [1, 2]. Mode is 1.
 * - Subarray 2: [2, 2]. Mode is 2.
 * - Subarray 3: [2, 3]. Mode is 2.
 * - Subarray 4: [3, 3]. Mode is 3.
 * - Sum = 1 + 2 + 2 + 3 = 8.  <- Correction: The dry run shows the logic correctly leads to 8.
 */
public class SumOfModesInSubarrays {

    /**
     * Calculates the mode of a given array.
     * The mode is the most frequent element. If there's a tie, the smaller element is chosen.
     */
    private int findMode(int[] currentSubarray) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        int mode = Integer.MAX_VALUE; // Initialize with a large value

        for (int number : currentSubarray) {
            // Update the frequency count for the current number
            int frequency = frequencyMap.getOrDefault(number, 0) + 1;
            frequencyMap.put(number, frequency);

            // Check if this number should become the new mode
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = number;
            } else if (frequency == maxFrequency) {
                // Tie-breaking rule: choose the smaller number
                mode = Math.min(mode, number);
            }
        }
        return mode;
    }

    /**
     * Calculates the sum of modes for all contiguous subarrays of size k.
     */
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        int totalSumOfModes = 0;

        // Iterate through the array to form all possible subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            // Create a subarray of size k starting from index i
            int[] subarray = Arrays.copyOfRange(arr, i, i + k);

            // Find the mode of the current subarray and add it to the total sum
            totalSumOfModes += findMode(subarray);
        }

        return totalSumOfModes;
    }

    /*
     * ====================================================================
     * Dry Run
     * ====================================================================
     *
     * Let's trace with the input: arr[] = {2, 2, 1, 3}, k = 3
     *
     * 1. Initialization in `sumOfModes`:
     * - totalSumOfModes = 0
     * - The main loop will run from i = 0 to (4 - 3) = 1.
     *
     * 2. Main Loop: i = 0
     * - A subarray is created: [2, 2, 1]
     * - Call `findMode([2, 2, 1])`:
     * - Initialize: maxFrequency = 0, mode = infinity
     * - Process 2: frequency of 2 is 1. maxFrequency becomes 1, mode becomes 2.
     * - Process 2: frequency of 2 is 2. maxFrequency becomes 2, mode is still 2.
     * - Process 1: frequency of 1 is 1. This is not greater than maxFrequency (2), so no change.
     * - `findMode` returns 2.
     * - Update sum: totalSumOfModes = 0 + 2 = 2.
     *
     * 3. Main Loop: i = 1
     * - A subarray is created: [2, 1, 3]
     * - Call `findMode([2, 1, 3])`:
     * - Initialize: maxFrequency = 0, mode = infinity
     * - Process 2: frequency of 2 is 1. maxFrequency becomes 1, mode becomes 2.
     * - Process 1: frequency of 1 is 1. This is a tie with maxFrequency.
     * - Check tie-break: is 1 < mode (2)? Yes. Mode is updated to 1.
     * - Process 3: frequency of 3 is 1. This is a tie with maxFrequency.
     * - Check tie-break: is 3 < mode (1)? No. Mode remains 1.
     * - `findMode` returns 1.
     * - Update sum: totalSumOfModes = 2 + 1 = 3.
     *
     * 4. Termination:
     * - The main loop finishes.
     * - The function returns totalSumOfModes, which is 3.
     */
    public static void main(String[] args) {
        SumOfModesInSubarrays solution = new SumOfModesInSubarrays();

        // Test Case 1
        int[] arr1 = {2, 2, 1, 3};
        int k1 = 3;
        System.out.println("Array: " + Arrays.toString(arr1) + ", k: " + k1);
        System.out.println("Sum of Modes: " + solution.sumOfModes(arr1, k1)); // Expected: 3
        System.out.println("--------------------");

        // Test Case 2
        int[] arr2 = {1, 2, 2, 3, 3};
        int k2 = 2;
        System.out.println("Array: " + Arrays.toString(arr2) + ", k: " + k2);
        System.out.println("Sum of Modes: " + solution.sumOfModes(arr2, k2)); // Expected: 8
        System.out.println("--------------------");
    }
}

