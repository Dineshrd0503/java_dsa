package arrays;

import java.util.*;
import java.io.*;

public class RotateMatrixClockwise {

    /**
     * You are given a square matrix of dimensions ‘N \* N’. You have to rotate the
     * matrix 90 degrees in a clockwise direction.
     *
     * **EXAMPLE:**
     *
     * Input: 'N' = 2, 'NUMS' = [[1, 2], [3, 4]]
     *
     * Output: [[3, 1], [4, 2]]
     *
     * Here the given matrix is rotated 90 degrees in a clockwise direction.
     */
    static void rotateClockwise(int n, int[][] nums) {
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = nums[i][left];
                nums[i][left] = nums[i][right];
                nums[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        // Example Usage with static inputs
        int n1 = 2;
        int[][] matrix1 = {{1, 2}, {3, 4}};
        System.out.println("Original matrix1:");
        printMatrix(matrix1);
        rotateClockwise(n1, matrix1);
        System.out.println("Rotated matrix1:");
        printMatrix(matrix1);

        int n2 = 3;
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original matrix2:");
        printMatrix(matrix2);
        rotateClockwise(n2, matrix2);
        System.out.println("Rotated matrix2:");
        printMatrix(matrix2);

        int n3 = 3;
        int[][] matrix3 = {{5, 10, 4}, {10, 6, 2}, {10, 3, 3}};
        System.out.println("Original matrix3:");
        printMatrix(matrix3);
        rotateClockwise(n3, matrix3);
        System.out.println("Rotated matrix3:");
        printMatrix(matrix3);

        int n4 = 3;
        int[][] matrix4 = {{3, 8, 2}, {10, 3, 9}, {6, 3, 2}};
        System.out.println("Original matrix4:");
        printMatrix(matrix4);
        rotateClockwise(n4, matrix4);
        System.out.println("Rotated matrix4:");
        printMatrix(matrix4);
    }

    // Helper function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}