package heap;

/*
Problem: Nearly Sorted

Given an array 'arr' where every element is at most k positions away from its target position,
sort the array efficiently in-place. Do not use default sorting functions.

Constraints:
1 <= arr.length <= 10^6
0 <= k < arr.length
1 <= arr[i] <= 10^6

Approach:
Use a Min-Heap (PriorityQueue) of size k+1 to extract the minimum element in range
and place it in its sorted position. Time complexity = O(n log k)
*/

import java.util.*;

public class NearlySorted {

    // Function to sort a nearly sorted array
    public static void nearlySorted(int[] arr, int k) {
        // Min-Heap to store the next k+1 elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;
        int index = 0;

        // Step 1: Insert first k+1 elements into heap
        for (int i = 0; i < Math.min(k + 1, n); i++) {
            minHeap.add(arr[i]);
        }

        // Step 2: For remaining elements, replace and insert in heap
        for (int i = k + 1; i < n; i++) {
            // Extract min and put at current index
            arr[index++] = minHeap.poll();
            // Add current array element to heap
            minHeap.add(arr[i]);
        }

        // Step 3: Extract remaining elements from heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Static input array & k
        int[] arr = {6, 5, 3, 2, 8, 10, 9}; // Example: Every element is at most 3 positions away
        int k = 3;

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        // Call nearlySorted
        nearlySorted(arr, k);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}

/*
Sample Output:
Original array:
[6, 5, 3, 2, 8, 10, 9]
Sorted array:
[2, 3, 5, 6, 8, 9, 10]
*/

