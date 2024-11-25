package trees;

public class HeightOfTree {
    private static class Node{
        int data;
        Node left, right;
        Node(int item){
            data=item;
            left=right=null;
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

    }

    public static void main(String[] args) {
        BinaryTree t=new BinaryTree();
        t.root=new Node(1);
        t.root.left=new Node(2);
        t.root.right=new Node(3);
        t.root.left.left=new Node(4);
        t.root.left.right=new Node(5);
        t.root.right.left=new Node(6);
        t.root.right.left=new Node(7);
       t.root.left.left.left=new Node(8);
        System.out.println("height of tree is "+t.height(t.root));

    }
}
