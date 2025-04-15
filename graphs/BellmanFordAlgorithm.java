package graphs;

/*
 * Problem: Bellman-Ford Algorithm
 *
 * Given a weighted graph with V vertices numbered from 0 to V-1 and E edges,
 * represented by a 2d array edges[][], where edges[i] = [u, v, w] represents a
 * direct edge from node u to v having w edge weight. You are also given a source vertex src.
 *
 * Your task is to compute the shortest distances from the source to all other vertices.
 * If a vertex is unreachable from the source, its distance should be marked as 10^8.
 * Additionally, if the graph contains a negative weight cycle, return [-1] to indicate
 * that shortest paths cannot be reliably computed.
 *
 * Examples:
 * Input: V = 5, edges[][] = [[1,3,2], [4,3,-1], [2,4,1], [1,2,1], [0,1,5]], src = 0
 * Output: [0, 5, 6, 6, 7]
 * Explanation:
 * Shortest Paths from source 0:
 * 0 to 1 = 5 (path: 0 -> 1)
 * 0 to 2 = 6 (path: 0 -> 1 -> 2)
 * 0 to 3 = 6 (path: 0 -> 1 -> 2 -> 4 -> 3)
 * 0 to 4 = 7 (path: 0 -> 1 -> 2 -> 4)
 *
 * Input: V = 4, edges[][] = [[0,1,4], [1,2,-6], [2,3,5], [3,1,-2]], src = 0
 * Output: [-1]
 * Explanation: The graph contains a negative weight cycle formed by the path 1->2->3->1.
 *
 * Constraints:
 * 1 ≤ V ≤ 100
 * 1 ≤ E ≤ V*(V-1)
 * -1000 ≤ w ≤ 1000
 * 0 ≤ src < V
 */

import java.util.Arrays;

public class BellmanFordAlgorithm {

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // Initialize distance array with large value (10^8) for unreachable nodes
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[src] = 0;

        // Relax edges up to V-1 times
        for (int i = 1; i <= V - 1; i++) {
            boolean updated = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }
            if (!updated) break;  // Optimization: stop if no changes in an iteration
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                return new int[] { -1 };
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // Sample test case 1:
        int V1 = 5;
        int[][] edges1 = { {1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5} };
        int src1 = 0;

        int[] result1 = bellmanFord(V1, edges1, src1);
        System.out.println("Output for test case 1: " + Arrays.toString(result1));
        // Expected output: [0, 5, 6, 6, 7]

        // Sample test case 2: Negative weight cycle
        int V2 = 4;
        int[][] edges2 = { {0,1,4}, {1,2,-6}, {2,3,5}, {3,1,-2} };
        int src2 = 0;

        int[] result2 = bellmanFord(V2, edges2, src2);
        System.out.println("Output for test case 2: " + Arrays.toString(result2));
        // Expected output: [-1]
    }
}
