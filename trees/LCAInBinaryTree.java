package trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;


public class LCAInBinaryTree {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left, right;

        TreeNode(T item) {
            data = item;
            left = right = null;
        }
    }

    // LCA function for a binary tree (returns the value of the LCA node)
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        if (root == null) return -1;
        if (root.data == x || root.data == y) return root.data;
        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);
        if (left != -1 && right != -1) return root.data;
        return (left != -1) ? left : right;
    }

    // Helper: Build tree from level order input with -1 as null marker
    public static TreeNode<Integer> buildTreeFromLevelOrder(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        TreeNode<Integer> root = new TreeNode<>(arr[0]);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode<Integer> current = queue.poll();
            // Left child
            if (arr[i] != -1) {
                current.left = new TreeNode<>(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i >= arr.length) break;
            // Right child
            if (arr[i] != -1) {
                current.right = new TreeNode<>(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Test runner
    public static void runTest(int[] treeArr, int x, int y, int expected) {
        TreeNode<Integer> root = buildTreeFromLevelOrder(treeArr);
        int lca = lowestCommonAncestor(root, x, y);
        System.out.println("LCA of " + x + " and " + y + " is: " + lca + (lca == expected ? " (PASS)" : " (FAIL, expected " + expected + ")"));
    }

    public static void main(String[] args) {
        // Test 1: Sample Input 1
        int[] tree1 = {1, 2, 3, 4, 7, -1, -1, -1, -1, -1, -1};
        runTest(tree1, 4, 7, 2); // Expected: 2

        // Test 2: Sample Input 2
        int[] tree2 = {1, 2, 3, -1, -1, -1, -1};
        runTest(tree2, 2, 3, 1); // Expected: 1

        // Test 3: Big Tree Example
        int[] tree3 = {1, 2, 3, 4, 5, -1, 6, 7, -1, 8, 9, 10, 11, -1, -1, -1, -1, -1, -1, -1, -1};
        runTest(tree3, 8, 9, 5); // Expected: 5
        runTest(tree3, 7, 11, 1); // Expected: 1
        runTest(tree3, 4, 5, 2); // Expected: 2
        runTest(tree3, 10, 11, 6); // Expected: 6
        runTest(tree3, 2, 11, 1); // Expected: 1
    }
}

