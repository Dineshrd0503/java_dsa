package strings;

import java.util.*;

/*
 * Problem Statement:
 * Given a string S and a set of N words in a Dictionary, break S into subparts such that
 * each subpart is present in the Dictionary. Find the minimum number of breaks required.
 * If S is in the Dictionary, return 0. If impossible, return -1. All characters in S and
 * Dictionary words are uppercase English letters (A to Z).
 *
 * Constraints:
 * - 1 <= T <= 50 (number of test cases)
 * - 1 <= N <= 10^4 (number of Dictionary words)
 * - 1 <= |S| <= 50 (length of string S)
 * - 1 <= |word[i]| <= 50 (length of Dictionary word)
 * - Characters: A to Z
 * - Time Limit: 1 sec
 *
 * Sample Input 11
 * 1
 * CODESTUDIO
 * 5
 * COD CODE ESTU DIO STUDIO
 * Output: 1
 * Explanation: Break into CODE and STUDIO (one break).
 *
 * Sample Input 2:
 * 1
 * BREAKME
 * 3
 * BROKE ME BREAKM
 * Output: -1
 * Explanation: No valid break possible.
 *
 * Sample Test Cases:
 * Test Case 1: S = "A", Dictionary = ["A"] → Output: 0 (S in Dictionary)
 * Test Case 2: S = "ABC", Dictionary = ["A", "B", "C"] → Output: 2 (Break into A, B, C)
 * Test Case 3: S = "AAAA", Dictionary = ["AA"] → Output: 1 (Break into AA, AA)
 * Test Case 4: S = "Z", Dictionary = ["A"] → Output: -1 (No valid break)
 */

public class StringBreaker {
    public static int stringBreaker(String s, int n, String[] dictionary) {
        // Convert dictionary to Set for O(1) lookups
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));

        // If S is in dictionary, no breaks needed
        if (dict.contains(s)) {
            return 0;
        }

        int len = s.length();
        // dp[i] = min number of subparts for S[i..len-1]
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len] = 0; // Base case: empty string needs 0 subparts

        // Iterate from right to left
        for (int i = len - 1; i >= 0; i--) {
            // Try all prefixes starting at i
            for (int j = i; j < len; j++) {
                String prefix = s.substring(i, j + 1);
                if (dict.contains(prefix) && dp[j + 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        // Return breaks (subparts - 1) or -1 if impossible
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0] - 1;
    }
    public static void main(String[] args) {
        // Sample Test Cases
        String s1 = "CODESTUDIO";
        String[] dict1 = {"COD", "CODE", "ESTU", "DIO", "STUDIO"};
        System.out.println("Test Case 1 Output: " + stringBreaker(s1, dict1.length, dict1)); // Expected Output: 1

        String s2 = "BREAKME";
        String[] dict2 = {"BROKE", "ME", "BREAKM"};
        System.out.println("Test Case 2 Output: " + stringBreaker(s2, dict2.length, dict2)); // Expected Output: -1
    }
}