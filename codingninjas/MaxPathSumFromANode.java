package codingninjas;


//Problem statement
//You are given a binary tree with ‘N’ nodes.
//
//Your task is to find the “Maximum Path Sum” for any path.
//
//Note :
//
//        1. A ‘path’ is a sequence of adjacent pair nodes with an edge between them in the binary tree.
//        2. The ‘path’ doesn’t need to pass through the root.
//3. The ‘path sum’ is the sum of the node’s data in that path.
//        Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        1
//        -4 -2 3 -1 -1 1 1 -1 -1 -1 -1
//Sample Output 1 :
//        5
//Explanation For Sample Input 1 :
//The tree will be
//
//The path marked in yellow is the maximum sum path.
//Sample Input 2 :
//        1
//        -2 2 1 -1 -1 -1 -1
//Sample Output 2 :
//        2
//Explanation For Sample Input 2 :
//The tree will be:
//
//The maximum sum path will only contain one node and marked in yellow.


public class MaxPathSumFromANode {
    static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
        }
    }

    public static int maxPathSum(TreeNode<Integer> root) {
        // Write your code here.
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        findpathsum(root,max);
        return max[0];
    }
    private static int findpathsum(TreeNode<Integer> root,int[] max){
        if(root==null)
            return 0;
        int left=Math.max(0,findpathsum(root.left,max));
        int right=Math.max(0,findpathsum(root.right,max));
        max[0]=Math.max(max[0],root.val+left+right);
        return root.val+Math.max(left,right);
    }
    public static void main(String[] args) {
        // Create a sample tree
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        // Calculate and print the maximum path sum from a node
        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum path sum from a node: " + maxPathSum);
    }
}
