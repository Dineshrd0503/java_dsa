package bst;
import java.util.*;
public class SearchBst {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int values[]={4,8,1,34,6,71};
        BuildBst.Node root=null;
        for(int i=0;i<values.length;i++){
            root=BuildBst.buildbst(root,values[i]);
        }
        System.out.println("binaryt tree is ");
        BuildBst.inorder(root);
        System.out.println("enter a elemet to search int he tree");
        int key=sc.nextInt();
        System.out.println(searchvalue(root,key)?"element found":"element not found");


    }
    public static boolean searchvalue(BuildBst.Node root, int key){
        if(root==null){
            return false;

        }

       if(root.data>key)
            return searchvalue(root.left,key);
        else if(root.data<key)
            return searchvalue(root.right,key);
        else
            return true;
    }
}
