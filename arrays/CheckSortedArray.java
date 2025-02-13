package arrays;
//Problem statement
//You have been given an array ‘a’ of ‘n’ non-negative integers.You have to check whether the given array is sorted in the non-decreasing order or not.
//
//
//
//Your task is to return 1 if the given array is sorted. Else, return 0.
//
//
//
//Example :
//Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
//Output: 1
//
//The given array is sorted in non-decreasing order; hence the answer will be 1.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        4
//        0 0 0 1
//Sample Output 1 :
//        1
//Explanation For Sample Input 1 :
//The given array is sorted in non-decreasing order; hence the answer will be 1.
//Sample Input 2 :
//        5
//        4 5 4 4 4
//Sample Output 2 :
//        0
//Expected Time Complexity:
//O(n), Where ‘n’ is the size of an input array ‘a’.
//Constraints:
//        1 ≤ 'n' ≤ 5*10^6
//        0 ≤ 'a'[i] ≤ 10^9
//
//Time limit: 1 sec


public class CheckSortedArray {

    // Method to check if the array is sorted
    public static int isSorted(int n, int[] a) {
        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // Check if the current element is smaller than the previous one
            if (a[i - 1] > a[i]) {
                // If any element is smaller than the previous one, return 0 (not sorted)
                return 0;
            }
        }
        // If no issue found, return 1 (sorted)
        return 1;
    }

    // Main method to test the isSorted function
    public static void main(String[] args) {
        // Test case 1: Sorted array
        int[] arr1 = {1, 2, 3, 4};
        System.out.println("Test case 1: " + (isSorted(arr1.length, arr1) == 1 ? "Sorted" : "Not Sorted"));

        // Test case 2: Array with duplicates, still sorted
        int[] arr2 = {1, 2, 2, 3};
        System.out.println("Test case 2: " + (isSorted(arr2.length, arr2) == 1 ? "Sorted" : "Not Sorted"));

        // Test case 3: Unsorted array
        int[] arr3 = {4, 3, 2, 1};
        System.out.println("Test case 3: " + (isSorted(arr3.length, arr3) == 1 ? "Sorted" : "Not Sorted"));

        // Test case 4: Unsorted array with random values
        int[] arr4 = {1, 3, 2, 4};
        System.out.println("Test case 4: " + (isSorted(arr4.length, arr4) == 1 ? "Sorted" : "Not Sorted"));
        
        // Test case 5: Single element array (always sorted)
        int[] arr5 = {5};
        System.out.println("Test case 5: " + (isSorted(arr5.length, arr5) == 1 ? "Sorted" : "Not Sorted"));
    }
}
