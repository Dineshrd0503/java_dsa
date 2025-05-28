package arrays;

// Problem Statement: Find rectangle with corners as 1
// Difficulty: Medium
// Given an n x m binary matrix mat[][] containing only 0s and 1s, determine
// if there exists a rectangle within the matrix such that all four corners
// of the rectangle are 1. If such a rectangle exists, return true;
// otherwise, return false.
//
// Example:
// Input: mat[][] =
// [[1, 0, 0, 1, 0],
//  [0, 0, 1, 0, 1],
//  [0, 0, 0, 1, 0],
//  [1, 0, 1, 0, 1]]
// Output: true
// Explanation: Valid corners are at index (1,2), (1,4), (3,2), (3,4)

// Input: mat[][] =
// [[0, 0, 0],
//  [0, 0, 0],
//  [0, 0, 0]]
// Output: false
// Explanation: There are no valid corners.

public class RectangleWithCornersAs1S {

    public static boolean validCorner(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Check every pair of columns
        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = col1 + 1; col2 < m; col2++) {
                int rowCount = 0;
                // Count the number of rows where both columns have '1'
                for (int row = 0; row < n; row++) {
                    if (mat[row][col1] == 1 && mat[row][col2] == 1) {
                        rowCount++;
                    }
                }
                // If we find at least two rows, we can form a rectangle
                if (rowCount >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample Test Cases
        int[][] matrix1 = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(validCorner(matrix1)); // Output: true

        int[][] matrix2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(validCorner(matrix2)); // Output: false
    }
}