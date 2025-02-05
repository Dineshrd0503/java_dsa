package trees;

//Given the root of a binary tree, invert the tree, and return its root.
//
//
//
//Example 1:
//
//
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//Example 2:
//
//
//Input: root = [2,1,3]
//Output: [2,3,1]
//Example 3:
//
//Input: root = []
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100



public class MirrorTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;

    }
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
        System.out.println("mirror of a tree");
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        MirrorTree mirrorOfATree=new MirrorTree();
        mirrorOfATree.invertTree(root);
    }
}
