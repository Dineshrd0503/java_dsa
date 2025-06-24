package stacks;


import java.util.Stack;

/*
 * Problem: Largest Subsequence of Length K
 * Given a string s and an integer k, return the lexicographically largest
 * subsequence of length k by removing up to (n - k) characters, preserving
 * the relative order of remaining characters.
 *
 * Input:
 * - T: Number of test cases (hardcoded as 3)
 * - For each test case:
 *   - s: String of lowercase letters
 *   - k: Length of the subsequence (1 <= k <= s.length())
 *
 * Output:
 * - For each test case, a string of length k representing the lexicographically
 *   largest subsequence
 *
 * Example:
 * Test Case 1: s = "bcabc", k = 2
 * Output: "cb"
 * Test Case 2: s = "ritz", k = 2
 * Output: "tz"
 * Test Case 3: s = "zebra", k = 3
 * Output: "zeb"
 *
 * Constraints:
 * - 1 <= T <= 10^5
 * - 1 <= s.length() <= 10^5
 * - 1 <= k <= s.length()
 * - s contains only lowercase letters
 */
public class LexicographicallyLargestStringAfterKDeletions {
    /*
     * Returns the lexicographically largest subsequence of length k.
     * @param s Input string
     * @param k Length of subsequence
     * @return Lexicographically largest subsequence
     */
    public static String maxSubseq(String s, int k) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            // Ensure we have enough remaining characters for length k
            while (!stack.isEmpty() && stack.peek() < currentChar &&
                    (n - i - 1 + stack.size()) > k) {
                stack.pop();
            }
            stack.push(currentChar);
        }

        // Build result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        // Return first k characters
        return result.length() > k ? result.substring(0, k) : result.toString();
    }

    /*
     * Main method with static inputs for test cases.
     */
    public static void main(String[] args) {
        // Define static test cases
        String[] strings = {"bcabc", "ritz", "zebra"};
        int[] kValues = {2, 2, 3};

        // Process each test case
        for (int t = 0; t < strings.length; t++) {
            String result = maxSubseq(strings[t], kValues[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}