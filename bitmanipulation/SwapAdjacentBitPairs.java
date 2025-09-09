package bitmanipulation;
/**
 * Solution to swap adjacent bits in an integer n.
 * Problem: Given an integer n, swap its adjacent bits in the 32-bit binary representation.
 * For example, if n = 10 (binary 000...0001010), swap bits (0,1), (2,3), etc., to get 000...0000101 (5).
 *
 * Sample Test Cases:
 * 1. n = 10 (binary 000...0001010)
 *    - Expected Output: 5 (binary 000...0000101)
 *    - Explanation: Bits 0,1 swap (10 -> 01), bits 2,3 swap (10 -> 01).
 * 2. n = 7 (binary 000...0000111)
 *    - Expected Output: 11 (binary 000...0001011)
 *    - Explanation: Bits 0,1 swap (11 -> 11), bits 2,3 swap (10 -> 01).
 * 3. n = 0 (binary 000...0000000)
 *    - Expected Output: 0 (binary 000...0000000)
 *    - Explanation: No bits to swap, result is 0.
 * 4. n = -10 (binary 111...1110110)
 *    - Expected Output: -5 (binary 111...1111011)
 *    - Explanation: Swaps occur in the lower bits, sign bit remains.
 * 5. n = 4294967295 (binary 111...1111111, max unsigned int)
 *    - Expected Output: 4294967295 (binary 111...1111111)
 *    - Explanation: All 1s remain 1s after swapping.
 */
public class SwapAdjacentBitPairs{
    /**
     * Swaps adjacent bits in the 32-bit binary representation of n.
     *
     * @param n The input integer.
     * @return The integer after swapping adjacent bits.
     */
    public static int swapAdjacent(int n) {
        // Create a mask to extract even bits (bits at positions 1, 3, 5, ...)
        int evenBitsMask = 0xAAAAAAAA; // 10101010... in binary (32 bits)

        // Create a mask to extract odd bits (bits at positions 0, 2, 4, ...)
        int oddBitsMask = 0x55555555;  // 01010101... in binary (32 bits)

        // Extract even bits and shift them right by 1 (move to odd positions)
        int evenBits = (n & evenBitsMask) >>> 1;

        // Extract odd bits and shift them left by 1 (move to even positions)
        int oddBits = (n & oddBitsMask) << 1;

        // Combine the shifted even and odd bits using bitwise OR
        return evenBits | oddBits;
    }

    public static void main(String[] args) {
        // Static test cases
        int[] testCases = {10, 7, 0, -10, 42};
        for (int n : testCases) {
            int result = swapAdjacent(n);
            System.out.println("Input: n = " + n + " (binary: " + String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0') + ")");
            System.out.println("Output: " + result + " (binary: " + String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0') + ")");
            System.out.println();
        }
    }
}
