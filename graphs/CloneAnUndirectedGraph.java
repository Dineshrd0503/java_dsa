package graphs;

/**
 * Problem: Clone a connected undirected graph where each node contains:
 * - val: Integer value
 * - neighbors: List of adjacent nodes
 *
 * Approach:
 * 1. Use DFS traversal to visit all nodes
 * 2. Maintain a hashmap to track original->clone mappings
 * 3. Recursively clone nodes and their neighbors
 * 4. Handle cycles automatically through visited map checks
 *
 * Time Complexity: O(N+E) where N=nodes, E=edges
 * Space Complexity: O(N) for recursion stack and visited map
 * Examples :
 *
 * Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
 * Output: true
 * Explanation:
 *
 * As the cloned graph is identical to the original one the driver code will print true.
 * Input: n = 3, adjList[][] = [[1, 2], [0], [0]]
 * Output: true
 * Explanation:
 *
 * As the cloned graph is identical to the original one the driver code will print true.
 * Constraints:
 * 1 ≤ n ≤ 104
 * 0 ≤ no. of edges ≤ 105
 * 0 ≤ adjList[i][j] < n
 *
 *
 *
 */

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneAnUndirectedGraph {

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        // Map to track original nodes and their clones
        Map<Node, Node> visited = new HashMap<>();
        return dfsClone(node, visited);
    }

    private Node dfsClone(Node node, Map<Node, Node> visited) {
        // Return cached clone if already processed
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create new clone and register mapping
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Deep clone all neighbors recursively
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(dfsClone(neighbor, visited));
        }

        return clone;
    }

    public static void main(String[] args) {
        /* Test Case 1: 4-node cyclic graph
         * Original: 0 -- 1
         *           | \  |
         *           3 --2
         */
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node0.neighbors.add(node3);
        node1.neighbors.add(node0);
        node1.neighbors.add(node2);
        node2.neighbors.add(node0);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node0);
        node3.neighbors.add(node2);

        CloneAnUndirectedGraph solution = new CloneAnUndirectedGraph();
        Node cloned = solution.cloneGraph(node0);
        System.out.println("Test Case 1: " + isSameGraph(node0, cloned)); // true

        /* Test Case 2: Single node graph */
        Node singleNode = new Node(5);
        Node clonedSingle = solution.cloneGraph(singleNode);
        System.out.println("Test Case 2: " + isSameGraph(singleNode, clonedSingle)); // true

        /* Test Case 3: Null input */
        System.out.println("Test Case 3: " + (solution.cloneGraph(null) == null)); // true

        /* Test Case 4: Disconnected graph with 2 components */
        Node nodeA = new Node(10);
        Node nodeB = new Node(20);
        Node nodeC = new Node(30);
        Node nodeD = new Node(40);

        nodeA.neighbors.add(nodeB);
        nodeB.neighbors.add(nodeA);
        nodeC.neighbors.add(nodeD);
        nodeD.neighbors.add(nodeC);

        Node clonedDisconnected = solution.cloneGraph(nodeA);
        System.out.println("Test Case 4: " + isSameGraph(nodeA, clonedDisconnected)); // true
    }

    // Validation using BFS for structure and value comparison
    private static boolean isSameGraph(Node original, Node cloned) {
        if(original == null && cloned == null) return true;
        if(original == null || cloned == null) return false;

        Map<Node, Node> mapping = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(original);
        mapping.put(original, cloned);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            Node clone = mapping.get(current);

            // Value mismatch check
            if(current.val != clone.val) return false;

            // Neighbor count mismatch check
            if(current.neighbors.size() != clone.neighbors.size()) return false;

            // Validate each neighbor relationship
            for(int i = 0; i < current.neighbors.size(); i++) {
                Node originalNeighbor = current.neighbors.get(i);
                Node clonedNeighbor = clone.neighbors.get(i);

                // New node discovery
                if(!mapping.containsKey(originalNeighbor)) {
                    // Validate neighbor values
                    if(originalNeighbor.val != clonedNeighbor.val) return false;

                    mapping.put(originalNeighbor, clonedNeighbor);
                    queue.add(originalNeighbor);
                }
                // Existing node validation
                else if(mapping.get(originalNeighbor) != clonedNeighbor) {
                    return false;
                }
            }
        }
        return true;
    }
}
