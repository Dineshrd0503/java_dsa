package codingninjas;

public class MirrorOfATree {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        if(root==null)
            return;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        BinaryTreeNode temp;
        temp=root.left;
        root.left=root.right;
        root.right=temp;

    }
   public static void main(String[] args) {
        System.out.println("Mirror of a tree");
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        mirrorBinaryTree(root);

        System.out.println(root.data);
        if (root.left != null) {
            System.out.println(root.left.data);
            if (root.left.left != null) {
                System.out.println(root.left.left.data);
            }
            if (root.left.right != null) {
                System.out.println(root.left.right.data);
            }
        }
        if (root.right != null) {
            System.out.println(root.right.data);
        }
    }
}
