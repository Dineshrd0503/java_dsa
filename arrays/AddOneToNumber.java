package arrays;

import java.util.*;
import java.io.*;

public class AddOneToNumber {

    /**
     * Problem Statement:
     * Given a non-negative number represented as an array of digits, you have to add 1 to the number, i.e,
     * increment the given number by one.
     *
     * The digits are stored such that the most significant digit is at the starting of the array and the
     * least significant digit is at the end of the array.
     *
     * For Example
     * If the given array is {1,5,2}, the returned array should be {1,5,3}.
     *
     * Note
     * Input array can contain leading zeros, but the output array should not contain any leading zeros
     * (even if the input array contains leading zeroes).
     * For Example:
     * If the given array is {0,2}, the returned array should be {3}.
     *
     * Input Format:
     * The first line of input contains a single integer T, representing the number of test cases or queries to be run.
     *
     * The first line of each test case contains a positive integer N, which represents the number of digits in the
     * given number/array.
     *
     * The next line contains 'N' single space-separated positive integers representing the elements of the array.
     *
     * Output Format:
     * For each test case, print the final number.
     *
     * Print the output of each test case in a separate line.
     *
     * Note
     * You do not need to print anything, it has already been taken care of. Just implement the given function.
     *
     * Constraints
     * 1 <= T <= 10
     * 1 <= N <= 5 * 10^4
     * 0 <= Arr[i] <= 9
     *
     * Where Arr[i] is the i-th digit in the number.
     *
     * Sample Input 1
     * 3
     * 3
     * 1 2 3
     * 2
     * 9 9
     * 1
     * 4
     *
     * Sample Output 1
     * 1 2 4
     * 1 0 0
     * 5
     *
     * Explanation For Sample Input 1
     * In the 1st test case, the number is 123 after adding 1 number becomes 124, hence the output will be {1,2,4}.
     *
     * In the 2nd test case, the number is 99 after adding 1 number becomes 100, hence the output will be {1,0,0}.
     *
     * In the 3rd test case, the number is 4 after adding 1 number becomes 5, hence the output will be {5}.
     *
     * Sample Input 2
     * 3
     * 4
     * 2 4 6 8
     * 1
     * 0
     * 2
     * 0 2
     *
     * Sample Output 2
     * 2 4 6 9
     * 1
     * 3
     *
     * @param arr The ArrayList representing the number.
     * @return The ArrayList representing the number after adding one.
     */
    public static ArrayList<Integer> addOneToNumber(ArrayList<Integer> arr) {
        int n = arr.size();
        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            int sum = arr.get(i) + carry;
            arr.set(i, sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            arr.add(0, carry);
        }

        // Remove leading zeros
        while (arr.size() > 1 && arr.get(0) == 0) {
            arr.remove(0);
        }

        return arr;
    }

    public static void main(String[] args) {
        // Test cases with static inputs
        ArrayList<ArrayList<Integer>> testCases = new ArrayList<>();

        // Sample Input 1
        // Test Case 1: {1, 2, 3} -> {1, 2, 4}
        ArrayList<Integer> tc1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        testCases.add(tc1);
        // Test Case 2: {9, 9} -> {1, 0, 0}
        ArrayList<Integer> tc2 = new ArrayList<>(Arrays.asList(9, 9));
        testCases.add(tc2);
        // Test Case 3: {4} -> {5}
        ArrayList<Integer> tc3 = new ArrayList<>(Arrays.asList(4));
        testCases.add(tc3);

        // Sample Input 2
        // Test Case 4: {2, 4, 6, 8} -> {2, 4, 6, 9}
        ArrayList<Integer> tc4 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        testCases.add(tc4);
        // Test Case 5: {0} -> {1}
        ArrayList<Integer> tc5 = new ArrayList<>(Arrays.asList(0));
        testCases.add(tc5);
        // Test Case 6: {0, 2} -> {3}
        ArrayList<Integer> tc6 = new ArrayList<>(Arrays.asList(0, 2));
        testCases.add(tc6);

        // Additional Test Cases
        // Test Case 7: {9} -> {1, 0}
        ArrayList<Integer> tc7 = new ArrayList<>(Arrays.asList(9));
        testCases.add(tc7);
        // Test Case 8: {0, 0, 9} -> {1, 0}
        ArrayList<Integer> tc8 = new ArrayList<>(Arrays.asList(0, 0, 9));
        testCases.add(tc8);
        // Test Case 9: {0, 0, 0} -> {1}
        ArrayList<Integer> tc9 = new ArrayList<>(Arrays.asList(0, 0, 0));
        testCases.add(tc9);
        // Test Case 10: {1, 0, 0, 0} -> {1, 0, 0, 1}
        ArrayList<Integer> tc10 = new ArrayList<>(Arrays.asList(1, 0, 0, 0));
        testCases.add(tc10);

        for (int i = 0; i < testCases.size(); i++) {
            ArrayList<Integer> inputArr = testCases.get(i);
            ArrayList<Integer> result = addOneToNumber(new ArrayList<>(inputArr)); // Pass a copy to avoid modifying original test case

            System.out.print("Input: " + inputArr + " -> Output: ");
            for (int j = 0; j < result.size(); j++) {
                System.out.print(result.get(j) + (j == result.size() - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}