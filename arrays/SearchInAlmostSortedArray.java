package arrays;

// Problem Statement:
// Given a sorted integer array arr[] consisting of distinct elements,
// where some elements of the array are moved to either of the adjacent
// positions, i.e. arr[i] may be present at arr[i-1] or arr[i+1].
// Given an integer target. You have to return the index (0-based) of
// the target in the array. If target is not present return -1.

// Examples:
// Input: arr[] = [10, 3, 40, 20, 50, 80, 70], target = 40
// Output: 2
// Explanation: Index of 40 in the given array is 2.
//
// Input: arr[] = [10, 3, 40, 20, 50, 80, 70], target = 90
// Output: -1
// Explanation: 90 is not present in the array.
//
// Input: arr[] = [-20], target = -20
// Output: 0
// Explanation: -20 is the only element present in the array.

public class SearchInAlmostSortedArray {

    public static int findTarget(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid or its neighbors are the target.
            if (arr[mid] == target) {
                return mid;
            }
            if (mid - 1 >= left && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (mid + 1 <= right && arr[mid + 1] == target) {
                return mid + 1;
            }

            // Modify binary search condition
            if (arr[mid] > target) {
                right = mid - 2; // Skip the checked mid-1 position
            } else {
                left = mid + 2; // Skip the checked mid+1 position
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Sample test cases
        int[] arr1 = {10, 3, 40, 20, 50, 80, 70};
        int target1 = 40;
        System.out.println("Index of " + target1 + ": " + findTarget(arr1, target1)); // Output: 2

        int[] arr2 = {10, 3, 40, 20, 50, 80, 70};
        int target2 = 90;
        System.out.println("Index of " + target2 + ": " + findTarget(arr2, target2)); // Output: -1

        int[] arr3 = {-20};
        int target3 = -20;
        System.out.println("Index of " + target3 + ": " + findTarget(arr3, target3)); // Output: 0
    }
}
