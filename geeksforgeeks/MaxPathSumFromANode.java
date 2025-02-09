package geeksforgeeks;

//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//
//The path sum of a path is the sum of the node's values in the path.
//
//Given the root of a binary tree, return the maximum path sum of any non-empty path.
//
//
//
//Example 1:
//
//
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//Example 2:
//
//
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 3 * 104].
//        -1000 <= Node.val <= 1000


public class MaxPathSumFromANode {
    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        findpathsum(root,max);
        return max[0];

    }
    private static int findpathsum(TreeNode node,int[] max){
        if(node==null)
            return 0;
        int left=Math.max(0,findpathsum(node.left,max));
        int right=Math.max(0,findpathsum(node.right,max));
        max[0]=Math.max(node.val+left+right,max[0]);
        return node.val+Math.max(left,right);    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        MaxPathSumFromANode obj=new MaxPathSumFromANode();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println("Maximum path sum is : "+obj.maxPathSum(root));
    }
}
