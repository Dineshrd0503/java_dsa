package slidingwindow;

/*
    Problem Statement:
    Given two strings, STR (main string) and PTR (pattern),
    find and return all starting indices of substrings in STR that are anagrams of PTR.
    - STR: The main string where you search for anagrams.
    - PTR: The pattern whose anagrams need to be found in STR.

    Example:
    Input: STR = "CBAEBABACD", PTR = "ABC"
    Output: [0, 6]
    Explanation: The substrings starting at indices 0 ("CBA") and 6 ("BAC") are anagrams of "ABC".
*/

import java.util.*;

public class AnagramIndicesFinder {
    public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] ptrfreq = new int[26];
        int[] windowfreq = new int[26];

        // Build frequency array for PTR
        for (char c : ptr.toCharArray()) {
            ptrfreq[c - 'A']++;
        }

        // Slide a window of length m across str
        for (int i = 0; i < n; i++) {
            windowfreq[str.charAt(i) - 'A']++;
            // Remove oldest character when window size exceeds m
            if (i >= m)
                windowfreq[str.charAt(i - m) - 'A']--;
            // If window size equals m, compare with ptrfreq
            if (i >= m - 1 && Arrays.equals(ptrfreq, windowfreq))
                result.add(i - m + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        String STR1 = "CBAEBABACD";
        int n1 = STR1.length();
        String PTR1 = "ABC";
        int m1 = PTR1.length();

        ArrayList<Integer> indices = findAnagramsIndices(STR1, n1, PTR1, m1);
        System.out.println(indices); // Output: [0, 6]
    }
}
