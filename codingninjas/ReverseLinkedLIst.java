package codingninjas;

//You are given a Singly Linked List of integers. You need to reverse the Linked List by changing the links between nodes.
//
//        Note :
//You do not need to print anything, just return the head of the reversed linked list.
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= 'N' <= 10^4
//        0 <= 'data' <= 10^9
//
//Where 'N' is the number of nodes in the linked list.
//
//Time Limit: 1 sec
//Sample Input 1 :
//        1 2 4 -1
//Sample Output 1 :
//        4 2 1 -1
//Explanation for Sample Input 1 :
//        1->2->4 is the initial linked list. If we reverse this, we get 4->2->1.
//Sample Input 2 :
//        1
//        1 1 1 -1
//Sample Output 2 :
//        1 1 1 -1

public class ReverseLinkedLIst {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node reverseLinkedList(Node head)
    {
        Node prev=null;
        Node temp=head;
        while(temp!=null){
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;

        }
        return prev;

    }
        // Write your code here.
    public static void main(String[] args) {
        System.out.println("reversing the linked list");
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        Node temp=reverseLinkedList(head);
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
