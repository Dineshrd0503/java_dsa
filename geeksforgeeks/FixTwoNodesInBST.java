package geeksforgeeks;

//Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
//Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).
//
//Examples :
//Input: root = [10, 5, 8, 2, 20]
//
//Output: 1
//
//
//Explanation: The nodes 20 and 8 were swapped.
//Input: root = [5, 10, 20, 2, 8]
//
//Output: 1
//
//Explanation: The nodes 10 and 5 were swapped.
//Constraints:
//        1 ≤ Number of nodes ≤ 103

public class FixTwoNodesInBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    Node first,last,prev,middle=null;
    void correctBST(Node root) {
        // code here.
        inorder(root);
        if(first!=null&&last!=null)
            swap(first,last);
        else if(first!=null&&middle!=null)
            swap(first,middle);
    }
    private void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null&&root.data<prev.data){
            if(first==null){
                first=prev;
                middle=root;
            }
            else
                last=root;
        }
        prev=root;
        inorder(root.right);
    }
    private void swap(Node a,Node b){
        int temp=a.data;
        a.data=b.data;
        b.data=temp;
    }
    private void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        FixTwoNodesInBST obj=new FixTwoNodesInBST();
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(8);
        root.left.left=new Node(2);
        root.right.right=new Node(20);
        System.out.println("Inorder Traversal of the original tree");
        obj.printInorder(root);
        obj.correctBST(root);
        System.out.println("\nInorder Traversal of the corrected tree");
        obj.printInorder(root);
    }
}
