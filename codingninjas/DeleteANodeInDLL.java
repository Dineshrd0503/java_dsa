package codingninjas;

//Problem statement
//You are given a Doubly Linked List of ‘N’ positive integers. Your task is to delete a node at position ‘POS’ in the linked list.
//
//Note:
//Assume that the Indexing for the linked list starts from 0.
//EXAMPLE:
//Input: ‘N’ = 5, 'LIST' = [1, 1, 2, 3, 4, -1], ‘POS’ = 1.
//
//Output: 1 < - > 2 < - > 3 < - > 4
//
//Here in the given list, we can see that the node at position 1 is deleted.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= ‘T’ <= 10
//        2 <= ‘N’ <= 10^4
//        0 <= ‘POS < N
//1 <= ‘data’ <= 10^7
//Where 'N' is the size of the doubly linked list, and ‘data’ is the Integer data of the doubly linked list.
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        1 1 2 3 4 -1
//        1
//        1 2 -1
//        1
//Sample Output 1 :
//        1 2 3 4
//        1
//Explanation Of Sample Input 1 :
//For the first test case,
//        ‘N’ = 5, 'LIST' = [1, 1, 2, 3, 4, -1], ‘POS’ = 1.
//After deleting the node at position 1 the list will be:
//        1 < - > 2 < - > 3 < - > 4.
//
//For the second test case,
//        ‘N’ = 2,  'LIST' = [1, 2, -1], ‘POS’ = 1.
//After deleting the node at position 1 the list will be:
//        1.
//Sample Input 2 :
//        2
//        1 2 3 -1
//        0
//        3 4 4 -1
//        2
//Sample Output 2 :
//        2 3
//        3 4
public class DeleteANodeInDLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    static Node deleteNode(Node head, int k) {
        // Write your code here.
        if(k==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
            return head;
        }
        int count=0;
        Node curr=head;
        while(curr!=null&&count<k){
            count++;
            curr=curr.next;
        }
        if(curr==null)
            return head;
        if(curr.next!=null)
            curr.next.prev=curr.prev;
        if(curr.prev!=null)
            curr.prev.next=curr.next;
        return head;



    }
    public static void main(String[] args) {
        System.out.println("Delete a node in DLL");
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.prev=head;
        head.next.next=new Node(30);
        head.next.next.prev=head.next;
        head.next.next.next=new Node(40);
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next=new Node(50);
        head.next.next.next.next.prev=head.next.next.next;
        Node res=deleteNode(head,2);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
