package greedyalgorithms;

/*
 * PROBLEM STATEMENT:
 * 3577. Count the Number of Computer Unlocking Permutations
 *
 * You are given an array 'complexity' of length 'n'.
 * There are 'n' LOCKED computers in a room with labels from 0 to n-1, each with its own unique password.
 * The password of computer 'i' has a complexity 'complexity[i]'.
 *
 * The password for computer labeled 0 is ALREADY decrypted and serves as the root.
 * All other computers must be unlocked using it or another previously unlocked computer:
 *
 * - You can decrypt the password for computer 'i' using the password for computer 'j',
 *   where 'j' is any integer less than 'i' with LOWER complexity.
 *   (i.e., j < i AND complexity[j] < complexity[i])
 *
 * - To decrypt computer 'i', you must have already unlocked a computer 'j' such that
 *   j < i AND complexity[j] < complexity[i].
 *
 * Find the number of PERMUTATIONS of [0, 1, 2, ..., (n-1)] that represent a valid
 * order in which computers can be unlocked, starting from computer 0.
 *
 * Return the answer MODULO 10^9 + 7.
 *
 * NOTE: The password for computer WITH LABEL 0 is decrypted, not the computer
 * at the first position in the permutation.
 *
 * EXAMPLES:
 * Example 1:
 *   Input: complexity = [1, 2, 3]
 *   Output: 2
 *   Explanation: Valid permutations are [0,1,2] and [0,2,1]
 *
 * Example 2:
 *   Input: complexity = [3, 3, 3, 4, 4, 4]
 *   Output: 0
 *   Explanation: No valid permutation exists (no unique minimum)
 *
 * CONSTRAINTS:
 * - 2 <= complexity.length <= 10^5
 * - 1 <= complexity[i] <= 10^9
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 *
 * KEY INSIGHT:
 * For a valid permutation to exist:
 * 1. Element at index 0 MUST have the UNIQUE minimum complexity
 * 2. If valid, answer = (n-1)! mod (10^9 + 7)
 *
 * WHY? Because computer 0 can unlock any computer with higher complexity.
 * Once computer 0 is unlocked, remaining (n-1) computers can be unlocked in ANY order.
 */

public class CountTheNoOfComputerUnlockingPermutations {

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        final long MOD = 1000000007;

        // Check if element at index 0 has unique minimum complexity
        int minComplexity = complexity[0];
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= minComplexity) {
                return 0;  // No valid permutation exists
            }
        }

        // If valid: return (n-1)! mod MOD
        long result = 1;
        for (int i = 1; i < n; i++) {
            result = (result * i) % MOD;
        }

        return (int) result;
    }

    // Main method to test the solution with examples
    public static void main(String[] args) {
        CountTheNoOfComputerUnlockingPermutations solution = new CountTheNoOfComputerUnlockingPermutations();


        // Test Case 1: Valid permutation with strictly increasing complexity
        int[] test1 = {1, 2, 3};
        System.out.println("Test Case 1:");
        System.out.println("Input: complexity = [1, 2, 3]");
        System.out.println("Output: " + solution.countPermutations(test1));
        System.out.println("Expected: 2");
        System.out.println("Explanation: Valid permutations are [0,1,2] and [0,2,1]");
        System.out.println();

        // Test Case 2: No valid permutation (duplicate minimum)
        int[] test2 = {3, 3, 3, 4, 4, 4};
        System.out.println("Test Case 2:");
        System.out.println("Input: complexity = [3, 3, 3, 4, 4, 4]");
        System.out.println("Output: " + solution.countPermutations(test2));
        System.out.println("Expected: 0");
        System.out.println("Explanation: No valid permutation (no unique minimum at index 0)");
        System.out.println();

        // Test Case 3: Two elements with unique minimum
        int[] test3 = {1, 5};
        System.out.println("Test Case 3:");
        System.out.println("Input: complexity = [1, 5]");
        System.out.println("Output: " + solution.countPermutations(test3));
        System.out.println("Expected: 1 (which is 1! = 1)");
        System.out.println("Explanation: Only one way: [0, 1]");
        System.out.println();

        // Test Case 4: Four elements with unique minimum
        int[] test4 = {2, 5, 7, 10};
        System.out.println("Test Case 4:");
        System.out.println("Input: complexity = [2, 5, 7, 10]");
        System.out.println("Output: " + solution.countPermutations(test4));
        System.out.println("Expected: 1 (which is 4! = 24)");
        System.out.println("Explanation: Only one way: [0, 1, 2, 3]");

    }
}

