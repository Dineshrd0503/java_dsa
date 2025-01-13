package geeksforgeeks;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
//Given an array of integers, find the Kth largest sum of subarrays. A subarray is a contiguous part of an array.
//nput
//        arr: An ArrayList of integers (both positive and negative).
//        k: An integer representing the Kth largest sum to find.
//        Output
//        An integer representing the Kth largest sum of subarrays.
//        Example
//        Example 1
//        Input:
//ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, -2, 5));
//        int k = 3;
//        Output:
//        3
//        Explanation: The sums of all subarrays are: [3], [3, -2], [3, -2, 5], [-2], [-2, 5], [5]. The sorted sums are: [6, 5, 3, 3, 1, -2]. The 3rd largest sum is 3.


        public class KthLargestSumSubArray {


        public static int getKthLargest(ArrayList<Integer> arr, int k) {
            // Priority queue to store the K largest sums
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            // Iterate over all possible subarrays
            for (int start = 0; start < arr.size(); start++) {
                int sum = 0;
                for (int end = start; end < arr.size(); end++) {
                    sum += arr.get(end);

                    // If the heap has less than k elements, add the current sum
                    if (minHeap.size() < k) {
                        minHeap.add(sum);
                    } else if (sum > minHeap.peek()) {
                        // If the current sum is larger than the smallest sum in the heap, replace it
                        minHeap.poll();
                        minHeap.add(sum);
                    }
                }
            }

            // The root of the heap is the Kth largest sum
            return minHeap.peek();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = 2; // Number of test cases

            // Test case 1
            ArrayList<Integer> arr1 = new ArrayList<>();
            arr1.add(3);
            arr1.add(-2);
            arr1.add(5);
            int k1 = 3;
            System.out.println(getKthLargest(arr1, k1)); // Output: 3

            // Test case 2
            ArrayList<Integer> arr2 = new ArrayList<>();
            arr2.add(4);
            arr2.add(1);
            int k2 = 2;
            System.out.println(getKthLargest(arr2, k2)); // Output: 4
        }
    }
