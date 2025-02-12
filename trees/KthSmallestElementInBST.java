package trees;

//k-th Smallest in BST
//Difficulty: MediumAccuracy: 43.53%Submissions: 130K+Points: 4Average Time: 40m
//Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.
//
//Examples:
//
//Input: root = [2, 1, 3], k = 2
//
//Output: 2
//Explanation: 2 is the 2nd smallest element in the BST.
//Input: root = [2, 1, 3], k = 5
//
//Output: -1
//Explanation: There is no 5th smallest element in the BST as the size of BST is 3.
//Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3
//
//Output: 10
//Explanation: 10 is the 3rd smallest element in the BST.
//Constraints:
//
//        1 <= number of nodes, k <= 105
//        1 <= node->data <= 105



public class KthSmallestElementInBST {
    int count=0,result=-1;
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        inorder(root,k);
        return result;



    }
    private void inorder(Node root,int k){
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
        Node root=new Node(3);
        root.left=new Node(1);
        root.right=new Node(4);
        root.left.right=new Node(2);
        root.right.right=new Node(5);
        KthSmallestElementInBST kthSmallestElementInBST=new KthSmallestElementInBST();
        System.out.println(kthSmallestElementInBST.kthSmallest(root,3));
    }
}
