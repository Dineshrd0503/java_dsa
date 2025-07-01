package strings;


import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Count Substrings with Exactly K Distinct Characters
 * Count substrings of length k in string s with exactly k distinct characters.
 * Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.

Examples:

Input: s = "abcc", k = 2
Output: 1
Explaination: Possible substring of length k = 2 are,
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct characters
Only one valid substring so, count is equal to 1.
Input: "aabab", k = 3
Output: 3
Explaination: Possible substring of length k = 3 are,
aab : 2 distinct charcters
aba : 2 distinct characters
bab : 2 distinct characters
All these substring are valid so, the total count is equal to 3.
Constrains:
1 ≤ s.size() ≤ 105
2 ≤ k ≤ 27
 *
 */
public class SubstringsOfLengthkWithKMinus1DistinctElements {
    public int substrCount(String s, int k) {
        int count = 0;
        int n = s.length();

        if (n < k) {
            return 0;
        }

        for (int i = 0; i <= n - k; i++) {
            String sub = s.substring(i, i + k);
            Map<Character, Integer> charCounts = new HashMap<>();
            for (char c : sub.toCharArray()) {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
            if (charCounts.size() == k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SubstringsOfLengthkWithKMinus1DistinctElements sol = new SubstringsOfLengthkWithKMinus1DistinctElements();
        String[] strings = {"aba", "aabb", "aaaa"};
        int[] kValues = {2, 3, 3};

        for (int t = 0; t < strings.length; t++) {
            int result = sol.substrCount(strings[t], kValues[t]);
            System.out.println("Test Case " + (t + 1) + ": s = " + strings[t] + ", k = " + kValues[t] + ", Output = " + result);
        }
    }
}
