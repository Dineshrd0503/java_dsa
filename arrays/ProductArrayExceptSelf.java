package arrays;

/**
 * Problem Statement:
 * You have been given an integer array/list (ARR) of size N. You have to return an array/list PRODUCT such that
 * PRODUCT[i] is equal to the product of all the elements of ARR except ARR[i].
 * Each product can cross integer limits, so take modulo of the operation with MOD = 10^9 + 7.
 * Follow-up: Solve the problem in O(1) space (excluding the output array).
 *
 * Constraints:
 * 1 <= T <= 100
 * 0 <= N <= 10^5
 * 0 <= ARR[i] <= 10^5
 * Time Limit: 1 sec
 *
 * Sample Input 1:
 * T = 2
 * Test Case 1: N = 3, ARR = [1, 2, 3]
 * Test Case 2: N = 3, ARR = [5, 2, 2]
 * Sample Output 1:
 * [6, 3, 2]
 * [4, 10, 10]
 *
 * Sample Input 2:
 * T = 2
 * Test Case 1: N = 1, ARR = [100]
 * Test Case 2: N = 2, ARR = [1, 2]
 * Sample Output 2:
 * [1]
 * [2, 1]
 */
public class ProductArrayExceptSelf {
    private static final long MOD = 1000000007; // 10^9 + 7

    public static int[] getProductArrayExceptSelf(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return new int[0]; // Fix 1: Return empty array for N = 0
        int[] product = new int[n];
        product[0] = 1;
        for (int i = 1; i < n; i++)
            product[i] = (int)(((long)product[i-1] * arr[i-1]) % MOD); // Fix 2: Use MOD
        long right = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] = (int)(((long)product[i] * right) % MOD); // Fix 2: Use MOD
            right = (right * arr[i]) % MOD; // Fix 2: Use MOD
        }
        return product;
    }

    public static void main(String[] args) {
        // Static test cases
        int[][] testCases = {
                new int[]{1, 2, 3},    // Test case 1: N = 3
                new int[]{5, 2, 2},    // Test case 2: N = 3
                new int[]{100},        // Test case 3: N = 1
                new int[]{1, 2},       // Test case 4: N = 2
                new int[]{}            // Test case 5: N = 0
        };

        int[][] expectedOutputs = {
                new int[]{6, 3, 2},
                new int[]{4, 10, 10},
                new int[]{1},
                new int[]{2, 1},
                new int[]{}
        };

        // Run test cases
        for (int t = 0; t < testCases.length; t++) {
            int[] arr = testCases[t];
            int[] expected = expectedOutputs[t];
            int[] result = getProductArrayExceptSelf(arr);

            System.out.println("Test Case " + (t + 1) + ":");
            System.out.print("Input: ARR = [");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
            }
            System.out.println("]");

            System.out.print("Expected Output: [");
            for (int i = 0; i < expected.length; i++) {
                System.out.print(expected[i] + (i < expected.length - 1 ? ", " : ""));
            }
            System.out.println("]");

            System.out.print("Actual Output: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i < result.length - 1 ? ", " : ""));
            }
            System.out.println("]");

            boolean pass = result.length == expected.length;
            if (pass) {
                for (int i = 0; i < result.length; i++) {
                    if (result[i] != expected[i]) {
                        pass = false;
                        break;
                    }
                }
            }
            System.out.println("Status: " + (pass ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}
