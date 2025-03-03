package codingninjas;

//Problem statement
//You have been given a Binary Tree of integers, find the minimum depth of this Binary Tree. The minimum depth of a Binary Tree is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note:
//A leaf is a node with no children.
//For example:
//For the given binary tree
//
//Output: 2
//The shortest path is from root node 1 to leaf node 2 which contains 2 nodes in the path. Hence, the minimum depth is 2.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10^2
//        0 <= N <= 10^3
//
//Time Limit: 1 sec
//Sample Input 1:
//        3
//        1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
//        1 2 3 -1 -1 -1 -1
//        1 2 -1 3 -1 -1 -1
//Sample Output 1:
//        3
//        2
//        3
//Explanation For Sample Input 1:
//For the first test case, the given tree is
//
//There are two shortest paths from the root to the leaf node i.e. {1 -> 3 -> 5} and {1 -> 3 -> 6}. Both paths contain 3 nodes, hence the minimum depth of this binary tree is 3.
//Sample Input 2:
//        1
//        1 2 -1 3 -1 -1 -1
//Sample Output 2:
//        3

public class MinDepthOfBinaryTree {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static int minDepth(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left==null)
            return 1+minDepth(root.right);
        if(root.right==null)
            return 1+minDepth(root.left);
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
        root.left=new BinaryTreeNode<>(2);
        root.right=new BinaryTreeNode<>(3);
        root.left.left=new BinaryTreeNode<>(4);
        root.left.right=new BinaryTreeNode<>(5);
        root.right.left=new BinaryTreeNode<>(6);
        root.right.right=new BinaryTreeNode<>(7);
        System.out.println(minDepth(root));
    }
}
