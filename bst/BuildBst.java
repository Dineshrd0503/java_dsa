package bst;
public class BuildBst {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static Node buildbst(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(root.data>val){
            root.left=buildbst(root.left,val);
        }
        else if(root.data<val){
            root.right=buildbst(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static void main(String[] args) {
        int values[]={9,3,5,1,7,4};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=buildbst(root,values[i]);
        }
        System.out.println("Inorder traversal of constructed BST is: ");
        inorder(root);  // Output: 1 3 4 5 7 9
        System.out.println();
    }
}
