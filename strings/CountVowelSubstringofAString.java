package strings;

import java.util.*;

/**
 * ✅ Problem Statement:
 * ---------------------
 * A substring is a contiguous (non-empty) sequence of characters within a string.
 * A vowel substring is a substring that:
 *    - consists only of vowels ('a', 'e', 'i', 'o', 'u')
 *    - contains all five vowels at least once
 *
 * Given a string `word`, return the number of vowel substrings in `word`.
 *
 * ✅ Example 1:
 * Input: word = "aeiouu"
 * Output: 2
 * Explanation: Valid substrings that contain only vowels and all five vowels:
 * - "aeiou" ✅
 * - "aeiouu" ✅
 *
 * ✅ Example 2:
 * Input: word = "unicornarihan"
 * Output: 0
 *
 * ✅ Example 3:
 * Input: word = "cuaieuouac"
 * Output: 7
 */

public class CountVowelSubstringofAString {

    // Main function to count "vowel substrings" as per the definition
    public int countVowelSubstrings(String word) {
        // Set of valid vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int count = 0;

        // Traverse all substrings
        for (int i = 0; i < word.length(); i++) {
            if (!vowels.contains(word.charAt(i))) continue;

            Set<Character> seen = new HashSet<>();

            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);

                // Break if not a vowel
                if (!vowels.contains(c)) break;

                seen.add(c);

                // Vowel substring must have all 5 vowels
                if (seen.size() == 5) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountVowelSubstringofAString counter = new CountVowelSubstringofAString();

        // ✅ Test Case 1
        String word1 = "aeiouu";
        System.out.println("Input: " + word1 + " → Output: " + counter.countVowelSubstrings(word1)); // Output: 2

        // ✅ Test Case 2
        String word2 = "unicornarihan";
        System.out.println("Input: " + word2 + " → Output: " + counter.countVowelSubstrings(word2)); // Output: 0

        // ✅ Test Case 3
        String word3 = "cuaieuouac";
        System.out.println("Input: " + word3 + " → Output: " + counter.countVowelSubstrings(word3)); // Output: 7

        // ✅ Test Case 4
        String word4 = "aaiiouuoueia";
        System.out.println("Input: " + word4 + " → Output: " + counter.countVowelSubstrings(word4)); // Output: ?

        // ✅ Test Case 5
        String word5 = "abcdefg";
        System.out.println("Input: " + word5 + " → Output: " + counter.countVowelSubstrings(word5)); // Output: 0
    }
}
