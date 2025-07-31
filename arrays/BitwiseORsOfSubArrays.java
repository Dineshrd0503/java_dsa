package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Statement:
 * Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.
 *
 * The bitwise OR of a subarray is the bitwise OR of each integer in the subarray.
 * The bitwise OR of a subarray of one integer is that integer.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: arr = [0]
 * Output: 1
 * Explanation: There is only one possible result: 0.
 *
 * Example 2:
 * Input: arr = [1,1,2]
 * Output: 3
 * Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
 * These yield the results 1, 1, 2, 1, 3, 3.
 * There are 3 unique values, so the answer is 3.
 *
 * Example 3:
 * Input: arr = [1,2,4]
 * Output: 6
 * Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
 *
 * Constraints:
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] <= 10^9
 */
public class BitwiseORsOfSubArrays {
    /**
     * Finds the number of distinct bitwise ORs of all subarrays of the given array.
     *
     * @param arr The input integer array.
     * @return The number of distinct bitwise ORs of all subarrays of arr.
     */
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            for (int val : curr) {
                next.add(num | val);
            }
            next.add(num);
            result.addAll(next);
            curr = next;
        }
        return result.size();
    }

    public static void main(String[] args) {
        BitwiseORsOfSubArrays solution = new BitwiseORsOfSubArrays();

        // Test case 1
        int[] arr1 = {0};
        // Expected output: 1
        System.out.println("Test Case 1 Output: " + solution.subarrayBitwiseORs(arr1));  // Output: 1

        // Test case 2
        int[] arr2 = {1, 1, 2};
        // Expected output: 3
        System.out.println("Test Case 2 Output: " + solution.subarrayBitwiseORs(arr2));  // Output: 3

        // Test case 3
        int[] arr3 = {1, 2, 4};
        // Expected output: 6
        System.out.println("Test Case 3 Output: " + solution.subarrayBitwiseORs(arr3));  // Output: 6

        // Test case 4:
        int[] arr4 = {1, 2, 3, 4, 5};
        // Expected output: 12
        System.out.println("Test Case 4 Output: " + solution.subarrayBitwiseORs(arr4));


         // Test case 5
        int[] arr5 = {15};
        // Expected output: 1
        System.out.println("Test Case 5 Output: " + solution.subarrayBitwiseORs(arr5));
    }
}
