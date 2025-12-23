package binarysearch;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Given a sorted array arr[] (0-indexed based) of distinct integers and an integer k,
 * find the index of k if it is present in the arr[].
 * If not, return the index where k should be inserted to maintain the sorted order.
 *
 * Example 1:
 * Input: arr[] = [1, 3, 5, 6], k = 5
 * Output: 2
 * Explanation: Since 5 is found at index 2 as arr[2] = 5, the output is 2.
 *
 * Example 2:
 * Input: arr[] = [1, 3, 5, 6], k = 2
 * Output: 1
 * Explanation: The element 2 is not present in the array, but inserting it at
 * index 1 will maintain the sorted order.
 *
 * Time Complexity: O(log n) - Binary Search
 * Space Complexity: O(1)
 */

public class SearchInsertPositionOfKInASortedArray {

    // Method to find the search insert position of K in a sorted array
    public int searchInsertK(int arr[], int k) {
        int left = 0, right = arr.length;

        // Binary search to find the insertion position
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Main method with test cases
    public static void main(String[] args) {
        SearchInsertPositionOfKInASortedArray solution = new SearchInsertPositionOfKInASortedArray();


        // Test Case 1: Element present in array
        int[] arr1 = {1, 3, 5, 6};
        int k1 = 5;
        int result1 = solution.searchInsertK(arr1, k1);
        System.out.println("Test Case 1:");
        System.out.println("Array: " + java.util.Arrays.toString(arr1));
        System.out.println("k = " + k1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");
        System.out.println();

        // Test Case 2: Element not present, insert in middle
        int[] arr2 = {1, 3, 5, 6};
        int k2 = 2;
        int result2 = solution.searchInsertK(arr2, k2);
        System.out.println("Test Case 2:");
        System.out.println("Array: " + java.util.Arrays.toString(arr2));
        System.out.println("k = " + k2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println();

        // Test Case 3: Element to be inserted at the end
        int[] arr3 = {1, 3, 5, 6};
        int k3 = 7;
        int result3 = solution.searchInsertK(arr3, k3);
        System.out.println("Test Case 3:");
        System.out.println("Array: " + java.util.Arrays.toString(arr3));
        System.out.println("k = " + k3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 4");
        System.out.println();

        // Test Case 4: Element to be inserted at the beginning
        int[] arr4 = {1, 3, 5, 6};
        int k4 = 0;
        int result4 = solution.searchInsertK(arr4, k4);
        System.out.println("Test Case 4:");
        System.out.println("Array: " + java.util.Arrays.toString(arr4));
        System.out.println("k = " + k4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: 0");
        System.out.println();

        // Test Case 5: Single element array
        int[] arr5 = {1};
        int k5 = 1;
        int result5 = solution.searchInsertK(arr5, k5);
        System.out.println("Test Case 5:");
        System.out.println("Array: " + java.util.Arrays.toString(arr5));
        System.out.println("k = " + k5);
        System.out.println("Output: " + result5);
        System.out.println("Expected: 0");
    }
}
