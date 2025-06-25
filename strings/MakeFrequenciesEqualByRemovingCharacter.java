package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Equal Character Frequencies
 * Given a string s, determine if it is possible to remove exactly one character
 * to make all remaining characters have equal frequencies.
 *
 * Input:
 * - T: Number of test cases (hardcoded as 3)
 * - For each test case:
 *   - s: String of lowercase letters
 *
 * Output:
 * - For each test case, a boolean indicating if such a removal is possible
 *
 * Example:
 * Test Case 1: s = "ababc"
 * Output: true (Remove 'c' to get "abab" with frequencies {'a': 2, 'b': 2})
 * Test Case 2: s = "aabbcc"
 * Output: true (Initial frequencies {'a': 2, 'b': 2, 'c': 2} are equal)
 * Test Case 3: s = "aabbc"
 * Output: false (No single removal results in equal frequencies)
 *
 * Constraints:
 * - 1 <= T <= 10^5
 * - 1 <= s.length() <= 10^5
 * - s contains only lowercase letters
 */
public class MakeFrequenciesEqualByRemovingCharacter {
    /*
     * Determines if removing one character results in equal frequencies.
     * @param s Input string
     * @return true if possible, false otherwise
     */
    boolean sameFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (isequal(map)) {
            return true;
        }

        // Create a copy of keys to avoid ConcurrentModificationException
        for (char c : new ArrayList<>(map.keySet())) {
            int original = map.get(c);
            map.put(c, original - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
            if (isequal(map)) {
                return true;
            }
            map.put(c, original);
        }
        return false;
    }

    /*
     * Checks if all frequencies in the map are equal.
     * @param map Map of character frequencies
     * @return true if all frequencies are equal, false otherwise
     */
    private static boolean isequal(HashMap<Character, Integer> map) {
        int target = -1;
        for (int freq : map.values()) {
            if (target == -1) {
                target = freq;
            } else if (freq != target) {
                return false;
            }
        }
        return true;
    }

    /*
     * Main method with static inputs for test cases.
     */
    public static void main(String[] args) {
        MakeFrequenciesEqualByRemovingCharacter solution = new MakeFrequenciesEqualByRemovingCharacter();
        String[] testCases = {"ababc", "aabbcc", "aabbc"};

        for (int t = 0; t < testCases.length; t++) {
            boolean result = solution.sameFreq(testCases[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}
