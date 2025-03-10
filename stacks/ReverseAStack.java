package stacks;

import java.util.Stack;
//You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
//
//We can only use the following functions on this stack S.
//
//is_empty(S) : Tests whether stack is empty or not.
//push(S) : Adds a new element to the stack.
//pop(S) : Removes top element from the stack.
//top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.
//Note :
//        1) Use of any loop constructs like while, for..etc is not allowed.
//        2) The stack may contain duplicate integers.
//        3) The stack may contain any integer i.e it may either be negative, positive or zero.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= 'T' <= 100
//        1 <=  'N' <= 100
//        1 <= |'V'| <= 10^9
//
//Where |V| denotes the absolute value of any stack element.
//
//Time limit: 1 sec
//Sample Input 1:
//        1
//        5
//        5 -2 9 -7 3
//Sample Output 1:
//        9 5 3 -2 -7
//Explanation of Sample Input 1:
//        9 Is the largest element, hence it’s present at the top. Similarly 5>3, 3>-2 and -7 being the smallest element is present at the last.
//Sample Input 2:
//        1
//        5
//        -3 14 18 -5 30
//Sample Output 2:
//        30 18 14 -3 -5
//Explanation of Sample Input 2:
//        30 is the largest element, hence it’s present at the top. Similarly, 18>14, 14>-3 and -5 being the smallest element is present at the last.
public class ReverseAStack {
    public static void sortStack(Stack<Integer> stack) {
        // Base condition: If stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int ele = stack.pop();

        // Step 2: Sort the remaining stack recursively
        sortStack(stack);

        // Step 3: Insert the popped element into the sorted stack
        insertInSortedOrder(stack, ele);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int ele) {
        // Base condition: If stack is empty or the top element is larger, push the element
        if (stack.isEmpty() || stack.peek() <= ele) {
            stack.push(ele);
            return;
        }

        // Otherwise, pop the top element and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, ele);

        // Push the previously popped element back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        System.out.println("Original Stack:");
        System.out.println(stack);

        sortStack(stack);

        System.out.println("\nSorted Stack:");
        System.out.println(stack);
    }

}
