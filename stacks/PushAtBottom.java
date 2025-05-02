package stacks;

/*
Problem Statement:
Given a stack of integers myStack and an integer x, push x to the bottom of the stack and return the modified stack.

Example:
- Input: myStack = [5, 6, 7] (top is 7), x = 4
  Output: [7, 6, 5, 4] (top is 7, bottom is 4)

Approach:
- Use an auxiliary Stack to temporarily hold the stack elements.
- Transfer all elements from the original stack to the auxiliary stack (reversing the order).
- Push x to the original stack (now empty, so x becomes the bottom).
- Transfer all elements back from the auxiliary stack to the original stack.
*/

import java.util.*;

public class PushAtBottom {
    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        // Step 1: Create an auxiliary stack to temporarily hold the elements
        Stack<Integer> auxStack = new Stack<>();

        // Step 2: Transfer all elements from myStack to auxStack
        while (!myStack.isEmpty()) {
            auxStack.push(myStack.pop());
        }

        // Step 3: Push x to myStack (now empty, so x becomes the bottom)
        myStack.push(x);

        // Step 4: Transfer all elements back from auxStack to myStack
        while (!auxStack.isEmpty()) {
            myStack.push(auxStack.pop());
        }

        // Step 5: Return the modified stack
        return myStack;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test Case 1: myStack = [5, 6, 7], x = 4
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        int x1 = 4;
        System.out.println("Test Case 1:");
        System.out.println("Input Stack (top to bottom): " + stack1);
        System.out.println("x: " + x1);
        Stack<Integer> result1 = pushAtBottom(stack1, x1);
        System.out.println("Output Stack (top to bottom): " + result1);
        System.out.println("Expected: [7, 6, 5, 4]\n");

        // Test Case 2: Empty stack, x = 1
        Stack<Integer> stack2 = new Stack<>();
        int x2 = 1;
        System.out.println("Test Case 2:");
        System.out.println("Input Stack (top to bottom): " + stack2);
        System.out.println("x: " + x2);
        Stack<Integer> result2 = pushAtBottom(stack2, x2);
        System.out.println("Output Stack (top to bottom): " + result2);
        System.out.println("Expected: [1]");
    }
}
