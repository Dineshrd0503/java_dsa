package strings;

import java.util.HashMap;

/**
 * Problem Statement:
 * ------------------
 * Given a string, count all *distinct vowels* in the string, and their frequencies.
 * Then return:
 *   (product of frequencies) * (permutations of distinct vowels)
 *
 * Explanation:
 * 1. Count how many vowels (a, e, i, o, u) occur in the string.
 * 2. Let n = number of distinct vowels.
 * 3. Compute: (freq1 * freq2 * ... * freqN) * (n!)
 *
 * Sample Input 1:
 * "aeiiouu"
 * Vowels: a=1, e=1, i=2, o=1, u=2
 * Distinct vowels: 5 => n! = 120
 * Total count = 1*1*2*1*2 * 120 = 480
 *
 * Sample Input 2:
 * "xyz"
 * Output: 0 (no vowels)
 */
public class CountUniqueVowelStrings {

    public int vowelCount(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of vowels
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        // No vowels found
        if (map.size() == 0) return 0;

        // Number of permutations of distinct vowels = map.size()!
        int permutationCount = findPermutations(map.size());

        // Product of all frequencies
        int frequencyProduct = 1;
        for (int freq : map.values()) {
            frequencyProduct *= freq;
        }

        // Final result = frequency product * permutations
        return frequencyProduct * permutationCount;
    }

    public static int findPermutations(int n) {
        if (n == 0 || n == 1) return 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        CountUniqueVowelStrings obj = new CountUniqueVowelStrings();

        // Sample Test Case 1
        String input1 = "aeiiouu";
        int result1 = obj.vowelCount(input1);
        System.out.println("Input: " + input1 + " → Output: " + result1);
        // Expected Output:
        // Vowel frequencies: a=1, e=1, i=2, o=1, u=2
        // Distinct vowels = 5 → 5! = 120
        // Product of frequencies = 1*1*2*1*2 = 4
        // Final result = 4 * 120 = 480

        // Sample Test Case 2
        String input2 = "xyz";
        int result2 = obj.vowelCount(input2);
        System.out.println("Input: " + input2 + " → Output: " + result2);
        // Expected Output: 0 (no vowels)

        // Sample Test Case 3
        String input3 = "aaee";
        int result3 = obj.vowelCount(input3);
        System.out.println("Input: " + input3 + " → Output: " + result3);
        // Expected Output:
        // Vowel frequencies: a=2, e=2
        // Distinct vowels = 2 => 2! = 2
        // Product of frequencies = 2*2 = 4
        // Final result = 4 * 2 = 8
    }
}

