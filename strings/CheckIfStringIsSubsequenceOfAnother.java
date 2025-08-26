package strings;

public class CheckIfStringIsSubsequenceOfAnother {
    /**
     * Given two strings s1 and s2, check if s1 is a subsequence of s2.
     * A subsequence is a sequence that can be derived from another sequence
     * by deleting some elements without changing the order of the remaining elements.
     *
     * Examples:
     *
     * Input: s1 = "AXY", s2 = "YADXCP"
     * Output: false
     * Explanation: s1 is not a subsequence of s2 as 'Y' appears before 'A'.
     *
     * Input: s1 = "gksrek", s2 = "geeksforgeeks"
     * Output: true
     * Explanation: If we combine the bold character of "geeksforgeeks", it equals to s1.
     * So s1 is a subsequence of s2.
     *
     * Constraints:
     * 1 <= s1.size(), s2.size() <= 10^6
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * @param s1 The subsequence to check.
     * @param s2 The main string.
     * @return True if s1 is a subsequence of s2, false otherwise.
     */
    public boolean isSubSeq(String s1, String s2) {
        int i = 0; // Pointer for s1 (subsequence)
        int j = 0; // Pointer for s2 (main string)

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                // If characters match, move the pointer for s1
                i++;
            }
            // Always move the pointer for s2
            j++;
        }

        // If all characters of s1 were found in s2 in the correct order,
        // then i will be equal to s1.length().
        return i == s1.length();
    }

    public static void main(String[] args) {
        CheckIfStringIsSubsequenceOfAnother solution = new CheckIfStringIsSubsequenceOfAnother();

        // Test cases
        String s1_1 = "AXY";
        String s2_1 = "YADXCP";
        System.out.println("Input: s1 = \"" + s1_1 + "\", s2 = \"" + s2_1 + "\"");
        System.out.println("Output: " + solution.isSubSeq(s1_1, s2_1)); // Expected: false
        System.out.println();

        String s1_2 = "gksrek";
        String s2_2 = "geeksforgeeks";
        System.out.println("Input: s1 = \"" + s1_2 + "\", s2 = \"" + s2_2 + "\"");
        System.out.println("Output: " + solution.isSubSeq(s1_2, s2_2)); // Expected: true
        System.out.println();

        String s1_3 = "abc";
        String s2_3 = "ahbgdc";
        System.out.println("Input: s1 = \"" + s1_3 + "\", s2 = \"" + s2_3 + "\"");
        System.out.println("Output: " + solution.isSubSeq(s1_3, s2_3)); // Expected: true
        System.out.println();

        String s1_4 = "axc";
        String s2_4 = "ahbgdc";
        System.out.println("Input: s1 = \"" + s1_4 + "\", s2 = \"" + s2_4 + "\"");
        System.out.println("Output: " + solution.isSubSeq(s1_4, s2_4)); // Expected: false
        System.out.println();

        String s1_5 = "";
        String s2_5 = "ahbgdc";
        System.out.println("Input: s1 = \"" + s1_5 + "\", s2 = \"" + s2_5 + "\"");
        System.out.println("Output: " + solution.isSubSeq(s1_5, s2_5)); // Expected: true (empty string is always a subsequence)
        System.out.println();

        String s1_6 = "abc";
        String s2_6 = "";
        System.out.println("Input: s1 = \"" + s1_6 + "\", s2 = \"" + s2_6 + "\"");
        System.out.println("Output: " + solution.isSubSeq(s1_6, s2_6)); // Expected: false
        System.out.println();
    }
}