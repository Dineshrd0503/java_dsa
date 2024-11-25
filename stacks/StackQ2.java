package stacks;
import java.util.Stack;

public class StackQ2 {
    static Stack<Integer> s = new Stack<Integer>();

    public static void main(String[] args) {
        System.out.println("Completely reversing a stack");

        // Push elements into the stack
        s.push(98);
        s.push(43);
        s.push(12);

        System.out.println("Displaying the elements:");
        display();  // Display the stack in its original state

        System.out.println("Reversed stack is:");
        reverse(s);  // Reverse the stack

        display();  // Display the stack after reversal
    }

    // Method to display the elements in the stack without altering the original stack
    public static void display() {
        if (s.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        int top = s.pop();
        System.out.println(top);  // Print the top element
        display();  // Recursively display the remaining elements
        s.push(top);  // Push the top element back to retain the original stack
    }

    // Method to push an element at the bottom of the stack
    public static void pushAtBottom(int data, Stack<Integer> s) {
        if (s.isEmpty()) {
            s.push(data);  // If stack is empty, push the data to the bottom
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);  // Recursive call to push the element at the bottom
        s.push(top);  // Push the top element back after placing data at the bottom
    }

    // Method to reverse the stack
    private static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();  // Pop the top element
        reverse(s);  // Reverse the remaining stack recursively
        pushAtBottom(top, s);  // Push the popped element at the bottom
    }
}
