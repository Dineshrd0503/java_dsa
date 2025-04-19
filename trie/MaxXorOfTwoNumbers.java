package trie;

// MaxXorOfTwoNumbers.java
/*
    Maximum XOR of two numbers in an array

    Difficulty: Medium
    Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.

    Examples:

    Input: arr[] = [25, 10, 2, 8, 5, 3]
    Output: 28
    Explanation: The maximum possible XOR is 5 ^ 25 = 28.

    Input: arr[] = [1, 2, 3, 4, 5, 6, 7]
    Output: 7
    Explanation: The maximum possible XOR is 1 ^ 6 = 7.

    Constraints:
    2 ≤ arr.size() ≤ 5*10^4
    1 ≤ arr[i] ≤ 10^6

    Test Cases:
    Test Case 1:
    Input: arr[] = [3, 10, 5, 25, 2, 8]
    Output: 28

    Test Case 2:
    Input: arr[] = [14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70]
    Output: 127
*/

import java.util.Arrays;

public class MaxXorOfTwoNumbers {

    public int maxXor(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int maxXor = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxXor = Math.max(maxXor, arr[i] ^ arr[j]);
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        MaxXorOfTwoNumbers solution = new MaxXorOfTwoNumbers();

        // Test Cases
        int[] arr1 = {25, 10, 2, 8, 5, 3};
        System.out.println("Max XOR of arr1: " + solution.maxXor(arr1)); // Output: 28

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Max XOR of arr2: " + solution.maxXor(arr2)); // Output: 7

        int[] arr3 = {3, 10, 5, 25, 2, 8};
        System.out.println("Max XOR of arr3: " + solution.maxXor(arr3)); // Output: 28

        int[] arr4 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        System.out.println("Max XOR of arr4: " + solution.maxXor(arr4)); // Output: 127
    }
}
