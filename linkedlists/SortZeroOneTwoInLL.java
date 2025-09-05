package linkedlists;
// Problem Statement: Sort a linked list of 0s, 1s, and 2s.
// Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. 
// Your task is to rearrange the list so that all 0s appear at the beginning, 
// followed by all 1s, and all 2s are placed at the end.
//
// Examples:
// Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
// Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
// 
// Input: head = 2 → 2 → 0 → 1
// Output: 0 → 1 → 2 → 2
//
// Constraints: 
// 1 ≤ no. of nodes ≤ 10^6 
// 0 ≤ node->data ≤ 2

public class SortZeroOneTwoInLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to segregate 0s, 1s, and 2s in a linked list
    public Node segregate(Node head) {
        Node zeroD = new Node(0), oneD = new Node(0), twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        // Connect parts: 0s -> 1s -> 2s
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;
        return zeroD.next;
    }

    // Utility function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        SortZeroOneTwoInLL list = new SortZeroOneTwoInLL();

        // Creating a linked list: 1 -> 2 -> 2 -> 1 -> 2 -> 0 -> 2 -> 2
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);

        System.out.println("Original Linked List:");
        list.printList(head);

        // Sorting the linked list
        head = list.segregate(head);
        
        System.out.println("Sorted Linked List:");
        list.printList(head);
    }
}
