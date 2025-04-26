package trees;

public class IsBinaryTreeHeap {

            // Static Node class
            static class Node {
                int data;
                Node left, right;

                Node(int d) {
                    data = d;
                    left = right = null;
                }
            }

            public static void main(String[] args) {
                // Problem Statement:
                // You are given a binary tree, and the task is to determine whether it satisfies the properties of a max-heap.
                // A binary tree is considered a max-heap if it satisfies the following conditions:
                // 1. Completeness: Every level of the tree, except possibly the last, is completely filled, and
                //    all nodes are as far left as possible.
                // 2. Max-Heap Property: The value of each node is greater than or equal to the values of its children.

                // Test Cases
                // Example 1
                Node root1 = new Node(97);
                root1.left = new Node(46);
                root1.right = new Node(37);
                root1.left.left = new Node(12);
                root1.left.right = new Node(3);
                root1.right.left = new Node(7);
                root1.right.right = new Node(31);
                root1.left.left.left = new Node(6);
                root1.left.left.right = new Node(9);

                System.out.println("Test Case 1: " + isHeap(root1)); // Expected Output: true

                // Example 2
                Node root2 = new Node(97);
                root2.left = new Node(46);
                root2.right = new Node(37);
                root2.left.left = new Node(12);
                root2.left.right = new Node(3);
                root2.right.left = new Node(7);
                root2.right.right = new Node(31);
                root2.left.left.left = new Node(2); // Example of improper child
                root2.left.left.right = new Node(4);

                System.out.println("Test Case 2: " + isHeap(root2)); // Expected Output: false
            }

            // Function to check if the binary tree is a heap
            public static boolean isHeap(Node root) {
                int nodeCount = countNodes(root);
                return isCompleteBinaryTree(root, 0, nodeCount) && isMaxHeap(root);
            }

            // Count the total number of nodes in the tree
            public static int countNodes(Node node) {
                if (node == null) return 0;
                return 1 + countNodes(node.left) + countNodes(node.right);
            }

            // Check if the binary tree is complete
            public static boolean isCompleteBinaryTree(Node node, int index, int totalNodes) {
                if (node == null) return true;
                if (index >= totalNodes) return false;

                return isCompleteBinaryTree(node.left, 2 * index + 1, totalNodes) &&
                        isCompleteBinaryTree(node.right, 2 * index + 2, totalNodes);
            }

            // Check if the binary tree satisfies the max-heap property
            public static boolean isMaxHeap(Node node) {
                if (node == null) return true;

                if (node.left != null) {
                    if (node.data < node.left.data) return false;
                    if (!isMaxHeap(node.left)) return false;
                }

                if (node.right != null) {
                    if (node.data < node.right.data) return false;
                    if (!isMaxHeap(node.right)) return false;
                }

                return true;
            }
        }