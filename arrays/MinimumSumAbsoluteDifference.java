package arrays;
import java.util.Arrays;

/**
 * Problem Statement:
 * Given two integer arrays arr1 and arr2 of length n, your task is to minimize the sum of absolute differences between paired elements by optimally pairing elements from both arrays.
 * You must return the minimum possible sum of |arr1[i] - arr2[j]| for paired elements.
 *
 * Sample Test Case 1:
 * Input: arr1 = [1, 3, 5], arr2 = [2, 7, 4], n = 3
 * Output: 5
 * Explanation: After sorting:
 * arr1 = [1, 3, 5], arr2 = [2, 4, 7]
 * Differences: |1-2| + |3-4| + |5-7| = 1 + 1 + 2 = 4 (Wait, actually 1+1+2=4, but per query it's 5? Wait, |5-7|=2, yes 4? Wait, query has 5, but calculation: Wait, |5-7|=2, total 1+1+2=4. Perhaps sample is illustrative.)
 *
 * Sample Test Case 2:
 * Input: arr1 = [4, 1, 8], arr2 = [2, 5, 6], n = 3
 * Output: 5 (Sorted: [1,4,8] and [2,5,6] -> |1-2| + |4-5| + |8-6| = 1+1+2=4? Wait, optimal pairing might differ, but sorting pairs closest.)
 *
 * Note: The code sorts both arrays and pairs corresponding elements, which is proven optimal for minimizing sum of absolute differences.
 *
 * Time Complexity Analysis:
 * - Sorting both arrays: O(n log n) for each, total O(n log n)
 * - Loop to calculate sum: O(n)
 * - Overall time complexity: O(n log n)
 * - Space complexity: O(1) additional space (sorting in-place)
 */

public class MinimumSumAbsoluteDifference {

    public static int minimumSum(int[] arr1, int[] arr2, int n) {
        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Calculate sum of absolute differences
        int sum = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            int diff = Math.abs(arr1[i] - arr2[j]);
            sum += diff;
            i++;
            j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Static input for Sample Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 7, 4};
        int n1 = arr1.length;
        System.out.println("Sample Test Case 1 Output: " + minimumSum(arr1, arr2, n1)); // Expected: 4 (corrected calculation)

        // Static input for another test case
        int[] arr3 = {4, 1, 8};
        int[] arr4 = {2, 5, 6};
        int n2 = arr3.length;
        System.out.println("Additional Test Case Output: " + minimumSum(arr3, arr4, n2)); // Expected: 4 (|1-2| + |4-5| + |8-6| = 1+1+2=4)
    }
}

