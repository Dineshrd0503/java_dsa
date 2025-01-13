package trees;
import java.util.*;
public class BfsTree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    static class BinaryTree{
        static Node root;
        public static void bfs(Node root) {
            if (root == null)
                return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node currnode = queue.poll();

                // Print the current node's data
                System.out.print(currnode.data + " ");
                if(currnode.left!=null)
                    queue.add(currnode.left);
                if(currnode.right!=null)
                    queue.add(currnode.right);

            }
        }

    }
    public static void main(String[] args) {
        BinaryTree.root = new Node(1);
        BinaryTree.root.left = new Node(2);
        BinaryTree.root.right = new Node(3);
        BinaryTree.root.left.left = new Node(4);
        BinaryTree.root.left.right = new Node(5);
        BinaryTree.bfs(BinaryTree.root);

    }
}
