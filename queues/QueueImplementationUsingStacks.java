package queues;

import java.util.Stack;

/**
 * This class implements a Queue data structure using two stacks.
 * This approach ensures that the enqueue operation is O(1) and the dequeue operation is amortized O(1).
 */


/**
 * A main class to demonstrate the functionality of the Queue class.
 */
public class QueueImplementationUsingStacks {
    static class Queue {
        // Stacks to be used in the operations.
        // stk1 is used for enqueue operations.
        // stk2 is used for dequeue operations.
        Stack<Integer> stk1, stk2;

        /**
         * Constructor to initialize the two stacks.
         */
        public Queue() {
            stk1 = new Stack<>();
            stk2 = new Stack<>();
        }

        /**
         * Enqueues 'x' into the queue.
         * This operation is always O(1) as it's just a push to stk1.
         * @param x The integer element to be added to the queue.
         * @return always returns true after enqueuing.
         */
        public boolean enqueue(int x) {
            stk1.push(x);
            return true;
        }

        /**
         * Dequeues the front element from the queue.
         * If stk2 is empty, it transfers all elements from stk1 to stk2.
         * This reverses the order of elements, placing the oldest element at the top of stk2.
         * @return The dequeued element, or -1 if the queue is empty.
         */
        public int dequeue() {
            // If stk2 is empty, it means we need to transfer elements from stk1.
            if (stk2.isEmpty()) {
                // While stk1 is not empty, pop from stk1 and push to stk2.
                while (!stk1.isEmpty()) {
                    stk2.push(stk1.pop());
                }
            }

            // If stk2 is still empty after the transfer attempt, the queue is truly empty.
            if (stk2.isEmpty()) {
                return -1;
            } else {
                // Pop the top element from stk2, which is the front of the queue.
                return stk2.pop();
            }
        }
    }
    public static void main(String[] args) {
        // Create a new Queue object
        Queue myQueue = new Queue();

        System.out.println("Enqueuing elements: 1, 2, 3");
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println("Dequeuing element: " + myQueue.dequeue()); // Should print 1
        System.out.println("Dequeuing element: " + myQueue.dequeue()); // Should print 2

        System.out.println("Enqueuing element: 4");
        myQueue.enqueue(4);

        System.out.println("Dequeuing element: " + myQueue.dequeue()); // Should print 3
        System.out.println("Dequeuing element: " + myQueue.dequeue()); // Should print 4

        System.out.println("Attempting to dequeue from empty queue...");
        System.out.println("Dequeuing element: " + myQueue.dequeue()); // Should print -1
    }
}
