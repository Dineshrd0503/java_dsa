package trees;

import java.util.HashMap;
import java.util.Map;

//Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.
//
//        Note: The output is written in postorder traversal.
//
//        Examples:
//
//Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
//Output: [8, 7, 6, 1]
//Explanation: The tree will look like
//
//Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
//Output: [3, 4, 1, 5, 2, 0]
//Explanation: The tree will look like
//
//Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
//Output: [2, 5, 4, 3, 1]
//Explanation: The tree will look like
//
//Constraints:
//        1 ≤ number of nodes ≤ 103
//        0 ≤ nodes -> data ≤ 103

// Problem Description:
// Given the preorder and inorder traversals of a binary tree, construct the binary tree.
// Preorder: Root -> Left -> Right
// Inorder: Left -> Root -> Right
// Note: Duplicates do not exist in the traversals.

// Constraints:
// 1 <= N <= 3000
// 1 <= data <= 10^4

// Test Cases:
// 1. N = 5, preorder = [1, 2, 4, 7, 3], inorder = [4, 2, 7, 1, 3]
//    Output: Tree with root 1, structure: 1(2(4,7), 3)
// 2. N = 2, preorder = [1, 2], inorder = [2, 1]
//    Output: Tree with root 1, structure: 1(2, null)

// Definition of TreeNode class

public class ConstructTreeFromInorderPreorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private static HashMap<Integer, Integer> inorderMap;
    private static int preIndex;

    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        inorderMap = new HashMap<>();
        preIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);

        root.left = buildTreeHelper(preorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, rootIndex + 1, inEnd);

        return root;
    }

    private static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder1 = {1, 2, 4, 7, 3};
        int[] inorder1 = {4, 2, 7, 1, 3};
        TreeNode root1 = buildBinaryTree(inorder1, preorder1);
        System.out.print("Test 1 Preorder: ");
        printPreorder(root1);
        System.out.println();

        int[] preorder2 = {1, 2};
        int[] inorder2 = {2, 1};
        TreeNode root2 = buildBinaryTree(inorder2, preorder2);
        System.out.print("Test 2 Preorder: ");
        printPreorder(root2);
        System.out.println();
    }
}