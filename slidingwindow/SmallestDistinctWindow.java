package slidingwindow;

/*
Problem Statement:
Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

Example:
Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.

Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.

Input: str = "geeksforgeeks"
Output: 8
Explanation: There are multiple substrings with the smallest length that contain all characters of str, "geeksfor" and "forgeeks".

Constraints:
1 ≤ str.size() ≤ 10^5
str contains only lower-case English alphabets.

Sample Test Cases:
- Test Case 1:
  Input: str = "aabcbcdbca"
  Output: 4
- Test Case 2:
  Input: str = "aaab"
  Output: 2
- Test Case 3:
  Input: str = "geeksforgeeks"
  Output: 8
*/

import java.util.HashMap;
import java.util.HashSet;

public class SmallestDistinctWindow {
    public int findSubString(String str) {
        // Step 1: Find unique characters using HashSet
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        int left = 0;
        int totalchars = set.size(), len = Integer.MAX_VALUE;

        // Step 2: Use sliding window to find the smallest window
        for (int right = 0; right < str.length(); right++) {
            char currchar = str.charAt(right);
            map.put(currchar, map.getOrDefault(currchar, 0) + 1);
            while (map.size() == totalchars) {
                len = Math.min(len, right - left + 1);
                char leftchar = str.charAt(left);
                map.put(leftchar, map.get(leftchar) - 1);
                if (map.get(leftchar) == 0) {
                    map.remove(leftchar);
                }
                left++;
            }
        }

        // Step 3: Return the result
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }

    public static void main(String[] args) {
        SmallestDistinctWindow solution = new SmallestDistinctWindow();

        // Test Case 1
        String test1 = "aabcbcdbca";
        System.out.println("Test Case 1:");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + solution.findSubString(test1));

        // Test Case 2
        String test2 = "aaab";
        System.out.println("\nTest Case 2:");
        System.out.println("Input: " + test2);
        System.out.println("Output: " + solution.findSubString(test2));

        // Test Case 3
        String test3 = "geeksforgeeks";
        System.out.println("\nTest Case 3:");
        System.out.println("Input: " + test3);
        System.out.println("Output: " + solution.findSubString(test3));
    }
}
