package arrays;

/*
 * ============================================================================
 * PROBLEM STATEMENT: Left Rotate an Array by One
 * ============================================================================
 *
 * Given an array 'arr' containing 'n' elements, rotate this array left once
 * and return it.
 *
 * Rotating the array left by one means shifting all elements by one place to
 * the left and moving the first element to the last position in the array.
 *
 * Example:
 * Input: n = 5, arr = [1, 2, 3, 4, 5]
 * Output: [2, 3, 4, 5, 1]
 *
 * Explanation: We moved the 2nd element to the 1st position, and 3rd element
 * to the 2nd position, and 4th element to the 3rd position, and 5th element
 * to the 4th position, and move the 1st element to the 5th position.
 *
 * Constraints:
 * - 1 <= n <= 10^5
 * - -10^9 <= arr[i] <= 10^9
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) - new array created
 * ============================================================================
 */

import java.util.Arrays;

public class LeftRotateArrayByOne {

    /**
     * Method to rotate array left by one position
     * @param arr - input array
     * @param n - size of array
     * @return rotated array
     */
    static int[] rotateArray(int[] arr, int n) {
        // Edge case: single element or empty array
        if (n <= 1) return arr;

        // Store the first element
        int first = arr[0];

        // Shift all elements to the left by one position
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the last position
        arr[n - 1] = first;

        return arr;
    }

    /**
     * Main method with comprehensive test cases
     */
    public static void main(String[] args) {
        System.out.println("========== LEFT ROTATE ARRAY BY ONE ==========");
        System.out.println();

        // Test Case 1: Standard case
        System.out.println("Test Case 1: Standard case with 5 elements");
        int[] arr1 = {1, 2, 3, 4, 5};
        int n1 = arr1.length;
        System.out.println("Input: n = " + n1 + ", arr = " + Arrays.toString(arr1));
        int[] result1 = rotateArray(arr1, n1);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [2, 3, 4, 5, 1]");
        System.out.println("Status: " + (Arrays.equals(result1, new int[]{2, 3, 4, 5, 1}) ? "✅ PASS" : "❌ FAIL"));
        System.out.println();

        // Test Case 2: Single element array
        System.out.println("Test Case 2: Single element array");
        int[] arr2 = {5};
        int n2 = arr2.length;
        System.out.println("Input: n = " + n2 + ", arr = " + Arrays.toString(arr2));
        int[] result2 = rotateArray(arr2, n2);
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [5]");
        System.out.println("Status: " + (Arrays.equals(result2, new int[]{5}) ? "✅ PASS" : "❌ FAIL"));
        System.out.println();

        // Test Case 3: Two elements
        System.out.println("Test Case 3: Two element array");
        int[] arr3 = {1, 2};
        int n3 = arr3.length;
        System.out.println("Input: n = " + n3 + ", arr = " + Arrays.toString(arr3));
        int[] result3 = rotateArray(arr3, n3);
        System.out.println("Output: " + Arrays.toString(result3));
        System.out.println("Expected: [2, 1]");
        System.out.println("Status: " + (Arrays.equals(result3, new int[]{2, 1}) ? "✅ PASS" : "❌ FAIL"));
        System.out.println();

        // Test Case 4: Negative numbers
        System.out.println("Test Case 4: Array with negative numbers");
        int[] arr4 = {-1, -100, 3, 99, 87, 8, -97, 38, 28};
        int n4 = arr4.length;
        System.out.println("Input: n = " + n4 + ", arr = " + Arrays.toString(arr4));
        int[] result4 = rotateArray(arr4, n4);
        System.out.println("Output: " + Arrays.toString(result4));
        System.out.println("Expected: [-100, 3, 99, 87, 8, -97, 38, 28, -1]");
        System.out.println("Status: " + (Arrays.equals(result4, new int[]{-100, 3, 99, 87, 8, -97, 38, 28, -1}) ? "✅ PASS" : "❌ FAIL"));
        System.out.println();

        // Test Case 5: Large array with zeros
        System.out.println("Test Case 5: Array with zeros");
        int[] arr5 = {0, 1, 2, 0, 3, 0, 0, 4};
        int n5 = arr5.length;
        System.out.println("Input: n = " + n5 + ", arr = " + Arrays.toString(arr5));
        int[] result5 = rotateArray(arr5, n5);
        System.out.println("Output: " + Arrays.toString(result5));
        System.out.println("Expected: [1, 2, 0, 3, 0, 0, 4, 0]");
        System.out.println("Status: " + (Arrays.equals(result5, new int[]{1, 2, 0, 3, 0, 0, 4, 0}) ? "✅ PASS" : "❌ FAIL"));
        System.out.println();

        // Test Case 6: All same elements
        System.out.println("Test Case 6: Array with all same elements");
        int[] arr6 = {5, 5, 5, 5, 5};
        int n6 = arr6.length;
        System.out.println("Input: n = " + n6 + ", arr = " + Arrays.toString(arr6));
        int[] result6 = rotateArray(arr6, n6);
        System.out.println("Output: " + Arrays.toString(result6));
        System.out.println("Expected: [5, 5, 5, 5, 5]");
        System.out.println("Status: " + (Arrays.equals(result6, new int[]{5, 5, 5, 5, 5}) ? "✅ PASS" : "❌ FAIL"));
        System.out.println();

        
    }
}
