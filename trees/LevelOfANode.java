package trees;

import java.util.LinkedList;
import java.util.Queue;


//Problem statement
//Ninja has been given a binary tree having N nodes and an integer M, he needs to find the level of node M. He finds it difficult to solve and asks for your help.
//
//Note:
//
//Consider root to be at level 1. It is guaranteed that all the nodes in the binary tree have distinct values.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 5
//        0 <= N <= 3000
//        0 <= node data <= 10^9

//Time Limit: 1 sec
//Sample Input 1:
//        2
//        1 2 3 -1 -1 -1  6 -1 -1
//        6
//        1 2 -1 -1 -1
//        1
//Sample Output 1:
//        3
//        1
//Explanation of Sample Input 1:
//For the first test case, the given binary tree is shown below.
//        Here, we see that node 6 is at a distance of 2 units from the root(node 1). Hence, our level will be 3.
//
//For the second test case, the given binary tree is shown below.
//
//As we are looking for node 1 which is itself the root node, hence our level is 1.
//Sample Input 2:
//        1
//        1 3 8 5 -1 7 -1 -1 -1 -1 -1
//        10
//Sample Output 2:
//        0
//Explanation of Sample Input 2:
//For the first test case, the given binary tree is shown below.
//
//As node 10 is not present in the tree, so we return 0.




public class LevelOfANode {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static int nodeLevel(BinaryTreeNode<Integer> root,int node)
    {
        // Write your code here.
        int level=1;
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> curr=queue.poll();
                if(curr.data==node) return level;
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);

            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
        root.left=new BinaryTreeNode<>(2);
        root.right=new BinaryTreeNode<>(3);
        root.left.left=new BinaryTreeNode<>(4);
        root.left.right=new BinaryTreeNode<>(5);
        root.right.left=new BinaryTreeNode<>(6);
        root.right.right=new BinaryTreeNode<>(7);
        System.out.println(nodeLevel(root,5));
    }
}
