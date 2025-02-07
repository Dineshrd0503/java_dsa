package codingninjas;
import java.util.ArrayList;
import java.util.List;

//Problem statement
//You have been given a Binary Tree of 'n' nodes, where the nodes have integer values. Your task is to return the In-Order traversal of the given binary tree.

//
//
//For example :
//For the given binary tree:
//
//The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        1 2 3 -1 -1 -1  6 -1 -1
//Sample Output 1 :
//        2 1 3 6
//Explanation of Sample Output 1 :
//The given binary tree is shown below:
//
//Inorder traversal of given tree = [2, 1, 3, 6]
//Sample Input 2 :
//        1 2 4 5 3 -1 -1 -1 -1 -1 -1
//Sample Output 2 :
//        5 2 3 1 4
//Explanation of Sample Output 2 :
//The given binary tree is shown below:
//
//Inorder traversal of given tree = [5, 2, 3, 1, 4]
//Expected time complexity:
//The expected time complexity is O(n).
//Constraints :
//        1 <= 'n' <= 10^5
//        0 <= 'data' <= 10^5
//
//where 'n' is the number of nodes and 'data' denotes the node value of the binary tree nodes.
//
//Time limit: 1 sec



public class InorderTraversal {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        list.addAll(getInOrderTraversal(root.left));
        list.add(root.data);
        list.addAll(getInOrderTraversal(root.right));
        return list;


    }
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        List<Integer> res=getInOrderTraversal(root);
        for(int i:res)
            System.out.print(i+" ");
    }
}
