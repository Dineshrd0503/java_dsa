package trees;

import java.util.HashSet;

//Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target.
//
//Examples:
//
//Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
//bst
//Output: True
//Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
//Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
//bst-3
//Output: False
//Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
//Constraints:
//
//        1 ≤ Number of Nodes ≤ 105
//        1 ≤ target ≤ 106


public class PairSumInBST {
    boolean findTarget(Node root, int target) {
        // Write your code here
        HashSet<Integer> set=new HashSet<>();
        return findsum(root,target,set);
    }
    private static boolean findsum(Node node,int target,HashSet<Integer> set){
        if(node==null)
            return false;
        int complement=target-node.data;
        if(set.contains(complement))
            return true;
        set.add(node.data);
        return findsum(node.left,target,set)||findsum(node.right,target,set);
    }
    public static void main(String[] args) {
        PairSumInBST obj=new PairSumInBST();
        Node root=new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.right.right=new Node(7);
        System.out.println(obj.findTarget(root,9));
    }
}
