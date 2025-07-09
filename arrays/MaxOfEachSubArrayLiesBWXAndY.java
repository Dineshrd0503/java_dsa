package arrays;

import java.util.*;
import java.io.*;

public class MaxOfEachSubArrayLiesBWXAndY {

    /**
     * Anish is teaching his brother about sub-arrays. However, his brother is sometimes very inattentive.
     * So, he wants to test whether his brother has understood the concept of sub-arrays or not.
     * He gives his brother two numbers and asks him to find the number of sub-arrays of a certain array ARR
     * such that the maximum element of the sub-array lies between X and Y.
     *
     * Example:-
     *
     * Let,
     *
     * ARR = [2, 1, 4, 3]
     * X = 2 , Y = 3
     *
     * Answer:- 3 (The sub-arrays which meet the requirements are [2], [2, 1], [3]).
     *
     * Input Format :
     * The first line contains a single integer ‘T’ representing the number of test cases. Then each test case follows.
     * The first line of each test case contains three integers ‘N’, ‘X’, and ‘Y’ denoting the length of the array given and the two integers.
     * The next line of every test case contains ‘N’ integers containing the elements of the array arr.
     *
     * Output Format :
     * For each test case, print an integer denoting the number of sub-arrays that has a maximum between X and Y.
     * The output of each test case should be printed in a separate line.
     *
     * Note :
     * You are not required to print anything, it has already been taken care of. Just implement the function.
     *
     * Constraints :
     * 1 <= T <= 5
     * 4 <= N <= 10^5
     * 1 <= ARR[i] <= 10^9
     * Time Limit: 1 sec
     *
     * Sample Input 1 :
     * 2
     * 3 1 3
     * 1 2 3
     * 4 2 3
     * 10 2 3 4
     *
     * Sample Output 1 :
     * 6
     * 3
     *
     * Explanation for Sample Output 1 :
     * In the first test case, the answer should be 6 because every sub-array satisfies the conditions.
     * In the second test case, the answer should be 3 because the sub-arrays [2], [3], and [2, 3] satisfy the conditions.
     *
     * Sample Input 2 :
     * 1
     * 4 1 2
     * 4 3 6 7
     *
     * Sample Output 2 :
     * 0
     *
     * @param n The length of the array.
     * @param arr The input array.
     * @param x The lower bound of the range.
     * @param y The upper bound of the range.
     * @return The number of sub-arrays with a maximum element between x and y.
     */
    public static int find(int n, int[] arr, int x, int y) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int maxval = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                maxval = Math.max(maxval, arr[j]);

                if (maxval >= x && maxval <= y) {
                    count++;
                } else if (maxval > y) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample test cases
        int[] arr1 = {1, 2, 3};
        int x1 = 1, y1 = 3;
        System.out.println("Test Case 1: " + find(arr1.length, arr1, x1, y1)); // Expected output: 6

        int[] arr2 = {10, 2, 3, 4};
        int x2 = 2, y2 = 3;
        System.out.println("Test Case 2: " + find(arr2.length, arr2, x2, y2)); // Expected output: 3

        int[] arr3 = {4, 3, 6, 7};
        int x3 = 1, y3 = 2;
        System.out.println("Test Case 3: " + find(arr3.length, arr3, x3, y3)); // Expected output: 0

        int[] arr4 = { 2, 1, 4, 3 };
        int x4 = 2, y4 = 3;
        System.out.println("Test Case 4: " + find(arr4.length, arr4, x4, y4)); // Expected output: 3
    }
}