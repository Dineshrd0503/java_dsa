package heap;

/*
Problem: Minimum Cost of ropes
Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
The cost to connect two ropes is the sum of their lengths.

Examples:
Input: arr[] = [4, 3, 2, 6]
Output: 29

Input: arr[] = [4, 2, 7, 6, 9]
Output: 62

Input: arr[] = [10]
Output: 0
*/

import java.util.*;

public class MinCostOfRopes {
    // Function to return the minimum cost of connecting the ropes
    public static int minCost(int[] arr) {
        if (arr.length <= 1) return 0;

        // Min heap to store rope lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : arr) {
            minHeap.add(rope);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            // Take the two shortest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            // Insert the combined rope back into the heap
            minHeap.add(cost);
        }
        return totalCost;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 6};
        System.out.println(minCost(arr1)); // Output: 29

        int[] arr2 = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr2)); // Output: 62

        int[] arr3 = {10};
        System.out.println(minCost(arr3)); // Output: 0
    }
}

