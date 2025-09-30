package arrays;


import java.util.ArrayList;

/**
 * Problem Statement:
 * Given an integer N, print all numbers less than N which are having digits only 2 or 5 or both.
 * Return the numbers in ascending order.
 *
 * Examples:
 * Input: N = 10
 * Output: [2, 5]
 * Explanation: Only 2 and 5 are the required numbers.
 *
 * Input: N = 100
 * Output: [2, 5, 22, 25, 52, 55]
 * Explanation: These are all numbers less than 100 with digits 2 and/or 5.
 *
 * Input: N = 2
 * Output: []
 * Explanation: No numbers less than 2 have digits 2 or 5.
 *
 * Input: N = 7
 * Output: [2, 5]
 * Explanation: Numbers less than 7 with digits 2 or 5.
 *
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 10^16
 * Time Limit: 1 sec
 */
public class NumberWith2And5 {
    public static ArrayList<Long> createSequence(long n) {
        // Initialize result list to store valid numbers
        ArrayList<Long> result = new ArrayList<>();

        // Iterate from 2 to n-1
        for (long i = 2; i < n; i++) {
            // Check if the number has only digits 2 or 5
            if (istrue(i)) {
                result.add(i);
            }
        }

        // Return the list of valid numbers
        return result;
    }

    static boolean istrue(long n) {
        // Convert number to string for digit checking
        String s = String.valueOf(n);
        // Check each digit
        for (char c : s.toCharArray()) {
            if (c != '2' && c != '5') { // Fixed: Changed & to &&
                return false; // Return false if any digit is not 2 or 5
            }
        }
        return true; // Return true if all digits are 2 or 5
    }

    public static void main(String[] args) {
        // Static test cases
        long[] testCases = {10, 100, 2, 7};

        // Process each test case
        for (long n : testCases) {
            ArrayList<Long> result = createSequence(n);
            System.out.println("Input: N = " + n);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}