package arrays;

/**
 * Solution to generate an array of n unique integers that sum to zero.
 * Problem: Given an integer n (1 <= n <= 1000), return any array containing n unique integers
 * such that they add up to 0.
 *
 * Sample Test Cases:
 * 1. n = 4
 *    - Valid Output: [2, 4, -4, -2] or [1, 2, -2, -1]
 *    - Sum: 2 + 4 + (-4) + (-2) = 0
 *    - Explanation: All integers are unique and sum to zero.
 * 2. n = 5
 *    - Valid Output: [1, 2, 0, -2, -1]
 *    - Sum: 1 + 2 + 0 + (-2) + (-1) = 0
 *    - Explanation: Includes zero for odd n, all integers unique.
 * 3. n = 3
 *    - Valid Output: [1, 0, -1]
 *    - Sum: 1 + 0 + (-1) = 0
 * 4. n = 1
 *    - Valid Output: [0]
 *    - Sum: 0 = 0
 * 5. n = 2
 *    - Valid Output: [1, -1]
 *    - Sum: 1 + (-1) = 0
 */
public class FindNUniqueIntegersThatSumUpToZero {
    /**
     * Generates an array of n unique integers that sum to zero.
     *
     * @param n The number of unique integers in the array (1 <= n <= 1000).
     * @return An array of n unique integers summing to zero.
     */
    public int[] sumZero(int n) {
        int[] result = new int[n];
        // Pair positive and negative integers to ensure sum is zero
        for (int i = 0; i < n / 2; i++) {
            result[i] = (i + 1) * 2;          // Positive integers: 2, 4, 6, ...
            result[n - 1 - i] = -(i + 1) * 2; // Negative integers: -2, -4, -6, ...
        }
        // For odd n, the middle element (at index n/2) remains 0 due to array initialization
        return result;
    }

    public static void main(String[] args) {
        FindNUniqueIntegersThatSumUpToZero solution = new FindNUniqueIntegersThatSumUpToZero();

        // Static test cases
        int[] testCases = {1, 2, 3, 4, 5, 6, 1000};
        for (int n : testCases) {
            int[] result = solution.sumZero(n);
            System.out.print("n = " + n + ": [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            // Verify sum
            int sum = 0;
            for (int num : result) sum += num;
            System.out.println("Sum: " + sum);
        }
    }
}