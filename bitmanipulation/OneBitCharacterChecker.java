package bitmanipulation;

/**
 * Problem: One-Bit and Two-Bit Characters
 *
 * You are given an array of bits.
 * - A one-bit character is represented by a single `0`.
 * - A two-bit character is represented by either `10` or `11`.
 *
 * The input always ends with a `0`. Return `true` if the last character must be a one-bit character.
 *
 * Examples:
 * Input: bits = [1, 0, 0]
 * Output: true
 * Explanation: The only way to decode it is [10, 0], so the last character is one-bit.
 *
 * Input: bits = [1, 1, 1, 0]
 * Output: false
 * Explanation: The only way to decode it is [11, 10], so the last character is not one-bit.
 *
 * Constraints:
 * 1 <= bits.length <= 1000
 * bits[i] is either 0 or 1
 */

public class OneBitCharacterChecker {

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2; // two-bit character
            } else {
                i += 1; // one-bit character
            }
        }
        return i == bits.length - 1;
    }

    // Test driver
    public static void main(String[] args) {
        int[] test1 = {1, 0, 0};
        int[] test2 = {1, 1, 1, 0};
        int[] test3 = {0};  // edge case

        System.out.println("Test 1: " + isOneBitCharacter(test1)); // true
        System.out.println("Test 2: " + isOneBitCharacter(test2)); // false
        System.out.println("Test 3: " + isOneBitCharacter(test3)); // true
    }
}
