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
        // Code here
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<v;i++)
            list.add(new ArrayList<>());
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);

        }
        boolean[] vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(dfs(list,i,-1,vis))
                    return true;

            }
        }
        return false;
    }
    private static boolean dfs(List<List<Integer>>list,int node,int parent,boolean[] vis){
        vis[node]=true;
        for(int neighbour:list.get(node)){
            if(!vis[neighbour]){
                if(dfs(list,neighbour,node,vis))
                    return true;
            }
            else if(neighbour!=parent)
                return true;

        }
        return false;
    }
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

