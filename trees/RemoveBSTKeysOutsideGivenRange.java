package trees;

// Definition for a binary tree node.

public class RemoveBSTKeysOutsideGivenRange {
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


    /**
     * Problem Statement:
     * Given the root of a Binary Search Tree (BST) and two integers l and r,
     * remove all the nodes whose values lie outside the range [l, r].
     * Note: The modified tree should also be a BST.
     *
     * Approach:
     * This is a recursive solution.  For each node, we check if its value
     * is within the given range [l, r].
     * 1. If the node's value is less than l, then the node and its left subtree
     *    are outside the range. We discard them and return the right subtree.
     * 2. If the node's value is greater than r, then the node and its right
     *    subtree are outside the range.  We discard them and return the left subtree.
     * 3. If the node's value is within the range [l, r], we recursively process
     *    the left and right subtrees and update the node's left and right children
     *    with the results.  Then we return the node itself.
     *
     * Time Complexity: O(n), where n is the number of nodes in the BST.
     * Space Complexity: O(h), where h is the height of the BST (due to the recursive call stack).
     *                             In the worst case, h = n, so the space complexity can be O(n).
     *
     * @param root The root of the BST.
     * @param l The lower bound of the range.
     * @param r The upper bound of the range.
     * @return The root of the modified BST.
     */
    Node removekeys(Node root, int l, int r) {
        // Base case: if the tree is empty, return null.
        if (root == null) {
            return null;
        }

        // If the node's value is less than the lower bound, remove it and its left subtree.
        if (root.data < l) {
            return removekeys(root.right, l, r);
        }

        // If the node's value is greater than the upper bound, remove it and its right subtree.
        if (root.data > r) {
            return removekeys(root.left, l, r);
        }

        // If the node's value is within the range, recursively process the left and right subtrees.
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        // Return the (possibly modified) node.
        return root;
    }

    // Helper method to print the inorder traversal of the tree
    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }


    public static void main(String[] args) {
        // Example usage:
        Node root = new Node(6);
        root.left = new Node(-13);
        root.right = new Node(14);
        root.left.right = new Node(-8);
        root.right.left = new Node(13);
        root.right.right = new Node(15);
        root.left.right.left = new Node(7);

        int l = -10;
        int r = 13;

        RemoveBSTKeysOutsideGivenRange sol = new RemoveBSTKeysOutsideGivenRange();


        System.out.println("Original BST (inorder traversal):");
        sol.inorderTraversal(root);
        System.out.println();

        // Remove keys outside the given range
        root = sol.removekeys(root, l, r);

        System.out.println("Modified BST (inorder traversal):");
        sol.inorderTraversal(root);
        System.out.println();
    }
}
