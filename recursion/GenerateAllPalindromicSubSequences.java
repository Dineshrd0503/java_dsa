package recursion;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:

Given a string s, find all possible ways to partition it such that every substring in the partition is a palindrome.

Examples:

Input: s = "geeks"
Output: [[g, e, e, k, s], [g, ee, k, s]]
Explanation: [g, e, e, k, s] and [g, ee, k, s] are the only partitions of "geeks" where each substring is a palindrome.

Input: s = "abcba"
Output: [[a, b, c, b, a], [a, bcb, a], [abcba]]
Explanation: [a, b, c, b, a], [a, bcb, a] and [abcba] are the only partitions of "abcba" where each substring is a palindrome.

Constraints:
1 <= s.size() <= 20
*/

public class GenerateAllPalindromicSubSequences {

    /**
     * Finds all possible palindromic partitions of a string.
     *
     * @param s The input string.
     * @return An ArrayList of ArrayLists of Strings representing all palindromic partitions.
     */
    public ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Recursive helper function to find all palindromic partitions using backtracking.
     *
     * @param s               The input string.
     * @param start           The starting index for partitioning.
     * @param currentPartition The current partition being built.
     * @param result          The list to store all valid partitions.
     */
    private void backtrack(String s, int start, List<String> currentPartition, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition)); // Add a copy!
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                backtrack(s, end + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1); // Backtrack
            }
        }
    }

    /**
     * Checks if a given string is a palindrome.
     *
     * @param s The string to check.
     * @return True if the string is a palindrome, false otherwise.
     */
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        GenerateAllPalindromicSubSequences sol = new GenerateAllPalindromicSubSequences();

        // Sample test cases
        String s1 = "geeks";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.palinParts(s1));
        // Expected Output: [[g, e, e, k, s], [g, ee, k, s]]

        String s2 = "abcba";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + sol.palinParts(s2));
        // Expected Output: [[a, b, c, b, a], [a, bcb, a], [abcba]]

        String s3 = "aab";
        System.out.println("\nInput: " + s3);
        System.out.println("Output: " + sol.palinParts(s3));
        // Expected Output: [[a, a, b], [aa, b]]

        String s4 = "kayak";
        System.out.println("\nInput: " + s4);
        System.out.println("Output: " + sol.palinParts(s4));
        // Expected Output: [[k, a, y, a, k], [k, aya, k], [kayak]]
    }
}