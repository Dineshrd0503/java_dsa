package arrays;

import java.util.Arrays;

public class MaxAreaOfLongestDiagonalRectangle {

    /*
     * ====================================================================
     * Problem Statement: Find Area of Rectangle with Largest Diagonal
     * ====================================================================
     *
     * You are given a 2D integer array `dimensions` where each `dimensions[i] = [li, wi]`
     * represents the length and width of the ith rectangle.
     *
     * Your task is to find the area of the rectangle that has the longest diagonal.
     * If there are multiple rectangles with the same longest diagonal, return the
     * area of the one with the largest area.
     *
     * ====================================================================
     * Sample Test Cases
     * ====================================================================
     *
     * Example 1:
     * Input: dimensions = [[9,3],[8,6]]
     * Output: 48
     * Explanation:
     * For rectangle [9,3]: diagonal^2 = 9*9 + 3*3 = 81 + 9 = 90. Area = 27.
     * For rectangle [8,6]: diagonal^2 = 8*8 + 6*6 = 64 + 36 = 100. Area = 48.
     * The second rectangle has the longer diagonal, so its area (48) is returned.
     *
     * Example 2:
     * Input: dimensions = [[3,4],[4,3]]
     * Output: 12
     * Explanation:
     * Both rectangles have the same diagonal^2 = 3*3 + 4*4 = 25.
     * Both also have the same area of 12. So, 12 is returned.
     */

    /**
     * Finds the area of the rectangle with the maximum diagonal. In case of a tie
     * in diagonal length, it returns the largest area among the tied rectangles.
     *
     * @param dimensions A 2D array where each inner array contains the length and width.
     * @return The area of the rectangle with the largest diagonal.
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSquared = 0; // Stores the SQUARE of the max diagonal
        int maxArea = 0;            // Stores the area of the rectangle with the max diagonal

        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];

            // Calculate the square of the diagonal. This is more accurate and
            // faster than using Math.sqrt().
            int currentDiagonalSquared = length * length + width * width;

            // If we find a rectangle with a strictly larger diagonal...
            if (currentDiagonalSquared > maxDiagonalSquared) {
                maxDiagonalSquared = currentDiagonalSquared; // Update the max diagonal
                maxArea = length * width; // Store the area of this new rectangle
            }
            // If it's a tie in diagonal length...
            else if (currentDiagonalSquared == maxDiagonalSquared) {
                // ...store the larger area among the tied rectangles.
                maxArea = Math.max(maxArea, length * width);
            }
        }
        // Return the area of the rectangle that has the largest diagonal.
        return maxArea;
    }

    // Main method to test the areaOfMaxDiagonal function with static inputs.
    public static void main(String[] args) {
        MaxAreaOfLongestDiagonalRectangle sol = new MaxAreaOfLongestDiagonalRectangle();

        // Test Case 1
        int[][] dims1 = {{9, 3}, {8, 6}};
        System.out.println("Input: " + Arrays.deepToString(dims1));
        System.out.println("Area of max diagonal: " + sol.areaOfMaxDiagonal(dims1)); // Expected: 48
        System.out.println("--------------------");

        // Test Case 2
        int[][] dims2 = {{3, 4}, {4, 3}};
        System.out.println("Input: " + Arrays.deepToString(dims2));
        System.out.println("Area of max diagonal: " + sol.areaOfMaxDiagonal(dims2)); // Expected: 12
        System.out.println("--------------------");

        // Test Case 3 (with a tie in diagonal, but different areas)
        int[][] dims3 = {{6, 8}, {10, 1}};
        // Diagonal^2 for [6,8] is 36+64=100, Area=48
        // Diagonal^2 for [10,1] is 100+1=101, Area=10
        System.out.println("Input: " + Arrays.deepToString(dims3));
        System.out.println("Area of max diagonal: " + sol.areaOfMaxDiagonal(dims3)); // Expected: 10
        System.out.println("--------------------");
    }
}
