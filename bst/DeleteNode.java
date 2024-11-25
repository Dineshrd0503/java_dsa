package bst;
import bst.BuildBst;
public class DeleteNode {
    public static void main(String[] args) {
        BuildBst.Node root=null;
        int values[]={3,5,1,7,9,12,11};
        for(int i=0;i<values.length;i++){
            root=BuildBst.buildbst(root,values[i]);
        }
        System.out.println("inorder traversal of tree is");
        BuildBst.inorder(root);
        System.out.println("Enter the node to delete");
        int key=3;



    }
}
