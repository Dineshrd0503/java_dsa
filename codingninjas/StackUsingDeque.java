package codingninjas;

import java.util.* ;
import java.io.*;
public class StackUsingDeque {
    // Initialize your data structure.
    private Deque<Integer> deque;
    StackUsingDeque() {
        deque=new LinkedList<>();

    }

    // Pushes 'X' into the stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x) {
        deque.addLast(x);
        return true;
        // Write your code here.
    }

    // Pops top element from Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop() {
        if(deque.isEmpty())
            return -1;
        return deque.removeLast();
        // Write your code here.
    }

    // Returns the topmost element of the stack. In case the stack is empty, it returns -1.
    public int top() {
        if(deque.isEmpty())
            return -1;
        return deque.peekLast();
        // Write your code here.
    }

    // Returns true if the stack is empty, otherwise false.
    public boolean isEmpty() {
        return deque.isEmpty();

        // Write your code here.
    }

    // Returns the number of elements currently present in the stack.
    public int size() {
        return deque.size();
        // Write your code here.
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        StackUsingDeque stack = new StackUsingDeque();

        int q = sc.nextInt();  // Read number of queries

        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();  // Read the query type

            switch (queryType) {
                case 1: // Push operation
                    int x = sc.nextInt();
                    System.out.println(stack.push(x));
                    break;

                case 2: // Pop operation
                    System.out.println(stack.pop());
                    break;

                case 3: // Top operation
                    System.out.println(stack.top());
                    break;

                case 4: // IsEmpty operation
                    System.out.println(stack.isEmpty());
                    break;

                case 5: // Size operation
                    System.out.println(stack.size());
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}