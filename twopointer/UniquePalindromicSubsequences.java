package twopointer;

/*
LeetCode Problem: Unique Length-3 Palindromic Subsequences
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

A palindrome is a string that reads the same forwards and backwards ("aba", "aaa", etc).
A subsequence is a string derived from another string by deleting some or no characters without changing the order of the remaining characters.

Example:
Input: s = "aabca"
Output: 3 ("aba", "aca", "aaa")
*/

import java.util.*;

public class UniquePalindromicSubsequences {
    public static int countPalindromicSubsequence(String s) {
        // We only need to consider 'c_x c c_x' where c_x is any lower case character.
        // Use a set to store unique palindromic subsequences.
        Set<String> palindromes = new HashSet<>();

        // All lowercase letters
        for(char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);
            if(left == -1 || right - left < 2) continue; // Need at least one char in between

            // Collect unique characters in between left and right
            Set<Character> middleChars = new HashSet<>();
            for(int i = left + 1; i < right; i++) {
                middleChars.add(s.charAt(i));
            }
            // For each possible middle character, "c_x m c_x" is a palindrome
            for(char m : middleChars) {
                palindromes.add("" + c + m + c);
            }
        }
        return palindromes.size();
    }

    public static void main(String[] args) {
        // Example inputs
        String s1 = "aabca";
        String s2 = "adc";
        String s3 = "bbcbaba";

        System.out.println(countPalindromicSubsequence(s1)); // Output: 3
        System.out.println(countPalindromicSubsequence(s2)); // Output: 0
        System.out.println(countPalindromicSubsequence(s3)); // Output: 4
    }
}
