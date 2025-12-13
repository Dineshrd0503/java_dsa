package arrays;

/*
 * PROBLEM STATEMENT (GFG - Swap Diagonals):
 *
 * Given a square matrix mat[][], the task is to swap the elements of the
 * major and minor diagonals.
 *
 * Major Diagonal: Elements that lie from the top-left corner to the
 * bottom-right corner of the matrix (where row index equals column index).
 *
 * Minor Diagonal: Elements that lie from the top-right corner to the
 * bottom-left corner (where the sum of row and column indices equals n - 1).
 *
 * Example:
 * Input:  mat[][] = [[0, 1, 2],
 *                     [3, 4, 5],
 *                     [6, 7, 8]]
 *
 * Output: mat[][] = [[2, 1, 0],
 *                     [3, 4, 5],
 *                     [8, 7, 6]]
 *
 * Explanation: Major Diagonal = [0, 4, 8], Minor Diagonal = [2, 4, 6]
 * After swapping: [2, 4, 6] becomes major diagonal and [0, 4, 8] becomes minor
 *
 * Constraints:
 * 1 <= mat.size() <= 500
 * 1 <= mat[i][j] <= 10^6
 *
 * Time Complexity: O(n) where n is the size of the matrix
 * Space Complexity: O(1) - in-place swapping
 */

public class SwapDiagonalsInMatrix {

    /**
     * Swaps the major and minor diagonals of a square matrix
     *
     * @param mat The square matrix
     */
    public static void swapDiagonal(int[][] mat) {
        int n = mat.length;

        // Iterate through half the matrix size to swap diagonals
        for (int i = 0; i < n; i++) {
            // Swap element at major diagonal (i, i) with minor diagonal (i, n-1-i)
            int temp = mat[i][i];
            mat[i][i] = mat[i][n - 1 - i];
            mat[i][n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {

        // Test Case 1
        int[][] mat1 = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        System.out.println("Original Matrix 1:");
        printMatrix(mat1);
        swapDiagonal(mat1);
        System.out.println("Matrix 1 after swapping diagonals:");
        printMatrix(mat1);
        System.out.println();

        // Test Case 2 (Even sized matrix)
        int[][] mat2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Original Matrix 2:");
        printMatrix(mat2);
        swapDiagonal(mat2);
        System.out.println("Matrix 2 after swapping diagonals:");
        printMatrix(mat2);
        System.out.println();

        // Test Case 3 (Single element matrix)
        int[][] mat3 = {
                {5}
        };
        System.out.println("Original Matrix 3:");
        printMatrix(mat3);
        swapDiagonal(mat3);
        System.out.println("Matrix 3 after swapping diagonals:");
        printMatrix(mat3);
        System.out.println();
    }


    // Helper method to print the matrix
    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
