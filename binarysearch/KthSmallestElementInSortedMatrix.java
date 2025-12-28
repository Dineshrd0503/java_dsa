package binarysearch;

/*
 * PROBLEM STATEMENT:
 *
 * Kth Smallest Element in a Sorted Matrix
 * LeetCode Problem #378
 * Difficulty: Medium
 *
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 *
 * You must find a solution with memory complexity better than O(n²).
 *
 * CONSTRAINTS:
 * - n == matrix.length == matrix[i].length
 * - 1 <= n <= 300
 * - -10^9 <= matrix[i][j] <= 10^9
 * - All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order
 * - 1 <= k <= n²
 *
 * EXAMPLES:
 * Example 1:
 * Input: matrix = [[1,2],[1,1]], k = 1
 * Output: 1
 *
 * Example 2:
 * Input: matrix = [[1,2],[1,1]], k = 2
 * Output: 1
 *
 * Example 3:
 * Input: matrix = [[1,2],[1,1]], k = 3
 * Output: 2
 */

import java.util.*;

public class KthSmallestElementInSortedMatrix {

    /**
     * Find the kth smallest element in a sorted matrix using binary search
     * Time Complexity: O(n * log(max - min))
     * Space Complexity: O(1)
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                // kth element is greater than mid
                low = mid + 1;
            } else {
                // kth element is <= mid
                high = mid;
            }
        }

        return low;
    }

    /**
     * Count how many elements are <= value in the matrix
     * Uses two-pointer technique from top-right corner
     * Time Complexity: O(n)
     */
    private static int countLessEqual(int[][] matrix, int value) {
        int n = matrix.length;
        int count = 0;
        int row = 0;
        int col = n - 1;

        // Start from top-right corner
        while (row < n && col >= 0) {
            if (matrix[row][col] <= value) {
                // All elements in this row from index 0 to col are <= value
                count += col + 1;
                row++;  // Move down
            } else {
                // matrix[row][col] > value, move left
                col--;
            }
        }

        return count;
    }

    /**
     * Alternative Solution using Min Heap (Priority Queue)
     * Time Complexity: O(k * log(n))
     * Space Complexity: O(n)
     */
    public static int kthSmallestUsingHeap(int[][] matrix, int k) {
        int n = matrix.length;

        // Create a min heap storing [value, row, col]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add the top-left element
        minHeap.offer(new int[]{matrix[0][0], 0, 0});

        // Set to track visited elements
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int count = 0;
        int result = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int row = current[1];
            int col = current[2];

            count++;
            result = value;

            if (count == k) {
                return result;
            }

            // Add right element
            if (col + 1 < n && !visited.contains(row + "," + (col + 1))) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
                visited.add(row + "," + (col + 1));
            }

            // Add bottom element
            if (row + 1 < n && !visited.contains((row + 1) + "," + col)) {
                minHeap.offer(new int[]{matrix[row + 1][col], row + 1, col});
                visited.add((row + 1) + "," + col);
            }
        }

        return result;
    }

    /**
     * Main method to test the solution
     */
    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {{1, 2}, {1, 1}};
        int k1 = 1;
        System.out.println("Test Case 1:");
        System.out.println("Matrix: " + Arrays.deepToString(matrix1));
        System.out.println("k = " + k1);
        System.out.println("Output (Binary Search): " + kthSmallest(matrix1, k1));
        System.out.println("Output (Heap): " + kthSmallestUsingHeap(matrix1, k1));
        System.out.println();

        // Test Case 2
        int[][] matrix2 = {{1, 2}, {1, 1}};
        int k2 = 3;
        System.out.println("Test Case 2:");
        System.out.println("Matrix: " + Arrays.deepToString(matrix2));
        System.out.println("k = " + k2);
        System.out.println("Output (Binary Search): " + kthSmallest(matrix2, k2));
        System.out.println("Output (Heap): " + kthSmallestUsingHeap(matrix2, k2));
        System.out.println();

        // Test Case 3 (from GeeksforGeeks)
        int[][] matrix3 = {{16, 28, 60, 64}, {22, 41, 63, 91}, {27, 50, 87, 93}, {36, 78, 87, 94}};
        int k3 = 3;
        System.out.println("Test Case 3:");
        System.out.println("Matrix: " + Arrays.deepToString(matrix3));
        System.out.println("k = " + k3);
        System.out.println("Output (Binary Search): " + kthSmallest(matrix3, k3));
        System.out.println("Output (Heap): " + kthSmallestUsingHeap(matrix3, k3));
        System.out.println();

        // Test Case 4 (from GeeksforGeeks)
        int[][] matrix4 = {{10, 20, 30, 40}, {15, 25, 35, 45}, {24, 29, 37, 48}, {32, 33, 39, 50}};
        int k4 = 7;
        System.out.println("Test Case 4:");
        System.out.println("Matrix: " + Arrays.deepToString(matrix4));
        System.out.println("k = " + k4);
        System.out.println("Output (Binary Search): " + kthSmallest(matrix4, k4));
        System.out.println("Output (Heap): " + kthSmallestUsingHeap(matrix4, k4));
        System.out.println();

        // Test Case 5 (Large test case)
        int[][] matrix5 = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k5 = 8;
        System.out.println("Test Case 5:");
        System.out.println("Matrix: " + Arrays.deepToString(matrix5));
        System.out.println("k = " + k5);
        System.out.println("Output (Binary Search): " + kthSmallest(matrix5, k5));
        System.out.println("Output (Heap): " + kthSmallestUsingHeap(matrix5, k5));
    }
}
