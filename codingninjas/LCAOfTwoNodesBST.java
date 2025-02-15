package codingninjas;

public class LCAOfTwoNodesBST {
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        // Write your code here.
        while(root!=null){
            if(root.data>p.data&&root.data>q.data)
                root=root.left;
            else if(root.data<p.data&&root.data<q.data)
                root=root.right;
            else
                return root;
        }
        return null;
    }
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(4);
        TreeNode res=LCAinaBST(root,n1,n2);
        System.out.println(res.data);
    }
}
