package trees;
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//A valid BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//
//Example 1:
//
//
//Input: root = [2,1,3]
//Output: true
//Example 2:
//
//
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.

public class ValidBST {
                static class TreeNode {
                    int val;
                    TreeNode left, right;

                    TreeNode(int val) {
                        this.val = val;
                        this.left = null;
                        this.right = null;
                    }
                }

                public boolean isValidBST(TreeNode root) {
                    // Call helper with long range to handle Integer.MIN_VALUE and Integer.MAX_VALUE
                    return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
                }

                private boolean isValidBSTHelper(TreeNode root, long min, long max) {
                    // Base case: empty tree is valid
                    if (root == null) {
                        return true;
                    }

                    // Check if current node's value is within the valid range
                    if (root.val <= min || root.val >= max) {
                        return false;
                    }

                    // Recurse on left subtree (values < root.val)
                    // Recurse on right subtree (values > root.val)
                    return isValidBSTHelper(root.left, min, (long) root.val) &&
                            isValidBSTHelper(root.right, (long) root.val, max);
                }

                // Main method with test cases
                public static void main(String[] args) {
                    ValidBST solution = new ValidBST();

                    // Test Case 1: [2, 1, 3]
                    TreeNode root1 = new TreeNode(2);
                    root1.left = new TreeNode(1);
                    root1.right = new TreeNode(3);
                    System.out.println("Test Case 1: " + solution.isValidBST(root1) + " (Expected: true)");

                    // Test Case 2: [5, 1, 4, null, null, 3, 6]
                    TreeNode root2 = new TreeNode(5);
                    root2.left = new TreeNode(1);
                    root2.right = new TreeNode(4);
                    root2.right.left = new TreeNode(3);
                    root2.right.right = new TreeNode(6);
                    System.out.println("Test Case 2: " + solution.isValidBST(root2) + " (Expected: false)");

                    // Test Case 3: [1] (Single node)
                    TreeNode root3 = new TreeNode(1);
                    System.out.println("Test Case 3: " + solution.isValidBST(root3) + " (Expected: true)");

                    // Test Case 4: [10, 5, 15, null, null, 6, 20] (Invalid due to 6 < 10)
                    TreeNode root4 = new TreeNode(10);
                    root4.left = new TreeNode(5);
                    root4.right = new TreeNode(15);
                    root4.right.left = new TreeNode(6);
                    root4.right.right = new TreeNode(20);
                    System.out.println("Test Case 4: " + solution.isValidBST(root4) + " (Expected: false)");

                    // Test Case 5: [2147483647] (Edge case: Integer.MAX_VALUE)
                    TreeNode root5 = new TreeNode(Integer.MAX_VALUE);
                    System.out.println("Test Case 5: " + solution.isValidBST(root5) + " (Expected: true)");
                }
            }