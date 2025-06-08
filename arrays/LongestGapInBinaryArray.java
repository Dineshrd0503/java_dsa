package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement:
 * Given two binary arrays a1[] and a2[] of equal length, find the length of the longest
 * common span (i, j) where j >= i such that the sum of elements in a1[i..j] equals
 * the sum of elements in a2[i..j]. The arrays contain only 0 or 1.
 *
 * Constraints:
 * - 1 <= a1.length = a2.length <= 10^6
 * - 0 <= a1[i], a2[i] <= 1
 *
 * Examples:
 * Example 1:
 * Input: a1 = [0, 1, 0, 0, 0, 0], a2 = [1, 0, 1, 0, 0, 1]
 * Output: 4
 * Explanation: The longest span is from index 1 to 4 (zero-based indexing).
 *              a1[1..4] = [1,0,0,0], sum = 1; a2[1..4] = [0,1,0,0], sum = 1.
 *
 * Example 2:
 * Input: a1 = [0, 1, 0, 1, 1, 1, 1], a2 = [1, 1, 1, 1, 1, 0, 1]
 * Output: 6
 * Explanation: The longest span is from index 1 to 6.
 *              a1[1..6] = [1,0,1,1,1,1], sum = 5; a2[1..6] = [1,1,1,1,0,1], sum = 5.
 *
 * Sample Test Cases:
 * Test Case 1: a1 = [0], a2 = [0] → Output: 1 (single element, sum = 0)
 * Test Case 2: a1 = [1], a2 = [0] → Output: 0 (no equal sum)
 * Test Case 3: a1 = [0,0,0], a2 = [0,0,0] → Output: 3 (entire array, sum = 0)
 * Test Case 4: a1 = [1,1,1], a2 = [1,1,1] → Output: 3 (entire array, sum = 3)
 */

public class LongestGapInBinaryArray {
    public static int longestCommonSum(int[] a1, int[] a2) {
        int prefixsum = 0, maxlen = 0;
        int n = a1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Handle subarray starting from index 0

        for (int i = 0; i < n; i++) {
            prefixsum += (a1[i] - a2[i]);
            if (map.containsKey(prefixsum)) {
                int previndex = map.get(prefixsum);
                maxlen = Math.max(maxlen, i - previndex);
            } else {
                map.put(prefixsum, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {

        // Static Test Case 1: Example 1
        int[] a1_1 = {0, 1, 0, 0, 0, 0};
        int[] a2_1 = {1, 0, 1, 0, 0, 1};
        System.out.println("Test Case 1:");
        System.out.println("Input: a1 = " + arrayToString(a1_1) + ", a2 = " + arrayToString(a2_1));
        System.out.println("Output: " + longestCommonSum(a1_1, a2_1)); // Expected: 4

        // Static Test Case 2: Example 2
        int[] a1_2 = {0, 1, 0, 1, 1, 1, 1};
        int[] a2_2 = {1, 1, 1, 1, 1, 0, 1};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: a1 = " + arrayToString(a1_2) + ", a2 = " + arrayToString(a2_2));
        System.out.println("Output: " +longestCommonSum(a1_2, a2_2)); // Expected: 6

        // Static Test Case 3: Single element, equal
        int[] a1_3 = {0};
        int[] a2_3 = {0};
        System.out.println("\nTest Case 3:");
        System.out.println("Input: a1 = " + arrayToString(a1_3) + ", a2 = " + arrayToString(a2_3));
        System.out.println("Output: " + longestCommonSum(a1_3, a2_3)); // Expected: 1

        // Static Test Case 4: Single element, unequal
        int[] a1_4 = {1};
        int[] a2_4 = {0};
        System.out.println("\nTest Case 4:");
        System.out.println("Input: a1 = " + arrayToString(a1_4) + ", a2 = " + arrayToString(a2_4));
        System.out.println("Output: " + longestCommonSum(a1_4, a2_4)); // Expected: 0

        // Static Test Case 5: All zeros
        int[] a1_5 = {0, 0, 0};
        int[] a2_5 = {0, 0, 0};
        System.out.println("\nTest Case 5:");
        System.out.println("Input: a1 = " + arrayToString(a1_5) + ", a2 = " + arrayToString(a2_5));
        System.out.println("Output: " + longestCommonSum(a1_5, a2_5)); // Expected: 3
    }

    // Utility method to print array as string
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}