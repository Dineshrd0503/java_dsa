package strings;

import java.util.HashMap;

/*
Problem Statement:

Given a string `s`, return the number of distinct strings that can be obtained by exactly one swap of two different indices (i < j).

Examples:

Input: s = "geek"
Output: 6
Explanation: After one swap, there are only 6 distinct strings possible (i.e., "egek", "eegk", "geek", "geke", "gkee", "keeg").

Input: s = "aaaa"
Output: 1
Explanation: Only one distinct string is possible after one swap (i.e., "aaaa").

Constraints:
2 ≤ s.size() ≤ 10^4
*/



public class ExactlyOneSwap {

    public static int countStrings(String s) {
        int n = s.length();

        // Calculate total possible pairs of swaps (i, j)
        long totalPairs = (long) n * (n - 1) / 2;

        // Count frequency of each character using HashMap
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Calculate duplicate pairs
        long duplicatePairs = 0;
        boolean hasDuplicateChar = false;

        for (int f : freqMap.values()) {
            if (f > 1) {
                hasDuplicateChar = true;
                duplicatePairs += (long) f * (f - 1) / 2;
            }
        }

        // Calculate the final distinct string count
        long distinct = totalPairs - duplicatePairs;

        // If there are duplicate characters, add 1 for the original string
        if (hasDuplicateChar) {
            distinct += 1;
        }

        return (int) distinct;
    }

    public static void main(String[] args) {

        // Sample test cases
        System.out.println("Input: geek -> Output: " + countStrings("geek")); // Expected Output: 6
        System.out.println("Input: aaaa -> Output: " + countStrings("aaaa")); // Expected Output: 1

        // Additional test cases
        System.out.println("Input: ab -> Output: " + countStrings("ab")); // Expected Output: 1
        System.out.println("Input: aabb -> Output: " + countStrings("aabb")); // Expected Output: 6
        System.out.println("Input: abcde -> Output: " + countStrings("abcde")); // Expected Output: 10
    }
}

