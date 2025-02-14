package codingninjas;

public class FixTwoNodesInBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }
    static TreeNode first,last,prev,middle;
    public static TreeNode FixBST(TreeNode root) {
        first = last = prev = middle = null;
        inorder(root);
        if (first != null && last != null) {
            swap(first, last);
        } else if (first != null && middle != null) {
            swap(first, middle);
        }
        return root;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    private static void swap(TreeNode a, TreeNode b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(20);
        System.out.println("orginal traveral");
        printInorder(root);
        FixBST(root);
        System.out.println();
        System.out.println("After fixing BST");
        printInorder(root);



    }

}
