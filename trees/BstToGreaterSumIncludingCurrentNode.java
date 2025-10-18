package trees;

/**
 * PROBLEM STATEMENT (Approach 1):
 * Given a Binary Search Tree (BST) with unique node values, transform it into a
 * greater sum tree where each node contains the sum of ALL nodes greater than or
 * equal to itself (includes current node value).
 *
 * Example:
 * Input: [2, 1, 6, null, null, 3, 7]
 * Output: [16, 18, 7, null, null, 13, 0]
 *
 * Explanation: Each node value is replaced with the sum of itself and all greater values.
 *
 * Approach: Reverse in-order traversal (right-root-left) with running sum accumulation.
 * Time: O(N), Space: O(H) where H is tree height
 */

import java.util.*;

// TreeNode class


public class BstToGreaterSumIncludingCurrentNode {
    // Static variable for running sum (shared across recursion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val, trees.TreeNode left, trees.TreeNode right) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int i) {
            this.val = i;
        }
    }
    static int sumStandard = 0;

    public static TreeNode transformStandard(TreeNode root) {
        sumStandard = 0;  // Reset for each transformation
        if (root == null) return null;
        helperStandard(root);
        return root;
    }

    private static void helperStandard(TreeNode root) {
        if (root == null) return;

        // Reverse in-order traversal: RIGHT -> ROOT -> LEFT
        helperStandard(root.right);  // Process all greater values first

        // Store original value
        int originalValue = root.val;

        // Update node: sum of all greater values + current value itself
        root.val = sumStandard + originalValue;

        // Update running sum for next node (includes current)
        sumStandard = root.val;

        helperStandard(root.left);  // Process smaller values
    }

    // Utility to print inorder traversal for verification
    public static void printInorder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Utility to create BST from array representation
    public static TreeNode createBST(int[] arr) {
        if (arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            if (arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== STANDARD GREATER SUM TREE (INCLUDES CURRENT VALUE) ===\n");

        // Test Case 1: Sample problem input
        System.out.println("Test Case 1: [2, 1, 6, null, null, 3, 7]");
        int[] arr1 = {2, 1, 6, -1, -1, 3, 7};
        TreeNode root1 = createBST(arr1.clone());

        System.out.print("Original Inorder: ");
        printInorder(root1);
        System.out.println();

        TreeNode result1 = transformStandard(root1);
        System.out.print("Transformed Inorder: ");
        printInorder(result1);
        System.out.println();
        System.out.println("Expected: [16, 18, 7, null, null, 13, 0]");
        System.out.println();

        // Test Case 2: Larger example
        System.out.println("Test Case 2: [11, 2, 29, 1, 7, 15, 40, null, null, null, null, null, null, 35, null]");
        int[] arr2 = {11, 2, 29, 1, 7, 15, 40, -1, -1, -1, -1, -1, -1, 35, -1};
        TreeNode root2 = createBST(arr2.clone());

        TreeNode result2 = transformStandard(root2);
        System.out.print("Transformed Inorder: ");
        printInorder(result2);
        System.out.println();
        System.out.println("Expected: [119, 137, 75, 139, 130, 104, 0, null, null, null, null, null, null, 40, null]");
        System.out.println();

        // Test Case 3: Simple balanced tree
        System.out.println("Test Case 3: [4, 2, 5, 1, 3]");
        int[] arr3 = {4, 2, 5, 1, 3, -1, -1};
        TreeNode root3 = createBST(arr3.clone());

        TreeNode result3 = transformStandard(root3);
        System.out.print("Transformed Inorder: ");
        printInorder(result3);
        System.out.println();
        System.out.println("Expected: [5, 12, 0, 14, 9]");
    }
}
