package arrays;

import java.util.*;

/**
 * Problem Statement:
 * You are given three numbers 'A', 'B' and 'C'.
 * You have to find an array 'P' of size 3 such that:
 * P[0] + P[1] = A
 * P[0] + P[2] = B
 * P[1] + P[2] = C
 *
 * It is guaranteed that an array P exists and all elements are integers.
 *
 * Example:
 * A = 4, B = 3, C = 5
 * P can be {1, 3, 2} as:
 * 1 + 3 = 4 = A
 * 1 + 2 = 3 = B
 * 3 + 2 = 5 = C
 *
 * Constraints:
 * 1 <= T <= 1000
 * 1 <= A, B, C <= 10^9
 */
public class FindArrayP {

    /**
     * Solution Method
     *
     * Proof of correctness:
     * Let P[0] = x, P[1] = y, P[2] = z
     *
     * From the given conditions:
     * x + y = A ... (1)
     * x + z = B ... (2)
     * y + z = C ... (3)
     *
     * Adding equations (1) and (2): 2x + y + z = A + B
     * Substituting (3): 2x + C = A + B
     * Therefore: x = (A + B - C)/2
     *
     * Similarly:
     * y = (A + C - B)/2
     * z = (B + C - A)/2
     */
    static int[] solve(int a, int b, int c) {
        int p0 = (a + b - c) / 2;
        int p1 = (a + c - b) / 2;
        int p2 = (b + c - a) / 2;
        return new int[]{p0, p1, p2};
    }

    public static void main(String[] args) {
        // For online judge submission (uncomment to use)
        /*
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int[] result = solve(a, b, c);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }
        scanner.close();
        */

        // Static test cases for verification
        System.out.println("--- Sample Test Cases ---");

        // Example from problem statement
        runTest(4, 3, 5);  // Expected: 1 3 2

        // Sample Input 1
        runTest(7, 8, 11); // Expected: 2 5 6
        runTest(7, 6, 3);  // Expected: 5 2 1

        // Sample Input 2
        runTest(16, 14, 16); // Expected: 7 9 7
        runTest(7, 7, 10);   // Expected: 2 5 5
        runTest(6, 9, 11);   // Expected: 2 4 7
    }

    // Helper method to run and verify test cases
    private static void runTest(int a, int b, int c) {
        int[] result = solve(a, b, c);

        System.out.println("\nInput: A=" + a + ", B=" + b + ", C=" + c);
        System.out.println("Output: " + result[0] + " " + result[1] + " " + result[2]);

        // Verification
        System.out.println("Verification:");
        System.out.println("P[0] + P[1] = " + result[0] + " + " + result[1] + " = " + (result[0] + result[1]) + " (A=" + a + ")");
        System.out.println("P[0] + P[2] = " + result[0] + " + " + result[2] + " = " + (result[0] + result[2]) + " (B=" + b + ")");
        System.out.println("P[1] + P[2] = " + result[1] + " + " + result[2] + " = " + (result[1] + result[2]) + " (C=" + c + ")");
    }
}

