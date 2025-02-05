package codingninjas;

//Problem statement
//You are given a singly linked list ‘HEAD’ consisting of ‘N’ nodes. The task is to group all the odd nodes together, followed by the even nodes, maintaining the relative order of nodes given in the input. Note that we are talking about the node’s positions and not the value stored in the node. Try to write an in-place algorithm (i.e., without using any extra space) to solve this problem.
//
//        Example:
//Given linked list: ‘2 => 1 => 3 => 4 => 6 => 5’
//
//While maintaining the relative order of nodes as it is in the input, Nodes at odd positions are (2, 3, 6), and nodes at evens position are (1, 4, 5).
//
//Modified linked list: ‘2 => 3 => 6 => 1 => 4 => 5’
//Note:
//        1. Consider that the first node is odd, the second is even, and so on.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 100
//        1 <= N <= 10^3
//        -10^6 <= Node value <= 10^6 (Node Value != -1)
//
//Time limit: 1 second
//Sample input 1:
//        2
//        1 2 3 -4 5 6 -1
//        -3 -1
//Sample output 1:
//        1 3 5 2 -4 6 -1
//        -3 -1
//Explanation of sample input 1:
//Test Case 1:
//
//Given linked list: ‘1 => 2 => 3 => -4 => 5 => 6’
//While maintaining the relative order of nodes as it is in the input, Nodes at odd positions are (1, 3, 5), and nodes at evens position are (2, -4, 6).
//Modified linked list: ‘1 => 3 => 5 => 2 => -4 => 6’
//
//Test Case 2:
//
//Input linked list: ‘-3’
//The linked list contains only one node.
//Modified linked list: ‘-3’
//Sample input 2:
//        2
//        3 5 -2 1 7 -1
//        -2 3 5 3 -1
//Sample output 2:
//        3 -2 7 5 1 -1
//        -2 5 3 3 -1


public class OddAndEvenPosNodesLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node oddEvenLinkedList(Node head) {
        // Write your code here.
        if(head==null||head.next==null)
            return head;
        Node odd=head,even=head.next;
        Node evenhead=head.next;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;

        }
        odd.next=evenhead;
        return head;
    }
    public static void main(String[] args) {
        System.out.println("odd and even position nodes in linked list");
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);
        Node temp=oddEvenLinkedList(head);
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
