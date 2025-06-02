package dynamicprogramming;
import java.util.Arrays;

/*
Problem Statement:
You are present at point ‘A’ which is the top-left cell of an M X N matrix,
your destination is point ‘B’, which is the bottom-right cell of the same matrix.
Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.
In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’,
your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].
To traverse in the matrix, you can either move Right or Down at each step.

Input Format:
The first line of input contains an integer 'T' representing the number of the test case.
The first and the only line of each test case contains two space-separated integers ‘M’ and ‘N’,
denoting the number of rows and number of columns of the matrix respectively.

Output Format:
For every test case, return a single integer, which is the total number of unique paths
for traveling from top-left to bottom-right cells of the matrix.

Sample Input 1:
2
2 2
1 1

Sample Output 1:
2
1

Sample Input 2:
2
3 2
1 6

Sample Output 2:
3
1

Explanation of Sample Output 1:
In test case 1, to move from matrix[0][0] to matrix[1][1] we have:
1) (0, 0) -> (0, 1) -> (1, 1) (Right, Down)
2) (0, 0) -> (1, 0) -> (1, 1) (Down, Right)
Total paths = 2.

In test case 2, for the 1 x 6 matrix, there is only one path (the single row).
*/

public class UniquePaths {

        public static int uniquePaths(int m, int n) {
            // If the grid is either 1 row or 1 column, there is only 1 unique path
            if (m == 1 || n == 1) {
                return 1;
            }

            // Create a 2D array to store the number of unique paths
            int[][] dp = new int[m][n];

            // Fill the first row and first column with 1s
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1; // Only one way to move down
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1; // Only one way to move right
            }

            // Calculate the number of unique paths for the rest of the grid
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Paths from above and left
                }
            }

            // The number of unique paths to reach the bottom-right corner
            return dp[m - 1][n - 1];
        }

        public static void main(String[] args) {
            // Static test cases
            int[][] testCases = {
                    {2, 2},  // Test case 1: 2x2 grid
                    {1, 1},  // Test case 2: 1x1 grid
                    {3, 2},  // Test case 3: 3x2 grid
                    {1, 6},  // Test case 4: 1x6 grid
                    {5, 5},  // Test case 5: 5x5 grid
                    {4, 4},  // Test case 6: 4x4 grid
            };

            // Array to store results for each test case
            int[] results = new int[testCases.length];

            // Loop through each test case
            for (int i = 0; i < testCases.length; i++) {
                int m = testCases[i][0];
                int n = testCases[i][1];

                // Calculate and store the number of unique paths
                results[i] = uniquePaths(m, n);
            }

            // Print results for each test case
            System.out.println("Results for each test case:");
            for (int i = 0; i < results.length; i++) {
                System.out.println("Unique paths for grid " + Arrays.toString(testCases[i]) + ": " + results[i]);
            }
        }
    }


