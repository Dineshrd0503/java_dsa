package graphs;

/**
 * Problem: Find shortest path between all pairs of nodes in a weighted directed graph using Floyd-Warshall algorithm.
 * The graph may contain negative edges but no negative cycles.
 *
 * Approach:
 * 1. Initialize the solution matrix with the given adjacency matrix.
 * 2. For each intermediate node k (0 to n-1):
 *    a. For each pair (i, j):
 *       i. Update dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
 * 3. Handle large values (1e8) representing infinity appropriately
 *
 * Constraints:
 * - 1 <= n <= 100
 * - -1000 <= weight <= 1000
 */

public class FloydWarshallAlgorithm {
    private static final int INF = 100000000; // Represents infinity

    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Prevent integer overflow by checking INF
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Test Case 1:
         * Input:
         * [[0, 4, INF, 5, INF],
         *  [INF, 0, 1, INF, 6],
         *  [2, INF, 0, 3, INF],
         *  [INF, INF, 1, 0, 2],
         *  [1, INF, INF, 4, 0]]
         *
         * Expected Output:
         * [[0,4,5,5,7],
         *  [3,0,1,4,6],
         *  [2,6,0,3,5],
         *  [3,7,1,0,2],
         *  [1,5,5,4,0]]
         */
        int[][] test1 = {
                {0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF},
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}
        };

        System.out.println("Test Case 1 Input:");
        printMatrix(test1);
        floydWarshall(test1);
        System.out.println("\nTest Case 1 Output:");
        printMatrix(test1);

        /* Test Case 2:
         * Input:
         * [[0, -1, 2],
         *  [1, 0, INF],
         *  [3, 1, 0]]
         *
         * Expected Output:
         * [[0,-1,2],
         *  [1,0,3],
         *  [2,1,0]]
         */
        int[][] test2 = {
                {0, -1, 2},
                {1, 0, INF},
                {3, 1, 0}
        };

        System.out.println("\nTest Case 2 Input:");
        printMatrix(test2);
        floydWarshall(test2);
        System.out.println("\nTest Case 2 Output:");
        printMatrix(test2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == INF) System.out.print("INF ");
                else System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

