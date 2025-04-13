package codingninjas;

/**
 * Problem Statement:
 * You are given two polynomials represented by their coefficients in arrays A and B.
 * Your task is to multiply these polynomials and return the coefficients of the resulting polynomial.
 *
 * Example:
 * A = [1,2,3] represents the polynomial x^2 + 2x + 3.
 * B = [3,2,1] represents the polynomial 3x^2 + 2x + 1.
 * On multiplying these polynomials, we get:
 * Result = [3,8,14,8,3], which represents 3x^4 + 8x^3 + 14x^2 + 8x + 3.
 *
 * Constraints:
 * - 1 ≤ T ≤ 10 (Number of test cases)
 * - 1 ≤ N ≤ 10^4 (Length of arrays A and B)
 * - 1 ≤ A[i], B[i] ≤ 500
 */

import java.util.*;

public class PolynomialMultiplication {
    // Static method with proper implementation
    public static int[] multiply(int[] a, int[] b) {
        int[] result = new int[a.length + b.length - 1];

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<b.length; j++) {
                result[i+j] += a[i] * b[j];  // Accumulate products
            }
        }

        return result;
    }

    // Main method with static test cases
    public static void main(String[] args) {
        // Test Case 1 (From original problem)
        int[] a1 = {1, 2, 3};
        int[] b1 = {3, 2, 1};
        int[] result1 = multiply(a1, b1);
        printResult(result1);  // Output: 3 8 14 8 3

        // Test Case 2 (From sample input 1)
        int[] a2 = {1, 0, 1};
        int[] b2 = {2, 1, 0};
        int[] result2 = multiply(a2, b2);
        printResult(result2);  // Output: 2 1 2 1 0

        // Test Case 3 (Single element)
        int[] a3 = {1};
        int[] b3 = {1};
        int[] result3 = multiply(a3, b3);
        printResult(result3);  // Output: 1

        // Test Case 4 (Different sizes)
        int[] a4 = {1, 1};
        int[] b4 = {1, 1};
        int[] result4 = multiply(a4, b4);
        printResult(result4);  // Output: 1 2 1
    }

    // Helper method to print results
    private static void printResult(int[] arr) {
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

