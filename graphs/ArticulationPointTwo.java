package graphs;

// ArticulationPointTwo.java

/*
Problem Statement:
Given an undirected graph with V vertices and E edges, find all articulation points (cut vertices) in the graph.
An articulation point is a vertex whose removal increases the number of connected components in the graph.
If no such vertices exist, return [-1].

Input Format:
- V: Number of vertices
- edges: 2D array of edges between vertices

Output Format:
- ArrayList<Integer> containing articulation points or [-1] if none exist

Example Input 1:
V = 5, edges = [[0,1],[1,4],[4,3],[4,2],[2,3]]
Expected Output: [1, 4]

Example Input 2:
V = 4, edges = [[0,1],[0,2]]
Expected Output: [0]
*/

import java.util.*;

public class ArticulationPointTwo {
    public static void main(String[] args) {
        // Test Case 1
        int V1 = 5;
        int[][] edges1 = {{0,1},{1,4},{4,3},{4,2},{2,3}};
        System.out.println(articulationPoints(V1, edges1)); // Output: [1, 4]

        // Test Case 2
        int V2 = 4;
        int[][] edges2 = {{0,1},{0,2}};
        System.out.println(articulationPoints(V2, edges2)); // Output: [0]

        // Test Case 3 (No articulation points)
        int V3 = 3;
        int[][] edges3 = {{0,1},{1,2},{2,0}};
        System.out.println(articulationPoints(V3, edges3)); // Output: [-1]
    }

    public static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Initialize trackers
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        int[] time = {0};

        // Process all components
        for(int i=0; i<V; i++) {
            if(disc[i] == -1) {
                dfs(i, disc, low, parent, isAP, adj, time);
            }
        }

        // Collect results
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<V; i++) {
            if(isAP[i]) result.add(i);
        }
        if(result.isEmpty()) result.add(-1);
        return result;
    }

    private static void dfs(int u, int[] disc, int[] low, int[] parent,
                            boolean[] isAP, ArrayList<ArrayList<Integer>> adj,
                            int[] time) {
        int children = 0;
        disc[u] = low[u] = ++time[0];

        for(int v : adj.get(u)) {
            if(disc[v] == -1) {  // Unvisited node
                children++;
                parent[v] = u;
                dfs(v, disc, low, parent, isAP, adj, time);

                // Update low value after subtree processing
                low[u] = Math.min(low[u], low[v]);

                // Check for articulation point
                if(parent[u] == -1 && children > 1) isAP[u] = true;  // Root case
                if(parent[u] != -1 && low[v] >= disc[u]) isAP[u] = true;  // Non-root case

            } else if(v != parent[u]) {  // Back edge case
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
