package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Longest Subarray with At Most Two Distinct Integers
 * Find the length of the longest subarray with at most two distinct integers.
 *
 * Input:
 * - arr: Array of integers
 *
 * Output:
 * - Length of the longest subarray with at most two distinct integers
 *
 * Example:
 * Test Case 1: arr = [1, 2, 1, 2, 3], Output = 4 ([1, 2, 1, 2])
 * Test Case 2: arr = [1, 1, 1, 2, 2], Output = 5 (entire array)
 * Test Case 3: arr = [1, 2, 3, 4], Output = 2 (e.g., [1, 2])
 */
public class LongestSubarrayWithAtmostTwoDistinctIntegers {
    public int totalElements(int[] arr) {
        int maxLength = 0;
        int left = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            while (countMap.size() > 2) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }


            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubarrayWithAtmostTwoDistinctIntegers sol = new LongestSubarrayWithAtmostTwoDistinctIntegers();
        int[][] arrays = {{1, 2, 1, 2, 3}, {1, 1, 1, 2, 2}, {1, 2, 3, 4}};

        for (int t = 0; t < arrays.length; t++) {
            int result = sol.totalElements(arrays[t]);
            System.out.println("Test Case " + (t + 1) + ": Output = " + result);
        }
    }
}
