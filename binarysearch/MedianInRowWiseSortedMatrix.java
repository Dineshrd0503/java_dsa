package binarysearch;

/*
Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.

Examples:

Input: mat[][] = [[1, 3, 5],
                [2, 6, 9],
                [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
Input: mat[][] = [[2, 4, 9],
                [3, 6, 7],
                [4, 7, 10]]
Output: 6
Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.
Input: mat = [[3], [4], [8]]
Output: 4
Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.
Constraints:
1 ≤ n, m ≤ 400
1 ≤ mat[i][j] ≤ 2000

Expected Complexities
Time Complexity: O(n log m * log(maxVal – minVal))
Auxiliary Space: O(1)

 */



public class MedianInRowWiseSortedMatrix {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum elements in the matrix
        for (int i = 0; i < n; i++) {
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][m - 1]);
        }

        int desired = (n * m + 1) / 2; // We need the element with this rank.

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;

            // Count the number of elements less than or equal to mid
            for (int i = 0; i < n; i++) {
                count += countSmaller(mat[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    // Binary search to count elements less than or equal to mid in a row
    private int countSmaller(int[] row, int mid) {
        int low = 0;
        int high = row.length - 1; // Corrected to row length - 1

        while (low <= high) { // Changed to <= to include both ends
            int m = low + (high - low) / 2;
            if (row[m] <= mid) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return low; // Returns the count of elements <= mid
    }

    public static void main(String[] args) {
        MedianInRowWiseSortedMatrix solution = new MedianInRowWiseSortedMatrix();

        // Problem Statement:
        // Given a row-wise sorted matrix mat[][] of size n*m, where n and m are odd,
        // return the median of the matrix. The median is the middle element when
        // all elements are sorted. Constraints: 1 <= n, m <= 400, 1 <= mat[i][j] <= 2000.

        // Sample Test Case 1
        // Input: [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
        // Expected Output: 5
        // Explanation: Sorted [1, 2, 3, 3, 5, 6, 6, 9, 9], median is 5th element.
        int[][] mat1 = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println("Test Case 1 Median: " + solution.median(mat1));

        // Sample Test Case 2
        // Input: [[2, 4, 9], [3, 6, 7], [4, 7, 10]]
        // Expected Output: 6
        // Explanation: Sorted [2, 3, 4, 4, 6, 7, 7, 9, 10], median is 5th element.
        int[][] mat2 = {{2, 4, 9}, {3, 6, 7}, {4, 7, 10}};
        System.out.println("Test Case 2 Median: " + solution.median(mat2));

        // Sample Test Case 3
        // Input: [[3], [4], [8]]
        // Expected Output: 4
        // Explanation: Sorted [3, 4, 8], median is 2nd element.
        int[][] mat3 = {{3}, {4}, {8}};
        System.out.println("Test Case 3 Median: " + solution.median(mat3));
    }
}
