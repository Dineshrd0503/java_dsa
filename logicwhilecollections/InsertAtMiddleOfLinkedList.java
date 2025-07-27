package logicwhilecollections;

/*
Problem Statement:
Given the head of a Singly Linked List and a value x. The task is to insert the key in the middle of the linked list.

Examples :
Input: LinkedList = 1->2->4 , x = 3
Output: 1->2->3->4
Explanation: The new element is inserted after the current middle element in the linked list.

Input: LinkedList = 10->20->40->50 , x = 30
Output: 10->20->30->40->50
Explanation: The new element is inserted after the current middle element in the linked list and Hence, the output is 10->20->30->40->50.

Expected Time Complexity: O(n)
Expected Auxilliary Space: O(1)

Constraints:
0 <= number of nodes <= 105
0 <= node->data , x <= 103
*/
// Definition of the Node class


public class InsertAtMiddleOfLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    /**
     * Inserts a new node with value x in the middle of the linked list.
     *  If the number of nodes is even, the new node is inserted after (size/2) th node.
     * @param head The head of the linked list.
     * @param x The value to be inserted.
     * @return The head of the modified linked list.
     */
    public Node insertInMiddle(Node head, int x) {
        // Create a new node with the given data
        Node newNode = new Node(x);

        // If the list is empty, make the new node the head
        if (head == null) {
            return newNode;
        }

        // use slow and fast pointer to find middle
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // insert new node
        newNode.next = slow.next;
        slow.next = newNode;

        return head;
    }
    public static void main(String[] args) {
        // Test case 1: Insert into an empty list
        InsertAtMiddleOfLinkedList sol = new InsertAtMiddleOfLinkedList();
        Node head = null;
        head = sol.insertInMiddle(head, 5);
        printList(head); // Expected output: 5

        // Test case 2: Insert into a list with one element
        head = new Node(1);
        head = sol.insertInMiddle(head, 2);
        printList(head); // Expected output: 1 2

        // Test case 3: Insert into a list with multiple elements (odd)
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head = sol.insertInMiddle(head, 3);
        printList(head); // Expected output: 1 2 3 4

        // Test case 4: Insert into a list with multiple elements (even)
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);
        head = sol.insertInMiddle(head, 30);
        printList(head); // Expected output: 10 20 30 40 50
    }

    // Utility function to print the linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}