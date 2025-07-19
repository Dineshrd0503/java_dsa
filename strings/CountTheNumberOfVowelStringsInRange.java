package strings;

import java.util.*;

/**
 * ✅ Problem Statement:
 * ---------------------
 * Given an array of lowercase strings `words`, and integers `left` and `right`,
 * your job is to **count how many strings in the subarray words[left] to words[right] (inclusive)**
 * start **and** end with a **vowel**.
 *
 * The vowels are: {a, e, i, o, u}
 *
 * Notes:
 * - A single-character word counts if the character is a vowel.
 *
 * ✅ Constraints:
 * - 1 <= words.length <= 1000
 * - 0 <= left <= right < words.length
 * - Each word consists of only lowercase English letters.
 *
 * ✅ Sample Input 1:
 * String[] words = {"apple", "eye", "tree", "owl", "x", "ice"};
 * left = 0, right = 4
 *
 * ✅ Sample Output 1:
 * 3
 * → Matches: "apple", "eye", "owl"
 *
 */
public class CountTheNumberOfVowelStringsInRange{

    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;

        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.length() == 1) {
                if (vowels.contains(word.charAt(0))) {
                    count++;
                }
            } else {
                if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountTheNumberOfVowelStringsInRange obj = new CountTheNumberOfVowelStringsInRange();

        // ✅ Sample Test Case 1
        String[] words1 = {"apple", "eye", "tree", "owl", "x", "ice"};
        int result1 = obj.vowelStrings(words1, 0, 4);
        System.out.println("Test 1 Output: " + result1); // Expected: 3

        // ✅ Sample Test Case 2
        String[] words2 = {"dog", "cat", "a", "idea", "eagle", "sun", "oil"};
        int result2 = obj.vowelStrings(words2, 1, 6);
        System.out.println("Test 2 Output: " + result2); // Expected: 3

        // ✅ Sample Test Case 3
        String[] words3 = {"ice", "eye", "ear", "end", "and"};
        int result3 = obj.vowelStrings(words3, 0, 4);
        System.out.println("Test 3 Output: " + result3); // Expected: 4
    }
}
