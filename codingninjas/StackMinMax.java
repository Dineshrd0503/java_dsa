package codingninjas;

import java.util.*;
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//1. Push(num): Push the given number in the stack.
//2. Pop: Remove and return the top element from the stack if present, else return -1.
//        3. Top: return the top element of the stack if present, else return -1.
//        4. getMin: Returns minimum element of the stack if present, else return -1.
//For Example:
//
//For the following input:
//        1
//        5
//        1 1
//        1 2
//        4
//        2
//        3
//
//For the first two operations, we will just insert 1 and then 2 into the stack which was empty earlier. So now the stack is => [2,1]
//In the third operation, we need to return the minimum element of the stack, i.e., 1. So now the stack is => [2,1]
//For the fourth operation, we need to pop the topmost element of the stack, i.e., 2. Now the stack is => [1]
//In the fifth operation, we return the top element of the stack, i.e. 1 as it has one element. Now the stack is => [1]
//
//So, the final output will be:
//        1 2 1
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        2
//        5
//        1 1
//        1 2
//        4
//        2
//        3
//        4
//        1 13
//        2
//        3
//        4
//Sample Output 1 :
//        1 2 1
//        13 -1 -1
//Explanation For Sample Input 1 :
//For First Case - Similar to the example explained above.
//
//For Second Case -
//For the first operation, we will just insert 13 into the stack which was empty earlier. So now the stack is => [13]
//In the second operation, we need to remove the topmost element 13 and return it for printing. Now the stack is => [] (empty)
//For the third operation, we need to return the topmost element of the stack. As the stack is empty we will return -1. Now the stack is => [] (empty)
//In the fourth operation, we return the minimum element of the stack if it is not empty, i.e. -1 as it has no elements. Now the stack is => [] (empty)
//Sample Input 2 :
//        2
//        4
//        4
//        2
//        1 4
//        3
//        6
//        1 19
//        1 45
//        3
//        4
//        2
//        3
//Sample Output 2 :
//        -1 -1 4
//        45 19 45 19

public class StackMinMax {

    static class MinStack {
        Stack<Integer> stack;       // Main stack to store all elements
        Stack<Integer> minStack;    // Auxiliary stack to store minimum elements

        // Constructor
        MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Function to add another element equal to num at the top of the stack
        void push(int num) {
            stack.push(num);
            // Push the current minimum to the minStack
            if (minStack.isEmpty() || num <= minStack.peek()) {
                minStack.push(num);
            }
        }

        // Function to remove the top element of the stack
        int pop() {
            if (stack.isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            int removed = stack.pop();
            // If the removed element is the current minimum, pop it from the minStack as well
            if (removed == minStack.peek()) {
                minStack.pop();
            }
            return removed;
        }

        // Function to return the top element of the stack if present, otherwise -1
        int top() {
            if (stack.isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return stack.peek();
        }

        // Function to return the minimum element of the stack if present, otherwise -1
        int getMin() {
            if (minStack.isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return minStack.peek();
        }
    }

    // Main function for input/output handling
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int operations = sc.nextInt(); // Number of operations
            MinStack minStack = new MinStack();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < operations; i++) {
                int op = sc.nextInt();

                switch (op) {
                    case 1: // Push operation
                        int num = sc.nextInt();
                        minStack.push(num);
                        break;

                    case 2: // Pop operation
                        output.append(minStack.pop()).append(" ");
                        break;

                    case 3: // Top operation
                        output.append(minStack.top()).append(" ");
                        break;

                    case 4: // Get minimum operation
                        output.append(minStack.getMin()).append(" ");
                        break;
                }
            }
            System.out.println(output.toString().trim());
        }
        sc.close();
    }
}

