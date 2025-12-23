package binarysearch;

/*
================================================================================
                        ROW WITH MAX 1s
                    GeeksforGeeks Problem
                    Difficulty: MEDIUM
================================================================================

PROBLEM STATEMENT:
You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row
of the array is sorted in non-decreasing order. Your task is to find and return
the index of the FIRST row that contains the MAXIMUM number of 1s.
If no such row exists, return -1.

KEY POINTS:
- Array follows 0-based indexing
- Each row is sorted in non-decreasing order (0s come first, then 1s)
- Find the FIRST row with maximum 1s (if tie, return smaller index)
- If no 1s exist in any row, return -1

EXAMPLE 1:
Input: arr[][] = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}}
Output: 2
Explanation: Row 2 contains the maximum number of 1s (4 ones).

EXAMPLE 2:
Input: arr[][] = {{0,0}, {1,1}}
Output: 1
Explanation: Row 1 contains the maximum number of 1s (2 ones).

EXAMPLE 3:
Input: arr[][] = {{0,0}, {0,0}}
Output: -1
Explanation: No row contains any 1s.

CONSTRAINTS:
- 1 ≤ arr.size(), arr[i].size() ≤ 10^3
- 0 ≤ arr[i][j] ≤ 1

EXPECTED COMPLEXITY:
- Time Complexity: O(n + m) where n = rows, m = columns
- Space Complexity: O(1)

APPROACH:
Use Two-Pointer technique starting from top-right corner:
- If current element is 1, update result and move left (check more 1s)
- If current element is 0, move down (no more 1s in this row due to sorting)
- This ensures we visit each element at most once

================================================================================
*/

public class RowWithMax1s {

    /**
     * OPTIMAL SOLUTION: Two-Pointer Approach O(n + m)
     * Start from top-right corner and traverse intelligently
     *
     * @param arr 2D binary array sorted in each row
     * @return index of first row with maximum 1s, or -1 if no 1s exist
     */
    public static int rowWithMax1s(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;      // number of rows
        int m = arr[0].length;   // number of columns

        // Start from top-right corner
        int row = 0;
        int col = m - 1;
        int maxRowIndex = -1;

        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                // Found a 1, this row has at least (col + 1) ones
                // Update result as this is the leftmost 1 in this row
                maxRowIndex = row;

                // Move left to find if there are more 1s in this row
                col--;
            } else {
                // Current element is 0
                // Since row is sorted, no more 1s exist to the left
                // Move to next row
                row++;
            }
        }

        return maxRowIndex;
    }

    /**
     * UTILITY: Print 2D array for debugging
     */
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Row " + i + ": [");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    /**
     * MAIN METHOD: Test all solutions with examples
     */
    public static void main(String[] args) {
        System.out.println("================== ROW WITH MAX 1s ==================\n");

        // Test Case 1: Normal case
        System.out.println("TEST CASE 1:");
        int[][] arr1 = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println("Input Array:");
        printArray(arr1);
        System.out.println("Expected Output: 2");
        System.out.println("Solution (Two-Pointer): " + rowWithMax1s(arr1));
        System.out.println();

        // Test Case 2: Different case
        System.out.println("TEST CASE 2:");
        int[][] arr2 = {{0, 0}, {1, 1}};
        System.out.println("Input Array:");
        printArray(arr2);
        System.out.println("Expected Output: 1"); // Corrected expected output
        System.out.println("Solution (Two-Pointer): " + rowWithMax1s(arr2));
        System.out.println();

        // Test Case 3: No 1s
        System.out.println("TEST CASE 3:");
        int[][] arr3 = {{0, 0}, {0, 0}};
        System.out.println("Input Array:");
        printArray(arr3);
        System.out.println("Expected Output: -1"); // Corrected expected output
        System.out.println("Solution (Two-Pointer): " + rowWithMax1s(arr3));
        System.out.println();

        // Test Case 4: All 1s in first row
        System.out.println("TEST CASE 4:");
        int[][] arr4 = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        System.out.println("Input Array:");
        printArray(arr4);
        System.out.println("Expected Output: 0"); // Corrected expected output
        System.out.println("Solution (Two-Pointer): " + rowWithMax1s(arr4));
        System.out.println();

        // Test Case 5: Single row
        System.out.println("TEST CASE 5:");
        int[][] arr5 = {{0, 1, 1, 1, 1}};
        System.out.println("Input Array:");
        printArray(arr5);
        System.out.println("Expected Output: 0"); // Corrected expected output
        System.out.println("Solution (Two-Pointer): " + rowWithMax1s(arr5));
        System.out.println();

        // Test Case 6: Complex case
        System.out.println("TEST CASE 6:");
        int[][] arr6 = {{0, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}};
        System.out.println("Input Array:");
        printArray(arr6);
        System.out.println("Expected Output: 2"); // Corrected expected output
        System.out.println("Solution (Two-Pointer): " + rowWithMax1s(arr6));
        System.out.println();

        System.out.println("==================== COMPLEXITY ANALYSIS ====================");
        System.out.println("Solution (Two-Pointer):  Time: O(n+m), Space: O(1) ⭐");
        System.out.println();
    }
}
