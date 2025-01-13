package trees;

public class SumOfNodes {
    private static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.right=this.left=null;
        }

    }
    private static class BinaryTree{
        Node root;
        private static int sumofnodes(Node node){
            if(node==null)
                return 0;
            return node.data+sumofnodes(node.left)+sumofnodes(node.right);
        }
    }
    public static void main(String[] args) {
        BinaryTree t=new BinaryTree();
        t.root=new Node(1);
        t.root.left=new Node(2);
        t.root.right=new Node(3);
        t.root.left.left=new Node(4);
        t.root.left.right=new Node(5);
        System.out.println("Sum of all nodes in the binary tree: "+BinaryTree.sumofnodes(t.root));


    }
}
