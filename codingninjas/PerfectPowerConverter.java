package codingninjas;

/**
 * Problem Statement:
 * You are given an integer ‘N’. You have to convert this number into a perfect power of ‘2’ by applying the given operation any number of times.
 * In a single operation, you can turn off a pair of set bits in the given number. Here, a set bit represents a ‘1’ in the binary representation of a number.
 * Return '1' if it is possible to convert the given number into a perfect power of ‘2’; otherwise, return '0'.
 *
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 10^9
 * Time Limit: 1 sec
 *
 * Sample Input 1:
 * T = 2
 * N = 19
 * N = 15
 * Sample Output 1:
 * 1
 * 0
 * Explanation:
 * For N = 19:
 * - Binary: 10011 (three 1s).
 * - Turn off the last two bits: 10011 → 10000 (16, which is 2^4).
 * - Output: 1 (possible).
 * For N = 15:
 * - Binary: 1111 (four 1s).
 * - First operation: 1111 → 1100 (two 1s).
 * - Second operation: 1100 → 0000 (zero 1s, not a power of 2).
 * - Cannot reach exactly one 1.
 * - Output: 0 (not possible).
 *
 * Sample Input 2:
 * T = 2
 * N = 17
 * N = 16
 * Sample Output 2:
 * 0
 * 1
 * Explanation:
 * For N = 17:
 * - Binary: 10001 (two 1s).
 * - One operation: 10001 → 00000 (zero 1s).
 * - Output: 0 (not possible).
 * For N = 16:
 * - Binary: 10000 (one 1).
 * - Already a power of 2 (2^4).
 * - Output: 1 (possible).
 */
public class PerfectPowerConverter {
    /**
     * Determines if a number can be converted to a perfect power of 2 by turning off pairs of set bits.
     * @param n The input number.
     * @return 1 if possible, 0 if not.
     */
    static int perfectPower(int n) {
        // Count the number of 1s in the binary representation of n
        int bitCount = Integer.bitCount(n);

        // If the number of 1s is odd, we can reduce to exactly one 1
        // If even, we cannot (we'll reach 0, 2, 4, etc. 1s)
        return (bitCount % 2 == 1) ? 1 : 0;
    }

    /**
     * Main method to test the solution with static inputs.
     */
    public static void main(String[] args) {
        // Static test cases (Sample Input 1 and Sample Input 2)
        int[] testCases = {
                19,  // Test case 1
                15,  // Test case 2
                17,  // Test case 3
                16   // Test case 4
        };

        int[] expectedOutputs = {
                1,  // Expected for N = 19
                0,  // Expected for N = 15
                0,  // Expected for N = 17
                1   // Expected for N = 16
        };

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            int expected = expectedOutputs[i];
            int result = perfectPower(n);

            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: N = " + n);
            System.out.println("Binary: " + Integer.toBinaryString(n));
            System.out.println("Expected Output: " + expected);
            System.out.println("Actual Output: " + result);
            System.out.println("Status: " + (result == expected ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}