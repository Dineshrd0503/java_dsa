package slidingwindow;


import java.util.HashMap;

/*
 * Problem: Longest Substring with Exactly K Distinct Characters
 * Find the length of the longest substring with exactly k distinct characters.
 *
 * Input:
 * - s: String of characters
 * - k: Number of distinct characters
 *
 * Output:
 * - Length of the longest substring with exactly k distinct characters, or -1 if none
 *
 * Example:
 * Test Case 1: s = "ababbc", k = 2, Output = 5 ("ababb")
 * Test Case 2: s = "aaaa", k = 2, Output = -1 (no substring with 2 distinct characters)
 * Test Case 3: s = "abcde", k = 3, Output = 3 (e.g., "abc")
 */
public class LongestSubStringWithKUniqueCharacters {
    public int longestKSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return -1;
        int left = 0, maxlen = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                left++;
            }
            if (map.size() == k)
                maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubStringWithKUniqueCharacters sol = new LongestSubStringWithKUniqueCharacters();
        String[] strings = {"ababbc", "aaaa", "abcde"};
        int[] kValues = {2, 2, 3};

        for (int t = 0; t < strings.length; t++) {
            int result = sol.longestKSubstr(strings[t], kValues[t]);
            System.out.println("Test Case " + (t + 1) + ": s = " + strings[t] + ", k = " + kValues[t] + ", Output = " + result);
        }
    }
}