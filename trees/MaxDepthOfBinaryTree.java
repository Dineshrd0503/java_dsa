package trees;


//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
//Example 2:
//
//Input: root = [1,null,2]
//Output: 2
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//        -100 <= Node.val <= 100


public class MaxDepthOfBinaryTree {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static int maxDepth(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
        root.left=new BinaryTreeNode<>(2);
        root.right=new BinaryTreeNode<>(3);
        root.left.left=new BinaryTreeNode<>(4);
        root.left.right=new BinaryTreeNode<>(5);
        root.right.left=new BinaryTreeNode<>(6);
        root.right.right=new BinaryTreeNode<>(7);
        System.out.println(maxDepth(root));
    }
}
