package codingninjas;

//Problem statement
//You are given a Binary Tree.
//
//
//
//Return the length of the diameter of the tree.
//
//
//
//        Note :
//The diameter of a binary tree is the length of the longest path between any two end nodes in a tree.
//
//The number of edges between two nodes represents the length of the path between them.
//        Example :
//Input: Consider the given binary tree:
//
//Output: 6
//
//Explanation:
//Nodes in the diameter are highlighted. The length of the diameter, i.e., the path length, is 6.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        1 2 3 4 7 -1 -1 -1 -1 -1 -1
//
//
//Sample Output 1 :
//        3
//
//
//Explanation of Sample Input 1 :
//The binary tree in the given test case will look like
//
//The length of the diameter of the above tree is the length of the path between nodes 4 and 3, i.e., 4->2->1->3. Hence the output will be 3.
//
//
//Sample Input 2 :
//        1 2 3 -1 -1 -1 -1
//
//
//Sample Output 2 :
//        2
//
//
//Explanation of Sample Input 2 :
//The binary tree in the given test case will look like
//
//The length of the diameter of the above tree is the length of the path between nodes 2 and 3, i.e., 2.
//
//
//Expected Time Complexity:
//Try to do this in O(n).
//
//
//Constraints:
//        1 <= n <= 10000
//
//Where 'n' is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec


public class DiameterOfBinaryTree {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        // Write your code here.
        int[] max=new int[1];
        height(root,max);
        return max[0];
    }
    private static int height(TreeNode<Integer> root,int[] max){
        if(root==null)
            return 0;
        int lh=height(root.left,max);
        int rh=height(root.right,max);
        max[0]=Math.max(max[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        // Create a sample tree
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        // Calculate and print the diameter of the tree
        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the tree: " + diameter);
    }
}
