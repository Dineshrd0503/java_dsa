
package codingninjas2monthchallenge;


/*
Problem Statement:
Given a binary tree with integer values in nodes, find the maximum sum of nodes such that 
no two chosen nodes are adjacent (directly connected). 

Constraints:
- 1 <= T <= 100 (test cases)
- 0 <= N <= 3000 (nodes)
- Node values: 1 <= data <= 10^4

Sample Input 1:
1
1 2 3 1 -1 4 5 -1 -1 -1 -1 -1 -1

Sample Output 1:
11
Explanation: Chosen nodes (2,4,5) sum to 11

Sample Input 2:
2
1 2 3 -1 -1 -1 -1
7 -1 -1

Sample Output 2:
5
7 
Explanation: First case (2+3=5), Second case (7)
*/

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumOfNodes {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { data = x; }
    }

    public static void main(String[] args) {
        // Static test cases as per sample input 2 (two test cases)
        String[][] testCases = {
            {"1", "2", "3", "-1", "-1", "-1", "-1"},
            {"7", "-1", "-1"}
        };

        for (String[] nodes : testCases) {
            TreeNode root = buildTree(nodes);
            int maxSum = maximumSumOfNodes(root);
            System.out.println(maxSum);
        }
    }

    // Build tree from level order input (-1 for null nodes)
    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode curr = q.poll();

            // Left child
            if (!nodes[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.left);
            }
            i++;

            // Right child
            if (i < nodes.length && !nodes[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Main solution method
    public static int maximumSumOfNodes(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    // Returns [includeCurrent, excludeCurrent]
    private static int[] helper(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int include = node.data + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }
}
