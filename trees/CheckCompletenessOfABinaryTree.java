package trees;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
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

public class CheckCompletenessOfABinaryTree {

    /**
     * Given the root of a binary tree, determine if it is a complete binary tree.
     * In a complete binary tree, every level, except possibly the last, is completely filled,
     * and all nodes in the last level are as far left as possible.
     *
     * Example 1:
     * Input: root = [1,2,3,4,5,6]
     * Output: true
     * Explanation: Every level before the last is full (i.e. levels with node-values {1} and {2, 3}),
     * and all nodes in the last level ({4, 5, 6}) are as far left as possible.
     *
     * Example 2:
     * Input: root = [1,2,3,4,5,null,7]
     * Output: false
     * Explanation: The node with value 7 isn't as far left as possible.
     *
     * Constraints:
     * - The number of nodes in the tree is in the range [1, 100].
     * - 1 <= Node.val <= 1000
     */

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false; // Flag to indicate if we've seen a non-full node

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                end = true; // We've encountered null, no more nodes should come after this
            } else {
                if (end) return false; // If we hit a null before and now we have a non-null, it's not complete
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true; // If we passed through all nodes without violation, it's complete
    }

    public static void main(String[] args) {
        // Sample Test Cases
        CheckCompletenessOfABinaryTree checker = new CheckCompletenessOfABinaryTree();

        // Test case 1: should return true
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        new TreeNode(6),
                        null
                ));
        System.out.println(checker.isCompleteTree(root1)); // Output: true

        // Test case 2: should return false
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(7)
                ));
        System.out.println(checker.isCompleteTree(root2)); // Output: false
    }
}