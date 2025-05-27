package trees;

public class SymmetricBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isSymmetric(Node root) {
        // Base case: if the root is null, it is considered symmetric
        if (root == null) {
            return true;
        }
        // Check if the left and right subtrees are symmetric
        return symmetric(root.left, root.right);
    }

    private static boolean symmetric(Node root1, Node root2) {
        // Both nodes are null, so they are symmetric
        if (root1 == null && root2 == null)
            return true;
        // One of the nodes is null, or their values differ, so they are not symmetric
        if (root1 == null || root2 == null)
            return false;

        // Check if the current nodes are equal and recurse on the subtrees
        return (root1.data == root2.data) &&
                symmetric(root1.left, root2.right) &&
                symmetric(root1.right, root2.left);
    }

    public static void main(String[] args) {
        // Creating a symmetric tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.right.left = new Node(4);
        root1.right.right = new Node(3);

        // Creating a non-symmetric tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(2);
        root2.left.right = new Node(3);
        root2.right.right = new Node(3);

        // Test cases
        System.out.println(isSymmetric(root1)); // Output: true
        System.out.println(isSymmetric(root2)); // Output: false
    }
}

/*
Problem Statement:
Given a root of a Binary Tree, your task is to check whether it is Symmetric or not,
i.e., whether the binary tree is a Mirror image of itself.

Examples:
Input: root[] = [1, 2, 2, 3, 4, 4, 3]
Output: true
Explanation: The tree is a mirror image of itself i.e. the tree is symmetric.

Input: root[] = [1, 2, 2, N, 3, N, 3]
Output: false
Explanation: The tree is not a mirror image of itself i.e. the tree is not symmetric.
*/
