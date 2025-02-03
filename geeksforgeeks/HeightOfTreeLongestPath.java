package geeksforgeeks;

//Given a binary tree, find its height.
//
//The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.
//
//Examples:
//
//Input: root[] = [12, 8, 18, 5, 11]
//
//Output: 2
//Explanation: One of the longest path from the root (node 12) goes through node 8 to node 5, which has 2 edges.
//        Input: root[] = [1, 2, 3, 4, N, N, 5, N, N, 6, 7]
//
//Output: 3
//Explanation: The longest path from the root (node 1) to a leaf node 6 with 3 edge.
//        Constraints:
//        1 <= number of nodes <= 105
//        0 <= node->data <= 105

public class HeightOfTreeLongestPath {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    int height(Node node) {
        // code here
        if(node==null)
            return -1;

        int lh=height(node.left);
        int rh=height(node.right);
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.right.left=new Node(6);
        root.left.right.right=new Node(7);
        HeightOfTreeLongestPath obj=new HeightOfTreeLongestPath();
        System.out.println(obj.height(root)); // Output: 3
    }

}
