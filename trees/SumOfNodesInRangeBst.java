package trees;

/**
 * Problem Statement:
 * Given the root of a Binary Search Tree and two integers l and r, the task is to find the
 * sum of all nodes that lie between l and r, including both l and r.
 *
 * Examples:
 *
 * Input: root = [22, 12, 30, 8, 20], l = 10, r = 22
 *        22
 *       /  \
 *      12  30
 *     / \
 *    8  20
 * Output: 54
 * Explanation: The nodes in the given Tree that lies in the range [10, 22] are {12, 20, 22}.
 * Therefore, the sum of nodes is 12 + 20 + 22 = 54.
 *
 * Input: root = [8, 5, 11, 3, 6, N, 20], l = 11, r = 15
 *       8
 *      / \
 *     5  11
 *    / \   \
 *   3   6   20
 * Output: 11
 * Explanation: The nodes in the given Tree that lies in the range [11, 15] is {11}. Therefore, the sum of node is 11.
 *
 * Constraints:
 * 0 ≤ number of nodes ≤ 10^4
 * 0 ≤ node->data ≤ 10^4
 * 0 ≤ l ≤ r ≤ 10^4
 */



public class SumOfNodesInRangeBst {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }
    /**
     * Calculates the sum of nodes within a given range in a Binary Search Tree (BST).
     *
     * @param root The root node of the BST.
     * @param l    The lower bound of the range (inclusive).
     * @param r    The upper bound of the range (inclusive).
     * @return The sum of the node values within the specified range.
     */
    public int nodeSum(Node root, int l, int r) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // If the current node's value is within the range, add it to the sum.
        if (root.data >= l && root.data <= r) {
            sum += root.data;
        }

        // Recursively explore the left subtree if the current node's value is greater than the lower bound.
        if (root.data > l) {
            sum += nodeSum(root.left, l, r);
        }

        // Recursively explore the right subtree if the current node's value is less than the upper bound.
        if (root.data < r) {
            sum += nodeSum(root.right, l, r);
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfNodesInRangeBst sol = new SumOfNodesInRangeBst();

        // Test case 1
        Node root1 = new Node(22);
        root1.left = new Node(12);
        root1.right = new Node(30);
        root1.left.left = new Node(8);
        root1.left.right = new Node(20);
        int l1 = 10;
        int r1 = 22;
        System.out.println("Test Case 1: Sum of nodes in range [" + l1 + ", " + r1 + "] = " + sol.nodeSum(root1, l1, r1)); // Expected Output: 54

        // Test case 2
        Node root2 = new Node(8);
        root2.left = new Node(5);
        root2.right = new Node(11);
        root2.left.left = new Node(3);
        root2.left.right = new Node(6);
        // root2.right.left = null; //Adding these would cause error as the code doesn't handle null node correctly
        root2.right.right = new Node(20);
        int l2 = 11;
        int r2 = 15;
        System.out.println("Test Case 2: Sum of nodes in range [" + l2 + ", " + r2 + "] = " + sol.nodeSum(root2, l2, r2)); // Expected Output: 11

        // Test case 3: Empty tree
        Node root3 = null;
        int l3 = 1;
        int r3 = 10;
        System.out.println("Test Case 3: Sum of nodes in range [" + l3 + ", " + r3 + "] = " + sol.nodeSum(root3, l3, r3)); // Expected Output: 0

        // Test case 4: Single node tree, node within range
        Node root4 = new Node(5);
        int l4 = 3;
        int r4 = 7;
        System.out.println("Test Case 4: Sum of nodes in range [" + l4 + ", " + r4 + "] = " + sol.nodeSum(root4, l4, r4)); // Expected Output: 5

        // Test case 5: Single node tree, node outside range
        Node root5 = new Node(10);
        int l5 = 1;
        int r5 = 5;
        System.out.println("Test Case 5: Sum of nodes in range [" + l5 + ", " + r5 + "] = " + sol.nodeSum(root5, l5, r5)); // Expected Output: 0

        // Test case 6: All nodes within range
        Node root6 = new Node(5);
        root6.left = new Node(3);
        root6.right = new Node(7);
        int l6 = 1;
        int r6 = 10;
        System.out.println("Test Case 6: Sum of nodes in range [" + l6 + ", " + r6 + "] = " + sol.nodeSum(root6, l6, r6)); // Expected Output: 15

        // Test case 7: No nodes within range
        Node root7 = new Node(5);
        root7.left = new Node(3);
        root7.right = new Node(7);
        int l7 = 8;
        int r7 = 10;
        System.out.println("Test Case 7: Sum of nodes in range [" + l7 + ", " + r7 + "] = " + sol.nodeSum(root7, l7, r7)); // Expected Output: 0


    }
}
