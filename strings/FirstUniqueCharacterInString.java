package strings;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Problem Statement:
 * Given a string STR of lowercase English letters, find the first non-repeating character.
 * Return the character, or '#' if none exists. Process T test cases.
 *
 * Constraints:
 * - 1 ≤ T ≤ 100 (number of test cases)
 * - 1 ≤ N ≤ 10^4 (length of string)
 * - STR contains only lowercase English letters (a-z)
 * Time Limit: 1 sec
 *
 * Examples:
 * Input: T = 2
 *        STR = "bbabcbcb"
 *        STR = "babaabea"
 * Output: a
 *         e
 * Explanation:
 * - For "bbabcbcb": 'a' at index 2 is first non-repeating (b repeats at 0,1,3,5,7; c at 4,6).
 * - For "babaabea": 'e' at index 6 is first non-repeating (b at 0,2,5; a at 1,3,4,7).
 *
 * Input: T = 3
 *        STR = "cbbd"
 *        STR = "bebeeed"
 *        STR = "abcd"
 * Output: c
 *         d
 *         a
 */
public class FirstUniqueCharacterInString {
    /*
     * Finds the first non-repeating character in a string using a HashMap.
     * @param str Input string of lowercase letters
     * @return First non-repeating character, or '#' if none
     */
    public static char firstNonRepeating(String str) {
        // HashMap to store character frequencies
        HashMap<Character, Integer> freq = new HashMap<>();

        // First pass: Count frequency of each character
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Second pass: Find first character with frequency 1
        for (char c : str.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }

        // No non-repeating character found
        return '#';
    }

    /*
     * Main method to handle multiple test cases.
     * Reads T test cases and processes each string.
     */
   public static void main(String[] args) {
        // Static test cases
        String[] testCases = {
            "bbabcbcb",   // Expected: a
            "babaabea",   // Expected: e
            "cbbd",       // Expected: c
            "bebeeed",    // Expected: d
            "abcd"        // Expected: a
        };

        // Process each test case
        for (String str : testCases) {
            System.out.println("Input: " + str);
            System.out.println("Output: " + firstNonRepeating(str));
            System.out.println();
        }
    }
}