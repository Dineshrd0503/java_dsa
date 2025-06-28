package strings;

import java.util.*;
import java.io.*;

/*
Problem Statement:
You are given a string 'S' of length 'N', you need to find the frequency of each of the characters from ‘a’ to ‘z’ in the given string.

Example:
Given 'S' : abcdg
Then output will be : 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
*/

public class CountFrequenciesOfCharacters {

    public static int[] findFrequency(String S) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            frequencyMap.put(c, 0);
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            frequencyMap.put(c, frequencyMap.get(c) + 1);
        }

        int[] frequencies = new int[26];
        for (int i = 0; i < 26; i++) {
            frequencies[i] = frequencyMap.get((char) ('a' + i));
        }

        return frequencies;
    }

    public static void main(String[] args) {
        // Static Input for testing
        String[] testCases = {"abaaba", "bbcccaaaa", "z", "abc"};

        for (String testCase : testCases) {
            int[] result = findFrequency(testCase);
            System.out.println("Input String: " + testCase);
            System.out.print("Frequencies: ");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println(); // New line for next test case
        }
    }
}
