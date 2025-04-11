package graphs;

/**
 * Problem Statement:
 * Given an undirected, weighted graph with V vertices (0 to V-1) and E edges,
 * find the shortest distance from a source vertex to all other vertices.
 *
 * Input Format:
 * - edges[i] = [u, v, w] represents an edge between u and v with weight w
 * - Graph is connected with no negative weights
 *
 * Output Format:
 * - List of integers where ith element = shortest distance from source to vertex i
 *
 * Constraints:
 * 1 ≤ V ≤ 10^5
 * 1 ≤ E ≤ 10^5
 * 0 ≤ edge weights ≤ 10^4
 *
 * Example 1:
 * Input: V=3, edges=[[0,1,1],[1,2,3],[0,2,6]], src=2
 * Output: [4, 3, 0]
 * Explanation:
 * - 2→1: direct path 3
 * - 2→1→0: total weight 3+1=4
 * - 2→2: distance 0
 *
 * Example 2:
 * Input: V=5, edges=[[0,1,4],[0,2,8],[1,4,6],[2,3,2],[3,4,10]], src=0
 * Output: [0,4,8,10,10]
 * Explanation:
 * - 0→0: distance 0
 * - 0→1: direct path 4
 * - 0→2: direct path 8
 * - 0→2→3: total 8+2=10
 * - 0→1→4: total 4+6=10
 */

import java.util.*;

public class DijkstraAlgorithm {

    public static List<Integer> dijkstra(int[][] edges, int vertices, int edgesCount, int source) {
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list (undirected graph)
        for(int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // Initialize distances
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Min-heap priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{source, 0});

        // Dijkstra's algorithm
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0], dist = current[1];

            if(dist > distance[u]) continue;

            for(int[] neighbor : adj.get(u)) {
                int v = neighbor[0], weight = neighbor[1];
                int newDist = distance[u] + weight;

                if(newDist < distance[v]) {
                    distance[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }
            }
        }

        // Convert to List<Integer>
        List<Integer> result = new ArrayList<>();
        for(int d : distance) {
            result.add(d);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1 (From Example 1)
        int[][] edges1 = {{0,1,1},{1,2,3},{0,2,6}};
        System.out.println("Test Case 1: " + dijkstra(edges1, 3, 3, 2)); // Output: [4, 3, 0]

        // Test Case 2 (From Example 2)
        int[][] edges2 = {{0,1,4},{0,2,8},{1,4,6},{2,3,2},{3,4,10}};
        System.out.println("Test Case 2: " + dijkstra(edges2, 5, 5, 0)); // Output: [0,4,8,10,10]

        // Test Case 3 (Additional Case)
        int[][] edges3 = {{0,1,2},{1,2,3},{0,2,9}};
        System.out.println("Test Case 3: " + dijkstra(edges3, 3, 3, 0)); // Output: [0,2,5]

        // Test Case 4 (Single Node)
        int[][] edges4 = {};
        System.out.println("Test Case 4: " + dijkstra(edges4, 1, 0, 0)); // Output: [0]
    }
}

