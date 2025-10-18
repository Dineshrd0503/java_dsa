package trees;

/*
Problem Statement:
-------------------
Given a Binary Search Tree (BST), find the median of all the nodes present in it.

The median is defined as:
 - If the number of nodes (n) is odd, median = middle element after sorting all node values.
 - If the number of nodes (n) is even, median = average of the two middle elements after sorting all node values.

You can assume that the BST does not contain duplicate elements.

Example 1:
-----------
Input:
        6
       / \
      3   8
     / \   \
    1   4   9

Output: 6

Explanation:
The inorder traversal of the BST is [1, 3, 4, 6, 8, 9]
The median is (4 + 6) / 2 = 5 (integer division gives 5)

Example 2:
-----------
Input:
        6
       / \
      3   8
     / \
    1   4

Output: 4

Explanation:
The inorder traversal of the BST is [1, 3, 4, 6, 8]
The median is the middle element 4.
*/

import java.util.*;



public class BSTMedian {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    // Function to find the median of BST
    public int findMedian(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        int n = result.size();

        // Odd number of nodes
        if (n % 2 != 0)
            return result.get(n / 2);

        // Even number of nodes
        return (result.get(n / 2) + result.get(n / 2 - 1)) / 2;
    }

    // Helper function for inorder traversal (gives sorted order in BST)
    public void inorder(Node root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    // Main method with static input
    public static void main(String[] args) {
        /*
         Example BST structure:
                 6
                / \
               3   8
              / \   \
             1   4   9
        Expected Output: Median = 5
        */

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        BSTMedian obj = new BSTMedian();
        int median = obj.findMedian(root);
        System.out.println("Median of BST is: " + median);
    }
}
