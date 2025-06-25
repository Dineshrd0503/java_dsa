package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem: Minimum Deletions to Make Character Frequencies Unique
 * Given a string s, return the minimum number of characters to delete to make
 * all character frequencies unique.
 *
 * Input:
 * - T: Number of test cases (hardcoded as 3)
 * - For each test case:
 *   - s: String of lowercase letters
 *
 * Output:
 * - For each test case, an integer representing minimum deletions
 *
 * Example:
 * Test Case 1: s = "aab"
 * Output: 0 (Frequencies {'a': 2, 'b': 1} are unique)
 * Test Case 2: s = "aaabbbcc"
 * Output: 2 (Delete 1 'b', 1 'c' → {'a': 3, 'b': 2, 'c': 1})
 * Test Case 3: s = "ceabaacb"
 * Output: 2 (Delete 2 'b's → {'c': 2, 'e': 1, 'a': 3, 'b': 0})
 *
 * Constraints:
 * - 1 <= s.length() <= 10^5
 * - s contains only lowercase letters
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique
       {
    /*
     * Returns minimum deletions to make character frequencies unique.
     * @param s Input string
     * @return Minimum deletions needed
     */
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Set<Integer> seenFrequencies = new HashSet<>();
        int deletions = 0;

        for (int frequency : freqMap.values()) {
            while (frequency > 0 && seenFrequencies.contains(frequency)) {
                frequency--;
                deletions++;
            }
            seenFrequencies.add(frequency);
        }

        return deletions;
    }

    /*
     * Main method with static inputs for test cases.
     */
    public static void main(String[] args) {
        // Static test cases (hardcoded as per the problem statement)
        MinimumDeletionsToMakeCharacterFrequenciesUnique solution =
                new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        String[] testCases = {"aab", "aaabbbcc", "ceabaacb"};

        for (int t = 0; t < testCases.length; t++) {
            int result = solution.minDeletions(testCases[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}