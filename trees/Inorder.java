package trees;
import java.util.*;
public class Inorder {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
        public static List<Integer> inorder(Node root,int val){
            List<Integer> result = new ArrayList<>();
            getinorder(root,result);
            return result;
        }
        public static void getinorder(Node node, List<Integer> result){
            if(node == null) return;
            getinorder(node.left, result);
            result.add(node.data);
            getinorder(node.right, result);
        }

    }
    public static void main(String[] args) {
        System.out.println("inderting data into binary tree");
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        List<Integer> inorderList = Inorder.Node.inorder(root, 0);
        System.out.println("Inorder traversal of the tree is: " + inorderList);
    }
}
