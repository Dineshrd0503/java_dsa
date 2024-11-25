package trees;
import java.util.*;

public class DfsTrees {

    // Static class for Node
    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize the node
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Static class for BinaryTree
    static class BinaryTree {
        Node root;

        // Method to perform DFS (pre-order traversal) using a stack
        public void dfs(Node root) {
            if (root == null)
                return;

            // Stack to hold nodes for DFS
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            // Loop until the stack is empty
            while (!stack.isEmpty()) {
                Node temp = stack.pop(); // Get the current node from the stack
                System.out.print(temp.data + " ");

                // Push right child first, so that left child is processed first
                if (temp.right != null)
                    stack.push(temp.right);

                // Push left child next
                if (temp.left != null)
                    stack.push(temp.left);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create the binary tree
        BinaryTree t = new BinaryTree();

        // Create the nodes
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);

        // Perform DFS traversal
        System.out.println("Depth First Traversal of tree is:");
        t.dfs(t.root);
    }
}
