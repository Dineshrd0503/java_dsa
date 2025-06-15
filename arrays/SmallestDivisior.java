package arrays;

public class SmallestDivisior {


    /*
     * Problem Statement:
     * Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer divisor
     * such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to k.
     * The ceiling value ceil(a/d) is the smallest integer ≥ a/d.
     *
     * Constraints:
     * - 1 ≤ arr.length ≤ 10^5
     * - 1 ≤ arr[i] ≤ 10^6
     * - arr.length ≤ k ≤ 10^6
     *
     * Examples:
     * Example 1:
     * Input: arr = [1, 2, 5, 9], k = 6
     * Output: 5
     * Explanation: For d = 5, ceil(1/5) = 1, ceil(2/5) = 1, ceil(5/5) = 1, ceil(9/5) = 2. Sum = 1 + 1 + 1 + 2 = 5 ≤ 6.
     *              For d = 4, sum = 1 + 1 + 2 + 3 = 7 > 6. Thus, 5 is the smallest divisor.
     *
     * Example 2:
     * Input: arr = [1, 1, 1, 1], k = 4
     * Output: 1
     * Explanation: For d = 1, ceil(1/1) = 1 for all elements. Sum = 1 + 1 + 1 + 1 = 4 ≤ 4. Smallest possible divisor is 1.
     */

    /*
         * Finds the smallest positive integer divisor d such that the sum of ceil(arr[i] / d) is ≤ k.
         * Uses binary search to find d efficiently.
         *
         * @param arr The input array of integers
         * @param k The threshold for the sum of ceiling values
         * @return The smallest divisor d
         */
        public static int smallestDivisor(int[] arr, int k) {
            // Find the maximum element to set the upper bound for binary search
            int max = 0;
            for (int a : arr) {
                max = Math.max(max, a);
            }

            // Binary search for the smallest divisor
            int left = 1; // Minimum possible divisor
            int right = max; // Maximum needed divisor (beyond max, all ceilings are 1)
            int ans = max; // Initialize answer with maximum possible divisor

            while (left <= right) {
                int mid = left + (right - left) / 2; // Avoid overflow
                if (getCeilingSum(arr, mid) <= k) {
                    ans = mid; // Found a valid divisor, try smaller
                    right = mid - 1;
                } else {
                    left = mid + 1; // Sum too large, need larger divisor
                }
            }
            return ans;
        }

        /*
         * Computes the sum of ceil(arr[i] / d) for all elements in arr.
         * Uses Math.ceil for clarity, with double division to ensure precision.
         *
         * @param arr The input array
         * @param d The divisor
         * @return The sum of ceiling values
         */
        private static long getCeilingSum(int[] arr, int d) {
            long sum = 0;
            for (int a : arr) {
                sum += (long) Math.ceil((double) a / d);
            }
            return sum;
        }

        /*
         * Main method to test the smallestDivisor function with static inputs.
         * Includes sample test cases and an edge case for validation.
         */
        public static void main(String[] args) {
            // Test Case 1: Example 1 from problem statement
            int[] arr1 = {1, 2, 5, 9};
            int k1 = 6;
            System.out.println("Test Case 1: arr = [1, 2, 5, 9], k = 6");
            System.out.println("Output: " + smallestDivisor(arr1, k1)); // Expected: 5

            // Test Case 2: Example 2 from problem statement
            int[] arr2 = {1, 1, 1, 1};
            int k2 = 4;
            System.out.println("\nTest Case 2: arr = [1, 1, 1, 1], k = 4");
            System.out.println("Output: " + smallestDivisor(arr2, k2)); // Expected: 1

            // Test Case 3: Edge case with large values
            int[] arr3 = {1000000};
            int k3 = 1000000;
            System.out.println("\nTest Case 3: arr = [1000000], k = 1000000");
            System.out.println("Output: " + smallestDivisor(arr3, k3)); // Expected: 1000000
        }
    }

