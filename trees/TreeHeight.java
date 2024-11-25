package trees;

public class TreeHeight {
    public static int getHeight(Node root){
        if(root==null)
            return -1; // return -1 for null nodes
        int lheight=getHeight(root.left);
        int rheight=getHeight(root.right);
        return Math.max(lheight,rheight)+1;
    }

    public static void main(String[] args) {
        // Create a sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Calculate and print the height of the tree
        int height = getHeight(root);
        System.out.println("Height of the tree: " + height);
    }
}
