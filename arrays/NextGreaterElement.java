package arrays;

import java.util.Stack;

public class NextGreaterElement{

    public static int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are less than or equal to arr[i]
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // If stack is not empty, the top is the next greater element
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            } else {
                nge[i] = -1; // No greater element exists
            }
            // Push the current element to the stack
            stack.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        // Sample Inputs
        int[][] testCases = {
                {1, 5, 3, 4, 2},         // Sample Input 1
                {5, 5, 5, 5, 5}          // Sample Input 2
        };

        for (int[] testCase : testCases) {
            int n = testCase.length;
            int[] result = nextGreaterElement(testCase, n);
            for (int r : result) {
                System.out.print(r + " "); // Print the result for each test case
            }
            System.out.println(); // New line after each case
        }
    }
}

/*
Problem Statement:
You are given an array 'a' of size 'n'. Print the Next Greater Element (NGE) for every element.
The Next Greater Element for an element 'x' is the first element on the right side of 'x' in the array, which is greater than 'x'.
If no greater elements exist to the right of 'x', consider the next greater element as -1.

Example:

Input: 'a' = [7, 12, 1, 20]
Output: NGE = [12, 20, 20, -1]
Explanation:
- The next greater element for 7 is 12.
- The next greater element for 12 is 20.
- The next greater element for 1 is 20.
- There is no greater element for 20 on the right side. So we consider NGE as -1.

Sample Input 1:
5
1 5 3 4 2

Sample Output 1:
5 -1 4 -1 -1

Sample Input 2:
5
5 5 5 5 5

Sample Output 2:
-1 -1 -1 -1 -1

Expected time complexity : O(n).
*/
