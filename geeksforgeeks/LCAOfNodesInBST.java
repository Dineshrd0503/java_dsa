package geeksforgeeks;

//Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.
//
//LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
//
//Examples:
//
//Input: root = [5, 4, 6, 3, N, N, 7, N, N, N, 8], n1 = 7, n2 = 8
//
//Output: 7
//Explanation: 7 is the closest node to both 7 and 8, which is also an ancestor of both the nodes.
//        Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], n1 = 8, n2 = 14
//
//Output: 8
//Explanation: 8 is the closest node to both 8 and 14, which is also an ancestor of both the nodes.
//        Input: root = [2, 1, 3], n1 = 1, n2 = 3
//
//Output: 2
//Explanation: 2 is the closest node to both 1 and 3, which is also an ancestor of both the nodes.
//        Constraints:
//        1 <= number of nodes <= 105
//        1 <= node->data <= 105
//        1 <= n1, n2 <= 10

public class LCAOfNodesInBST {
    Node LCA(Node root, Node n1, Node n2) {
        // your code here.

        while(root!=null){
            if(root.data>n1.data&&root.data>n2.data)
                root=root.left;
            else if(root.data<n1.data&&root.data<n2.data)
                root=root.right;
            else
                return root;
        }
        return null;
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        LCAOfNodesInBST obj=new LCAOfNodesInBST();
        Node root=new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.right.right=new Node(7);
        Node n1=new Node(2);
        Node n2=new Node(4);
        Node res=obj.LCA(root,n1,n2);
        System.out.println(res.data);
    }
}
