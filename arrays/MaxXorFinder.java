package arrays;


/**
 * Problem Statement:
 * You have an integer array ‘A’ of the form [x, x+1, x+2, x+3, …]. As the array is vast in size,
 * you are given both endpoints of the array, i.e., if you are given two integers ‘L’ and ‘R’,
 * the array ‘A’ will be [L, L+1, L+2, …, R-1, R]. Your task is to find the maximum possible value
 * of ‘X’ such that the following two conditions hold:
 * 1. a ⊕ b = X, where ⊕ denotes the bitwise XOR operation.
 * 2. Both numbers ‘a’ and ‘b’ belong to the array ‘A’.
 *
 * Constraints:
 * - 1 <= T <= 10^3
 * - 1 <= L <= R <= 10^9
 * - Time Limit: 1 sec
 *
 * Sample Input 1:
 * 2
 * 8 20
 * 1 3
 * Sample Output 1:
 * 31
 * 3
 * Explanation for Sample Input 1:
 * Case 1: The array is [8, 9, 10, ..., 18, 19, 20]. The pair (15, 16) gives the maximum XOR value:
 * 15 ⊕ 16 = 31.
 * Case 2: The array is [1, 2, 3]. The pair (2, 3) gives the maximum XOR value: 2 ⊕ 3 = 3.
 *
 * Sample Input 2:
 * 2
 * 4 10
 * 4 7
 * Sample Output 2:
 * 15
 * 3
 * Explanation for Sample Input 2:
 * Case 1: The array is [4, 5, 6, 7, 8, 9, 10]. The pair (7, 8) gives the maximum XOR value:
 * 7 ⊕ 8 = 15.
 * Case 2: The array is [4, 5, 6, 7]. The pair (4, 7) gives the maximum XOR value: 4 ⊕ 7 = 3.
 */
public class MaxXorFinder {

    /**
     * Finds the maximum possible value of X such that X = a ⊕ b, where a and b are numbers
     * in the range [L, R], and ⊕ denotes the bitwise XOR operation.
     *
     * @param L The left endpoint of the range.
     * @param R The right endpoint of the range.
     * @return The maximum possible value of a ⊕ b for any a, b in [L, R].
     */
    public static int maxXor(int L, int R) {
        // Step 1: Compute L ⊕ R to find differing bits
        int xor = L ^ R;

        // Step 2: Find the most significant bit position of L ⊕ R
        int msb = 0;
        while (xor > 0) {
            msb++;
            xor >>= 1;
        }

        // Step 3: Maximum XOR is 2^msb - 1
        return (1 << msb) - 1;
    }

    /**
     * Main method to test the maxXor method with static inputs (sample test cases).
     */
    public static void main(String[] args) {
        // Test Case 1: L = 8, R = 20
        int L1 = 8, R1 = 20;
        System.out.println("Test Case 1: L = " + L1 + ", R = " + R1);
        System.out.println("Output: " + maxXor(L1, R1)); // Expected: 31

        // Test Case 2: L = 1, R = 3
        int L2 = 1, R2 = 3;
        System.out.println("\nTest Case 2: L = " + L2 + ", R = " + R2);
        System.out.println("Output: " + maxXor(L2, R2)); // Expected: 3

        // Test Case 3: L = 4, R = 10
        int L3 = 4, R3 = 10;
        System.out.println("\nTest Case 3: L = " + L3 + ", R = " + R3);
        System.out.println("Output: " + maxXor(L3, R3)); // Expected: 15

        // Test Case 4: L = 4, R = 7
        int L4 = 4, R4 = 7;
        System.out.println("\nTest Case 4: L = " + L4 + ", R = " + R4);
        System.out.println("Output: " + maxXor(L4, R4)); // Expected: 3
    }
}