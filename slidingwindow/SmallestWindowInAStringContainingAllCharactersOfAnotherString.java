package slidingwindow;

import java.util.Arrays;

public class SmallestWindowInAStringContainingAllCharactersOfAnotherString {

    /*
     * ====================================================================
     * Problem Statement: Smallest Window in a String
     * ====================================================================
     *
     * Given two strings s and p. Find the smallest substring in s
     * consisting of all the characters (including duplicates) of the string p.
     * Return an empty string in case no such substring is present.
     *
     * If there are multiple such substrings of the same length found, return
     * the one with the least starting index.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: s = "timetopractice", p = "toc"
     * Output: "toprac"
     * Explanation: "toprac" is the smallest substring in which "toc" can be found.
     *
     * Example 2:
     * Input: s = "zoomlazapzo", p = "oza"
     * Output: "apzo"
     * Explanation: "apzo" is the smallest substring in which "oza" can be found.
     */

    /**
     * Finds the smallest window in string s that contains all characters of string p.
     *
     * @param s The string to search within.
     * @param p The pattern string whose characters must be contained in the window.
     * @return The smallest window substring, or "" if none exists.
     */
    public static String smallestWindow(String s, String p) {
        if (p.length() > s.length()) {
            return "";
        }

        // Frequency map for characters in the pattern p
        int[] pMap = new int[256];
        for (char c : p.toCharArray()) {
            pMap[c]++;
        }

        int left = 0;
        int required = p.length();
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        // Sliding window traversal
        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);

            // If the character at 'right' is needed for the pattern, decrement required count
            if (pMap[charRight] > 0) {
                required--;
            }
            pMap[charRight]--;

            // When the window is valid (contains all required characters)
            while (required == 0) {
                // Check if this is the smallest window found so far
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // Try to shrink the window from the left
                char charLeft = s.charAt(left);
                pMap[charLeft]++;

                // If removing the character at 'left' makes the window invalid,
                // increment required count.
                if (pMap[charLeft] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    // Main method to test the function with static inputs.
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "timetopractice";
        String p1 = "toc";
        System.out.println("s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("Smallest Window: \"" + smallestWindow(s1, p1) + "\""); // Expected: "toprac"
        System.out.println("--------------------");

        // Test Case 2
        String s2 = "zoomlazapzo";
        String p2 = "oza";
        System.out.println("s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("Smallest Window: \"" + smallestWindow(s2, p2) + "\""); // Expected: "apzo"
        System.out.println("--------------------");
    }
}
