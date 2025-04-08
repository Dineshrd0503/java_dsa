package graphs;

/**
 * BridgeEdgeInAGraph - Determines if a specific edge is a bridge in an undirected graph
 *
 * Problem Description:
 * Given an undirected graph with V vertices (0 to V-1) and E edges, determine if the edge between
 * vertices (c, d) is a bridge. A bridge is an edge whose removal increases the number of connected components.
 *
 * Approach:
 * 1. Build adjacency list using HashSets for O(1) edge operations
 * 2. Check if edge (c,d) exists
 * 3. Remove the edge from both vertices' adjacency lists
 * 4. Perform BFS from c to check if d remains reachable
 *
 * Input Format:
 * - Number of vertices (V)
 * - Edges as 2D array [[u1,v1],[u2,v2],...]
 * - Target edge (c,d)
 *
 * Output Format:
 * - Boolean true/false indicating if edge is a bridge
 *
 * Example Input 1:
 * V=5, edges=[[0,1],[1,2],[2,0],[2,3],[3,4]], c=1, d=2
 * Output: true
 *
 * Example Input 2:
 * V=4, edges=[[0,1],[1,2],[2,0],[1,3]], c=0, d=2
 * Output: false
 */

import java.util.*;

public class BridgeEdgeInAGraph {

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // Build adjacency list
        Set<Integer>[] adj = new HashSet[V];
        for(int i=0; i<V; i++) adj[i] = new HashSet<>();

        // Populate adjacency list
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // Edge case: if edge doesn't exist
        if(!adj[c].contains(d)) return false;

        // Remove target edge
        adj[c].remove(d);
        adj[d].remove(c);

        // BFS setup
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(c);
        visited[c] = true;

        // Perform BFS
        while(!queue.isEmpty()) {
            int u = queue.poll();

            // Check all neighbors
            for(int neighbor : adj[u]) {
                if(neighbor == d) return false;  // Found alternate path
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return !visited[d];  // Bridge exists if d is unreachable
    }


    public static void main(String[] args) {
        BridgeEdgeInAGraph solution = new BridgeEdgeInAGraph();

        // Test Case 1 - Bridge exists
        int[][] edges1 = {{0,1},{1,2},{2,0},{2,3},{3,4}};
        System.out.println(solution.isBridge(5, edges1, 1, 2));  // true

        // Test Case 2 - Not a bridge
        int[][] edges2 = {{0,1},{1,2},{2,0},{1,3}};
        System.out.println(solution.isBridge(4, edges2, 0, 2));  // false

        // Test Case 3 - Edge doesn't exist
        int[][] edges3 = {{0,1},{1,2}};
        System.out.println(solution.isBridge(3, edges3, 0, 2));  // false
    }

}

