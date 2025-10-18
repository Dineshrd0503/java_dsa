package trees;
import java.util.*;
/**
 * PROBLEM STATEMENT (Approach 2):
 * Given a Binary Search Tree (BST) with unique node values, transform it into a
 * strictly greater sum tree where each node contains the sum of ALL nodes
 * STRICTLY GREATER than itself (excludes current node value).
 *
 * Example:
 * Input: [2, 1, 6, null, null, 3, 7]
 * Output: [14, 16, 1, null, null, 7, 0]
 *
 * Explanation: Each node value is replaced with the sum of only greater values
 * (excludes itself).
 *
 * Approach: Reverse in-order traversal (right-root-left) with running sum.
 * Add current value to sum, but assign sum minus current value to node.
 * Time: O(N), Space: O(H) where H is tree height
 */



public class BstToGreaterSumExcludingCurrentNode {
    // Static variable for running sum (shared across recursion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, trees.TreeNode left, trees.TreeNode right) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int sumStrict = 0;

    public static TreeNode transformStrict(TreeNode root) {
        sumStrict = 0;  // Reset for each transformation
        if (root == null) return null;
        helperStrict(root);
        return root;
    }

    private static void helperStrict(TreeNode root) {
        if (root == null) return;

        // Reverse in-order traversal: RIGHT -> ROOT -> LEFT
        helperStrict(root.right);  // Process all greater values first

        // Store original value BEFORE modifying
        int originalValue = root.val;

        // Add current node's original value to running sum (for next nodes)
        sumStrict += originalValue;

        // Update node with ONLY sum of strictly greater values
        // (total sum minus current node's original value)
        root.val = sumStrict - originalValue;

        helperStrict(root.left);  // Process smaller values
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
        System.out.println("=== STRICT GREATER SUM TREE (EXCLUDES CURRENT VALUE) ===\n");

        // Test Case 1: Sample problem input
        System.out.println("Test Case 1: [2, 1, 6, null, null, 3, 7]");
        int[] arr1 = {2, 1, 6, -1, -1, 3, 7};
        TreeNode root1 = createBST(arr1.clone());

        System.out.print("Original Inorder: ");
        printInorder(root1);
        System.out.println();

        TreeNode result1 = transformStrict(root1);
        System.out.print("Transformed Inorder: ");
        printInorder(result1);
        System.out.println();
        System.out.println("Expected: [14, 16, 1, null, null, 7, 0]");
        System.out.println();

        // Test Case 2: Larger example
        System.out.println("Test Case 2: [11, 2, 29, 1, 7, 15, 40, null, null, null, null, null, null, 35, null]");
        int[] arr2 = {11, 2, 29, 1, 7, 15, 40, -1, -1, -1, -1, -1, -1, 35, -1};
        TreeNode root2 = createBST(arr2.clone());

        TreeNode result2 = transformStrict(root2);
        System.out.print("Transformed Inorder: ");
        printInorder(result2);
        System.out.println();
        System.out.println("Expected: [108, 126, 64, 128, 119, 93, 0, null, null, null, null, null, null, 29, null]");
        System.out.println();

        // Test Case 3: Simple balanced tree
        System.out.println("Test Case 3: [4, 2, 5, 1, 3]");
        int[] arr3 = {4, 2, 5, 1, 3, -1, -1};
        TreeNode root3 = createBST(arr3.clone());

        TreeNode result3 = transformStrict(root3);
        System.out.print("Transformed Inorder: ");
        printInorder(result3);
        System.out.println();
        System.out.println("Expected: [1, 8, 0, 10, 5]");

        // Test Case 4: Single node
        System.out.println("\nTest Case 4: [10]");
        int[] arr4 = {10};
        TreeNode root4 = createBST(arr4.clone());
        TreeNode result4 = transformStrict(root4);
        System.out.print("Transformed Inorder: ");
        printInorder(result4);
        System.out.println();
        System.out.println("Expected: 0 (no greater values)");
    }
}
