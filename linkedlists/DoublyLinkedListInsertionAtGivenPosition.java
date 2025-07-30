package linkedlists;

/**
 * Problem Statement:
 * Given a doubly-linked list, a position p (0-based index), and an integer x, add a new node with
 * value x just after the pth node and return the head of the updated list.
 *
 * Examples:
 * - Input: 2<->4<->5, p = 2, x = 6 -> Output: 2<->4<->5<->6
 * - Input: 1<->2<->3<->4, p = 0, x = 44 -> Output: 1<->44<->2<->3<->4
 *
 * Constraints:
 * - 0 <= p < size of doubly linked list <= 10^6
 * - 1 <= x <= 10^6
 *
 * Date: 11:41 AM IST, Tuesday, July 29, 2025
 */

public class DoublyLinkedListInsertionAtGivenPosition {
    // Definition for doubly-linked list node
    public static class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    /**
     * Adds a new node with value x after the pth node in a doubly-linked list.
     *
     * @param head The head node of the doubly-linked list
     * @param p The 0-based position after which to insert
     * @param x The value to insert
     * @return The head of the updated list
     */
    public static Node addNode(Node head, int p, int x) {
        // Create new node with value x
        Node newNode = new Node(x);

        // Handle case where p = 0 (insert after head)
        if (p == 0 && head != null) {
            newNode.next = head.next;
            newNode.prev = head;
            if (head.next != null) {
                head.next.prev = newNode;
            }
            head.next = newNode;
            return head;
        }

        // Traverse to the pth node
        Node temp = head;
        int count = 0;
        while (count < p && temp != null) {
            temp = temp.next;
            count++;
        }

        // Check if p is valid (within list size)
        if (temp == null) {
            return head; // p exceeds list size, return unchanged head
        }

        // Insert new node after pth node
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;

        return head;
    }

    /**
     * Main method to test the addNode method with static inputs.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        DoublyLinkedListInsertionAtGivenPosition solution = new DoublyLinkedListInsertionAtGivenPosition();

        // Test Case 1: 2<->4<->5, p = 2, x = 6
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.prev = head1;
        head1.next.next = new Node(5);
        head1.next.next.prev = head1.next;
        Node result1 = solution.addNode(head1, 2, 6);
        System.out.print("Test Case 1 - Updated List: ");
        printList(result1); // Expected: 2<->4<->5<->6

        // Test Case 2: 1<->2<->3<->4, p = 0, x = 44
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.prev = head2;
        head2.next.next = new Node(3);
        head2.next.next.prev = head2.next.next.prev;
        head2.next.next.next = new Node(4);
        head2.next.next.next.prev = head2.next.next;
        Node result2 = solution.addNode(head2, 0, 44);
        System.out.print("Test Case 2 - Updated List: ");
        printList(result2); // Expected: 1<->44<->2<->3<->4
    }

    /**
     * Helper method to print the doubly-linked list for verification.
     *
     * @param head The head node of the list
     */
    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "<->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }
}