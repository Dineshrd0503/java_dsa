package geeksforgeeks;

//Given the root of a binary tree, invert the tree, and return its root.
//
//
//
//Example 1:
//
//
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//Example 2:
//
//
//Input: root = [2,1,3]
//Output: [2,3,1]
//Example 3:
//
//Input: root = []
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100


public class MirrorOfATree {
    void mirror(Node node) {
        // Your code here
        if(node==null)
            return;
        mirror(node.left);
        mirror(node.right);
        Node temp;
        temp=node.left;
        node.left=node.right;
        node.right=temp;
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
        System.out.println("mirror of a tree");
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        MirrorOfATree mirrorOfATree=new MirrorOfATree();
        mirrorOfATree.mirror(root);
    }
}
