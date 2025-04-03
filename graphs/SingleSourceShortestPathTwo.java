package graphs;

import java.util.*;

/**
 * Problem Statement:
 * You are given an undirected graph with 'N' nodes and 'M' edges. The weight of each edge in the graph is one unit.
 * Given a source vertex 'src', you must return an array 'answer' of length 'N', where 'answer[i]' is the shortest path
 * length between the source vertex 'src' and 'i'th vertex.
 *
 * Note:
 * - All the nodes are zero-based.
 *
 * Example:
 * Input:
 * Input: graph = [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 *
 
 *
 * Constraints:
 * - Number of vertices: 1 <= N <= 100
 * - Number of edges: 0 <= M <= N*(N-1)/2
 * - Source vertex: src ∈ [0, N-1]
 *
 * Time Complexity: O(N + M)
 */

public class SingleSourceShortestPathTwo {

    /**
     * Method to find shortest path lengths from source vertex using BFS.
     *
     * @param n     Number of vertices in the graph.
     * @param edges List of edges representing the graph.
     * @param src   Source vertex.
     * @return Array of shortest path lengths from src to all vertices.
     */
    public static int[] shortestPath(int n, int[][] edges, int src) {
        // Step 1: Build adjacency list from edges
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected graph
        }

        // Step 2: Initialize distance array and queue for BFS
        int[] distance = new int[n];
        Arrays.fill(distance, -1); // Default: unreachable
        distance[src] = 0; // Distance to source is zero

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (distance[neighbor] == -1) { // Only process unvisited nodes
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distance;
    }

    /**
     * Main method to test the functionality with example inputs.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example Input 1
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        int src1 = 1;
        System.out.println("Shortest Path from Vertex " + src1 + ": " 
            + Arrays.toString(shortestPath(n1, edges1, src1))); 
        // Expected Output: [1, 0, 2, 2, 1]

        // Example Input 2
        int n2 = 4;
        int[][] edges2 = {{0, 1}, {0, 3}, {2, 3}};
        int src2 = 0;
        System.out.println("Shortest Path from Vertex " + src2 + ": " 
            + Arrays.toString(shortestPath(n2, edges2, src2))); 
        // Expected Output: [0, 1, -...,...]
    }
}
