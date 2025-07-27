package arrays;

/**
 * Problem Statement:
 * -------------------
 * Given a 2D integer matrix 'mat' of size n x m, if an element is 0,
 * set its entire row and column to 0 in place. You must do this using
 * only constant extra space (O(1) auxiliary space), and the modification
 * should be done in place (mutate the given matrix).
 *
 * Example:
 * Input:
 * 1 1 1
 * 1 0 1
 * 1 1 1
 * Output:
 * 1 0 1
 * 0 0 0
 * 1 0 1
 *
 * Input:
 * 0 1 2 0
 * 3 4 5 2
 * 1 3 1 5
 * Output:
 * 0 0 0 0
 * 0 4 5 0
 * 0 3 1 0
 *
 * Constraints:
 * - 1 <= n, m <= 200
 * - -2^31 <= mat[i][j] <= 2^31 - 1
 *
 * Sample Test Cases:
 * -------------------
 * Test Case 1:
 * Input:
 * int[][] mat = {
 *     {1, 2, 3},
 *     {4, 0, 6},
 *     {7, 8, 9}
 * };
 * Output after calling setMatrixZeroes(mat):
 * [
 *   [1, 0, 3],
 *   [0, 0, 0],
 *   [7, 0, 9]
 * ]
 *
 * Test Case 2:
 * Input:
 * int[][] mat = {
 *     {0, 1},
 *     {1, 1}
 * };
 * Output after calling setMatrixZeroes(mat):
 * [
 *   [0, 0],
 *   [0, 1]
 * ]
 */

public class SetMatrixZeroes {

    /**
     * Sets matrix zeroes in place with constant extra space.
     * @param mat The input 2D integer matrix.
     */
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Check if first column needs to be zeroed
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // Check if first row needs to be zeroed
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // Use first row and column as markers for zeroing
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        // Zero the marked rows and columns (excluding first row and column)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        // Zero the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
        // Zero the first column if needed
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    // ---------- Demo Test Code -----------
    public static void main(String[] args) {
        SetMatrixZeroes solver = new SetMatrixZeroes();

        // Test case 1
        int[][] mat1 = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        solver.setMatrixZeroes(mat1);
        // Expected Output:
        // 1 0 3
        // 0 0 0
        // 7 0 9
        printMatrix(mat1);

        // Test case 2
        int[][] mat2 = {
                {0, 1},
                {1, 1}
        };
        solver.setMatrixZeroes(mat2);
        // Expected Output:
        // 0 0
        // 0 1
        printMatrix(mat2);

        // Test case 3
        int[][] mat3 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solver.setMatrixZeroes(mat3);
        // Expected Output:
        // 0 0 0 0
        // 0 4 5 0
        // 0 3 1 0
        printMatrix(mat3);
    }

    /**
     * Utility method to print a 2D matrix.
     */
    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
