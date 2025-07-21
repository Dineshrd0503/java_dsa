package arrays;

import java.util.Arrays;

public class MinimizeDifferenceInArray {

    /**
     * ✅ Problem: Minimize the Maximum Difference Between Heights
     *
     * Given an array of integers `a[]` representing the height of N towers, and a value `k`,
     * modify each element by either increasing or decreasing it by `k` (only once).
     *
     * The task is to return the minimum possible difference between the maximum
     * and minimum heights after performing the modification.
     *
     * Constraints:
     * - Each tower can be increased or decreased by `k` once.
     * - The final height must be non-negative after modification.
     * - The solution must handle edge cases like small arrays or repeated values.
     *
     * 🔧 Example:
     * Input: a[] = {1, 5, 8, 10}, k = 2
     * Output: 5
     * Explanation: Modified array = {3, 3, 6, 8} or similar
     *              Max difference = 8 - 3 = 5
     *
     * Input: a[] = {1, 2, 3, 4, 5}, k = 2
     * Output: 3
     *
     * Input: a[] = {8}, k = 2
     * Output: 0
     */

    public static int minimizeIt(int[] a, int k) {
        Arrays.sort(a); // Sort the array
        int n = a.length;

        if (n == 1) return 0; // One element: no difference

        int ans = a[n - 1] - a[0]; // Initial max difference
        int smallest = a[0] + k;
        int largest = a[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            int minval = Math.min(smallest, a[i + 1] - k);
            int maxval = Math.max(largest, a[i] + k);

            if (minval < 0) continue; // Ensure no negative heights

            int diff = maxval - minval;
            ans = Math.min(ans, diff);
        }

        return ans;
    }

    public static void main(String[] args) {
        // ✅ Test Case 1
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;
        System.out.println("Output 1: " + minimizeIt(arr1, k1)); // Expected: 5

        // ✅ Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Output 2: " + minimizeIt(arr2, k2)); // Expected: 3

        // ✅ Test Case 3
        int[] arr3 = {8};
        int k3 = 2;
        System.out.println("Output 3: " + minimizeIt(arr3, k3)); // Expected: 0

        // ✅ Test Case 4
        int[] arr4 = {1, 3, 3};
        int k4 = 2;
        System.out.println("Output 4: " + minimizeIt(arr4, k4)); // Expected: 2

        // ✅ Test Case 5 (Complex)
        int[] arr5 = {7, 4, 8, 8, 8, 9};
        int k5 = 6;
        System.out.println("Output 5: " + minimizeIt(arr5, k5)); // Expected: 5
    }
}
