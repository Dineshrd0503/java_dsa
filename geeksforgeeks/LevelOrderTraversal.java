package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.
//
//Examples:
//
//Input: root[] = [1, 2, 3]
//
//Output: [[1], [2, 3]]
//Input: root[] = [10, 20, 30, 40, 50]
//
//Output: [[10], [20, 30], [40, 50]]
//Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]
//
//Output: [[1], [3, 2], [4], [6, 5]]
//Constraints:
//
//        1 ≤ number of nodes ≤ 105
//        0 ≤ node->data ≤ 109

public class LevelOrderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    public ArrayList<ArrayList<Integer>> levelOrder(Node root1) {
        // Your code here
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(root1==null)
            return result;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root1);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> row=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                row.add(node.data);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

            }
            result.add(row);
        }
        return result;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        LevelOrderTraversal obj=new LevelOrderTraversal();
        ArrayList<ArrayList<Integer>> result=obj.levelOrder(root);
        for(ArrayList<Integer> row:result)
            System.out.println(row);
    }

}
