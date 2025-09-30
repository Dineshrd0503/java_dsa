package bitmanipulation;

import java.util.ArrayList;

/**
 * Problem Statement:
 * Given an integer n, generate all binary strings of n characters representing bits.
 * Return the strings in ascending order.
 *
 * Examples:
 * Input: n = 2
 * Output: ["00", "01", "10", "11"]
 * Explanation: Each position can be either 0 or 1, so the total possible combinations are 4.
 *
 * Input: n = 3
 * Output: ["000", "001", "010", "011", "100", "101", "110", "111"]
 * Explanation: Each position can be either 0 or 1, so the total possible combinations are 8.
 *
 * Constraints:
 * 1 ≤ n ≤ 20
 */
public class GenerateAllBinaryStrings {
    public ArrayList<String> binstr(int n) {
        // Initialize result list to store binary strings
        ArrayList<String> result = new ArrayList<>();

        // Iterate from 0 to 2^n - 1 to generate all binary numbers
        for (int i = 0; i < (1 << n); i++) {
            // Convert number to binary string
            String binary = Integer.toBinaryString(i);
            // Pad with leading zeros to ensure length n
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            // Add to result list
            result.add(binary);
        }

        // Return the list of binary strings
        return result;
    }

    public static void main(String[] args) {
        GenerateAllBinaryStrings solution = new GenerateAllBinaryStrings();

        // Static test cases
        int[] testCases = {2, 3};

        // Process each test case
        for (int n : testCases) {
            ArrayList<String> result = solution.binstr(n);
            System.out.println("Input: n = " + n);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
