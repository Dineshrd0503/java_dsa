package codingninjas;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOfANode
{
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
