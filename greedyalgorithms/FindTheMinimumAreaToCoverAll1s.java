package greedyalgorithms;

/*
You are given a 2D **binary** array `grid`. Find a rectangle with horizontal and vertical sides with the **smallest** area, such that all the 1's in `grid` lie inside this rectangle.

Return the **minimum** possible area of the rectangle.

**Example 1:**

**Input:** grid = [[0,1,0],[1,0,1]]
**Output:** 6

**Explanation:**
The smallest rectangle has a height of 2 and a width of 3, so it has an area of `2 * 3 = 6`.

**Example 2:**

**Input:** grid = [[1,0],[0,0]]
**Output:** 1

**Explanation:**
The smallest rectangle has both height and width 1, so its area is `1 * 1 = 1`.

**Constraints:**

*   `1 <= grid.length, grid[i].length <= 1000`
*   `grid[i][j]` is either 0 or 1.
*   The input is generated such that there is at least one 1 in `grid`.
*/

public class FindTheMinimumAreaToCoverAll1s {
    /**
     * Finds the minimum area rectangle covering all 1s in a 2D binary grid.
     *
     * @param grid The 2D binary grid.
     * @return The minimum possible area of the rectangle.
     */
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        // Iterate through the grid to find the boundaries of the rectangle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        // Calculate the height and width of the rectangle
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        // Return the area
        return height * width;
    }

    public static void main(String[] args) {
        FindTheMinimumAreaToCoverAll1s solution = new FindTheMinimumAreaToCoverAll1s();


        // Test case 1
        int[][] grid1 = {{0, 1, 0}, {1, 0, 1}};
        System.out.println("Minimum area for grid1: " + solution.minimumArea(grid1)); // Expected output: 6

        // Test case 2
        int[][] grid2 = {{1, 0}, {0, 0}};
        System.out.println("Minimum area for grid2: " + solution.minimumArea(grid2)); // Expected output: 1

        // Test case 3
        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println("Minimum area for grid3: " + solution.minimumArea(grid3)); // Expected output: 4

        // Test case 4: All zeros except one
        int[][] grid4 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Minimum area for grid4: " + solution.minimumArea(grid4)); // Expected output: 1
    }
}