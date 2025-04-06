package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;



import java.util.*;

/**
 * Problem Statement:
 * Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][],
 * where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return topological sort for the given graph.
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v,
 * vertex u comes before v in the ordering.
 *
 * Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct,
 * then the output will be true; otherwise, false.
 *
 * Examples:
 *
 * Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
 * Output: true
 * Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
 * [3, 2, 1, 0]
 * [1, 2, 3, 0]
 * [2, 3, 1, 0]
 *
 * Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
 * Output: true
 * Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
 * [4, 5, 0, 1, 2, 3]
 * [5, 2, 4, 0, 1, 3]
 *
 * Constraints:
 * - 2 ≤ V ≤ 103
 * - 1 ≤ E = edges.size() ≤ (V * (V - 1)) / 2
 */

public class TopologicalSort {

    /**
     * Method to perform topological sort using DFS.
     *
     * @param V     Number of vertices in the graph.
     * @param edges List of directed edges where each edge is represented as [u -> v].
     * @return List containing one valid topological order of vertices.
     */
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // Add directed edge u -> v
        }

        // Step 2: Initialize visited array and stack
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 3: Perform DFS for each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 4: Convert stack to result list (topological order)
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * Helper method to perform DFS and populate stack with topological order.
     *
     * @param node    Current node being visited.
     * @param adj     Adjacency list representing the graph.
     * @param visited Array to track visited nodes.
     * @param stack   Stack to store nodes in reverse post-order.
     */
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        stack.push(node); // Push current node after processing all neighbors
    }

    /**
     * Main method to test the implementation with example inputs.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example Input: V=4 and edges=[[3->0],[1->0],[2->0]]
        int V1 = 4;
        int[][] edges1 = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println("Topological Sort for Example Input:");
        System.out.println(topoSort(V1, edges1)); // Output can be [3,2,1,0] or other valid orders

        // Example Input: V=6 and edges=[[1->3],[2->3],[4->1],[4->0],[5->0],[5->2]]
        int V2 = 6;
        int[][] edges2 = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
        System.out.println("Topological Sort for Example Input:");
        System.out.println(topoSort(V2, edges2)); // Output can be [4,5,x,x,x,x] or other valid orders
    }
}
