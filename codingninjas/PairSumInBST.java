package codingninjas;

import java.util.HashSet;

//Problem statement
//You are given a Binary Search Tree (BST) and a target value ‘K’. Your task is to return true if there exist two nodes in the given BST such that the sum of their values is equal to the given target ‘K’, else return false.
//
//
//
//A binary search tree (BST) is a binary tree data structure which has the following properties.
//
//        • The left subtree of a node contains only nodes with data less than the node’s data.
//
//        • The right subtree of a node contains only nodes with data greater than the node’s data.
//
//        • Both the left and right subtrees must also be binary search trees.
//
//
//Note:
//        1. All the elements of the Binary Search Tree are unique.
//
//        2. You can’t use the same node value/element of BST twice.
//
//
//For example:
//tree: 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        'K' = 13,
//
//The nodes with values 8 and 5 as shown in the above figure gives sum equal to the given target 13.
//
//Therefore, the output will be “true” i.e it is possible to find a pair in the given BST having sum equal to ‘K’.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        19
//Sample Output 1:
//        false
//Explanation for sample input 1:
//There are no two elements in the given BST such that their sum equals the given target ‘K’ = 19.
//Sample Input 2 :
//        20 16 -1 12 -1 8 -1 4 -1 -1 -1
//        12
//Sample Output 2:
//        true
//Constraints:
//        1 <= 'N' <= 10^5
//        1 <= DATA <= 10^6
//        1 <= 'K' <= 10^6
//
//Where ‘DATA’ denotes the value of each node in the given tree and ‘N’ denotes the number of nodes in BST.
//
//Time limit: 1 sec

public class PairSumInBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
    public static boolean pairSumBst(TreeNode root, int k) {
        // Write your code here.
        HashSet<Integer> set=new HashSet<>();
        return findsum(root,k,set);
    }
    private static boolean findsum(TreeNode node,int k,HashSet<Integer> set){
        if(node==null)
            return false;
        int complement=k-node.data;
        if(set.contains(complement))
            return true;
        set.add(node.data);
        return findsum(node.left,k,set)||findsum(node.right,k,set);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(15);
        root.left=new TreeNode(10);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(8);
        root.left.right=new TreeNode(12);
        root.right.left=new TreeNode(16);
        root.right.right=new TreeNode(25);
        int k=33;
        System.out.println(pairSumBst(root,k));
    }
}
