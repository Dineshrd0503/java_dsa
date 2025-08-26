package arrays;

import java.util.*;
import java.io.*;

public class NTermsOfAP {

    /**
     * Ayush is given a number ‘X’. He has been told that he has to find the
     * first ‘X’ terms of the series 3 * ‘N’ + 2, which are not multiples of 4.
     * Help Ayush to find it as he has not been able to answer.
     *
     * Example:
     * Given an ‘X’ = 4. The output array/list which must be passed to Ayush will be [ 5, 11, 14, 17 ].
     *
     * Input Format:
     * The first line contains a single integer ‘T’ representing the number of test cases.
     * The first line of each test case will contain one integer, ‘X’ that denotes the number of terms he has to answer.
     *
     * Output Format:
     * For each test case, return a vector with the first ‘X’ integer of the series 3 * ‘N’ + 2, which is not multiple of 4.
     * Output for every test case will be printed in a separate line.
     *
     * Note:
     * You don’t need to print anything; It has already been taken care of.
     *
     * Constraints:
     * 1 <= T <= 10^2
     * 1 <= X <= 10^5
     *
     * Time Limit: 1 sec
     *
     * Sample Input 1:
     * 2
     * 2
     * 5
     *
     * Sample Output 1:
     * 5 11
     * 5 11 14 17 23
     *
     * Explanation For Sample Input 1:
     * In the first test case, the first number is 5, while the second number cannot be 8 as it is divisible by 4, and so, the next number is directly 11 as it is not divisible by 4.
     * In the second test case, the first two numbers are 5 and 11. While following three numbers are 14, 17 and 23 for ‘N’ = 4, 5 and 7 respectively. 20 is divisible by 4, and thus, 20 cannot be included in the list.
     *
     * Sample Input 2:
     * 2
     * 7
     * 8
     *
     * Sample Output 2:
     * 5 11 14 17 23 26 29
     * 5 11 14 17 23 26 29 35
     *
     * Explanation For Sample Input 2:
     * In the first test case, the first five numbers are 5, 11, 14, 17 and 23. While the following two numbers are 26 and 29 for N = 8 and 9 respectively.
     * In the second test case, the seven numbers are explained in the above test case and for N = 10, we get the number 32, which is divisible by 4 and thus, we reject it. For N = 11, the number is 35 and is not divisible by 4.
     *
     * @param x
     * @return
     */
    public static int[] termsOfAP(int x) {
        int[] result = new int[x];
        int count = 0;
        int n = 1; // Start with N = 1;

        while (count < x) {
            int val = 3 * n + 2; // Calculate the term
            if (val % 4 != 0) { // Check if the term is NOT a multiple of 4
                result[count] = val; // Add the term to the array
                count++; // Increment the count only when a valid term is found
            }
            n++; // increment `n` for the next number in the series whether or not the previous number was added to the list.
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases based on the problem description
        int[][] testCases = {
            {2}, // Sample Input 1, Test Case 1
            {5}, // Sample Input 1, Test Case 2
            {7}, // Sample Input 2, Test Case 1
            {8}  // Sample Input 2, Test Case 2
        };

        for (int i = 0; i < testCases.length; i++) {
            int x = testCases[i][0]; // Get the value of X for the current test case
            int[] result = termsOfAP(x); // Call the function to get the terms

            // Print the result
            for (int i1 = 0; i1 < result.length; i1++) {
                System.out.print(result[i1] + (i1== result.length - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}