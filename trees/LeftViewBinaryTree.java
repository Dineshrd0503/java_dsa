package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {

    // Static inner class for a binary tree node
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Function to return list containing elements of the left view of the binary tree
    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                // Only add the first node of each level
                if (i == 0) {
                    result.add(currNode.data);
                }

                // Enqueue left child first
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                // Enqueue right child
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example tree:
        // Input: root[] = [1, 2, 3, 4, 5, N, N]
        // Output: [1, 2, 4]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        // Expected output: [1, 2, 4]
        System.out.println(leftView(root1)); // Should print [1, 2, 4]

        // Example tree:
        // Input: root[] = [1, 2, 3, N, N, 4, N, N, 5, N, N]
        // Output: [1, 2, 4, 5]
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(4);
        root2.right.left.right = new Node(5);

        // Expected output: [1, 2, 4, 5]
        System.out.println(leftView(root2)); // Should print [1, 2, 4, 5]

        // Example tree:
        // Input: root[] = [N]
        // Output: []
        Node root3 = null;

        // Expected output: []
        System.out.println(leftView(root3)); // Should print []
    }
}