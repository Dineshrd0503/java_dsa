package arrays;

public class CountPairsWithSum {
    /*
     * Problem Statement:
     * Given two matrices mat1[][] and mat2[][] of size n x n, where the elements in each matrix
     * are arranged in strictly ascending order (each row is sorted from left to right, and the
     * last element of a row is smaller than the first element of the next row), find and count
     * all pairs {a, b} such that a is from mat1 and b is from mat2 where a + b equals a given
     * target value x.
     *
     * Constraints:
     * - 1 ≤ n ≤ 100
     * - 1 ≤ x ≤ 10^5
     * - 1 ≤ mat1[i][j], mat2[i][j] ≤ 10^5
     *
     * Example 1:
     * Input: n = 3, x = 21
     * mat1[][] = [[1, 5, 6], [8, 10, 11], [15, 16, 18]]
     * mat2[][] = [[2, 4, 7], [9, 10, 12], [13, 16, 20]]
     * Output: 4
     * Explanation: The pairs whose sum is 21 are (1, 20), (5, 16), (8, 13), and (11, 10).
     *
     * Example 2:
     * Input: n = 2, x = 10
     * mat1[][] = [[1, 2], [3, 4]]
     * mat2[][] = [[4, 5], [6, 7]]
     * Output: 2
     * Explanation: The pairs whose sum is 10 are (4, 6) and (3, 7).
     */

    public static int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        int count = 0;

        // Initialize pointers: start of mat1 and end of mat2
        int p1 = 0; // Linear index for mat1
        int p2 = n * n - 1; // Linear index for mat2

        while (p1 < n * n && p2 >= 0) {
            // Convert linear indices to 2D indices
            int i1 = p1 / n, j1 = p1 % n; // For mat1
            int i2 = p2 / n, j2 = p2 % n; // For mat2

            int sum = mat1[i1][j1] + mat2[i2][j2];

            if (sum == x) {
                count++;
                p1++;
                p2--;
            } else if (sum < x) {
                p1++; // Need a larger sum, move mat1 pointer forward
            } else {
                p2--; // Need a smaller sum, move mat2 pointer backward
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Test Case 1
        int n1 = 3, x1 = 21;
        int[][] mat1_1 = {
                {1, 5, 6},
                {8, 10, 11},
                {15, 16, 18}
        };
        int[][] mat2_1 = {
                {2, 4, 7},
                {9, 10, 12},
                {13, 16, 20}
        };
        System.out.println("Test Case 1 Output: " + countPairs(mat1_1, mat2_1, x1)); // Expected: 4

        // Test Case 2
        int n2 = 2, x2 = 10;
        int[][] mat1_2 = {
                {1, 2},
                {3, 4}
        };
        int[][] mat2_2 = {
                {4, 5},
                {6, 7}
        };
        System.out.println("Test Case 2 Output: " +countPairs(mat1_2, mat2_2, x2)); // Expected: 2
    }
}