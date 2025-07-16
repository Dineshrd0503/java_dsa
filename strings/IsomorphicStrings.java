package strings;

/*
 * Problem Statement:
 * Given two strings s1 and s2 of equal length consisting of only lowercase English
 * letters, check if they are isomorphic. Two strings are isomorphic if characters
 * in s1 can be replaced with characters in s2 maintaining a one-to-one mapping
 * while preserving order.
 *
 * Constraints:
 * 1 ≤ s1.size() = s2.size() ≤ 10^5
 */

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean areIsomorphic(String s1, String s2) {
        // Check if lengths are equal
        if (s1.length() != s2.length()) return false;

        // HashMaps for bidirectional mapping
        HashMap<Character, Character> s1ToS2 = new HashMap<>();
        HashMap<Character, Character> s2ToS1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // If s1[c1] is already mapped
            if (s1ToS2.containsKey(c1)) {
                if (s1ToS2.get(c1) != c2) return false; // Must map to the same s2 char
            } else {
                // Check if s2[c2] is already mapped to a different s1 char
                if (s2ToS1.containsKey(c2)) return false;
                s1ToS2.put(c1, c2); // Map s1 char to s2 char
                s2ToS1.put(c2, c1); // Map s2 char to s1 char
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        String[][] testCases = {
                {"aab", "xxy"},
                {"aab", "xyz"},
                {"abc", "xxz"}
        };
        for (String[] test : testCases) {
            String s1 = test[0];
            String s2 = test[1];
            boolean result = areIsomorphic(s1, s2);
            System.out.println("Input: s1 = \"" + s1 + "\", s2 = \"" + s2 + "\"");
            System.out.println("Output: " + result);
        }
    }
}