package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSOfAGraph {
    /**
     * Problem Statement:
     * You are given a connected undirected graph represented by a 2D adjacency list adj[][],
     * where each adj[i] represents the list of vertices connected to vertex i.
     * Perform a Depth First Search (DFS) traversal starting from vertex 0,
     * visiting vertices from left to right as per the given adjacency list,
     * and return a list containing the DFS traversal of the graph.
     *
     * Note:
     * - Traverse in the same order as they are in the given adjacency list.
     *
     * Input:
     * adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
     *
     * Output:
     * [0, 2, 4, 3, 1]
     *
     * Explanation:
     * Starting from vertex 0, the DFS traversal proceeds as follows:
     * - Visit vertex 0 → Output: [0]
     * - Visit vertex 2 (the first neighbor of 0) → Output: [0, 2]
     * - Visit vertex 4 (the first neighbor of 2) → Output: [0, 2, 4]
     * - Backtrack to vertex 2, then backtrack to vertex 0, and visit vertex 3 → Output: [0, 2, 4, 3]
     * - Finally, backtrack to vertex 0 and visit vertex 1 → Final Output: [0, 2, 4, 3, 1]
     *
     * Constraints:
     * - The graph is connected and undirected.
     * - Adjacency list size: 1 ≤ adj.size() ≤ 10^4
     * - Vertex values: All vertices are integers in the range [1 ≤ adj[i][j] ≤ 10^4].
     */


        /**
         * Method to perform DFS traversal and return the result as a list.
         *
         * @param adj The adjacency list representing the graph.
         * @return An ArrayList containing the DFS traversal of the graph.
         */
        public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> result = new ArrayList<>(); // To store the DFS traversal
            boolean[] visited = new boolean[adj.size()]; // To track visited vertices
            dfsUtil(0, adj, visited, result); // Start DFS from vertex 0
            return result; // Return the final DFS traversal result
        }


        private static void dfsUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
            // Mark the current node as visited and add it to the result
            visited[v] = true;
            result.add(v);

            // Recur for all the vertices adjacent to this vertex
            for (int neighbor : adj.get(v)) {
                if (!visited[neighbor]) { // If not yet visited
                    dfsUtil(neighbor, adj, visited, result); // Recursive call
                }
            }
        }

        /**
         * Main method to test the DFS implementation with example graphs.
         *
         * @param args Command-line arguments (not used).
         */
        public static void main(String[] args) {

            // Example input: Graph represented as an adjacency list
            ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
            adj1.add(new ArrayList<>(Arrays.asList(2, 3, 1))); // Neighbors of vertex 0
            adj1.add(new ArrayList<>(Arrays.asList(0)));       // Neighbors of vertex 1
            adj1.add(new ArrayList<>(Arrays.asList(0, 4)));    // Neighbors of vertex 2
            adj1.add(new ArrayList<>(Arrays.asList(0)));       // Neighbors of vertex 3
            adj1.add(new ArrayList<>(Arrays.asList(2)));       // Neighbors of vertex 4

            System.out.println("DFS Traversal of Graph 1: " + dfs(adj1)); // Output: [0, 2, 4, 3, 1]

            ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
            adj2.add(new ArrayList<>(Arrays.asList(1, 2)));   // Neighbors of vertex 0
            adj2.add(new ArrayList<>(Arrays.asList(0, 2)));    // Neighbors of vertex 1
            adj2.add(new ArrayList<>(Arrays.asList(0, 1, 3, 4))); // Neighbors of vertex 2
            adj2.add(new ArrayList<>(Arrays.asList(2)));       // Neighbors of vertex 3
            adj2.add(new ArrayList<>(Arrays.asList(2)));       // Neighbors of vertex 4

            System.out.println("DFS Traversal of Graph 2: " + dfs(adj2)); // Output: [0, 1, 2, 3, 4]
        }
    }
