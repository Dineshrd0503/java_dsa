package twopointer;
import java.util.Arrays;
public class ThreeSumGFG {
    /**
     * Problem Statement:
     * Given an integer array arr and a target sum, determine if there exists a triplet
     * [arr[i], arr[j], arr[k]] such that i != j, i != k, j != k, and
     * arr[i] + arr[j] + arr[k] == target. Return true if such a triplet exists, false otherwise.
     *
     * Constraints:
     * - 3 <= arr.length <= 3000
     * - -10^5 <= arr[i] <= 10^5
     *
     * Examples:
     * Example 1:
     * Input: arr = [-1, 0, 1, 2, -1, -4], target = 0
     * Output: true
     * Explanation: Triplets [-1, -1, 2] and [-1, 0, 1] sum to 0.
     *
     * Example 2:
     * Input: arr = [1, 2, 3], target = 12
     * Output: false
     * Explanation: No triplet sums to 12.
     *
     * Example 3:
     * Input: arr = [0, 0, 0], target = 0
     * Output: true
     * Explanation: Triplet [0, 0, 0] sums to 0.
     */



        public static boolean hasTripletSum(int arr[], int target) {
            // Handle edge case: array length < 3
            if (arr.length < 3) {
                return false;
            }

            // Sort the array to enable two-pointer technique and handle duplicates
            Arrays.sort(arr);
            int n = arr.length;

            // Iterate over first element
            for (int i = 0; i < n - 2; i++) {
                // Skip duplicates for first element
                if (i > 0 && arr[i] == arr[i - 1]) {
                    continue;
                }

                // Two pointers for remaining elements
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int sum = arr[i] + arr[left] + arr[right];
                    if (sum == target) {
                        return true; // Found a triplet, return immediately
                    } else if (sum < target) {
                        left++; // Need larger sum, move left pointer
                    } else {
                        right--; // Need smaller sum, move right pointer
                    }
                    // Skip duplicates for left and right pointers
                    while (left < right && left > i + 1 && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && right < n - 1 && arr[right] == arr[right + 1]) {
                        right--;
                    }
                }
            }

            return false; // No triplet found
        }

        // Main method to test the solution
        public static void main(String[] args) {
            // Test Case 1
            int[] arr1 = {-1, 0, 1, 2, -1, -4};
            int target1 = 0;
            System.out.println("Test Case 1:");
            System.out.print("Input: arr = [");
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + (i < arr1.length - 1 ? ", " : ""));
            }
            System.out.println("], target = " + target1);
            System.out.println("Output: " + hasTripletSum(arr1, target1));
            System.out.println("Expected: true");
            System.out.println();

            // Test Case 2
            int[] arr2 = {1, 2, 3};
            int target2 = 12;
            System.out.println("Test Case 2:");
            System.out.print("Input: arr = [");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + (i < arr2.length - 1 ? ", " : ""));
            }
            System.out.println("], target = " + target2);
            System.out.println("Output: " + hasTripletSum(arr2, target2));
            System.out.println("Expected: false");
            System.out.println();

            // Test Case 3
            int[] arr3 = {0, 0, 0};
            int target3 = 0;
            System.out.println("Test Case 3:");
            System.out.print("Input: arr = [");
            for (int i = 0; i < arr3.length; i++) {
                System.out.print(arr3[i] + (i < arr3.length - 1 ? ", " : ""));
            }
            System.out.println("], target = " + target3);
            System.out.println("Output: " + hasTripletSum(arr3, target3));
            System.out.println("Expected: true");
        }
    }
