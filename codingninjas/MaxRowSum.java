package codingninjas;

import java.util.Arrays;

public class MaxRowSum {

    /**
     * Problem statement:
     * Ninja has been provided a matrix 'MAT' of size 'N X M' where 'M' is the number of columns in the matrix, and
     * 'N' is the number of rows.
     *
     * The weight of a particular row is the sum of all elements in it. Ninja wants to find the maximum weight
     * amongst all the rows. Your task is to help the ninja find the maximum weight amongst all the rows.
     *
     * Input Format:
     * The first line of input contains an integer 'T', denoting the number of test cases.
     * For each test case, the first line will contain two integers, 'N' and 'M' (number of rows and columns in the matrix).
     * Next, 'N' lines will contain 'M' integers for each of the matrix elements.
     *
     * Output format:
     * For each test case, print the maximum weight amongst all the rows.
     *
     * Constraints:
     * 1 <= 'T' <= 10
     * 1 <= 'N' <= 10^2
     * 1 <= 'M' <= 10^2
     * 0 <= 'MAT[I][J]' <= 10^5
     */

    public static int maximumWeightRow(int n, int m, int[][] mat) {
        int result = Integer.MIN_VALUE;

        for (int[] row : mat) {
            int curr = Arrays.stream(row).sum();
            result = Math.max(curr, result);
        }

        return result;
    }

    public static void main(String[] args) {
        // Static test cases
        // Sample Input 1
        /*
        Input:
        2
        3 3
        1 2 3
        3 4 2
        3 4 2
        1 1
        2

        Output:
        9
        2
        */

        int[][][] testCases = {
                { // Test Case 1: 3 rows, 3 columns
                        {1, 2, 3},
                        {3, 4, 2},
                        {3, 4, 2}
                },
                { // Test Case 2: 1 row, 1 column
                        {2}
                }
        };

        int[] testCaseCounts = {3, 1}; // Row counts for each test case
        int[][] testCaseColumns = {{3, 3}, {1, 1}}; // Column counts for each test case

        for (int i = 0; i < testCases.length; i++) {
            int N = testCaseCounts[i];
            int M = testCaseColumns[i][0];
            int[][] MAT = testCases[i];

            int result = maximumWeightRow(N, M, MAT);
            System.out.println(result); // Output the maximum row weight for each test case
        }
    }
}