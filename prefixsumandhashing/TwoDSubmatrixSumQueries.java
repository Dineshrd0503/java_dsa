package prefixsumandhashing;

/*
 * PROBLEM: 2D Submatrix Sum Queries
 *
 * Given a 2D integer matrix mat[][] and a list of queries queries[][],
 * your task is to answer a series of submatrix sum queries.
 *
 * Each query is represented as [r1, c1, r2, c2], where:
 * - (r1, c1) is the top-left coordinate of the submatrix
 * - (r2, c2) is the bottom-right coordinate of the submatrix (both inclusive)
 *
 * Return a list of integers, the sum of elements within the specified submatrix for each query.
 *
 * Example:
 * Input: mat[][] = [[1, 2, 3], [1, 1, 0], [4, 2, 2]]
 *        queries[][] = [[0, 0, 1, 1], [1, 0, 2, 2]]
 * Output: [5, 10]
 *
 * Approach: 2D Prefix Sum (2D Cumulative Sum Array)
 * Time Complexity: O(n*m + q) where n,m are matrix dimensions, q is number of queries
 * Space Complexity: O(n*m) for prefix array
 */

import java.util.*;

public class TwoDSubmatrixSumQueries {

    public static ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // Build 2D prefix sum array
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefix = new int[n + 1][m + 1];

        // Create prefix sum where prefix[i][j] = sum of all elements from (0,0) to (i-1,j-1)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        // Process queries
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            // Calculate sum of submatrix using prefix sum formula
            int sum = prefix[r2 + 1][c2 + 1] - prefix[r1][c2 + 1] - prefix[r2 + 1][c1] + prefix[r1][c1];
            result.add(sum);
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("===== Test Case 1: 3x3 Matrix =====");
        int[][] mat1 = {{1, 2, 3},
                {1, 1, 0},
                {4, 2, 2}};
        int[][] queries1 = {{0, 0, 1, 1},
                {1, 0, 2, 2}};

        System.out.println("Matrix:");
        printMatrix(mat1);
        System.out.println("Queries: [[0,0,1,1], [1,0,2,2]]");

        ArrayList<Integer> result1 = prefixSum2D(mat1, queries1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: [5, 10]");
        System.out.println();

        // Test Case 2
        System.out.println("===== Test Case 2: 3x3 Matrix with All Ones =====");
        int[][] mat2 = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        int[][] queries2 = {{1, 1, 2, 2},
                {0, 0, 2, 2},
                {0, 2, 2, 2}};

        System.out.println("Matrix:");
        printMatrix(mat2);
        System.out.println("Queries: [[1,1,2,2], [0,0,2,2], [0,2,2,2]]");

        ArrayList<Integer> result2 = prefixSum2D(mat2, queries2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: [4, 9, 3]");
        System.out.println();

        // Test Case 3
        System.out.println("===== Test Case 3: 4x4 Matrix =====");
        int[][] mat3 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] queries3 = {{0, 0, 1, 1},
                {2, 2, 3, 3}};

        System.out.println("Matrix:");
        printMatrix(mat3);
        System.out.println("Queries: [[0,0,1,1], [2,2,3,3]]");

        ArrayList<Integer> result3 = prefixSum2D(mat3, queries3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: [14, 54]");
        System.out.println();
    }

    // Helper method to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
