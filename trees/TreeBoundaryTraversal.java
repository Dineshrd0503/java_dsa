package trees;

import java.util.ArrayList;
import java.util.Stack;

//Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
//
//Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.
//
//Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.
//
//Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.
//
//Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.
//
//Examples:
//
//Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
//Output: [1, 2, 4, 8, 9, 6, 7, 3]
//Explanation:
//
//Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
//Output: [1, 2, 4, 6, 5, 7, 8]
//Explanation:
//
//
//
//
//
//
//
//
//
//
//
//
//As the root doesn't have a right subtree, the right boundary is not included in the traversal.
//Input: root[] = [1, N, 2, N, 3, N, 4, N, N]
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//
//Output: [1, 4, 3, 2]
//Explanation:
//Left boundary: [1] (as there is no left subtree)
//Leaf nodes: [4]
//Right boundary: [3, 2] (in reverse order)
//Final traversal: [1, 4, 3, 2]
//Constraints:
//        1 ≤ number of nodes ≤ 105
//        1 ≤ node->data ≤ 105





public class TreeBoundaryTraversal {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> result=new ArrayList();
        if(root==null) return result;
        if(!isleaf(root)) result.add(root.data);
        traverseleft(root.left,result);
        traverseleaf(root,result);
        traverseright(root.right,result);
        return result;
    }
    private static boolean isleaf(Node node){
        return node.left==null&&node.right==null;
    }
    private static void traverseleft(Node node,ArrayList<Integer> result){
        while(node!=null&&!isleaf(node)){
            result.add(node.data);
            node=(node.left!=null)?node.left:node.right;
        }

    }
    private static void traverseleaf(Node node,ArrayList<Integer> result){
        if(node==null)
            return;
        if(isleaf(node)){
            result.add(node.data);
            return;
        }
        traverseleaf(node.left,result);
        traverseleaf(node.right,result);
    }
    private static void traverseright(Node node,ArrayList<Integer> result){
        Stack<Integer> stack=new Stack<>();
        while(node!=null){
            if(!isleaf(node))
                stack.push(node.data);
            node=(node.right!=null)?node.right:node.left;
        }
        while(!stack.isEmpty())
            result.add(stack.pop());
    }
    public static void main(String[] args) {
        // Create a sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Calculate and print the boundary traversal of the tree
        TreeBoundaryTraversal treeBoundaryTraversal = new TreeBoundaryTraversal();
        ArrayList<Integer> result = treeBoundaryTraversal.boundaryTraversal(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
