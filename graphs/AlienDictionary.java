package graphs;

/**
 * Problem Statement:
 * A new alien language uses the English alphabet, but the order of letters is unknown.
 * You are given a list of words[] from the alien language’s dictionary, where the words
 * are sorted lexicographically according to the language’s rules. Determine the correct
 * order of letters in this alien language. If the order is valid, return the letters in
 * lexicographical order. If there are multiple valid orders, return any one. If the words
 * are inconsistent with any possible ordering, return an empty string ("").
 *
 * Example:
 * Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
 * Output: "bdac" (or other valid orders like "bdca")
 * Explanation:
 * - "baa" < "abcd" → 'b' before 'a'
 * - "abcd" < "abca" → 'd' before 'a'
 * - "abca" < "cab" → 'a' before 'c'
 * - "cab" < "cad" → 'b' before 'd'
 *
 * Constraints:
 * 1 ≤ words.length ≤ 500
 * 1 ≤ words[i].length ≤ 100
 * words[i] consists of lowercase English letters.
 */

import java.util.*;

public class AlienDictionary {

    public String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        // Initialize graph and in-degree map
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Build graph by comparing consecutive words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDiff = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    // Add edge from c1 to c2 if not already present
                    if (graph.get(c1).add(c2)) {
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    foundDiff = true;
                    break;
                }
            }

            // Check if word1 is longer than word2 with the same prefix
            if (!foundDiff && word1.length() > word2.length()) {
                return "";
            }
        }

        // Perform topological sort using BFS (Kahn's algorithm)
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);

            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if all characters were included (no cycles)
        return order.length() == graph.size() ? order.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionary solver = new AlienDictionary();

        // Test Case 1 (Example from problem statement)
        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(solver.findOrder(words1)); // Output: "bdac" or similar

        // Test Case 2
        String[] words2 = {"caa", "aaa", "aab"};
        System.out.println(solver.findOrder(words2)); // Output: "cab"

        // Test Case 3 (Invalid case)
        String[] words3 = {"ab", "cd", "ef", "ad"};
        System.out.println(solver.findOrder(words3)); // Output: ""

        // Test Case 4 (Single character)
        String[] words4 = {"z", "z"};
        System.out.println(solver.findOrder(words4)); // Output: "z"

        // Test Case 5 (Invalid prefix case)
        String[] words5 = {"abc", "ab"};
        System.out.println(solver.findOrder(words5)); // Output: ""
    }
}

