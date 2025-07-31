/**
 * Problem Statement:
 * Insert a new node with value 'val' at position 'k' (0-based indexing) in a circular singly linked list
 * and return the updated head. The last node points to the head.
 * 
 * Examples:
 * - Input: k = 1, val = 5, list = [1, 2, 3, 4] -> Output: [1, 5, 2, 3, 4]
 * - Input: k = 0, val = 5, list = [1, 2, 3, 4] -> Output: [5, 1, 2, 3, 4]
 * 
 * Constraints:
 * - 1 <= n <= 10^4
 * - 0 <= k <= n
 * - 1 <= val <= 10^5
 * - 1 <= Node.data <= 10^5
 * 
 * Expected Time Complexity: O(k)
 * 
 * Date: 09:45 AM IST, Wednesday, July 30, 2025
 */
package linkedlists;
public class InsertionInCircularLinkedList {
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
     * Inserts a new node with value 'val' at position 'k' in a circular singly linked list.
     * 
     * @param k The 0-based position to insert the new node
     * @param val The value to insert
     * @param head The head node of the circular linked list
     * @return The updated head of the list
     */
    static Node insert(int k, int val, Node head) {
        // Create new node
        Node newNode = new Node(val);

        // Handle empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Handle insertion at k = 0 (before head)
        if (k == 0) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            last.next = newNode;
            return newNode; // New head
        }

        // Traverse to the node before position k
        Node temp = head;
        int count = 0;
        while (count < k - 1 && temp != null) {
            temp = temp.next;
            count++;
            // Ensure we don't loop infinitely in a circular list
            if (temp == head && count < k - 1) {
                break;
            }
        }

        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;

        return head; // Head remains the same for k > 0
    }

    /**
     * Main method to test the insert method with static inputs.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        InsertionInCircularLinkedList solution = new InsertionInCircularLinkedList();

        // Test Case 1: k = 0, val = 5, list = [1, 2, 3, 4]
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head1; // Circular
        Node result1 = solution.insert(0, 5, head1);
        System.out.print("Test Case 1 - Updated List: ");
        printList(result1); // Expected: 5 1 2 3 4

        // Test Case 2: k = 1, val = 4, list = [10, 11, 5]
        Node head2 = new Node(10);
        Node node21 = new Node(11);
        Node node22 = new Node(5);
        head2.next = node21;
        node21.next = node22;
        node22.next = head2; // Circular
        Node result2 = solution.insert(1, 4, head2);
        System.out.print("Test Case 2 - Updated List: ");
        printList(result2); // Expected: 10 11 4 5
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
