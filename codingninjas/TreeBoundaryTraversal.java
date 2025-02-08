package codingninjas;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Problem statement
//You are given a binary tree having 'n' nodes.
//
//
//
//The boundary nodes of a binary tree include the nodes from the left and right boundaries and the leaf nodes, each node considered once.
//
//
//
//Figure out the boundary nodes of this binary tree in an Anti-Clockwise direction starting from the root node.
//
//
//
//        Example :
//Input: Consider the binary tree A as shown in the figure:
//
//Output: [10, 5, 3, 7, 18, 25, 20]
//
//Explanation: As shown in the figure
//
//The nodes on the left boundary are [10, 5, 3]
//
//The nodes on the right boundary are [10, 20, 25]
//
//The leaf nodes are [3, 7, 18, 25].
//
//Please note that nodes 3 and 25 appear in two places but are considered once.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        10 5 20 3 8 18 25 -1 -1 7 -1 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//        10 5 3 7 18 25 20
//Explanation of Sample Input 1:
//The nodes on the left boundary are [10, 5, 3]
//
//The nodes on the right boundary are [10, 20, 25]
//
//The leaf nodes are [3, 7, 18, 25].
//
//Please note that nodes 3 and 25 appear in two places but are considered once.
//Sample Input 2:
//        100 50 150 25 75 140 200 -1 30 70 80 -1 -1 -1 -1 -1 35 -1 -1 -1 -1 -1 -1
//Sample Output 2:
//        100 50 25 30 35 70 80 140 200 150
//Constraints:
//        1 <= n <= 10000
//
//Where 'n' is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec




public class TreeBoundaryTraversal {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        // code here
        List<Integer> result=new ArrayList();
        if(root==null) return result;
        if(!isleaf(root)) result.add(root.data);
        traverseleft(root.left,result);
        traverseleaf(root,result);
        traverseright(root.right,result);
        return result;
    }
    private static boolean isleaf(TreeNode node){
        return node.left==null&&node.right==null;
    }
    private static void traverseleft(TreeNode node,List<Integer> result){
        while(node!=null&&!isleaf(node)){
            result.add(node.data);
            node=(node.left!=null)?node.left:node.right;
        }

    }
    private static void traverseleaf(TreeNode node,List<Integer> result){
        if(node==null)
            return;
        if(isleaf(node)){
            result.add(node.data);
            return;
        }
        traverseleaf(node.left,result);
        traverseleaf(node.right,result);
    }
    private static void traverseright(TreeNode node, List<Integer> result){
        Stack<Integer> stack=new Stack<>();
        while(node!=null){
            if(!isleaf(node))
                stack.push(node.data);
            node=(node.right!=null)?node.right:node.left;
        }
        while(!stack.isEmpty())
            result.add(stack.pop());
    }


    public static void main(String[] args) {
        System.out.println("Tree Boundary Traversal");
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.right.right.left=new TreeNode(8);
        root.right.right.right=new TreeNode(9);
        List<Integer> result=traverseBoundary(root);
        for(int i:result)
            System.out.print(i+" ");
    }
}
