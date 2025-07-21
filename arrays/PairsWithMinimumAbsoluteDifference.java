package arrays;

import java.util.*;

/**
 * Problem: Given an integer array `arr`, find all pairs of elements with the minimum absolute difference.
 * Return the result as a list of pairs in increasing order.
 *
 * Example:
 * Input: [4, 2, 1, 3]
 * Output: [[1, 2], [2, 3], [3, 4]]
 *
 * Constraints:
 * - 2 <= arr.length <= 10^5
 * - -10^6 <= arr[i] <= 10^6
 * - All elements are distinct
 */
public class PairsWithMinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr); // Sort to simplify the difference checking

        int minDiff = Integer.MAX_VALUE;

        // 1st Pass: Find the minimum absolute difference
        for (int i = 0; i < n - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        // 2nd Pass: Add all pairs with the minimum absolute difference
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }

    // ✅ Sample test driver
    public static void main(String[] args) {
        int[] test1 = {4, 2, 1, 3};
        int[] test2 = {1, 3, 6, 10, 15};
        int[] test3 = {3, 8, -10, 23, 19, -4, -14, 27};

        System.out.println("Test 1 Output: " + minimumAbsDifference(test1)); // [[1, 2], [2, 3], [3, 4]]
        System.out.println("Test 2 Output: " + minimumAbsDifference(test2)); // [[1, 3]]
        System.out.println("Test 3 Output: " + minimumAbsDifference(test3)); // [[-14, -10], [19, 23], [23, 27]]
    }
}
