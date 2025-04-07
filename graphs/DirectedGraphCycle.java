package graphs;

/**
 * Problem Statement:
 * Given a Directed Graph with V vertices (numbered from 0 to V-1) and E edges,
 * check whether it contains any cycle or not. The graph is represented as a 2D vector edges[][],
 * where each entry edges[i] = [u, v] denotes an edge from vertex u to vertex v.
 *
 * Input Format:
 * - First line contains V (number of vertices) and E (number of edges)
 * - Next E lines contain the edges (u, v)
 *
 * Output Format:
 * - Boolean value (true if cycle exists, false otherwise)
 *
 * Example 1:
 * Input:
 * V = 4, edges = [[0,1],[1,2],[2,3],[3,3]]
 * Output: true
 * Explanation: 3 -> 3 forms a self-loop cycle
 *
 * Example 2:
 * Input:
 * V = 3, edges = [[0,1],[1,2]]
 * Output: false
 * Explanation: No cycle exists
 */

import java.util.*;

public class DirectedGraphCycle {

    public boolean isCyclic(int V, int[][] edges) {
        // Step 1: Build adjacency list and compute indegree
        List<Integer>[] graph = new ArrayList[V];
        int[] indegree = new int[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }

        // Step 2: Enqueue nodes with 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Process nodes
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for(int neighbor : graph[node]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Cycle exists if not all nodes are processed
        return count != V;
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 4;
        int[][] edges1 = {{0,1}, {1,2}, {2,3}, {3,3}};
        DirectedGraphCycle obj = new DirectedGraphCycle();
        System.out.println("Test Case 1: " + obj.isCyclic(V1, edges1)); // true

        // Test Case 2
        int V2 = 3;
        int[][] edges2 = {{0,1}, {1,2}};
        System.out.println("Test Case 2: " + obj.isCyclic(V2, edges2)); // false

        // Test Case 3 (Additional Test Case)
        int V3 = 5;
        int[][] edges3 = {{0,1},{1,2},{2,3},{3,4},{4,2}};
        System.out.println("Test Case 3: " + obj.isCyclic(V3, edges3)); // true

        // Test Case 4 (Additional Test Case)
        int V4 = 6;
        int[][] edges4 = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        System.out.println("Test Case 4: " + obj.isCyclic(V4, edges4)); // false
    }
}

