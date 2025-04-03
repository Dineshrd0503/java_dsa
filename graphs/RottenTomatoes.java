package graphs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement:
 * You are given a matrix `mat[][]` of dimension `n * m` where each cell in the matrix can have values:
 * - 0: Empty cell
 * - 1: Cell containing fresh oranges
 * - 2: Cell containing rotten oranges
 *
 * A rotten orange at index `(i, j)` can rot other fresh oranges at indexes `(i-1, j)`, `(i+1, j)`, `(i, j-1)`, `(i, j+1)`
 * (up, down, left, and right) in a unit time.
 *
 * Your task is to determine the minimum time required to rot all fresh oranges. If it is impossible to rot all fresh
 * oranges, return `-1`.
 *
 * Constraints:
 * - 1 ≤ mat.length ≤ 500
 * - 1 ≤ mat[0].length ≤ 500
 * - mat[i][j] ∈ {0, 1, 2}
 *
 * Examples:
 *
 * Input: mat[][] = [[0, 1, 2], [0, 1, 2], [2, 1, 1]]
 * Output: 1
 * Explanation: Oranges at positions (0,2), (1,2), (2,0) will rot oranges at (0,1), (1,1), (2,2), and (2,1) in unit time.
 *
 * Input: mat[][] = [[2, 2, 0, 1]]
 * Output: -1
 * Explanation: Oranges at (0,0) and (0,1) can't rot orange at (0,3).
 *
 * Input: mat[][] = [[2, 2, 2], [0, 2, 0]]
 * Output: 0
 * Explanation: There are no fresh oranges.
 */
public class RottenTomatoes {

    /**
     * Method to determine the minimum time required to rot all oranges.
     *
     * @param grid The matrix representing the grid of oranges.
     * @return Minimum time to rot all oranges or -1 if not possible.
     */
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize queue with all initially rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges exist initially
        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;

        // Perform BFS to rot oranges level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasInfected = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] dir : directions) {
                    int ni = cell[0] + dir[0];
                    int nj = cell[1] + dir[1];

                    // Check if neighbor is within bounds and is a fresh orange
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2; // Mark as rotten
                        queue.add(new int[]{ni, nj});
                        freshCount--;
                        hasInfected = true;
                    }
                }
            }

            // Increment time only if new infections occurred in this level
            if (hasInfected) {
                time++;
            }
        }

        // Return time if all fresh oranges are rotten; otherwise return -1
        return freshCount == 0 ? time : -1;
    }

    /**
     * Main method to test the functionality with example inputs.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        RottenTomatoes solution = new RottenTomatoes();

        // Example Input 1
        int[][] grid1 = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        System.out.println("Example Input 1 Output: " + solution.orangesRotting(grid1)); // Expected Output: 1

        // Example Input 2
        int[][] grid2 = {{2, 2, 0, 1}};
        System.out.println("Example Input 2 Output: " + solution.orangesRotting(grid2)); // Expected Output: -1

        // Example Input 3
        int[][] grid3 = {{2, 2, 2}, {0, 2, 0}};
        System.out.println("Example Input 3 Output: " + solution.orangesRotting(grid3)); // Expected Output: 0
    }
}

