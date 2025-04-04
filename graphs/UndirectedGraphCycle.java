package graphs;



import java.util.*;

/**
 * Problem Statement:
 * Given an undirected graph with 'V' vertices and 'E' edges, determine whether the graph contains a cycle or not.
 * The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v.
 *
 * Examples:
 *
 * Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
 * Output: true
 * Explanation: The graph contains a cycle (1 -> 2 -> 0 -> 1).
 *
 * Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
 * Output: false
 * Explanation: The graph does not contain a cycle.
 *
 * Constraints:
 * - 1 ≤ V ≤ 10^5
 * - 1 ≤ E = edges.size() ≤ 10^5
 */
public class UndirectedGraphCycle {

    /**
     * Method to check if the graph contains a cycle using BFS.
     *
     * @param v     Number of vertices in the graph.
     * @param edges List of edges in the graph.
     * @return True if the graph contains a cycle; false otherwise.
     */
    public boolean isCycle(int v, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected graph
        }

        // Step 2: Initialize visited array
        boolean[] visited = new boolean[v];

        // Step 3: Perform BFS from each unvisited node
        for (int i = 0; i < v; i++) {
            if (!visited[i]) { // Only start BFS from unvisited nodes
                if (bfscycle(i, adj, visited)) {
                    return true; // Return true if a cycle is detected
                }
            }
        }
        return false;
    }

    /**
     * Helper method to check for cycles using BFS.
     *
     * @param start  Starting vertex for BFS.
     * @param adj    Adjacency list representation of the graph.
     * @param visited Array to track visited vertices.
     * @return True if a cycle is detected; false otherwise.
     */
    private boolean bfscycle(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(new int[]{neighbour, node});
                } else if (neighbour != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

    /**
     * Main method to test the functionality with example inputs.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        UndirectedGraphCycle solution = new UndirectedGraphCycle();

        // Example Input 1
        int V1 = 4;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println("Does the graph contain a cycle? " + solution.isCycle(V1, edges1));
        // Expected Output: true

        // Example Input 2
        int V2 = 4;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Does the graph contain a cycle? " + solution.isCycle(V2, edges2));
        // Expected Output: false
    }
}

