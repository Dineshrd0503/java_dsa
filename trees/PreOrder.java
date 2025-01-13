package trees;

import java.util.*;

public class PreOrder {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
        public static List<Integer> preOrder(Node root) {
            List<Integer> result=new ArrayList<Integer>();
            getpreorder(root,result);
            return result;
        }
        public static void getpreorder(Node node, List<Integer> result){
            if(node==null) return;
            result.add(node.data);
            getpreorder(node.left,result);
            getpreorder(node.right,result);
        }
    }
    public static void main(String[] args) {
        System.out.println("building binary tree");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> preOrder = Node.preOrder(root);
        System.out.println("Preorder traversal: " + preOrder);
    }
}
