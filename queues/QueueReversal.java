package queues;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/*
Problem Statement:
Given a queue q containing integer elements, your task is to reverse the queue.

Examples:

Input: q[] = [5, 10, 15, 20, 25]
Output: [25, 20, 15, 10, 5]
Explanation: After reversing the given elements of the queue, the resultant queue will be 25 20 15 10 5.

Input: q[] = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
Explanation: After reversing the given elements of the queue, the resultant queue will be 5 4 3 2 1.

Constraints:
1 <= q.size() <= 10^3
0 <= q[i] <= 10^5

Expected Complexities:
Time Complexity: O(n)
Auxiliary Space: O(n)
*/

public class QueueReversal {

    /**
     * Reverses the given queue using an auxiliary array and two pointers.
     *
     * @param q The queue to be reversed.
     * @return The reversed queue.
     */
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        // Check if the queue is empty or null
        if (q == null || q.isEmpty()) {
            return q; // Return the queue as is if it's empty or null
        }

        int n = q.size(); // Get the size of the queue

        // Create a temporary array to store the queue elements
        Integer[] arr = new Integer[n];

        // Dequeue the elements from the queue and store them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = q.poll(); // Remove and store the head of the queue
        }

        // Use two pointers to reverse the array
        int left = 0;           // Left pointer starts at the beginning
        int right = n - 1;       // Right pointer starts at the end
        while (left < right) {  // Iterate until the pointers meet in the middle
            // Swap elements at the left and right pointers
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;           // Move the left pointer one step to the right
            right--;          // Move the right pointer one step to the left
        }


        // Enqueue the elements back into the queue from the reversed array
        for (int i = 0; i < n; i++) {
            q.offer(arr[i]); // Add the elements from the array back into the queue
        }

        return q; // Return the reversed queue
    }

    public static void main(String[] args) {
        // Example 1
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(5, 10, 15, 20, 25));
        QueueReversal sol = new QueueReversal();
        Queue<Integer> reversedQ1 = sol.reverseQueue(q1);
        System.out.println("Reversed Queue 1: " + reversedQ1); // Expected Output: [25, 20, 15, 10, 5]

        // Example 2
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Queue<Integer> reversedQ2 = sol.reverseQueue(q2);
        System.out.println("Reversed Queue 2: " + reversedQ2); // Expected Output: [5, 4, 3, 2, 1]

        // Example 3: Empty Queue
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> reversedQ3 = sol.reverseQueue(q3);
        System.out.println("Reversed Queue 3 (Empty): " + reversedQ3); // Expected Output: []

        // Example 4: Queue with single element
        Queue<Integer> q4 = new LinkedList<>(Arrays.asList(7));
        Queue<Integer> reversedQ4 = sol.reverseQueue(q4);
        System.out.println("Reversed Queue 4 (Single element): " + reversedQ4); // Expected Output: [7]
    }
}