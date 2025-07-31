/**
 * Problem Statement:
 * Given an array of integers `arr`, return `true` if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *   - `arr.length >= 3`
 *   - There exists some `i` with `0 < i < arr.length - 1` such that:
 *      - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
 *      - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`
 *
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 * Constraints:
 *   - `1 <= arr.length <= 10^4`
 *   - `0 <= arr[i] <= 10^4`
 */
public class ValidMountainSubArray {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;

        // Mountain arrays must have at least 3 elements
        if (n < 3) {
            return false;
        }

        int i = 0;

        // Traverse upward slope
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be the first or the last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Traverse downward slope
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        // If we reached the end of the array, it's a valid mountain
        return i == n - 1;
    }

    public static void main(String[] args) {
        // Static inputs
        int[] arr1 = {2, 1};
        int[] arr2 = {3, 5, 5};
        int[] arr3 = {0, 3, 2, 1};
        int[] arr4 = {0, 2, 3, 4, 5, 2, 1, 0};
        int[] arr5 = {0, 1, 2, 3, 2, 1, 0};
        int[] arr6 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arr7 = {1,2,3};

        // Test cases
        System.out.println("Input: [2, 1], Output: " + validMountainArray(arr1)); // Expected: false
        System.out.println("Input: [3, 5, 5], Output: " + validMountainArray(arr2)); // Expected: false
        System.out.println("Input: [0, 3, 2, 1], Output: " + validMountainArray(arr3)); // Expected: true
        System.out.println("Input: [0, 2, 3, 4, 5, 2, 1, 0], Output: " + validMountainArray(arr4)); // Expected: true
        System.out.println("Input: [0, 1, 2, 3, 2, 1, 0], Output: " + validMountainArray(arr5)); // Expected: true
        System.out.println("Input: [9, 8, 7, 6, 5, 4, 3, 2, 1, 0], Output: " + validMountainArray(arr6)); // Expected: false
        System.out.println("Input: [1,2,3], Output: " + validMountainArray(arr7)); // Expected: false
      
    }
}
