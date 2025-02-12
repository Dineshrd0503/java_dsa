package codingninjas;

//Problem statement
//Given a binary search tree and an integer ‘K’. Your task is to find the ‘K-th’ smallest element in the given BST( binary search tree).
//
//BST ( binary search tree) -
//
//If all the smallest nodes on the left side and all the greater nodes on the right side of the node current node.
//
//        Example -
//
//
//Order of elements in increasing order in the given BST is - { 2, 3, 4, 5, 6, 7, 8, 10 }
//
//Suppose given ‘K = 3’ then 3rd smallest element is ‘4’.
//
//Suppose given ‘K = 8’ then 8th smallest element is ‘10’.
//
//Note:
//        1. You are not required to print the output explicitly, it has already been taken care of. Just implement the function and return the ‘K-th’ smallest element of BST.
//        2. You don’t need to return ‘K-th’ smallest node, return just value of that node.
//3. If ‘K-th’ smallest element is not present in BST then return -1.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        2
//        3
//        3 1 4 -1 -1 -1 5 -1 -1
//        4
//        5 2 -1 -1 4 3 -1 -1 -1
//Sample output 1:
//        4
//        5
//Explanation of sample input 1:
//Test case 1:
//
//Order of elements in the increasing order in the given BST is - { 1, 3, 4, 5 }.
//        ‘K = 3’, so the 3’rd smallest element is ‘4’, return ‘4’.
//
//Test case 2:
//
//Order of elements in increasing order in the given BST is - { 2, 3, 4, 5 }.
//        ‘K=4’, so the 4’rd smallest element is ‘5’, return ‘5’.
//Sample Input 2:
//        2
//        1
//        3 2 -1 1 -1 -1 -1
//        4
//        3 1 4 -1 -1 -1 -1
//Sample output 2:
//        1
//        -1



public class KthSmallestEleInBST {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode(T data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    static int count=0,result=-1;
    public static int kthSmallest(TreeNode<Integer> root, int k) {
        //    Write your code here.
        count=0;
        result=-1;
        inorder(root,k);
        return result;
    }
    private static void inorder(TreeNode<Integer> root,int k){
        if(root==null)
            return;
        inorder(root.left,k);
        count++;
        if(count==k){
            result=root.data;
            return;
        }
        inorder(root.right,k);
    }
    public static void main(String[] args) {
        System.out.println("Kth Smallest Element in BST");
        TreeNode<Integer> root=new TreeNode<>(3);
        root.left=new TreeNode<>(1);
        root.right=new TreeNode<>(4);
        root.left.right=new TreeNode<>(2);
        root.right.right=new TreeNode<>(5);
        System.out.println(kthSmallest(root,3));
    }
}
