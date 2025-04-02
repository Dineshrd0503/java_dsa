package graphs;

/**
 * Problem Statement:
 * You are given a connected undirected graph containing V vertices, represented by a 2D adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i.
 * Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right
 * according to the given adjacency list, and return a list containing the BFS traversal of the graph.
 *
 * Note: Do traverse in the same order as they are in the given adjacency list.
 *
 * Input:
 * adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
 *
 * Output:
 * [0, 2, 3, 1, 4]
 *
 * Explanation: Starting from vertex 0, the BFS traversal will follow these steps:
 * Visit 0 → Output: [0]
 * Visit 2 (first neighbor of 0) → Output: [0, 2]
 * Visit 3 (next neighbor of 0) → Output: [0, 2, 3]
 * Visit 1 (next neighbor of 0) → Output: [0, 2, 3, 1]
 * Visit 4 (neighbor of 2) → Final Output: [0, 2, 3, 1, 4]
 *
 * Constraints:
 * - The graph is connected and undirected.
 * - Number of vertices: 1 ≤ V = adj.size() ≤ 10^4
 * - Vertex values: All vertices are integers in the range [1 ≤ adj[i][j] ≤ 10^4].
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfAGraph {

    /**
     * Method to perform BFS traversal and return the result as a list.
     *
     * @param adj The adjacency list representing the graph.
     * @return An ArrayList containing the BFS traversal of the graph.
     */
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        int V = adj.size(); // Number of vertices
        boolean[] visited = new boolean[V]; // To track visited vertices
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from vertex 0
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue the front vertex
            result.add(current); // Add it to the result

            // Visit all neighbors in the order of adjacency list
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) { // If not yet visited
                    visited[neighbor] = true; // Mark as visited
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }

        return result; // Return BFS traversal result
    }

    /**
     * Main method to test the BFS implementation with example graphs.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        BFSOfAGraph bfsTraversal = new BFSOfAGraph();

        // Example Input 1
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>() {{ add(2); add(3); add(1); }}); // Node 0
        adj1.add(new ArrayList<>() {{ add(0); }});                  // Node 1
        adj1.add(new ArrayList<>() {{ add(0); add(4); }});          // Node 2
        adj1.add(new ArrayList<>() {{ add(0); }});                  // Node 3
        adj1.add(new ArrayList<>() {{ add(2); }});                  // Node 4

        System.out.println("BFS Traversal of Graph 1: " + bfsTraversal.bfs(adj1));
        // Expected Output: [0, 2, 3, 1, 4]

        // Example Input 2
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>() {{ add(1); add(2); }});          // Node 0
        adj2.add(new ArrayList<>() {{ add(0); add(2); }});          // Node 1
        adj2.add(new ArrayList<>() {{ add(0); add(1); add(3); add(4); }}); // Node 2
        adj2.add(new ArrayList<>() {{ add(2); }});                  // Node 3
        adj2.add(new ArrayList<>() {{ add(2); }});                  // Node 4

        System.out.println("BFS Traversal of Graph 2: " + bfsTraversal.bfs(adj2));
        // Expected Output: [0, 1, 2, 3, 4]
    }
}
