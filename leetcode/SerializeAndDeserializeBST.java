package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//        Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
//
//
//        Example 1:
//
//
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
//Example 2:
//
//Input: root = []
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//        -1000 <= Node.val <= 1000


public class SerializeAndDeserializeBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString().trim();  // Trim to remove trailing space
    }

    // Deserializes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;  // Corrected condition

        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < values.length) {
            TreeNode node = q.poll();

            // Left child
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            i++; // Move to the next value

            // Right child
            if (i < values.length && !values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
            i++; // Move to the next value
        }
        return root;
    }

    public static void main(String[] args) {
        // Test case 1
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        SerializeAndDeserializeBST obj = new SerializeAndDeserializeBST();
        String serialized = obj.serialize(root);
        System.out.println("Serialized: " + serialized);  // Output: 2 1 3
        TreeNode deserialized = obj.deserialize(serialized);
        System.out.println("Deserialized: " + obj.serialize(deserialized));  // Output: 2 1 3

        // Test case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        SerializeAndDeserializeBST obj2 = new SerializeAndDeserializeBST();
        String serialized2 = obj2.serialize(root2);
        System.out.println("Serialized: " + serialized2);  // Output: 5 3 6 2 4
        TreeNode deserialized2 = obj2.deserialize(serialized2);
        System.out.println("Deserialized: " + obj2.serialize(deserialized2));  // Output: 5 3 6 2 4
    }

}
