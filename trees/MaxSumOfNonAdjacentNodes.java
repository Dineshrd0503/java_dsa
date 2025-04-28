package trees;

import java.util.*;



public class MaxSumOfNonAdjacentNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    /*
     Problem Statement:
     Given a binary tree with a value associated with each node.
     Your task is to select a subset of nodes such that the sum of their values is maximized,
     with the condition that no two selected nodes are directly connected; that is,
     if a node is included in the subset, neither its parent nor its children can be included.

     Examples:

     Input: root[] = [11, 1, 2]
     Output: 11
     Explanation: The maximum sum is obtained by selecting the node 11.

     Input: root[] = [1, 2, 3, 4, N, 5, 6]
     Output: 16
     Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5, and 6,
     which are not directly connected to each other. Their total sum is 16.

     Constraints:
     1 <= no. of nodes in the tree <= 10^4
     1 <= Node.val <= 10^5
    */

    private int[] dfs(Node node) {
        if (node == null) {
            return new int[]{0, 0}; // Base case: if the node is null, the sums are 0
        }

        // Recursive calls to calculate sums from left and right children
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Calculate include and exclude cases
        int include = node.data + left[1] + right[1]; // Include current node
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // Exclude current node

        return new int[]{include, exclude}; // Return array with sums for current node
    }

    public int getMaxSum(Node root) {
        int[] result = dfs(root); // Get the results from the DFS function
        return Math.max(result[0], result[1]); // Return the maximum of the two sums
    }

    public static void main(String[] args) {
        // Test case creation
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        MaxSumOfNonAdjacentNodes solution = new MaxSumOfNonAdjacentNodes();
        int maxSum = solution.getMaxSum(root);
        System.out.println("Maximum sum of non-adjacent nodes: " + maxSum); // Output: 16
    }
}