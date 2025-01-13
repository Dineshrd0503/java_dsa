package stacks;

import java.util.Stack;
//You are given two arrays A and B of unique elements of size N. Check if array B is a stack permutation of the array A or not.
//Stack permutation means that array B can be created from array A using a stack and stack operations.
//
//
//
//Example 1:
//
//Input:
//N = 3
//A = {1,2,3}
//B = {2,1,3}
//Output:
//        1
//Explanation:
//        1. push 1 from A to stack
//2. push 2 from A to stack
//3. pop 2 from stack to B
//4. pop 1 from stack to B
//5. push 3 from A to stack
//6. pop 3 from stack to B
//
//
//Example 2:
//
//Input:
//N = 3
//A = {1,2,3}
//B = {3,1,2}
//Output:
//        0
//Explanation:
//Not Possible

public class ValidStackPermutation {
    public static int isStackPermutation(int n, int[] first, int[] second) {
        // If sizes of the arrays are different, it's not a valid permutation
        if (first.length != second.length) {
            return 1; // Not a valid permutation
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for the second array

        // Traverse each element in the first array
        for (int i = 0; i < n; i++) {
            stack.push(first[i]); // Push the current element from the first array

            // Pop elements from the stack while they match the current element in `second`
            while (!stack.isEmpty() && stack.peek() == second[j]) {
                stack.pop();
                j++; // Move to the next element in `second`
            }
        }

        // If we've processed all elements in `second`, it's a valid permutation
        return stack.isEmpty() ? 1: 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {5, 4, 3, 2, 1};

        System.out.println(isStackPermutation(n, first, second));
    }

}
