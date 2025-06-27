package dynamicprogramming;

// Problem: Mobile Numeric Keypad Problem (GeeksforGeeks)
// URL: https://www.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1

/*
Problem Statement:
Given a mobile numeric keypad. You can only press buttons that are currently
pressed or buttons that are directly above, below, left, or right of the
currently pressed button. You cannot press diagonal buttons or buttons like
* and #.
Find the number of unique sequences of length N that can be pressed.
The starting digit can be any digit from 0 to 9.

Example 1:
Input: N = 1
Output: 10
Explanation:
For N = 1, each digit (0-9) is a valid sequence.

Example 2:
Input: N = 2
Output: 36
Explanation:
For N = 2, some possible sequences are:
00, 08, 11, 12, 14, 21, 22, 23, 25, ... and so on.
There are a total of 36 such sequences.

Constraints:
1 <= N <= 25
*/

public class MobileNumericKeypad {

    public long getCount(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 10;
        }

        // DP table to store the number of sequences of length 'i' ending at digit 'j'.
        // The table is indexed from 0 to 9 for digits and 0 to n for length.
        long[][] dp = new long[n + 1][10];

        // Initialize base cases for sequences of length 1.
        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1; // Corrected: Use dp[1][j] for length 1
        }

        // Define valid moves for each digit on the keypad.
        // This is a list of lists, where each inner list contains valid adjacent digits for a given digit.
        int[][] moves = {
                {0, 8}, // 0
                {1, 2, 4}, // 1
                {1, 2, 3, 5}, // 2
                {2, 3, 6}, // 3
                {1, 4, 5, 7}, // 4
                {2, 4, 5, 6, 8}, // 5
                {3, 5, 6, 9}, // 6
                {4, 7, 8}, // 7
                {0, 5, 7, 8, 9}, // 8
                {6, 8, 9} // 9
        };

        // Iterate through sequence lengths from 2 to n.
        for (int i = 2; i <= n; i++) {
            // Iterate through each digit (0 to 9) as the potential ending digit of the sequence.
            for (int j = 0; j < 10; j++) {
                // Initialize the count of sequences ending at digit 'j' for length 'i' to 0.
                dp[i][j] = 0;
                // Consider all valid previous digits ('k') from which we could have arrived at digit 'j'.
                for (int k : moves[j]) {
                    // Add the number of sequences of length 'i-1' ending at digit 'k' to the current count for dp[i][j].
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        // Sum up the counts for all possible ending digits of length n.
        long totalCount = 0;
        for (int j = 0; j < 10; j++) {
            totalCount += dp[n][j];
        }

        return totalCount;
    }

    public static void main(String[] args) {
        MobileNumericKeypad solution = new MobileNumericKeypad();

        // Sample Test Cases
        int n1 = 1;
        long result1 = solution.getCount(n1);
        System.out.println("For N = " + n1 + ", the number of sequences is: " + result1); // Expected Output: 10

        int n2 = 2;
        long result2 = solution.getCount(n2);
        System.out.println("For N = " + n2 + ", the number of sequences is: " + result2); // Expected Output: 36

        int n3 = 3;
        long result3 = solution.getCount(n3);
        System.out.println("For N = " + n3 + ", the number of sequences is: " + result3); // Example for N=3: need to calculate or verify

        // Add more test cases if needed
        int n4 = 4;
        long result4 = solution.getCount(n4);
        System.out.println("For N = " + n4 + ", the number of sequences is: " + result4);

    }
}
