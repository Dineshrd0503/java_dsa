package arrays;

import java.util.PriorityQueue;

public class KthLargestSumContingousArray {

    // Problem Description:
    /*
     K-th Largest Sum Contiguous Subarray
     Difficulty: Medium

     Given an array arr[] of size n, find the sum of the K-th largest sum among all contiguous subarrays.
     In other words, identify the K-th largest sum from all possible subarrays and return it.

     Example Test Cases:
     Input: arr[] = [3, 2, 1], k = 2
     Output: 5
     Explanation: The different subarray sums we can get from the array are = [6, 5, 3, 2, 1]. Where 5 is the 2nd largest.

     Input: arr[] = [2, 6, 4, 1], k = 3
     Output: 11
     Explanation: The different subarray sums we can get from the array are = [13, 12, 11, 10, 8, 6, 5, 4, 2, 1]. Where 11 is the 3rd largest.

     Constraints:
     1 <= arr.size() <= 1000
     1 <= k <= (n*(n+1))/2
     -10^5 <= arr[i] <= 10^5
    */

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 1}; // Example input array
        int k = 3; // Example k

        int result = kthLargest(arr, k);
        System.out.println(result); // Output the result
    }

    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j]; // Calculate the sum of the subarray
                if (minHeap.size() < k) {
                    minHeap.add(sum);
                } else if (sum > minHeap.peek()) {
                    minHeap.poll(); // Remove the smallest sum
                    minHeap.add(sum); // Add the current sum
                }
            }
        }
        return minHeap.peek(); // Return the k-th largest sum
    }
}
