package codingninjas7dayschallenge;

import java.util.Arrays;

public class PartitionsWithGivenDifference {

    /**
     * Problem statement:
     * Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array.
     * Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.
     *
     * Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’
     * and the difference between ‘S1’ and ‘S2’ is equal to ‘D’.
     * Since the answer may be too large, return it modulo ‘10^9 + 7’.
     */

    public static int countPartitions(int n, int d, int[] arr) {
        int sum = Arrays.stream(arr).sum();

        // Calculate target sum
        if (sum + d < 0 || (sum + d) % 2 != 0) {
            return 0;
        }

        int target = (sum + d) / 2;

        // Create a dp array
        int[] dp = new int[target + 1];
        dp[0] = 1;  // One way to reach sum 0 (by choosing nothing)

        // Fill the dp array
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % 1000000007;
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        // Static test cases
        int[][] testCases = {
                {4, 3, 5, 2, 6, 4},      // Test case 1: N=4, D=3, ARR={5, 2, 6, 4}
                {4, 0, 1, 1, 1, 1},      // Test case 2: N=4, D=0, ARR={1, 1, 1, 1}
                {3, 1, 4, 6, 3},         // Test case 3: N=3, D=1, ARR={4, 6, 3}
                {5, 0, 3, 1, 1, 2, 1},    // Test case 4: N=5, D=0, ARR={3, 1, 1, 2, 1}
                {5, 1, 3, 2, 2, 5, 1}      // Test case 5: N=5, D=1, ARR={3, 2, 2, 5, 1}
        };

        // Expected outputs for each test case based on problem statement:
        /*
        Test case 1: Expected output: 1
        Test case 2: Expected output: 6
        Test case 3: Expected output: 1
        Test case 4: Expected output: 6
        Test case 5: Expected output: 3
        */

        for (int[] testCase : testCases) {
            int N = testCase[0];
            int D = testCase[1];
            int[] ARR = Arrays.copyOfRange(testCase, 2, testCase.length);
            int result = countPartitions(N, D, ARR);
            System.out.println(result); // Output the result for each test case
        }
    }
}
