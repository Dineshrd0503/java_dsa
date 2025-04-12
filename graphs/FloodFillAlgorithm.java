package graphs;

/**
 * Problem Description:
 * Given a 2D image represented by an m x n integer grid where image[i][j] represents the pixel value,
 * perform a flood fill starting from pixel (sr, sc) with a new color.
 *
 * The flood fill should consider 4-directionally connected pixels of the same starting color.
 *
 * Input Format:
 * - image: 2D integer array (m x n)
 * - sr: starting row (0-based index)
 * - sc: starting column (0-based index)
 * - newColor: replacement color
 *
 * Output Format:
 * Modified image after flood fill
 *
 * Example Input/Output:
 *
 * Input:
 * image = [
 *   [1,1,1],
 *   [1,1,0],
 *   [1,0,1]
 * ]
 * sr = 1, sc = 1, newColor = 2
 *
 * Output:
 * [
 *   [2,2,2],
 *   [2,2,0],
 *   [2,0,1]
 * ]
 *
 * Explanation:
 * From center (1,1), all connected 1's are replaced with 2.
 * The pixel at (2,2) remains 1 because it's not 4-directionally connected.
 */

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && image[newRow][newCol] == originalColor) {

                    image[newRow][newCol] = newColor;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        FloodFillAlgorithm solution = new FloodFillAlgorithm();

        // Test Case 1
        int[][] image1 = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        printImage(result1);
        /* Expected Output:
           [2,2,2]
           [2,2,0]
           [2,0,1] */

        // Test Case 2
        int[][] image2 = {
                {0,0,0},
                {0,1,1}
        };
        int[][] result2 = solution.floodFill(image2, 1, 1, 1);
        printImage(result2);
        /* Expected Output:
           [0,0,0]
           [0,1,1] */

        // Test Case 3 (Edge Case: Single Pixel)
        int[][] image3 = {{5}};
        int[][] result3 = solution.floodFill(image3, 0, 0, 9);
        printImage(result3);
        /* Expected Output:
           [9] */
    }

    private static void printImage(int[][] image) {
        System.out.println("Output Image:");
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
