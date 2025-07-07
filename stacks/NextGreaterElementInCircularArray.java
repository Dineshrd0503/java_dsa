package stacks;


import java.util.*;

/*
 * Problem: Next Greater Element in Circular Array
 * Find the next greater element for each element in a circular array.
 *
 * Input:
 * - arr: Integer array
 *
 * Output:
 * - ArrayList<Integer> containing the next greater element for each position, or -1 if none exists
 *
 * Example:
 * Test Case 1: arr = [1, 3, 2, 4], Output = [3, 4, 4, -1]
 * Test Case 2: arr = [0, 2, 3, 1, 1], Output = [2, 3, -1, 2, 2]
 */
public class NextGreaterElementInCircularArray {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        // Process array twice to handle circular property
        for (int i = 0; i < 2 * n; i++) {
            int curr = arr[i % n];
            // Pop elements from stack while current element is greater
            while (!stack.isEmpty() && arr[stack.peek()] < curr) {
                result.set(stack.pop(), curr);
            }
            // Push current index (only in first n iterations to avoid duplicates)
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementInCircularArray sol = new NextGreaterElementInCircularArray();
        int[][] testCases = {
                {1, 3, 2, 4},
                {0, 2, 3, 1, 1}
        };

        for (int t = 0; t < testCases.length; t++) {
            ArrayList<Integer> result = sol.nextLargerElement(testCases[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}