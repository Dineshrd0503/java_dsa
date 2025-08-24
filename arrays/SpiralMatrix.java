package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
     * ====================================================================
     * Problem Statement: Spiral Matrix Traversal
     * ====================================================================
     *
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * The traversal should start from the top-left corner and move to the
     * right, then down, then left, and then up, continuing in a spiral
     * pattern inwards.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: matrix = [[1, 2, 3],
     * [4, 5, 6],
     * [7, 8, 9]]
     * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
     *
     * Example 2:
     * Input: matrix = [[1, 2,  3,  4],
     * [5, 6,  7,  8],
     * [9, 10, 11, 12]]
     * Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
     */

    /**
     * Traverses a 2D matrix in spiral order.
     * The approach uses four pointers (top, bottom, left, right) to define the
     * boundaries of the current layer of the matrix being traversed. The pointers
     * are moved inward after each direction is fully traversed.
     *
     * @param matrix The input m x n matrix.
     * @return A list of integers representing the spiral order of elements.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (from left to right along the top row)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // 2. Traverse Down (from top to bottom along the right column)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Check if there's still a valid row to traverse
            if (top <= bottom) {
                // 3. Traverse Left (from right to left along the bottom row)
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Check if there's still a valid column to traverse
            if (left <= right) {
                // 4. Traverse Up (from bottom to top along the left column)
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return result;
    }

    // Main method to test the spiralOrder function with a static input.
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println("Input Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        List<Integer> spiralResult = sm.spiralOrder(matrix);
        System.out.println("\nSpiral Order Traversal:");
        System.out.println(spiralResult); // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
