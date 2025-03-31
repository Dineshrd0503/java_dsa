package codingninjas6monthschallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReachLastCellInLeastTime {
    public static int lastCellLeastTime(int[][] grid, int n) {
        // Write your code here.
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // Priority queue to hold cells based on their unlock times
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.time));
        boolean[][] visited = new boolean[n][n]; // To track visited cells

        // Start from (0, 0)
        pq.offer(new Cell(0, 0, grid[0][0])); // (row, col, time)

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.row;
            int y = current.col;
            int currentTime = current.time;

            // If we reach the bottom-right corner
            if (x == n - 1 && y == n - 1) {
                return currentTime;
            }

            // Mark this cell as visited
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if not visited
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // The time to reach this neighbor is max of currentTime and its unlock time
                    pq.offer(new Cell(newX, newY, Math.max(currentTime, grid[newX][newY])));
                }
            }
        }

        return -1; // In case there's no path to reach (n-1,n-1), though per constraints this shouldn't happen.
    }

    static class Cell {
        int row;
        int col;
        int time;

        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(lastCellLeastTime(grid, n)); // 7
    }
}
