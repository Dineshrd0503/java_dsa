package codingninjas;

import java.util.HashMap;
import java.util.Map;

//Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.
//
//        Note: The output is written in postorder traversal.
//
//        Examples:
//
//Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
//Output: [8, 7, 6, 1]
//Explanation: The tree will look like
//
//Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
//Output: [3, 4, 1, 5, 2, 0]
//Explanation: The tree will look like
//
//Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
//Output: [2, 5, 4, 3, 1]
//Explanation: The tree will look like
//
//Constraints:
//        1 ≤ number of nodes ≤ 103
//        0 ≤ nodes -> data ≤ 103

public class ConstructTreeFromInorderAndPreorder {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        // Write your code here.
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return constructree(inorder,preorder,0,inorder.length-1,0,map);
    }
    private static TreeNode constructree(int[] inorder,int[] preorder,int instart,int inend,int preindex,Map<Integer,Integer> map){
        if(instart>inend)
            return null;
        TreeNode root=new TreeNode(preorder[preindex]);
        int inindex=map.get(preorder[preindex]);
        root.left=constructree(inorder,preorder,instart,inindex-1,preindex+1,map);
        root.right=constructree(inorder,preorder,inindex+1,inend,preindex+(inindex-instart+1),map);
        return root;
    }
    public static void main(String[] args) {
        System.out.println("Construct tree from inorder and preorder");
        int[] inorder={4,2,5,1,6,3,7};
        int[] preorder={1,2,4,5,3,6,7};
        TreeNode root=buildBinaryTree(inorder,preorder);
        System.out.println(root.data);
        if(root.left!=null){
            System.out.println(root.left.data);
            if(root.left.left!=null){
                System.out.println(root.left.left.data);
            }
            if(root.left.right!=null){
                System.out.println(root.left.right.data);
            }
        }
        if(root.right!=null){
            System.out.println(root.right.data);
        }
    }

}
