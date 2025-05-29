package arrays;

/**
 * Problem Statement:
 * You’re given an array of 'N' integers, and two integers 'X' and 'Y'. Your task is to find the minimum distance
 * between 'X' and 'Y' in the array. If either or both of them are not present in the array, then return -1.
 *
 * Notes:
 * 1. The array might contain duplicates.
 * 2. It is guaranteed that 'X' and 'Y' are two distinct integers i.e. 'X' is not equal to 'Y'.
 *
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 10^5
 * 0 <= X, Y <= 10^9
 * 0 <= ARR[i] <= 10^9
 * Where 'T' denotes the number of test cases, 'N' denotes the number of elements in the array 'ARR' respectively,
 * 'X' and 'Y' denotes the integer given in the input, and 'ARR[i]' denotes the 'i-th' element of the array 'ARR'.
 * Time Limit: 1 sec
 *
 * Sample Test Cases:
 * Sample Input 1:
 * T = 1
 * Test Case 1: N = 3, X = 3, Y = 5, ARR = [3, 4, 5]
 * Sample Output 1: 2
 * Explanation: 'X' (3) is at index 0, and 'Y' (5) is at index 2. The distance between them is |2 - 0| = 2.
 *
 * Sample Input 2:
 * T = 2
 * Test Case 1: N = 4, X = 1, Y = 2, ARR = [1, 2, 3, 2]
 * Test Case 2: N = 4, X = 2, Y = 3, ARR = [4, 5, 6, 7]
 * Sample Output 2:
 * 1
 * -1
 * Explanation:
 * For Test Case 1: 'X' (1) is at index 0, 'Y' (2) is at indices 1 and 3. Distances are |1 - 0| = 1 and |3 - 0| = 3. Minimum is 1.
 * For Test Case 2: Neither 'X' (2) nor 'Y' (3) exists in the array, so return -1.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinDistanceOfArrayElements {
    // Static inputs for testing based on sample test cases
    private static final int T = 3; // Number of test cases
    private static final int[] N = {3, 4, 4}; // Array sizes for each test case
    private static final int[] X = {3, 1, 2}; // X values
    private static final int[] Y = {5, 2, 3}; // Y values
    private static final int[][] ARR = {
            {3, 4, 5},          // Test Case 1
            {1, 2, 3, 2},      // Test Case 2
            {4, 5, 6, 7}       // Test Case 3
    };
    private static final int[] EXPECTED_OUTPUTS = {2, 1, -1};

    // Provided imperative solution
    public static int minimumDistance(int arr[], int n, int x, int y) {
        int min = Integer.MAX_VALUE;
        int lastx = -1, lasty = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                lastx = i;
                if (lasty != -1)
                    min = Math.min(min, lastx - lasty);
            }
            if (arr[i] == y) {
                lasty = i;
                if (lastx != -1)
                    min = Math.min(min, lasty - lastx);
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    // Alternative functional solution using streams
    public static int minimumDistanceFunctional(int arr[], int n, int x, int y) {
        // Find indices where x and y occur
        List<Integer> xIndices = IntStream.range(0, n)
                .filter(i -> arr[i] == x)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> yIndices = IntStream.range(0, n)
                .filter(i -> arr[i] == y)
                .boxed()
                .collect(Collectors.toList());

        // If either x or y is not found, return -1
        if (xIndices.isEmpty() || yIndices.isEmpty()) {
            return -1;
        }

        // Compute minimum distance between all pairs of indices
        return xIndices.stream()
                .flatMapToInt(xi -> yIndices.stream().mapToInt(yi -> Math.abs(xi - yi)))
                .min()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println("Testing MinDistanceFinder with static inputs:");
        for (int t = 0; t < T; t++) {
            int n = N[t];
            int x = X[t];
            int y = Y[t];
            int[] arr = ARR[t];
            int expected = EXPECTED_OUTPUTS[t];

            // Test imperative solution
            int resultImperative = minimumDistance(arr, n, x, y);
            System.out.printf("Test Case %d (Imperative): N=%d, X=%d, Y=%d, ARR=%s, Expected=%d, Output=%d, %s%n",
                    t + 1, n, x, y, Arrays.toString(arr), expected, resultImperative,
                    resultImperative == expected ? "PASS" : "FAIL");

            // Test functional solution
            int resultFunctional = minimumDistanceFunctional(arr, n, x, y);
            System.out.printf("Test Case %d (Functional): N=%d, X=%d, Y=%d, ARR=%s, Expected=%d, Output=%d, %s%n",
                    t + 1, n, x, y, Arrays.toString(arr), expected, resultFunctional,
                    resultFunctional == expected ? "PASS" : "FAIL");
        }
    }
}
