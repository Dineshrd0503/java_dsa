package  bitmanipulation;

/*
================================================================================
PROBLEM STATEMENT:
================================================================================
Given a positive integer 'n', your task is to find the next smallest integer
and the previous largest integer having the exact number of '1' bits set in
their binary representation as 'n'.

EXAMPLE:
n = 6
The binary representation of 6 = '0110', which has two '1' bits set.
Next smallest integer = 9 = '1001', the smallest integer greater than 6
  having two '1' bits set.
Previous largest integer = 5 = '0101', largest integer smaller than 6
  having two '1' bits set.
Therefore, the answer is {9, 5}.

CONSTRAINTS:
1. n is a positive integer greater than one.
2. For any given integer 'n', there is always a positive integer smaller than 'n'
   having the exact number of '1' bits set.
3. n can have a max of '30' bits.
4. Time limit: 1 second

INPUT:
T - number of test cases
For each test case: n - the given integer

OUTPUT:
For each test case: Print next smallest integer and previous largest integer
having the same number of set bits as n.

EXAMPLE INPUT:
2
6
9

EXAMPLE OUTPUT:
9 5
10 6
================================================================================
*/

public class NearestNumbersSameSetBits {

    /**
     * Main method to solve the problem with static test cases
     */
    public static void main(String[] args) {
        // Static test cases
        long[] testCases = {6, 9, 4, 5, 12, 8};

        System.out.println("Nearest Numbers with Same Number of Set Bits");
        System.out.println("=".repeat(60));

        for (long n : testCases) {
            long[] result = nearestNumbers(n);
            long next = result[0];
            long prev = result[1];

            System.out.println("\nInput: n = " + n);
            System.out.println("Binary: " + toBinaryString(n) + " (Set bits: " + countSetBits(n) + ")");
            System.out.println("Output: " + next + " " + prev);
            System.out.println("  Next binary: " + toBinaryString(next) + " (Set bits: " + countSetBits(next) + ")");
            System.out.println("  Prev binary: " + toBinaryString(prev) + " (Set bits: " + countSetBits(prev) + ")");
        }
    }

    /**
     * Find next smallest and previous largest numbers with same set bits count
     *
     * @param n - the given positive integer
     * @return array containing {nextSmallest, previousLargest}
     */
    public static long[] nearestNumbers(long n) {
        long next = getNext(n);
        long prev = getPrev(n);
        return new long[]{next, prev};
    }

    private static long getNext(long n) {
        // Step 1: Find rightmost 1-bit
        // Using two's complement: -x = ~x + 1
        // n & -n gives the rightmost 1-bit
        long rightOne = n & -n;

        // Step 2: Add rightOne to get next higher bit
        long nextHigherOneBit = n + rightOne;

        // Step 3: Find all bits that changed (flipped)
        long rightOnesPattern = n ^ nextHigherOneBit;

        // Step 4: Shift right and adjust the pattern
        rightOnesPattern = rightOnesPattern / rightOne;
        rightOnesPattern >>= 2;

        // Step 5: Combine to form the final answer
        return nextHigherOneBit | rightOnesPattern;
    }

    private static long getPrev(long n) {
        // Step 1: Find rightmost 1-bit
        long rightOne = n & -n;

        // Step 2: Clear the rightmost 1-bit
        long leftOnesPattern = n - rightOne;

        // Step 3: Create pattern of 1s for the right side
        long rightOnesCount = rightOne - 1;

        // Step 4: Get the overlapping pattern
        long rightOnesPattern = rightOnesCount & leftOnesPattern;

        // Step 5: XOR to create final pattern
        rightOnesPattern = rightOnesCount ^ rightOnesPattern;

        // Step 6: Combine to form the final answer
        return leftOnesPattern | rightOnesPattern;
    }


    private static int countSetBits(long n) {
        return Long.bitCount(n);
    }

    private static String toBinaryString(long n) {
        return Long.toBinaryString(n);
    }
}
