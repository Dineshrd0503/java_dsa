package geeksforgeeks;
//Check for BST
// Difficulty: EasyAccuracy: 25.37%Submissions: 558K+Points: 2Average Time: 30m
// Given the root of a binary tree. Check whether it is a BST or not.
// Note: We are considering that BSTs can not contain duplicate Nodes.
// A BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Examples:

// Input: root = [2, 1, 3, N, N, N, 5]


// Output: true 
// Explanation: The left subtree of every node contains smaller keys and right subtree of every node contains greater keys. Hence, the tree is a BST.
// Input: root = [2, N, 7, N, 6, N, 9] 



// Output: false 
// Explanation: Since the node to the right of node with key 7 has lesser key value, hence it is not a valid BST.
// Input: root = [10, 5, 20, N, N, 9, 25]


// Output: false
// Explanation: The node with key 9 present in the right subtree has lesser key value than root node.
// Constraints:
// 1 ≤ number of nodes ≤ 105
// 1 ≤ node->data ≤ 109


public class CheckForBst {
  static class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    Node(int item) {
        data = item;
        left = right = null;
    }
}


    // Main function to check if the tree is a BST.
   static  boolean isBST(Node root) {
        // Call the helper function with the initial min and max values.
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return check(root, min, max);
    }

    // Helper function to check if the tree is a BST within the given range.
    private static boolean check(Node root, int min, int max) {
        // Base condition: if the root is null, it's a valid BST by default.
        if (root == null) {
            return true;
        }
        
        // If the node's data is out of the valid range, return false.
        if (root.data <= min || root.data >= max) {
            return false;
        }
        
        // Recursively check the left subtree with an updated max value,
        // and the right subtree with an updated min value.
        return check(root.left, min, root.data) && check(root.right, root.data, max);
    }

    public static void main(String[] args) {
        // Test Case 1: A valid Binary Search Tree (BST)
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        
        System.out.println("Test Case 1: " + isBST(root1)); // Output: true
        
        // Test Case 2: A tree that is NOT a BST
        Node root2 = new Node(2);
        root2.left = new Node(3);  // Left child is greater than root (violation)
        root2.right = new Node(1); // Right child is smaller than root (violation)
        
        System.out.println("Test Case 2: " + isBST(root2)); // Output: false
        
        // Test Case 3: Another valid BST
        Node root3 = new Node(10);
        root3.left = new Node(5);
        root3.right = new Node(15);
        root3.left.left = new Node(2);
        root3.left.right = new Node(7);
        root3.right.left = new Node(12);
        root3.right.right = new Node(20);
        
        System.out.println("Test Case 3: " + isBST(root3)); // Output: true

        // Test Case 4: A tree with duplicate values (should not be a BST)
        Node root4 = new Node(5);
        root4.left = new Node(5);  // Duplicate value (violation of BST property)
        
        System.out.println("Test Case 4: " + isBST(root4)); // Output: false
    }
}
