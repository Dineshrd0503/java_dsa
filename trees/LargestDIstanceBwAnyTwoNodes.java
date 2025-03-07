package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



//Problem statement
//You are given an arbitrary unweighted rooted tree which consists of N nodes, 0 to N - 1. Your task is to find the largest distance between two nodes in the tree.
//
//The distance between two nodes is the number of edges in a path between the nodes (there will always be a unique path between any pair of nodes since it is a tree).
//
//Note :
//Use zero-based indexing for the nodes.
//
//The tree is always rooted at 0.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 100
//        2 <= N <= 3000
//        0 <= u , v < N
//
//Time Limit: 1 sec
//Sample Input 1 :
//        1
//        10
//        0 1
//        0 2
//        0 3
//        1 4
//        2 5
//        2 6
//        4 7
//        4 8
//        6 9
//Sample Output 1 :
//        6
//Explanation for sample input 1 :
//For the first test case, the tree is shown below. The longest path in the tree is {7, 4, 1, 0, 2, 6, 9} with a length of 6.
//
//Sample Input 2 :
//        1
//        6
//        0 1
//        1 2
//        1 3
//        2 4
//        3 5
//Sample Output 2 :
//        4
//Explanation for sample input 2 :
//For the first test case, the tree is shown below. The longest path in the tree is {4, 2, 1, 3, 5} with a length of 4.


public class LargestDIstanceBwAnyTwoNodes {

        public static int largestDistance(int n, int[][] edges) {
            // Construct adjacency list
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            // First DFS to find the farthest node from root (0)
            int[] farthestNode = bfs(0, n, adj);
            int nodeA = farthestNode[0]; // The farthest node found

            // Second DFS from nodeA to find the farthest distance
            int[] result = bfs(nodeA, n, adj);
            return result[1]; // Maximum distance found in second BFS
        }

        // BFS to find the farthest node and its distance from startNode
        private static int[] bfs(int startNode, int n, List<List<Integer>> adj) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            int[] distance = new int[n];

            queue.add(startNode);
            visited[startNode] = true;

            int farthestNode = startNode;
            int maxDist = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        distance[neighbor] = distance[node] + 1;

                        // Update farthest node if distance is greater
                        if (distance[neighbor] > maxDist) {
                            maxDist = distance[neighbor];
                            farthestNode = neighbor;
                        }
                    }
                }
            }

            return new int[]{farthestNode, maxDist}; // {Node, Max Distance}
        }

        public static void main(String[] args) {
            int[][] edges1 = {
                    {0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 5}, {2, 6}, {4, 7}, {4, 8}, {6, 9}
            };
            System.out.println(largestDistance(10, edges1)); // Output: 6

            int[][] edges2 = {
                    {0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}
            };
            System.out.println(largestDistance(6, edges2)); // Output: 4
        }


    }
