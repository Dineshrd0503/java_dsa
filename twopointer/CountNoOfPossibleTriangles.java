package twopointer;

import java.util.Arrays;

public class CountNoOfPossibleTriangles {

    /*
     * ====================================================================
     * Problem Statement: Count Number of Possible Triangles
     * ====================================================================
     *
     * Given an integer array arr[]. Find the number of triangles that can be
     * formed with three different array elements as lengths of three sides.
     *
     * A triangle is possible if the sum of the lengths of any two sides is
     * always greater than the third side.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: arr[] = [4, 6, 3, 7]
     * Output: 3
     * Explanation: Triangles are [3, 4, 6], [4, 6, 7], and [3, 6, 7].
     *
     * Example 2:
     * Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
     * Output: 6
     */

    /**
     * Counts the number of possible triangles that can be formed from array elements.
     *
     * @param arr The input array of side lengths.
     * @return The total count of possible triangles.
     */
    public int countTriangles(int arr[]) {
        int n = arr.length;
        if (n < 3) {
            return 0;
        }

        // Step 1: Sort the array. This is key to the O(n^2) approach.
        Arrays.sort(arr);

        int count = 0;

        // Step 2: Fix the largest side 'c' (arr[i]) and find pairs (a, b) to its left.
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                // Check if the two smaller sides can form a triangle with the largest side.
                if (arr[left] + arr[right] > arr[i]) {
                    // If arr[left] and arr[right] can form a triangle, then any element
                    // between left and right paired with arr[right] can also form a triangle.
                    // There are (right - left) such pairs.
                    count += (right - left);

                    // Try with a smaller second side.
                    right--;
                } else {
                    // The sum is too small, so we need a larger first side.
                    left++;
                }
            }
        }
        return count;
    }

    // Main method to test the function with a static input.
    public static void main(String[] args) {
        CountNoOfPossibleTriangles sol = new CountNoOfPossibleTriangles();


        // Test Case 1
        int[] arr1 = {4, 6, 3, 7};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Number of triangles: " + sol.countTriangles(arr1)); // Expected: 3
        System.out.println("--------------------");

        // Test Case 2
        int[] arr2 = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Number of triangles: " + sol.countTriangles(arr2)); // Expected: 6
        System.out.println("--------------------");
    }
}
