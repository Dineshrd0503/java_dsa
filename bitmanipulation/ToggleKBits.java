package bitmanipulation;

import java.util.Arrays;

/**
 * Problem Statement:
 *
 * You are given a 32-bit integer ‘N’. Your task is to toggle the rightmost ‘K’ bits
 * in the given integer and return the new integer.
 *
 * For Example:
 * If ‘N’ = 12 and ‘K’ = 2:
 * The binary representation of 12 is ‘1100’, after toggling rightmost 2 bits,
 * it becomes ‘1111’ i.e. 15. Hence, the answer is 15.
 *
 * Input format:
 * The first line contains a single integer T representing the number of test cases.
 * The next lines each contain two space-separated integers ‘N’ and ‘K’ that represent
 * the given 32-bit integer and the number of rightmost bits to toggle respectively.
 *
 * Output format:
 * For each test case, return the new Integer after toggling the rightmost ‘K’ bits.
 *
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 10^9
 * 1 <= K <= 31
 *
 * Sample Input:
 * 2
 * 21 3
 * 40 4
 *
 * Sample Output:
 * 18
 * 39
 */

public class ToggleKBits {

    public static int toggleKBits(int n, int k) {
        // Create a mask with K rightmost bits set to 1
        int mask = (1 << k) - 1;
        // Toggle the bits using XOR
        return n ^ mask;
    }

    public static void main(String[] args) {
        // Predefined static input
        int[][] testCases = {
                {21, 3},
                {40, 4},
                {20, 2},
                {85, 5}
        };

        // Process each test case
        for (int[] testCase : testCases) {
            int N = testCase[0];
            int K = testCase[1];
            System.out.println(toggleKBits(N, K)); // Output the result for each test case
        }
    }
}
