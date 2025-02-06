package trees;

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

public class ConstructTreeFromInorderPreorder {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return constructree(inorder,preorder,0,inorder.length-1,0,map);
    }
    public static Node constructree(int inorder[],int preorder[],int instart,int inend,int preindex,Map<Integer,Integer> map){
        if(instart>inend)
            return null;
        Node root=new Node(preorder[preindex]);
        int inindex=map.get(preorder[preindex]);
        root.left=constructree(inorder,preorder,instart,inindex-1,preindex+1,map);
        root.right=constructree(inorder,preorder,inindex+1,inend,preindex+(inindex-instart+1),map);
        return root;
    }
    public static void printInorder(Node root){
        if(root==null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        // Create a sample tree
        int inorder[] = {4,2,5,1,6,3};
        int preorder[] = {1,2,4,5,3,6};
        Node root = buildTree(inorder,preorder);
        System.out.println("Inorder traversal of the constructed tree is ");
        printInorder(root);
    }
}
