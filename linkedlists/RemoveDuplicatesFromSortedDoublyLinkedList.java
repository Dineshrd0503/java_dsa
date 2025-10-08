package linkedlists;

/*
Problem Statement:
Given a sorted doubly linked list, remove all duplicates such that each element appears only once.
The linked list is sorted (in non-decreasing order), so duplicates will be adjacent to each other.
Return the head of the modified list with unique elements.

Example:
Input: 1 <-> 1 <-> 2 <-> 3 <-> 3 <-> 4
Output: 1 <-> 2 <-> 3 <-> 4

Constraints:
- The number of nodes in the list is in the range [0, 300].
- -100 <= Node.val <= 100.
- The list is guaranteed to be sorted in non-decreasing order.

Approach:
- Traverse the list using a single pointer (curr).
- For each pair of adjacent nodes, if they have the same value, remove the next node by updating pointers.
- Since it's sorted, duplicates are consecutive, so this handles all cases in one pass.
- Time: O(n), Space: O(1).
*/
import java.util.*;

public class RemoveDuplicatesFromSortedDoublyLinkedList {


    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    // Method to remove duplicates from sorted doubly linked list
    public static Node uniqueSortedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                // Remove the duplicate (curr.next)
                Node duplicate = curr.next;
                curr.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = curr;
                }
                // Optional: Free memory (set duplicate to null)
                duplicate = null;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    // Helper method to print the doubly linked list (forward traversal)
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper method to create a sample doubly linked list
    public static Node createList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp.next.prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        // Test Case 1: Normal duplicates
        int[] arr1 = {1, 1, 2, 3, 3, 4};
        Node head1 = createList(arr1);
        System.out.println("Original List 1: ");
        printList(head1);

        head1 = uniqueSortedList(head1);
        System.out.println("After removing duplicates: ");
        printList(head1);

        // Test Case 2: All duplicates
        int[] arr2 = {5, 5, 5, 5};
        Node head2 = createList(arr2);
        System.out.println("\nOriginal List 2: ");
        printList(head2);

        head2 = uniqueSortedList(head2);
        System.out.println("After removing duplicates: ");
        printList(head2);

        // Test Case 3: No duplicates
        int[] arr3 = {1, 2, 3, 4};
        Node head3 = createList(arr3);
        System.out.println("\nOriginal List 3: ");
        printList(head3);

        head3 = uniqueSortedList(head3);
        System.out.println("After removing duplicates: ");
        printList(head3);

        // Test Case 4: Empty list
        Node head4 = null;
        System.out.println("\nOriginal Empty List: ");
        printList(head4);

        head4 = uniqueSortedList(head4);
        System.out.println("After removing duplicates: ");
        printList(head4);

        // Test Case 5: Single node
        int[] arr5 = {10};
        Node head5 = createList(arr5);
        System.out.println("\nOriginal Single Node List: ");
        printList(head5);

        head5 = uniqueSortedList(head5);
        System.out.println("After removing duplicates: ");
        printList(head5);
    }
}

