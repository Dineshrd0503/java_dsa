package strings;

import java.util.*;
import java.io.*;

public class GenerateBinaryStrings {

    /**
     * Problem Statement:
     * Your friend Ninja has been learning about binary numbers lately. In order to understand binary numbers with perfection,
     * Ninja asks you to generate a list of binary numbers from 1 to ‘N’, which he can use later for reference.
     *
     * For every integer Ninja gives, your task is to generate all the binary numbers from 1 to ‘N’.
     *
     * Example:
     * Consider N = 5,
     * All the binary numbers from 1 to 5 are: 1, 10, 11, 100, 101.
     *
     * Sample Input 1:
     * 2
     * 2
     * 6
     *
     * Sample Output 1:
     * 1 10
     * 1 10 11 100 101 110
     *
     * Explanation 1:
     * For the first test case when N = 2.
     * We need all the binary numbers from 1 to 2:
     * 1 -> 1
     * 2 -> 10
     * Thus, the output is 1, 10.
     *
     * For the second test case when N = 6
     * We need all the binary numbers from 1 to 6:
     * 1 -> 1
     * 2 -> 10
     * 3 -> 11
     * 4 -> 100
     * 5 -> 101
     * 6 -> 110
     * Thus, the output is 1, 10, 11, 100, 101, 110.
     *
     * Sample Input 2:
     * 2
     * 8
     * 4
     *
     * Sample Output 2:
     * 1 10 11 100 101 110 111 1000
     * 1 10 11 100
     */
    public static List<String> generateBinaryNumbers(int n) {
        //Write your code here
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String value = toBinaryString(i);
            result.add(value);
        }
        return result;
    }

    // User-defined method to convert an integer to its binary string representation
    private static String toBinaryString(int n) {
        if (n == 0) {
            return "0"; // Special case for 0
        }

        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, (n % 2)); // Prepend the remainder to the string
            n /= 2; // Integer division to get the next bit
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        // Static input values for T and N
        int[] testCases = {2, 6}; // Example test case values for N
        int T = testCases.length; // Number of test cases

        for (int i = 0; i < T; i++) {
            int n = testCases[i];
            List<String> binaryList = generateBinaryNumbers(n);

            // Print the binary numbers separated by spaces
            for (int j = 0; j < binaryList.size(); j++) {
                System.out.print(binaryList.get(j));
                if (j < binaryList.size() - 1) {
                    System.out.print(" "); // Add space between numbers
                }
            }
            System.out.println(); // New line for the next test case
        }
    }
}
