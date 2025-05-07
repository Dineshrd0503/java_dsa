package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Root to Leaf Paths
 *
 * Given a Binary Tree, you need to find all the possible paths from the root node to
 * all the leaf nodes of the binary tree.
 *
 * Note: The paths should be returned such that paths from the left subtree of any
 * node are listed first, followed by paths from the right subtree.
 *
 * Examples:
 *
 * Input: root[] = [1, 2, 3, 4, 5, N, N]
 * Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
 * Explanation: All the possible paths from root node to leaf nodes are:
 * 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3
 *
 * Input: root[] = [1, 2, 3]
 * Output: [[1, 2], [1, 3]]
 * Explanation: All the possible paths from root node to leaf nodes are:
 * 1 -> 2 and 1 -> 3
 *
 * Input: root[] = [10, 20, 30, 40, 60, N, N]
 * Output: [[10, 20, 40], [10, 20, 60], [10, 30]]
 * Explanation: All the possible paths from root node to leaf nodes are:
 * 10 -> 20 -> 40, 10 -> 20 -> 60 and 10 -> 30
 *
 * Constraints:
 * 1 <= number of nodes <= 10^4
 * 1 <= node->data <= 10^4
 */



public class RootToLeafNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to create a new node
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Find all paths from root to leaf nodes
        List<List<Integer>> result = findPaths(root);

        // Print the result
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }

    public static List<List<Integer>> findPaths(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, currentPath, result);
        return result;
    }

    private static void findPathsRecursive(Node node, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        currentPath.add(node.data);

        // If it's a leaf node, add the current path to the result
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Traverse the left and right children
            findPathsRecursive(node.left, currentPath, result);
            findPathsRecursive(node.right, currentPath, result);
        }

        // Remove the current node from the path for backtracking
        currentPath.remove(currentPath.size() - 1);
    }
}
