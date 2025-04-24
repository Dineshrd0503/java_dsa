package bitmanipulation;

// Two Unique Numbers

/*
Problem Statement:
Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs
whereas only two numbers occur exactly once and are distinct. Find the other two numbers.
Return the answer in increasing order.

Examples:
Input: arr[] = [1, 2, 3, 2, 1, 4]
Output: [3, 4]
Explanation: 3 and 4 occur exactly once.

Input: arr[] = [2, 1, 3, 2]
Output: [1, 3]
Explanation: 1 and 3 occur exactly once.

Input: arr[] = [2, 1, 3, 3]
Output: [1, 2]
Explanation: 1 and 2 occur exactly once.

Constraints:
2 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 5 * 10^6
arr.size() is even
*/

import java.util.Arrays;

public class TwoUniqueNumbers {
    public int[] singleNum(int[] arr) {
        int xorResult = 0;

        // Step 1: Get the XOR of all elements
        for (int num : arr) {
            xorResult ^= num;
        }

        // Step 2: Find the rightmost set bit
        int setBit = xorResult & -xorResult;

        int num1 = 0, num2 = 0;

        // Step 3: Separate numbers into two groups
        for (int num : arr) {
            if ((num & setBit) == 0) {
                // If the bit is not set
                num1 ^= num; // XOR with first group
            } else {
                num2 ^= num; // XOR with second group
            }
        }

        // Return the results in increasing order
        return new int[] {Math.min(num1, num2), Math.max(num1, num2)};
    }

    public static void main(String[] args) {
        TwoUniqueNumbers solution = new TwoUniqueNumbers();

        // Test cases
        int[] arr1 = {1, 2, 3, 2, 1, 4};
        int[] result1 = solution.singleNum(arr1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]

        int[] arr2 = {2, 1, 3, 2};
        int[] result2 = solution.singleNum(arr2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 3]

        int[] arr3 = {2, 1, 3, 3};
        int[] result3 = solution.singleNum(arr3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Output: [1, 2]
    }
}