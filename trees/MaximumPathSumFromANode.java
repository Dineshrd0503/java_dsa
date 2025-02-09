package trees;

//Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
//
//Examples:
//
//Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
//Output: 42
//Explanation:
//
//Max path sum is represented using green colour nodes in the above binary tree.
//Input: root[] = [-17, 11, 4, 20, -2, 10]
//Output: 31
//Explanation:
//
//Max path sum is represented using green colour nodes in the above binary tree.
//Constraints:
//        1 ≤ number of nodes ≤ 103
//        -104 ≤ node->data ≤ 104





public class MaximumPathSumFromANode {
    int findMaxSum(Node node) {
        // your code goes here
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        findpathsum(node,max);
        return max[0];
    }
    private  int findpathsum(Node node,int[] max){
        if(node==null)
            return 0;
        int left=Math.max(0,findpathsum(node.left,max));
        int right=Math.max(0,findpathsum(node.right,max));
        max[0]=Math.max(max[0],node.data+left+right);
        return node.data+Math.max(left,right);
    }

    public static void main(String[] args) {
        MaximumPathSumFromANode obj=new MaximumPathSumFromANode();
        Node root=new Node(10);
        root.left=new Node(2);
        root.right=new Node(10);
        root.left.left=new Node(20);
        root.left.right=new Node(1);
        root.right.right=new Node(-25);
        root.right.right.left=new Node(3);
        root.right.right.right=new Node(4);
        System.out.println(obj.findMaxSum(root));
    }

}
