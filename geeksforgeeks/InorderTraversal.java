package geeksforgeeks;

import java.util.ArrayList;

//Given a Binary Tree, your task is to return its In-Order Traversal.
//
//An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).
//
//Follow Up: Try solving this with O(1) auxiliary space.
//
//Examples:
//
//Input: root[] = [1, 2, 3, 4, 5]
//
//Output: [4, 2, 5, 1, 3]
//Explanation: The in-order traversal of the given binary tree is [4, 2, 5, 1, 3].
//Input: root[] = [8, 1, 5, N, 7, 10, 6, N, 10, 6]
//
//Output: [1, 7, 10, 8, 6, 10, 5, 6]
//Explanation: The in-order traversal of the given binary tree is [1, 7, 10, 8, 6, 10, 5, 6].
//Constraints:
//
//        1 <= number of nodes <= 105
//        0 <= node->data <= 105


public class InorderTraversal {
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        list.addAll(inOrder(root.left));
        list.add(root.data);
        list.addAll(inOrder(root.right));
        return list;
    }
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        System.out.println("inorder traversal of a tree");
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        InorderTraversal inorderTraversal=new InorderTraversal();
        ArrayList<Integer> list=inorderTraversal.inOrder(root);
        System.out.println(list);
    }

}
