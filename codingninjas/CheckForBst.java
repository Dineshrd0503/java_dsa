// problem statement
// Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.

// Note:
// Duplicate elements should be kept in the right subtree.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 0 <= Number of edges <= 10^5
// Time Limit: 1 second
// Sample Input 1 :
// 3 1 5 -1 2 -1 -1 -1 -1

// Sample Output 1 :
// true
// Sample Input 2 :
// 5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1

// Sample Output 2 :
// false



import java.util.*;
public class CheckForBst {
    
    // Define BinaryTreeNode as a static inner class
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left, right;

        // Constructor to create a new node
        BinaryTreeNode(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Main method to test the isBST function
    public static void main(String[] args) {
        CheckForBst solution = new CheckForBst();

        // Test Case 1: A valid Binary Search Tree (BST)
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(2);
        root1.left = new BinaryTreeNode<>(1);
        root1.right = new BinaryTreeNode<>(3);

        System.out.println(solution.isBST(root1)); // Output: true

        // Test Case 2: A tree that is NOT a BST
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(2);
        root2.left = new BinaryTreeNode<>(3);  // Left child is greater than root (violation)
        root2.right = new BinaryTreeNode<>(1); // Right child is smaller than root (violation)

        System.out.println(solution.isBST(root2)); // Output: false

        // Test Case 3: Another valid BST
        BinaryTreeNode<Integer> root3 = new BinaryTreeNode<>(10);
        root3.left = new BinaryTreeNode<>(5);
        root3.right = new BinaryTreeNode<>(15);
        root3.left.left = new BinaryTreeNode<>(2);
        root3.left.right = new BinaryTreeNode<>(7);
        root3.right.left = new BinaryTreeNode<>(12);
        root3.right.right = new BinaryTreeNode<>(20);

        System.out.println(solution.isBST(root3)); // Output: true

        // Test Case 4: A tree with duplicate values (should not be a BST)
        BinaryTreeNode<Integer> root4 = new BinaryTreeNode<>(5);
        root4.left = new BinaryTreeNode<>(5);  // Duplicate value (violation of BST property)

        System.out.println(solution.isBST(root4)); // Output: false
    }

    // Function to check if the binary tree is a BST
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper function to check if the binary tree is a BST within the given range
    private static boolean check(BinaryTreeNode<Integer> node, int min, int max) {
        // Base case: if the node is null, it's a valid BST by default
        if (node == null) {
            return true;
        }

        // If the node's data is outside the valid range, return false
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recursively check the left subtree with an updated max value,
        // and the right subtree with an updated min value
        return check(node.left, min, node.data) && check(node.right, node.data, max);
    }
}
