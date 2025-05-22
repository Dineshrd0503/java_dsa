package strings;

/**
 * Problem Statement:
 * Given a string s, delete the minimum number of characters so that the resultant string is a palindrome,
 * while maintaining the order of characters. Return the minimum number of deletions required.
 *
 * Examples:
 * Example 1:
 * Input: s = "aebcbda"
 * Output: 2
 * Explanation: Remove characters 'e' and 'd' to get "abcba", which is a palindrome.
 *
 * Example 2:
 * Input: s = "geeksforgeeks"
 * Output: 8
 * Explanation: The longest palindromic subsequence (LPS) is "eefee" (length 5).
 * Minimum deletions = 13 (length of s) - 5 = 8.
 *
 * Constraints:
 * 1 ≤ s.size() ≤ 10^3
 */
public class MinDeletionsToPalindrome {
    /**
     * Computes the minimum number of deletions to make the string a palindrome.
     * @param s The input string.
     * @return The minimum number of deletions.
     */
    static int minDeletions(String s) {
        int n = s.length();
        // The minimum deletions = length of s - length of Longest Palindromic Subsequence (LPS)
        // LPS can be found by computing the LCS of s and its reverse
        String rev = new StringBuilder(s).reverse().toString();
        int lpsLength = longestCommonSubsequence(s, rev);
        return n - lpsLength;
    }

    /**
     * Computes the length of the Longest Common Subsequence (LCS) of two strings using space-optimized DP.
     * @param s1 First string.
     * @param s2 Second string.
     * @return Length of the LCS.
     */
    static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        // Use two rows for space optimization
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Base case: dp[i][0] and dp[0][j] are 0 (already initialized to 0 in arrays)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Copy curr to prev for the next iteration
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }

        return curr[n];
    }

    /**
     * Main method to test the solution with static inputs.
     */
    public static void main(String[] args) {
        // Static test cases
        String[] testCases = {
                "aebcbda",          // Test case 1
                "geeksforgeeks",    // Test case 2
                "a",               // Test case 3: Single character (already palindrome)
                "abba",            // Test case 4: Already palindrome
                "abcd"             // Test case 5: No palindromic subsequence longer than 1
        };

        int[] expectedOutputs = {
                2,   // Test case 1
                8,   // Test case 2
                0,   // Test case 3
                0,   // Test case 4
                3    // Test case 5
        };

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i];
            int expected = expectedOutputs[i];
            int result = minDeletions(s);

            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: s = \"" + s + "\"");
            System.out.println("Expected Output: " + expected);
            System.out.println("Actual Output: " + result);
            System.out.println("Status: " + (result == expected ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}