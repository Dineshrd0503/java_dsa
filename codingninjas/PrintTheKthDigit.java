package codingninjas;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Problem Statement:
 * You are given three non-negative integers N, M, and K. Your task is to print the Kth digit from the right in
 * ‘N’ raised to the power ‘M’, that is, in N ^ M.
 *
 * Note:
 * 1) It is guaranteed that the Kth digit from the right always exists.
 * 2) It is also guaranteed that 'K' is always less than or equal to the number of digits in N ^ M.
 * 3) 'N' and 'M' can’t be 0 simultaneously.
 *
 * Detailed explanation (Input/output format, Notes, Images)
 *
 * Constraints:
 * 1 <= T <= 100
 * 0 <= N <= 15
 * 0 <= M <= 15
 * 1 <= K <= Digits in N ^ M
 *
 * Time Limit: 1 sec.
 *
 * Sample Input 1:
 * 1
 * 2 4 1
 *
 * Sample Output 1:
 * 6
 *
 * Explanation for sample input 1:
 * 2 ^ 4 = 16, and the 1st digit in 16 from the right is 6.
 *
 * Sample Input 2:
 * 1
 * 3 3 2
 *
 * Sample Output 2:
 * 2
 *
 * Explanation for sample input 2:
 * 3^3 = 27, and the 2nd digit in 27 from the right is 2.
 */

public class PrintTheKthDigit {

    /**
     * Method to find the Kth digit from the right in N^M.
     *
     * @param n Base number (N).
     * @param m Exponent (M).
     * @param k Position of digit from the right (K).
     * @return The Kth digit from the right in N^M.
     */
    public static int findKthFromRight(int n, int m, int k) {
        // Calculate N^M using BigInteger to handle large numbers
        long result = 1;
        for (int i = 1; i <= m; i++)
            result *= n;
        for (int i = 1; i < k; i++)
            result /= 10;
        return (int) (result % 10);
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {2, 4, 1},  // Expected Output: 6
                {3, 3, 2},  // Expected Output: 2
                {5, 3, 1},  // Expected Output: 5
                {2, 5, 3}   // Expected Output: 3 (2^5=32 → 3rd digit from right is 3)
        };

        // Process each test case
        for (int[] testCase : testCases) {
            int N = testCase[0];
            int M = testCase[1];
            int K = testCase[2];

            // Print the Kth digit
            System.out.println(findKthFromRight(N, M, K));
        }
    }
}

