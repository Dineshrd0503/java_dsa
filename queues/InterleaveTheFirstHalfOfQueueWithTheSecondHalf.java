package queues;

import java.util.*;

public class InterleaveTheFirstHalfOfQueueWithTheSecondHalf {
    /*
     * PROBLEM: Interleave The First Half Of The Queue With The Second Half
     *
     * You have been given a queue of integers. You need to rearrange the elements
     * of the queue by interleaving the elements of the first half with the second half.
     *
     * EXAMPLE:
     * Input:  Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
     * Output: Q = [10, 60, 20, 70, 30, 80, 40, 90, 50, 100]
     *
     * APPROACH:
     * 1. Split the queue into two halves using a stack
     * 2. First half goes to stack, second half stays in queue
     * 3. Interleave by alternately taking from stack and queue
     *
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     */

    public static Queue<Integer> interLeaveQueue(Queue<Integer> q) {
        int n = q.size();
        int half = n / 2;

        // Push first half to stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < half; i++) {
            stack.push(q.poll());
        }

        // Interleave: push stack elements back to queue (reverse order)
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        // Now queue has: [second_half, reversed_first_half]
        // Move second half to stack
        for (int i = 0; i < half; i++) {
            stack.push(q.poll());
        }

        // Interleave: alternate between stack (reversed first) and queue
        while (!stack.isEmpty()) {
            // Add from reversed first half (stack)
            q.offer(stack.pop());
            // Add from second half (queue)
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        return q;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1
        Queue<Integer> q1 = new LinkedList<>();
        int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for (int x : arr1) {
            q1.offer(x);
        }

        System.out.println("Test Case 1:");
        System.out.println("Input:  " + arr1);
        Queue<Integer> result1 = interLeaveQueue(q1);
        System.out.print("Output: ");
        while (!result1.isEmpty()) {
            System.out.print(result1.poll() + " ");
        }
        System.out.println("\nExpected: 10 60 20 70 30 80 40 90 50 100");
        System.out.println();

        // Test Case 2
        Queue<Integer> q2 = new LinkedList<>();
        int[] arr2 = {10, 20, 30, 40, 50, 60};
        for (int x : arr2) {
            q2.offer(x);
        }

        System.out.println("Test Case 2:");
        System.out.println("Input:  " + Arrays.toString(arr2));
        Queue<Integer> result2 = interLeaveQueue(q2);
        System.out.print("Output: ");
        while (!result2.isEmpty()) {
            System.out.print(result2.poll() + " ");
        }
        System.out.println("\nExpected: 10 40 20 50 30 60");
    }
}
