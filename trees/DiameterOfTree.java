package trees;

public class DiameterOfTree {
    private static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }

    }
    private static class BinaryTree{
        Node root;
        private static int height(Node node){
            if(node==null)
                return 0;
            int lheight=height(node.left);
            int rheight=height(node.right);
            return Math.max(lheight,rheight)+1;  // returns larger of two heights + 1
        }
        private static int diameter(Node node){
            if(node==null)
                return 0;
            int diam1=diameter(node.left);
            int diam2=diameter(node.right);
            int diam3=1+height(node.left)+height(node.right);
            return Math.max(diam3,Math.max(diam2,diam1));


        }
        private static class Height{
            int h;
        }
        private static int newdiameter(Node node,Height height){
            if(node==null) {
                height.h = 0;
                return 0;
            }
            Height lh=new Height();
            Height rh=new Height();
            int ldiameter=newdiameter(node.left,lh);
            int rdiameter=newdiameter(node.right,rh);
            height.h=Math.max(lh.h,rh.h)+1;
            int diameter=lh.h+rh.h+1;
            return Math.max(Math.max(ldiameter,rdiameter),diameter);  // returns larger of two heights + 1


        }

    }
    public static void main(String[] args) {
        BinaryTree t=new BinaryTree();
        t.root=new Node(1);
        t.root.left=new Node(2);
        t.root.right=new Node(3);
        t.root.left.left=new Node(4);
        t.root.left.right=new Node(5);
        System.out.println("Diameter of the tree is using n^2 aproach "+t.diameter(t.root));
        BinaryTree.Height height = new BinaryTree.Height();
        System.out.println("Diameter of the tree using O(n) approach: " + t.newdiameter(t.root, height));

    }
}
