package bitmanipulation;

// Problem Statement:
// Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order.
// The array has only one repetitive element. Your task is to find the repetitive element.
//
// Note: It is guaranteed that there is a repeating element present in the array.
//
// Examples:
// Input: arr[] = [1, 3, 2, 3, 4]
// Output: 3
// Explanation: The number 3 is the only repeating element.
//
// Input: arr[] = [1, 5, 1, 2, 3, 4]
// Output: 1
// Explanation: The number 1 is the only repeating element.
//
// Input: arr[] = [1, 1]
// Output: 1
// Explanation: The array is of size 2 with both elements being 1, making 1 the repeating element.
//
// Constraints:
// 2 ≤ arr.size() ≤ 10^5
// 1 ≤ arr[i] ≤ n-1

import java.util.HashMap;

public class FindOnlyRepetitiveElementfromOneToN {
    public int findDuplicate(int[] arr) {
        // code here
        int xor=0;
        for(int num:arr)
            xor^=num;
        for(int i=1;i<arr.length;i++)
            xor^=i;
        return xor;
    }

    public static void main(String[] args) {
        FindOnlyRepetitiveElementfromOneToN solution = new FindOnlyRepetitiveElementfromOneToN();

        // Test Case 1
        int[] arr1 = {1, 3, 2, 3, 4};
        System.out.println("Test Case 1 - Expected Output: 3");
        System.out.println("Actual Output: " + solution.findDuplicate(arr1));

        // Test Case 2
        int[] arr2 = {1, 5, 1, 2, 3, 4};
        System.out.println("Test Case 2 - Expected Output: 1");
        System.out.println("Actual Output: " + solution.findDuplicate(arr2));

        // Test Case 3
        int[] arr3 = {1, 1};
        System.out.println("Test Case 3 - Expected Output: 1");
        System.out.println("Actual Output: " + solution.findDuplicate(arr3));
    }
}
