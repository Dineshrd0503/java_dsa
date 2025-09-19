package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

    /**
     * Finds the k-th smallest element in a list using a min-heap.
     *
     * @param v The list of integers.
     * @param k The position of the smallest element to find (e.g., k=1 for the smallest).
     * @return The k-th smallest integer.
     */
    public static int kthSmallestWithMinHeap(ArrayList<Integer> v, int k) {
        // By default, PriorityQueue in Java is a min-heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 1. Add all elements from the list to the heap.
        // This operation takes O(N log N) time.
        minHeap.addAll(v);

        // 2. Remove the first (k-1) smallest elements from the heap.
        // This loop runs k-1 times, and each poll() takes O(log N).
        for (int i = 0; i < k - 1; i++) {
            minHeap.poll(); // Removes the smallest element at the top.
        }

        // 3. The element now at the top of the heap is the k-th smallest.
        // We use peek() to get the element without removing it.
        return minHeap.peek();
    }

    /**
     * The main method to test the functionality with static inputs.
     */
    public static void main(String[] args) {
        // --- Static Inputs ---
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(7, 10, 4, 3, 20, 15));
        int k = 3;

        System.out.println("Input List: " + numbers);
        System.out.println("Value of k: " + k);
        System.out.println("-------------------------------------");

        // --- Calling the method and printing the result ---
        int result = kthSmallestWithMinHeap(numbers, k);

        System.out.println("The " + k + "rd smallest element is: " + result);

        // --- Another example ---
        k = 5;
        System.out.println("\n--- Another Example ---");
        System.out.println("Value of k: " + k);
        result = kthSmallestWithMinHeap(numbers, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
