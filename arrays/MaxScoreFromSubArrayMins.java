package arrays;
import java.util.*;
public class MaxScoreFromSubArrayMins {

        /**
         * You are given an array arr[] of integers. Your task is to find the maximum sum of the smallest
         * and second smallest elements across all subarrays (of size >= 2) of the given array.
         *
         * Example 1:
         * Input: arr[] = [4, 3, 5, 1]
         * Output: 8
         * Explanation: All subarrays with at least 2 elements and find the two smallest numbers in each:
         * [4, 3] -> 3 + 4 = 7
         * [4, 3, 5] -> 3 + 4 = 7
         * [4, 3, 5, 1] -> 1 + 3 = 4
         * [3, 5] -> 3 + 5 = 8
         * [3, 5, 1] -> 1 + 3 = 4
         * [5, 1] -> 1 + 5 = 6
         * Maximum Score is 8.

         * Example 2:
         * Input: arr[] = [1, 2, 3]
         * Output: 5
         * Explanation: All subarray with at least 2 elements and find the two smallest numbers in each:[1, 2] -> 1 + 2 = 3
         * [1, 2, 3] -> 1 + 2 = 3
         * [2, 3] -> 2 + 3 = 5
         * Maximum Score is 5

         * Constraints:
         * 2 <= arr.size() <= 10^5
         * 1 <= arr[i] <= 10^6
         *
         * Time Complexity: O(n)
         * Auxiliary Space: O(1)
         *
         * @param arr The input array of integers
         * @return The maximum sum of the smallest and second smallest elements across all subarrays
         */
        public static int maxSum(int arr[]) {
            // code here
            if (arr == null || arr.length < 2) {
                return 0; // Handle edge cases: null array or array with fewer than 2 elements
            }

            int max_sum = arr[0] + arr[1]; // Initialize max_sum with the sum of the first two elements

            // Slide the window of size 2 through the array
            for (int i = 1; i < arr.length - 1; i++) {
                int current_sum = arr[i] + arr[i + 1]; // Calculate the sum of the current window
                max_sum = Math.max(max_sum, current_sum); // Update max_sum if the current sum is greater
            }

            return max_sum;
        }


        // Main method for testing / demonstrating the solution (for static input)
        public static void main(String[] args) {
            // Test cases
            int[] arr1 = {4, 3, 5, 1};  // Expected output: 8
            int[] arr2 = {1, 2, 3};  // Expected output: 5
            int[] arr3 = {5, 1, 2};  //Expected output 3
            int[] arr4 = {10, 20, 30, 40}; //Expected Output 50

            System.out.println("Test Case 1: " + maxSum(arr1));
            System.out.println("Test Case 2: " + maxSum(arr2));
            System.out.println("Test Case 3: " + maxSum(arr3));
            System.out.println("Test Case 4: " + maxSum(arr4));


        }
    }
