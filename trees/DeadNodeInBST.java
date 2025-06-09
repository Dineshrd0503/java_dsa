package trees;

import java.util.HashSet;

/*
 * Problem: Determine if a Binary Search Tree (BST) contains a dead end.
 * A dead end is a leaf node where no new positive integer (>0) can be inserted
 * at or below it while maintaining the BST property.
 * - For leaf node x, it's a dead end if:
 *   - x = 1 and x+1 = 2 exists, or
 *   - x-1 and x+1 both exist in the BST.
 * Constraints:
 * - 1 ≤ number of nodes ≤ 3000
 * - 1 ≤ node->data ≤ 10^5
 * - All node values are unique positive integers.
 *
 * Example Test Cases:
 * 1. Input: [8, 5, 9, 2, 7, null, null, 1]
 *    Output: true (Leaf 1 is a dead end, as 2 exists)
 * 2. Input: [8, 7, 10, 2, null, 9, 13]
 *    Output: true (Leaf 9 is a dead end, as 8 and 10 exist)
 * 3. Input: [5, 3, 6, 2, 4, null, null, 1]
 *    Output: true (Leaf 1 is a dead end, as 2 exists)
 * 4. Input: [3, 2, 4]
 *    Output: false (No dead end: Leaf 2 has 1 available, Leaf 4 has 5 available)
 * 5. Input: [1]
 *    Output: false (Leaf 1 has no 2, so 2 can be inserted)
 */

public class DeadNodeInBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public boolean isDeadEnd(Node root) {
        HashSet<Integer> allNodes = new HashSet<>();
        HashSet<Integer> leafNodes = new HashSet<>();

        inorder(root, allNodes, leafNodes);

        for (int val : leafNodes) {
            if (val == 1 && allNodes.contains(2)) {
                return true;
            }
            if (allNodes.contains(val - 1) && allNodes.contains(val + 1)) {
                return true;
            }
        }
        return false;
    }

    private void inorder(Node root, HashSet<Integer> allNodes, HashSet<Integer> leafNodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, allNodes, leafNodes);
        allNodes.add(root.data);
        if (root.left == null && root.right == null) {
            leafNodes.add(root.data);
        }
        inorder(root.right, allNodes, leafNodes);
    }

    public static void main(String[] args) {
        DeadNodeInBST solution = new DeadNodeInBST();

        Node root1 = new Node(8);
        root1.left = new Node(5);
        root1.right = new Node(9);
        root1.left.left = new Node(2);
        root1.left.right = new Node(7);
        root1.left.left.left = new Node(1);
        System.out.println("Test Case 1: " + solution.isDeadEnd(root1) + " (Expected: true)");

        Node root2 = new Node(8);
        root2.left = new Node(7);
        root2.right = new Node(10);
        root2.left.left = new Node(2);
        root2.right.left = new Node(9);
        root2.right.right = new Node(13);
        System.out.println("Test Case 2: " + solution.isDeadEnd(root2) + " (Expected: true)");

        Node root3 = new Node(5);
        root3.left = new Node(3);
        root3.right = new Node(6);
        root3.left.left = new Node(2);
        root3.left.right = new Node(4);
        root3.left.left.left = new Node(1);
        System.out.println("Test Case 3: " + solution.isDeadEnd(root3) + " (Expected: true)");

        Node root4 = new Node(3);
        root4.left = new Node(2);
        root4.right = new Node(4);
        System.out.println("Test Case 4: " + solution.isDeadEnd(root4) + " (Expected: false)");

        Node root5 = new Node(1);
        System.out.println("Test Case 5: " + solution.isDeadEnd(root5) + " (Expected: false)");
    }
}