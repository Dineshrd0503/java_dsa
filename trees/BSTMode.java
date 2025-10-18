package trees;

/**
 * Problem: Find Mode(s) in BST with Duplicates
 *
 * Given root of BST (allows duplicates: left <= node, right >= node),
 * return all mode(s) - most frequent value(s) - in any order.
 *
 * Approach: In-order traversal (sorted order) + HashMap for frequencies.
 * Track max frequency, collect all values with that frequency.
 *
 * Time: O(N), Space: O(N)
 *
 * TreeNode Definition:
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val; this.left = left; this.right = right;
 *     }
 * }
 */

import java.util.*;

// TreeNode class

public class BSTMode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Global variables for tracking during in-order traversal
    private Map<Integer, Integer> freqMap;
    private int maxFreq;
    private List<Integer> modes;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        freqMap = new HashMap<>();
        maxFreq = 0;
        modes = new ArrayList<>();

        // Perform in-order traversal to count frequencies
        inorderTraversal(root);

        // Second pass: Collect all modes with maxFreq
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }

        // Convert to array
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }

    // In-order traversal: left -> root -> right (produces sorted order)
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);  // Visit smaller/equal values

        // Visit current: Count frequency
        int count = freqMap.getOrDefault(node.val, 0) + 1;
        freqMap.put(node.val, count);
        if (count > maxFreq) {
            maxFreq = count;
        }

        inorderTraversal(node.right);  // Visit larger/equal values
    }

    // Utility: Create BST from level-order array (null = -1)
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

    // Utility: Print in-order traversal for verification
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Utility: Print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Main method with test cases
    public static void main(String[] args) {
        BSTMode solution = new BSTMode();


        System.out.println("=== BST MODE(S) WITH DUPLICATES ===\n");

        // Test Case 1: Example 1 [1,null,2,2]
        System.out.println("Test Case 1: [1,null,2,2]");
        int[] arr1 = {1, -1, 2, 2, -1};
        TreeNode root1 = createBST(arr1);
        System.out.print("In-order: ");
        printInorder(root1);
        System.out.println();
        int[] result1 = solution.findMode(root1);
        System.out.print("Modes: ");
        printArray(result1);  // Expected: [2]
        System.out.println();

        // Test Case 2: Example 2 [0]
        System.out.println("Test Case 2: [0]");
        int[] arr2 = {0};
        TreeNode root2 = createBST(arr2);
        System.out.print("In-order: ");
        printInorder(root2);
        System.out.println();
        int[] result2 = solution.findMode(root2);
        System.out.print("Modes: ");
        printArray(result2);  // Expected: [0]
        System.out.println();

        // Test Case 3: Multiple modes [1,0,2,0,3,null,null,null,null,null,null,null,null,null,null,3]
        System.out.println("Test Case 3: Tree with modes 0 and 3 (freq=2 each)");
        int[] arr3 = {0, -1, 3, 1, 2, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, 3};  // Simplified for [0,0,1,2,3,3]
        TreeNode root3 = createBST(arr3);
        System.out.print("In-order: ");
        printInorder(root3);
        System.out.println();
        int[] result3 = solution.findMode(root3);
        System.out.print("Modes: ");
        printArray(result3);  // Expected: [0, 3] (any order)
        System.out.println();

        // Test Case 4: All unique [1,2,3]
        System.out.println("Test Case 4: All unique [1,2,3]");
        int[] arr4 = {2, 1, 3};
        TreeNode root4 = createBST(arr4);
        System.out.print("In-order: ");
        printInorder(root4);
        System.out.println();
        int[] result4 = solution.findMode(root4);
        System.out.print("Modes: ");
        printArray(result4);  // Expected: [1,2,3] (all freq=1, so all modes)
        System.out.println();

        // Test Case 5: All duplicates [5,5,5]
        System.out.println("Test Case 5: All duplicates [5,5,5]");
        int[] arr5 = {5, 5, -1};
        TreeNode root5 = createBST(arr5);
        System.out.print("In-order: ");
        printInorder(root5);
        System.out.println();
        int[] result5 = solution.findMode(root5);
        System.out.print("Modes: ");
        printArray(result5);  // Expected: [5]
        System.out.println();
    }
}
