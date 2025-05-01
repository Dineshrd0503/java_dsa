package trees;

/**
 * Problem Statement:
 * Return true if all non-leaf nodes in a given binary tree have a value that is equal to the sum of their child nodes, otherwise return false.
 * A non-leaf node is a node with at least one child (left or right). A leaf node has no children.
 * For a non-leaf node, its value must equal the sum of its children's values (if a child is null, it contributes 0 to the sum).
 *
 * Constraints:
 * - 1 <= N <= 10^3 (number of nodes)
 * - 1 <= data <= 10^5 (node values)
 * - Time Limit: 1 sec
 *
 * Test Cases:
 * Sample Input 1:
 * N = 4
 * Tree: 5 3 2 3 -1 -1 -1 -1 -1
 * Explanation:
 * - Node 1 (value 5): Children sum = 3 + 2 = 5 (matches)
 * - Node 2 (value 3): Child sum = 3 (matches)
 * - Node 3 (value 2): Leaf node (no check)
 * - Node 4 (value 3): Leaf node (no check)
 * Output: true
 *
 * Sample Input 2:
 * N = 6
 * Tree: 7 3 4 3 -1 2 3 -1 -1 -1 -1 -1 -1
 * Explanation:
 * - Node 1 (value 7): Children sum = 3 + 4 = 7 (matches)
 * - Node 2 (value 3): Child sum = 3 (matches)
 * - Node 3 (value 4): Children sum = 2 + 3 = 5 (does not match)
 * Output: false
 */
public class ChildrenSumProperty {
    // Static inner class for binary tree node
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static boolean isParentSum(Node root) {
        // Base case: null node or leaf node
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        // Compute sum of children's values
        int childSum = 0;
        if (root.left != null) {
            childSum += root.left.data;
        }
        if (root.right != null) {
            childSum += root.right.data;
        }
        
        // Check if current node's value equals sum of children
        if (root.data != childSum) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isParentSum(root.left) && isParentSum(root.right);
    }
    
    // Helper method to build tree from array (level-order)
    private static Node buildTree(int[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == -1) {
            return null;
        }
        
        Node root = new Node(arr[0]);
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();
            
            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;
            
            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Should return true
        int[] testCase1 = {5, 3, 2, 3, -1, -1, -1, -1, -1};
        Node root1 = buildTree(testCase1);
        System.out.println("Test Case 1: " + isParentSum(root1)); // Expected: true
        
        // Test Case 2: Should return false
        int[] testCase2 = {7, 3, 4, 3, -1, 2, 3, -1, -1, -1, -1, -1, -1};
        Node root2 = buildTree(testCase2);
        System.out.println("Test Case 2: " + isParentSum(root2)); // Expected: false
    }
}
