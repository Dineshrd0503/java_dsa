/**
 * Problem Statement:
 * Insert a new node with value 'data' into a sorted circular linked list, maintaining sorted order,
 * and return the updated head.
 * 
 * Examples:
 * - Input: head = 1->2->4, data = 2 -> Output: 1->2->2->4
 * - Input: head = 1->4->7->9, data = 5 -> Output: 1->4->5->7->9
 * 
 * Constraints:
 * - 2 <= number of nodes <= 10^6
 * - 0 <= node->data <= 10^6
 * - 0 <= data <= 10^6
 * 
 * Date: 09:51 AM IST, Wednesday, July 30, 2025
 */
package linkedlists;
public class InsertInASortedCircularLinkedLists {
    // Definition for singly-linked list node
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Inserts a new node with value 'data' into a sorted circular linked list.
     * 
     * @param head The head node of the circular linked list
     * @param data The value to insert
     * @return The updated head of the list
     */
    static Node sortedInsert(Node head, int data) {
        // Create new node
        Node newNode = new Node(data);

        // Handle empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Handle single node
        if (head.next == head) {
            if (data <= head.data) {
                newNode.next = head;
                head.next = newNode;
                return newNode; // New head if data is smaller
            } else {
                newNode.next = head;
                head.next = newNode;
                return head; // Keep original head
            }
        }

        // Traverse to find insertion point
        Node curr = head;
        Node prev = null;
        do {
            if (curr.data > data) {
                break; // Insert before curr if data is smaller
            }
            if (prev != null && prev.data <= data && curr.data >= data) {
                break; // Insert between prev and curr if data fits
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        // Insert the new node
        if (prev == null) {
            // Insert at the beginning (data < head or largest)
            newNode.next = head;
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            return newNode; // New head if data is smallest
        } else {
            newNode.next = curr;
            prev.next = newNode;
            return head; // Head remains the same
        }
    }

    /**
     * Main method to test the sortedInsert method with static inputs.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        InsertInASortedCircularLinkedLists solution = new InsertInASortedCircularLinkedLists();
        // Test Case 1: head = 1->2->4, data = 2
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);
        head1.next.next.next = head1; // Circular
        Node result1 = solution.sortedInsert(head1, 2);
        System.out.print("Test Case 1 - Updated List: ");
        printList(result1); // Expected: 1 2 2 4

        // Test Case 2: head = 1->4->7->9, data = 5
        Node head2 = new Node(1);
        head2.next = new Node(4);
        head2.next.next = new Node(7);
        head2.next.next.next = new Node(9);
        head2.next.next.next.next = head2; // Circular
        Node result2 = solution.sortedInsert(head2, 5);
        System.out.print("Test Case 2 - Updated List: ");
        printList(result2); // Expected: 1 4 5 7 9
    }

    /**
     * Helper method to print the circular linked list for verification.
     * 
     * @param head The head node of the list
     */
    private static void printList(Node head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
