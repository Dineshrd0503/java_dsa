package trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
        }
        public static List<Integer> postorder(Node root, int data){
            List<Integer> result=new ArrayList<>();
            getpostorder(root,result);
            return result;
        }
        public static void getpostorder(Node node, List<Integer> result){
            if(node == null) return;
            getpostorder(node.left, result);
            getpostorder(node.right, result);
            result.add(node.data);
        }
    }
    public static void main(String[] args) {
        System.out.println("Building binary tree");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> postOrder = Node.postorder(root, 0);
        System.out.println("Postorder traversal: " + postOrder);
    }
}
