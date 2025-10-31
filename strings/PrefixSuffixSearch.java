package strings;

/*
Naukri Code360 Problem: Prefix Suffix Search

Given a list of words, process Q queries. Each query gives a prefix and suffix.
For each query, return the largest index i such that words[i] starts with prefix and ends with suffix.
Return -1 if no such word exists.

Example:
Input:
3
cat bat rat
3
ca t
b t
rr t

Output:
0
1
-1
*/

import java.util.*;

public class PrefixSuffixSearch {
    static ArrayList<String> list = new ArrayList<>();

    // Adds words for each test case (clears list before adding!)
    public static void wordFilter(String[] words) {
        list.clear();
        for (String word : words)
            list.add(word);
    }

    // Finds the largest index with matching prefix and suffix
    public static int find(String prefix, String suffix) {
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word.startsWith(prefix) && word.endsWith(suffix))
                idx = i;
        }
        return idx;
    }

    // Sample main method to demonstrate usage
    public static void main(String[] args) {
        String[] words = {"cat", "bat", "rat"};
        wordFilter(words);

        System.out.println(find("ca", "t")); // Expected: 0
        System.out.println(find("b", "t"));  // Expected: 1
        System.out.println(find("rr", "t")); // Expected: -1

        // Another test case
        String[] words2 = {"apple", "apricot", "banana", "apply"};
        wordFilter(words2);
        System.out.println(find("ap", "e")); // Expected: 3 (for "apply")
        System.out.println(find("ban", "a")); // Expected: 2
        System.out.println(find("app", "t")); // Expected: 1
    }
}
