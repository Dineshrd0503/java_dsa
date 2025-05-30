package trees;

/*
Problem Statement:
Given the root of a binary search tree (BST) and a number k, find the greatest number in the binary search tree that is less than or equal to k.

Examples:
Input:
  root = [10, 7, 15, 2, 8, 11, 16],
  k = 14
Output: 11
Explanation: The greatest element in the tree which is less than or equal to 14, is 11.

Input:
  root = [5, 2, 12, 1, 3, 9, 21, N, N, N, N, N, N, 19, 25],
  k = 24
Output: 21
Explanation: The greatest element in the tree which is less than or equal to 24, is 21.

Input:
  root = [5, 2, 12, 1, 3, 9, 21, N, N, N, N, N, N, 19, 25],
  k = 4
Output: 3
Explanation: The greatest element in the tree which is less than or equal to 4, is 3.

Constraints:
1 <= number of nodes <= 10^5
1 <= node->data, k <= 10^5
All nodes are unique in the BST.
*/


public class ClosestNeighbourInBST {

    // Static Node class
    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static int findMaxFork(Node root, int k) {
        int max = -1; // Initialize max to -1

        while (root != null) {
            if (root.data <= k) {
                max = root.data; // Update max
                root = root.right; // Move right
            } else {
                root = root.left; // Move left
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // Test case 1
        Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.left = new Node(2);
        root1.left.right = new Node(8);
        root1.right.left = new Node(11);
        root1.right.right = new Node(16);

        System.out.println(ClosestNeighbourInBST.findMaxFork(root1, 14)); // Output: 11

        // Test case 2
        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(12);
        root2.left.left = new Node(1);
        root2.left.right = new Node(3);
        root2.right.left = new Node(9);
        root2.right.right = new Node(21);
        root2.right.right.left = new Node(19);
        root2.right.right.right = new Node(25);

        System.out.println(ClosestNeighbourInBST.findMaxFork(root2, 24)); // Output: 21

        // Test case 3
        Node root3 = new Node(5);
        root3.left = new Node(2);
        root3.right = new Node(12);
        root3.left.left = new Node(1);
        root3.left.right = new Node(3);
        root3.right.left = new Node(9);
        root3.right.right = new Node(21);
        root3.right.right.left = new Node(19);
        root3.right.right.right = new Node(25);

        System.out.println(ClosestNeighbourInBST.findMaxFork(root3, 4)); // Output: 3
    }
}