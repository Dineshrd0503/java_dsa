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
        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;

        // Counting occurrences of 0s, 1s, and 2s
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else if (temp.data == 2) {
                count2++;
            }
            temp = temp.next;
        }

        // Reassigning values in the linked list based on counts
        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0--;
            } else if (count1 > 0) {
                temp.data = 1;
                count1--;
            } else {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }

        return head;
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
