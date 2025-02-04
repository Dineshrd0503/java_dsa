package geeksforgeeks;

//Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.
//
//Examples:
//
//Input: root[] = [1, 2, 3]
//
//Output: 2
//Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).
//
//Input: root[] = [5, 8, 6, 3, 7, 9]
//
//Output: 4
//Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).
//
//Constraints:
//        1 ≤ number of nodes ≤ 105
//        0 ≤ node->data ≤ 105





public class DiameterOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static int diameter(Node root) {
        // Your code here

        int[] max=new int[1];
        calculate(root,max);
        return max[0];



    }
    private static int calculate(Node root,int[] max){
        if(root==null)
            return 0;
        int lh=calculate(root.left,max);
        int rh=calculate(root.right,max);
        max[0]=Math.max(max[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        DiameterOfBinaryTree obj=new DiameterOfBinaryTree();
        System.out.println(obj.diameter(root)); // Output: 3
    }
}
