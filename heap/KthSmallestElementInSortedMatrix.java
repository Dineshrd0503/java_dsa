package heap;

/*
 * Problem Statement:
 * Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order.
 * Find the kth smallest element in the matrix.
 *
 * Constraints:
 * 1 <= n <= 500
 * 1 <= mat[i][j] <= 10000
 * 1 <= k <= n*n
 *
 * Examples:
 * Example 1:
 * Input: n = 4, mat[][] = [[16, 28, 60, 64], [22, 41, 63, 91], [27, 50, 87, 93], [36, 78, 87, 94]], k = 3
 * Output: 27
 * Explanation: 27 is the 3rd smallest element.
 *
 * Example 2:
 * Input: n = 4, mat[][] = [[10, 20, 30, 40], [15, 25, 35, 45], [24, 29, 37, 48], [32, 33, 39, 50]], k = 7
 * Output: 30
 * Explanation: 30 is the 7th smallest element.
 */

import java.util.PriorityQueue;

// Main class to find the k-th smallest element in a sorted matrix
public class KthSmallestElementInSortedMatrix {
    // Method to find the k-th smallest element in the matrix
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; // Size of the matrix (n x n)

        // Edge case: if matrix is empty or k is invalid
        if (n == 0 || k < 1 || k > n * n) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Define a class to store the element value, row, and column
        class Element {
            int val, row, col;
            Element(int val, int row, int col) {
                this.val = val;
                this.row = row;
                this.col = col;
            }
        }

        // Create a min-heap based on element values
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first element of each row to the heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Element(matrix[i][0], i, 0));
        }

        // Pop the smallest element k times
        for (int i = 0; i < k - 1; i++) {
            Element current = minHeap.poll();
            int row = current.row;
            int col = current.col;

            // If there is a next element in the same row, add it to the heap
            if (col + 1 < n) {
                minHeap.offer(new Element(matrix[row][col + 1], row, col + 1));
            }
        }

        // The k-th element is the top of the heap
        return minHeap.poll().val;
    }

    // Main method to test the kthSmallest function with sample test cases
    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
                {16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94}
        };
        int k1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Matrix:");
        printMatrix(matrix1);
        System.out.println("k = " + k1);
        System.out.println("k-th smallest element: " + kthSmallest(matrix1, k1));

        // Test Case 2
        int[][] matrix2 = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int k2 = 7;
        System.out.println("\nTest Case 2:");
        System.out.println("Matrix:");
        printMatrix(matrix2);
        System.out.println("k = " + k2);
        System.out.println("k-th smallest element: " + kthSmallest(matrix2, k2));
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
