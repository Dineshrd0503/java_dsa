package trees;

import java.util.ArrayList;

public class PredecessorAndSuccessor {

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    /**
     * This function finds the in-order predecessor and successor of a given key in a BST.
     *
     * Problem Description:
     * You are given root node of the BST and an integer key.
     * You need to find the in-order successor and predecessor of the given key.
     * If either predecessor or successor is not found, then set it to NULL.
     *
     * Note: In an inorder traversal the number just smaller than the target is the predecessor
     * and the number just greater than the target is the successor.
     *
     * Sample Test Cases:
     * Input:
     * root[] = [8, 1, 9, N, 4, N, 10], key = 8
     * Output: 4 9
     * Explanation: In the given BST, the inorder predecessor of 8 is 4 and the inorder successor of 8 is 9.
     *
     * Input:
     * root[] = [10, 2, 11, 1, 5, N, N, N, N, 3, 6, N, 4, N, N], key = 11
     * Output: 10 -1
     * Explanation: In the given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.
     *
     * Input:
     * root[] = [2, 1, 3], key = 3
     * Output: 2 -1
     * Explanation: In the given BST, the inorder predecessor of 3 is 2 whereas it does not have any inorder successor.
     *
     * @param root The root node of the binary search tree
     * @param key The key to search for its predecessor and successor
     * @return An ArrayList containing the predecessor and successor nodes
     */
    public static ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = null;
        Node successor = null;

        while (root != null) {
            if (root.data == key) {
                // Found the key, check for predecessor and successor
                if (root.left != null) {
                    // Find the predecessor
                    predecessor = root.left;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                }
                if (root.right != null) {
                    // Find the successor
                    successor = root.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }
                }
                break;
            } else if (root.data < key) {
                predecessor = root; // Candidate for predecessor
                root = root.right;  // Move to right subtree
            } else {
                successor = root;    // Candidate for successor
                root = root.left;    // Move to left subtree
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }

    // Helper method to create a sample BST
    public static Node createSampleTree() {
        Node root = new Node(8);
        root.left = new Node(1);
        root.right = new Node(9);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(10);
        return root;
    }

    public static void main(String[] args) {
        // Sample test case 1
        Node root = createSampleTree();
        int key = 8;
        ArrayList<Node> result = findPreSuc(root, key);

        System.out.println("For key " + key + ":");
        System.out.println("Predecessor: " + (result.get(0) != null ? result.get(0).data : "null"));
        System.out.println("Successor: " + (result.get(1) != null ? result.get(1).data : "null"));

        // Sample test case 2
        key = 11;
        root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(11);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        root.left.right.left.right = new Node(4);

        result = findPreSuc(root, key);

        System.out.println("For key " + key + ":");
        System.out.println("Predecessor: " + (result.get(0) != null ? result.get(0).data : "null"));
        System.out.println("Successor: " + (result.get(1) != null ? result.get(1).data : "null"));
    }
}