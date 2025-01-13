package trees;

class Node{
    int data;
    Node left,right;
    Node(int item){
        data=item;
        left=right=null;
    }  // Constructor
}
class BinaryTree{
    Node root;
    public void preorder(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
    public void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.println(node.data+" ");
        inorder(node.right);
    }
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);     // Traverse the left subtree
        postorder(node.right);    // Traverse the right subtree
        System.out.print(node.data + " "); // Visit the root
    }
}
public class BinaryTree1{
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        tree.root=new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Preorder traversal:");
        tree.preorder(tree.root);  // Output: 1 2 4 5 3
        System.out.println();
        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);   // Output: 4 2 5 1 3
        System.out.println();
        System.out.println("Postorder traversal:");
        tree.postorder(tree.root); // Output: 4 5 2 3 1
        System.out.println();
    }
}