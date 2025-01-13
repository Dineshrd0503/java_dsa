package trees;

public class SubTreeOfTree {
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    private static class BinaryTree {
        Node root;
        private static boolean subtree(Node t1, Node t2) {
            if(t2==null) return true;
            if(t1==null) return false;
            if(identical(t1,t2))
            return true;
            return subtree(t1.left,t2) || subtree(t1.right,t2);

        }
        private static boolean identical(Node t1, Node t2) {
            if(t1==null&&t2==null) return true;
            if(t1==null||t2==null) return false;
            return (t1.data == t2.data &&
                    identical(t1.left, t2.left) &&
                    identical(t1.right, t2.right));

        }
    }
    public static void main(String[] args) {
        BinaryTree T1 = new BinaryTree();
        T1.root = new Node(1);
        T1.root.left = new Node(2);
        T1.root.right = new Node(3);
        T1.root.left.left = new Node(4);
        T1.root.left.right = new Node(5);
        T1.root.right.right = new Node(6);

        // Create tree `T2`
        BinaryTree T2 = new BinaryTree();
        T2.root = new Node(2);
        T2.root.left = new Node(4);
        T2.root.right = new Node(5);
        if (BinaryTree.subtree(T1.root, T2.root)) {
            System.out.println("T2 is a subtree of T1");
        } else {
            System.out.println("T2 is NOT a subtree of T1");
        }

    }
}
