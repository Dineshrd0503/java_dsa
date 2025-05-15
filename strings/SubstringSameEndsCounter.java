package strings;

import java.util.HashMap;

/**
 * Problem Statement:
 * Given a string s consisting of lowercase English characters, the task is to find the count of all substrings
 * that start and end with the same character. A substring is a contiguous sequence of characters in the string.
 *
 * Constraints:
 * - 1 <= |s| <= 10^4
 * - s contains only lowercase English alphabets (a-z)
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "abcab"
 * Output: 7
 * Explanation: The substrings where the first and last characters are the same are:
 * - "a" (index 0 to 0)
 * - "abca" (index 0 to 3)
 * - "b" (index 1 to 1)
 * - "bcab" (index 1 to 4)
 * - "c" (index 2 to 2)
 * - "a" (index 3 to 3)
 * - "b" (index 4 to 4)
 * Total count: 7
 *
 * Example 2:
 * Input: s = "aba"
 * Output: 4
 * Explanation: The substrings where the first and last characters are the same are:
 * - "a" (index 0 to 0)
 * - "aba" (index 0 to 2)
 * - "b" (index 1 to 1)
 * - "a" (index 2 to 2)
 * Total count: 4
 *
 * Example 3 (Edge Case):
 * Input: s = "a"
 * Output: 1
 * Explanation: The only substring is "a" (index 0 to 0), which satisfies the condition.
 *
 * Example 4 (Edge Case):
 * Input: s = "aaaa"
 * Output: 10
 * Explanation: For a string with 4 'a's, the substrings are:
 * - Length 1: "a", "a", "a", "a" (4 substrings)
 * - Length 2: "aa", "aa", "aa" (3 substrings)
 * - Length 3: "aaa", "aaa" (2 substrings)
 * - Length 4: "aaaa" (1 substring)
 * Total count: 4 + 3 + 2 + 1 = 10
 */
public class SubstringSameEndsCounter {
    /**
     * Counts the number of substrings in string s that start and end with the same character.
     * @param s The input string consisting of lowercase English alphabets.
     * @return The count of substrings where the first and last characters are the same.
     */
    public int countSubstring(String s) {
        // Use a frequency array for characters a-z (since s contains only lowercase a-z)

        HashMap<Character, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            int currentFreq = freqMap.getOrDefault(ch, 0);
            count += currentFreq;
            freqMap.put(ch, currentFreq + 1);
        }
        count += s.length();
        return count;
    }

    /**
     * Main method to test the solution with static inputs.
     */
    public static void main(String[] args) {
        // Create an instance of the class
        SubstringSameEndsCounter solver = new SubstringSameEndsCounter();

        // Static test cases
        String[] testCases = {
                "abcab",  // Example 1
                "aba",    // Example 2
                "a",      // Example 3 (Edge case: single character)
                "aaaa"    // Example 4 (Edge case: all same characters)
        };

        int[] expectedOutputs = {
                7,   // Example 1
                4,   // Example 2
                1,   // Example 3
                10   // Example 4
        };

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            int expected = expectedOutputs[i];
            int result = solver.countSubstring(input);

            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: s = \"" + input + "\"");
            System.out.println("Expected Output: " + expected);
            System.out.println("Actual Output: " + result);
            System.out.println("Status: " + (result == expected ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}
