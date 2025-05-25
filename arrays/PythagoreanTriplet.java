package arrays;

import java.util.HashSet;

/**
 * Problem Statement:
 * Given an array arr[], return true if there is a triplet (a, b, c)
 * from the array (where a, b, and c are on different indexes) that
 * satisfies a^2 + b^2 = c^2, otherwise return false.
 *
 * Examples:
 * Input: arr[] = [3, 2, 4, 6, 5]
 * Output: true
 * Explanation: (3, 4, 5) forms a Pythagorean triplet.
 *
 * Input: arr[] = [3, 8, 5]
 * Output: false
 * Explanation: No such triplet possible.
 *
 * Input: arr[] = [1, 1, 1]
 * Output: false
 *
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i] <= 10^3
 */
public class PythagoreanTriplet {

    public static boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> squaresSet = new HashSet<>();

        // Step 1: Store the squares of all elements in a set
        for (int i = 0; i < n; i++) {
            squaresSet.add(arr[i] * arr[i]);
        }

        // Step 2: Check for each pair (arr[i], arr[j])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                // Calculate sum of squares
                int sumOfSquares = a * a + b * b;
                // Step 3: Check if sumOfSquares exists in the set
                if (squaresSet.contains(sumOfSquares)) {
                    return true; // Pythagorean triplet found
                }
            }
        }

        // No triplet found
        return false;
    }

    public static void main(String[] args) {
        // Sample Test Cases:
        int[] testCase1 = {3, 2, 4, 6, 5}; // Expected output: true
        int[] testCase2 = {3, 8, 5}; // Expected output: false
        int[] testCase3 = {1, 1, 1}; // Expected output: false

        // Running the test cases
        System.out.println("Test Case 1: " + pythagoreanTriplet(testCase1)); // Output: true
        System.out.println("Test Case 2: " + pythagoreanTriplet(testCase2)); // Output: false
        System.out.println("Test Case 3: " + pythagoreanTriplet(testCase3)); // Output: false
    }
}