package bitmanipulation;

// Problem Statement:
// You are given a single non-negative integer ‘N’ whose binary representation consists of a single ‘1’ digit
// and the rest ‘0’s. Your task is to find the position of the only ‘1’ digit, counted from the LSB (Least
// Significant Bit) end. If the count of set bits is not exactly 1, return -1.
//
// Examples:
// Input: N = 4
// Output: 3
// Explanation: Binary "0100", single '1' at position 3 from LSB.
//
// Input: N = 8
// Output: 4
// Explanation: Binary "1000", single '1' at position 4 from LSB.
//
// Input: N = 9
// Output: -1
// Explanation: Binary "1001", two '1's, invalid.
//
// Input: N = 0
// Output: -1
// Explanation: Binary "0000", no '1's, invalid.
//
// Constraints:
// 1 <= T <= 100
// 0 <= N <= 10^5
// Time Limit: 1 second

public class FindTheLoneSetBit {
    public static int findSetBit(int n) {
        // Initialize result as -1 (default for invalid cases)
        int result = -1;

        // Check if N has exactly one set bit
        int setBitCount = Integer.bitCount(n);
        if (setBitCount != 1) {
            return result; // Return -1 if not exactly one '1'
        }

        // Find position of the set bit (counting from LSB, 1-based)
        return Integer.numberOfTrailingZeros(n) + 1;
    }

    public static void main(String[] args) {
        // Static inputs based on sample cases
        int[] testCases = {4, 5}; // Number of test cases for Sample Input 1 and 2
        int[][] inputs = {
                {2, 8, 11, 0},    // Sample Input 1
                {16, 21, 32, 58, 64} // Sample Input 2
        };

        // Process each test case set
        for (int i = 0; i < testCases.length; i++) {
            int T = testCases[i];
            System.out.println("Processing " + T + " test cases:");
            for (int j = 0; j < T; j++) {
                int N = inputs[i][j];
                int result = findSetBit(N);
                System.out.println("N = " + N + ", Binary = " + Integer.toBinaryString(N) + ", Result = " + result);
            }
            System.out.println();
        }
    }
}