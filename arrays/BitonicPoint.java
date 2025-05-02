package arrays;

/*
Problem Statement:
Given an array of integers arr[] that is first strictly increasing and then maybe strictly decreasing,
find the bitonic point, that is the maximum element in the array. The bitonic point is the maximum element
in the array, before which elements are strictly increasing and after which elements are strictly decreasing.

Note: It is guaranteed that the array contains exactly one bitonic point.

Examples:
- Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
  Output: 8
  Explanation: Elements before 8 are strictly increasing [1, 2, 4, 5, 7] and elements after 8 are strictly decreasing [3].
- Input: arr[] = [10, 20, 30, 40, 50]
  Output: 50
  Explanation: Elements before 50 are strictly increasing [10, 20, 30, 40] and there are no elements after 50.
- Input: arr[] = [120, 100, 80, 20, 0]
  Output: 120
  Explanation: There are no elements before 120 and elements after 120 are strictly decreasing [100, 80, 20, 0].

Constraints:
- 3 ≤ arr.length ≤ 10^5
- 1 ≤ arr[i] ≤ 10^6
*/

import java.util.Arrays;

public class BitonicPoint {
    // Method to find the bitonic point (maximum element) using binary search
    public int findMaximum(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Avoid integer overflow

            // Case 1: mid is the first element
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return arr[mid];  // First element is the peak
                } else {
                    low = mid + 1;  // Peak is on the right
                }
            }
            // Case 2: mid is the last element
            else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return arr[mid];  // Last element is the peak
                } else {
                    high = mid - 1;  // Peak is on the left
                }
            }
            // Case 3: mid is in the middle
            else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid];  // Found the bitonic point
                } else if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1;  // Peak is on the right (still increasing)
                } else {
                    high = mid - 1;  // Peak is on the left (already decreasing)
                }
            }
        }

        return arr[low];  // This line is theoretically unreachable due to problem constraints
    }

    // Main method to test the solution with sample test cases
    public static void main(String[] args) {
        BitonicPoint solution = new BitonicPoint();

        // Test Case 1: arr = [1, 2, 4, 5, 7, 8, 3]
        int[] arr1 = {1, 2, 4, 5, 7, 8, 3};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + solution.findMaximum(arr1));
        System.out.println("Expected: 8\n");

        // Test Case 2: arr = [10, 20, 30, 40, 50]
        int[] arr2 = {10, 20, 30, 40, 50};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + solution.findMaximum(arr2));
        System.out.println("Expected: 50\n");

        // Test Case 3: arr = [120, 100, 80, 20, 0]
        int[] arr3 = {120, 100, 80, 20, 0};
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + solution.findMaximum(arr3));
        System.out.println("Expected: 120");
    }
}
