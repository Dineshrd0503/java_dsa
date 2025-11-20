package linkedlists;
/*
Problem Statement:
You are given the head node of a singly linked list 'head'. Your task is to modify the linked list in such a way that all the even valued nodes appear before the all odd valued node and order of nodes remain the same.

Example :-
The given singly linked list is  6 -> 5 -> 3 -> 4 -> 7 -> 1 -> 2 

The modified linked list should have all even values in starting and odd values in the end.

Sample Input 1
2 1 3 5 6 4 7 -1
Sample Output 1
2 6 4 1 3 5 7
Explanation of Sample Input 1
Given singly linked list 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7.

Arrange all the even values in the starting and odd values at the end of the linked list.

So ‘2, 6, 4’ must appear in the starting and ‘1, 3, 5, 7’ must appear at the end of linked list 

So return 2 -> 6 -> 4 -> 1 -> 3 -> 5 -> 7
*/



public class SegregateEvenAndOddLinkedLists {
static class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

    public static Node segregateEvenOdd(Node head) {
        if (head == null) return null;

        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node evenHead = even;
        Node oddHead = odd;

        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                even.next = curr;
                even = even.next;

            } else {
                odd.next = curr;
                odd = odd.next;

            }
            curr = curr.next;
        }
        odd.next = null; // Important: To prevent cycle in the end
        even.next = oddHead.next;

        return evenHead.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(7);
        // 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7

        // Segregate even and odd nodes
        Node segregatedList = segregateEvenOdd(head);

        // Print the segregated list
        Node current = segregatedList;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // Newline
        // Expected output: 2 6 4 1 3 5 7
    }
}
