package binarysearch;

/*
1351. Count Negative Numbers in a Sorted Matrix

Given an m x n matrix grid which is sorted in non-increasing order
both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input:  grid = [[4,3,2,-1],
                [3,2,1,-1],
                [1,1,-1,-2],
                [-1,-1,-2,-3]]
Output: 8

Example 2:
Input:  grid = [[3,2],
                [1,0]]
Output: 0

Constraints:
- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 100
- -100 <= grid[i][j] <= 100

Follow up: Could you find an O(n + m) solution?
*/

import java.util.*;

public class CountNegativeNumbersInSortedMatrix {

    // --------- SOLUTION METHOD (O(m + n)) ----------
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int i = m - 1;   // start from bottom row
        int j = 0;       // start from first column
        int count = 0;

        // Staircase walk from bottom-left to top-right
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                // grid[i][j] is negative, so all elements to the right are negative
                count += (n - j);
                i--; // move up to previous row
            } else {
                // non-negative, so all elements above in this column are >= this
                // move right to find negatives
                j++;
            }
        }

        return count;
    }

    // --------- MAIN METHOD FOR TESTING ----------
    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println("Example 1 Output: " + countNegatives(grid1)); // expected 8

        // Example 2
        int[][] grid2 = {
                {3, 2},
                {1, 0}
        };
        System.out.println("Example 2 Output: " + countNegatives(grid2)); // expected 0

        // Custom test
        int[][] grid3 = {
                {10, 5, 0},
                {5,  0, -1},
                {2, -1, -3}
        };
        System.out.println("Custom Example Output: " + countNegatives(grid3));
    }
}
