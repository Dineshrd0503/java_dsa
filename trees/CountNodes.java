package trees;

public class CountNodes {
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
        public static int countnodes(Node node){
            if(node==null)
                return 0;
            return 1+countnodes(node.left)+countnodes(node.right);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Manually construct the tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Call countNodes and print the result
        System.out.println("Number of nodes: " + tree.countnodes(tree.root));


    }
}
