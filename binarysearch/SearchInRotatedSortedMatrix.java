package binarysearch;

public class SearchInRotatedSortedMatrix {

    /*
     * ====================================================================
     * Problem Statement: Search in a Rotated Sorted Matrix
     * ====================================================================
     *
     * You are given a 2D matrix mat[][] of size n x m that was initially
     * filled in the following manner:
     * 1. Each row is sorted in increasing order from left to right.
     * 2. The first element of every row is greater than the last element
     * of the previous row.
     *
     * This implies that if the matrix is flattened row-wise, it forms a
     * strictly sorted 1D array. Later, this sorted 1D array was rotated
     * at some unknown pivot. The rotated array was then written back into
     * the matrix row-wise to form the current matrix.
     *
     * Given such a matrix mat[][] and an integer x, determine whether x
     * exists in the matrix.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: x = 3,
     * mat[][] = [[7, 8, 9, 10],
     * [11, 12, 13, 1],
     * [2, 3, 4, 5]]
     * Output: true
     * Explanation: 3 is located at the 3rd row and 2nd column.
     *
     * Example 2:
     * Input: x = 10,
     * mat[][] = [[6, 7, 8],
     * [9, 1, 2],
     * [3, 4, 5]]
     * Output: false
     * Explanation: The value 10 does not exist in the matrix.
     */

    /**
     * Searches for a value in a row-wise flattened and rotated sorted matrix.
     *
     * @param mat The input 2D matrix.
     * @param x   The integer to search for.
     * @return true if x is found, false otherwise.
     */
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        if (n == 0 || mat[0].length == 0) {
            return false;
        }
        int m = mat[0].length;

        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D mid-index to 2D coordinates to get the value
            int midValue = mat[mid / m][mid % m];

            if (midValue == x) {
                return true; // Found the element
            }

            // Check if the left half (from low to mid) is sorted
            if (mat[low / m][low % m] <= midValue) {
                // If x is within the sorted left half's range
                if (x >= mat[low / m][low % m] && x < midValue) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // If x is within the sorted right half's range
                if (x > midValue && x <= mat[high / m][high % m]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        // If the loop finishes, the element was not found
        return false;
    }

    // Main method to test the searchMatrix function with static inputs.
    public static void main(String[] args) {
        SearchInRotatedSortedMatrix solution = new SearchInRotatedSortedMatrix();



        // Test Case 1
        int[][] mat1 = {
                {7, 8, 9, 10},
                {11, 12, 13, 1},
                {2, 3, 4, 5}
        };
        int x1 = 3;
        System.out.println("Searching for " + x1 + " in matrix 1...");
        System.out.println("Result: " + solution.searchMatrix(mat1, x1)); // Expected: true
        System.out.println("--------------------");

        // Test Case 2
        int[][] mat2 = {
                {6, 7, 8},
                {9, 1, 2},
                {3, 4, 5}
        };
        int x2 = 10;
        System.out.println("Searching for " + x2 + " in matrix 2...");
        System.out.println("Result: " + solution.searchMatrix(mat2, x2)); // Expected: false
        System.out.println("--------------------");

        // Additional Test Case
        int x3 = 13;
        System.out.println("Searching for " + x3 + " in matrix 1...");
        System.out.println("Result: " + solution.searchMatrix(mat1, x3)); // Expected: true
        System.out.println("--------------------");
    }
}
