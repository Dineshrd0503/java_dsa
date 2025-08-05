package strings;
/*
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

public class FirstUniqueCharacterFreqArray{
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; // Frequency array to store the count of each lowercase letter

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;  // Increment the count of the character c
        }

        // Iterate through the string to find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            // If the character at index i has a frequency of 1, it's the first unique character
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }

        // If no unique character is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterFreqArray solution = new FirstUniqueCharacterFreqArray();

        // Test cases
        String s1 = "leetcode";
        System.out.println("First unique character in \"" + s1 + "\" is at index: " + solution.firstUniqChar(s1)); // Output: 0

        String s2 = "loveleetcode";
        System.out.println("First unique character in \"" + s2 + "\" is at index: " + solution.firstUniqChar(s2)); // Output: 2

        String s3 = "aabb";
        System.out.println("First unique character in \"" + s3 + "\" is at index: " + solution.firstUniqChar(s3)); // Output: -1
    }
}
