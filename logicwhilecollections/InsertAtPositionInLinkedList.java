package logicwhilecollections;

public class InsertAtPositionInLinkedList {

    // Node class to represent an element in the linked list
    static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node in the list

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null; // Initially, the next node is null
        }
    }

    // Head of the linked list
    Node head;

    // Constructor for the LinkedList class
    public InsertAtPositionInLinkedList() {
        this.head = null; // Initially, the list is empty
    }

    /**
     * Inserts a new node with the given data at a specified position in the linked list.
     *
     * @param data The data to be stored in the new node.
     * @param position The 0-indexed position where the new node should be inserted.
     *                 If position is 0, the node is inserted at the beginning.
     *                 If position is greater than or equal to the list's length,
     *                 the node is inserted at the end.
     */
    public void insertAtPosition(int data, int position) {
        // Create a new node with the given data
        Node newNode = new Node(data);

        // Case 1: Insert at the beginning (position 0)
        if (position == 0) {
            newNode.next = head; // New node points to the current head
            head = newNode;      // Head is updated to the new node
            return;              // Insertion complete
        }

        // Case 2: Insert at a position other than the beginning
        // Traverse the list to find the node just before the insertion point
        Node current = head;
        int count = 0;

        // Iterate until we reach the node before the desired position
        // or until we reach the end of the list
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // Check if the desired position is valid (i.e., current is not null)
        // If current is null, it means the position is out of bounds (too large)
        // In this case, we insert at the end of the list.
        if (current == null) {
            // If the list was empty and position > 0, or position is beyond the end,
            // we effectively append to the end.
            // If head is null, it means the list is empty, and we are trying to insert
            // at a position > 0. In this case, the new node becomes the head.
            if (head == null) {
                head = newNode;
            } else {
                // Traverse to the end to append
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        } else {
            // Insert the new node between current and current.next
            newNode.next = current.next; // New node points to the node current was pointing to
            current.next = newNode;      // Current node now points to the new node
        }
    }

    public static void main(String[] args) {
        InsertAtPositionInLinkedList list = new InsertAtPositionInLinkedList();

        // Inserting elements at various positions
        list.insertAtPosition(10, 0); // Insert 10 at position 0
        list.insertAtPosition(20, 1); // Insert 20 at position 1
        list.insertAtPosition(30, 1); // Insert 30 at position 1 (between 10 and 20)
        list.insertAtPosition(40, 3); // Insert 40 at position 3 (end of the list)
        list.insertAtPosition(50, 5); // Insert 50 at position 5 (beyond current length, should append)

        // Print the linked list to verify the insertions
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    }

