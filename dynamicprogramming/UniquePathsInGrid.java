package dynamicprogramming;

import java.util.Arrays;

public class UniquePathsInGrid {

    static final int MOD = 1000000007;

    // Function to calculate unique paths
    static int uniquePaths(int n, int m, int[][] grid) {
        // If the first or last cell is blocked, return 0
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return 0;

        int[][] dp = new int[n][m];
        // Set the starting point
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is blocked, continue to the next cell
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // Calculate paths from the top cell
                if (i > 0) dp[i][j] += dp[i - 1][j];
                // Calculate paths from the left cell
                if (j > 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD; // Ensure the result is modulo
            }
        }

        // Return the number of unique paths to the bottom-right corner
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        // Problem Statement:
        // You are given a 2D list grid[n][m] consisting of values 0 and 1.
        // A value of 0 means you can enter that cell, and 1 means you cannot.
        // You start at (0, 0) and need to reach (n-1, m-1), only moving right or down.
        // Calculate the total number of unique ways of reaching the target.

        // Sample Test Cases
        // Test Case 1
        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Test Case 1 Output: " + uniquePaths(3, 3, grid1)); // Expected Output: 2

        // Test Case 2
        int[][] grid2 = {
                {1, 0, 1}
        };
        System.out.println("Test Case 2 Output: " + uniquePaths(1, 3, grid2)); // Expected Output: 0

        // Test Case 3
        int[][] grid3 = {
                {0, 0},
                {0, 0}
        };
        System.out.println("Test Case 3 Output: " + uniquePaths(2, 2, grid3)); // Expected Output: 2

        // Test Case 4
        int[][] grid4 = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println("Test Case 4 Output: " + uniquePaths(3, 4, grid4)); // Expected Output: 4
    }
}