package strings;

import java.util.*;
import java.io.*;

public class LookAndSaySequence {

    /**
     * Problem statement:
     * You have been given a positive integer N. Your task is to find the Nth term of the Look-And-Say sequence.
     *
     * The Look-And-Say sequence is a sequence of positive integers. The sequence is as follows:
     *
     * 1, 11, 21, 1211, 111221, 312211, 13112221,...
     *
     * This sequence is constructed in the following way:
     *
     *     The first number is 1.
     *
     *     This is read as “One 1”.
     *     Hence, the second number will be 11.
     *
     *     The second number is read as “Two 1s”.
     *     Hence, the third number will be 21.
     *
     *     The third number is read as “One 2, One 1”.
     *     Hence, the fourth number will be 1211.
     *
     *     The fourth term is read as “One 1, One 2, Two 1s”.
     *     Hence, the fifth term will be 111221. And so on.
     *
     * Detailed explanation ( Input/output format, Notes, Images )
     *
     * Input Format:
     *
     *     The first line of input contains a single integer T, representing the number of test cases or queries to be run. The 'T' test cases follow
     *
     *     For each test case, the only line contains a single integer N.
     *
     *
     * Output Format:
     *
     *     For each test case/query, print the N-th term of the sequence.
     *
     *
     * Note:
     *
     *     You do not need to print anything, it has already been taken care of. Just implement the given function.
     *
     *
     * Constraints:
     *
     *     1 <= T <= 100
     *     1 <= N <= 40
     *
     *     Time Limit: 1 sec
     *
     *
     * Sample Input 1:
     *
     *     3
     *     1
     *     2
     *     3
     *
     *
     * Sample Output 1:
     *
     *     1
     *     11
     *     21
     *
     *
     * Explanation for Sample 1:
     *
     *     The first term is 1.
     *     The second term is 11.
     *     The third term is 21.
     *
     *
     * Sample Input 2:
     *
     *     1
     *     6
     *
     *
     * Sample Output 2:
     *
     *     312211
     */
    public static String lookAndSaySequence(int n) {
        if (n == 1) {
            return "1";
        }

        String previousTerm = lookAndSaySequence(n - 1);
        StringBuilder currentTerm = new StringBuilder();
        int count = 1;

        for (int i = 0; i < previousTerm.length(); i++) {
            if (i + 1 < previousTerm.length() && previousTerm.charAt(i) == previousTerm.charAt(i + 1)) {
                count++;
            } else {
                currentTerm.append(count);
                currentTerm.append(previousTerm.charAt(i));
                count = 1; // Reset count for the next digit
            }
        }

        return currentTerm.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Cases:");
        System.out.println("lookAndSaySequence(1) = " + lookAndSaySequence(1)); // Expected: 1
        System.out.println("lookAndSaySequence(2) = " + lookAndSaySequence(2)); // Expected: 11
        System.out.println("lookAndSaySequence(3) = " + lookAndSaySequence(3)); // Expected: 21
        System.out.println("lookAndSaySequence(4) = " + lookAndSaySequence(4)); // Expected: 1211
        System.out.println("lookAndSaySequence(5) = " + lookAndSaySequence(5)); // Expected: 111221
        System.out.println("lookAndSaySequence(6) = " + lookAndSaySequence(6)); // Expected: 312211
        System.out.println("lookAndSaySequence(7) = " + lookAndSaySequence(7)); // Expected: 13112221
        System.out.println("lookAndSaySequence(8) = " + lookAndSaySequence(8)); // Expected: 1113213211

        // Static input for multiple test cases
        int[] testCases = {3, 1, 2, 3, 1, 6}; // Example input array
        int t = testCases[0]; // Number of test cases
        int index = 1; // Index to track the current test case input

        while (t-- > 0) {
            int n = testCases[index++]; // Get the input n for each test case
            System.out.println(lookAndSaySequence(n));
        }

    }
}