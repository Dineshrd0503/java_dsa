package slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Problem Statement:
 * Given an array/list ARR of integers and an integer LIMIT, return the length of the longest subarray
 * where the absolute difference between the maximum and minimum element is less than or equal to LIMIT.
 *
 * Constraints:
 * - 1 <= T <= 50 (number of test cases)
 * - 1 <= N <= 10^4 (array length)
 * - 0 <= ARR[i] <= 10^5 (array elements)
 * - 0 <= LIMIT <= 10^5
 * Time Limit: 1 sec
 *
 * Examples:
 * Input: T = 2
 *        ARR = [3, 6, 5, 4, 1], LIMIT = 2
 *        ARR = [7, 2, 5, 4], LIMIT = 1
 * Output: 3
 *         2
 * Explanation:
 * - For [3, 6, 5, 4, 1], LIMIT = 2: Subarray [6, 5, 4] has max=6, min=4, |6-4|=2 <= 2, length=3.
 * - For [7, 2, 5, 4], LIMIT = 1: Subarray [5, 4] has max=5, min=4, |5-4|=1 <= 1, length=2.
 */
public class LongestContiguousSubarrayWithAbsoluteDiffBoundedByALimit {
    /*
     * Finds the length of the longest subarray where |max - min| <= LIMIT.
     * Uses sliding window with two deques to track max and min elements.
     * @param arr Input array
     * @param limit Maximum allowed difference
     * @return Length of the longest valid subarray
     */
    public static int getMaximumOfSubarrays(ArrayList<Integer> arr, int limit) {
        int n = arr.size();
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int maxLength = 0;
        int i = 0; // Left end of window

        for (int j = 0; j < n; j++) {
            // Maintain maxDeque (monotonic decreasing)
            while (!maxDeque.isEmpty() && arr.get(maxDeque.peekLast()) <= arr.get(j)) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            // Maintain minDeque (monotonic increasing)
            while (!minDeque.isEmpty() && arr.get(minDeque.peekLast()) >= arr.get(j)) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);

            // Remove elements outside the window
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    arr.get(maxDeque.peekFirst()) - arr.get(minDeque.peekFirst()) > limit) {
                if (maxDeque.peekFirst() < minDeque.peekFirst()) {
                    i = maxDeque.pollFirst() + 1;
                } else {
                    i = minDeque.pollFirst() + 1;
                }
            }

            // Update maxLength
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

    /*
     * Main method to handle multiple test cases.
     */
    public static void main(String[] args) {
        int[][] testArrays = {
                {3, 6, 5, 4, 1},
                {7, 2, 5, 4}
        };
        int[] limits = {2, 1};

        for (int t = 0; t < testArrays.length; t++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int num : testArrays[t]) arr.add(num);
            int limit = limits[t];
            int result = getMaximumOfSubarrays(arr, limit);
            System.out.println(result);
        }
    }
}