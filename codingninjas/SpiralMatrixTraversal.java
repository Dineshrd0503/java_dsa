package codingninjas;

import java.util.*;
//You are given a 2-D array 'MATRIX' of dimensions N x M, of integers. You need to return the spiral path of the matrix.
//
//Example Of Spiral Path:

public class SpiralMatrixTraversal {

    public static List<Integer> spiralPathMatrix(int[][] matrix, int n, int m) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || n == 0 || m == 0) {
            return result; // Return empty if the matrix is empty
        }

        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        // Traverse while boundaries don't overlap
        while (top <= bottom && left <= right) {

            // Traverse from left to right across the top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;  // Move the top boundary downwards

            // Traverse from top to bottom down the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;  // Move the right boundary leftwards

            if (top <= bottom) {  // Ensure we are within valid boundaries
                // Traverse from right to left across the bottom boundary
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;  // Move the bottom boundary upwards
            }

            if (left <= right) {  // Ensure we are within valid boundaries
                // Traverse from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;  // Move the left boundary rightwards
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralPathMatrix(matrix1, 3, 3));  // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Example 2
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralPathMatrix(matrix2, 3, 4));  // Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
