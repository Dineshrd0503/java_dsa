package codingninjas2monthchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class MatchSpecificPattern {


    public static ArrayList<String> findMatchedWords(int n, ArrayList<String> words, String pattern) {
        // Method to find all words matching the given pattern
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length())
                continue;

            HashMap<Character, Character> map = new HashMap<>();
            boolean isset = true;
            for (int i = 0; i < pattern.length(); i++) {
                char pchar = pattern.charAt(i);
                char wchar = word.charAt(i);
                if (map.containsKey(pchar)) {
                    if (map.get(pchar) != wchar) {
                        isset = false;
                        break;
                    }
                } else {
                    map.put(pchar, wchar);
                }
            }
            if (isset) {
                Set<Character> set = new HashSet<>(map.values());
                if (map.size() == set.size()) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample input
        System.out.println("Enter number of words:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> words = new ArrayList<>();

        System.out.println("Enter " + n + " words:");
        for (int i = 0; i < n; i++) {
            words.add(scanner.next());
        }

        System.out.println("Enter pattern:");
        String pattern = scanner.next();

        ArrayList<String> matchedWords = findMatchedWords(n, words, pattern);
        System.out.println("Matched words: " + matchedWords);
    }
}

/*
Problem Statement:
Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. Find all such words in the dictionary that match the given pattern.

Examples :
Input: n = 4, dict[] = {abb, abc, xyz, xyy}, pattern = foo
Output: abb xyy
Explanation: xyy and abb have the same character at index 1 and 2 like the pattern.

Expected Time Complexity: O(N*K) (where K is the length of the pattern).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10
*/