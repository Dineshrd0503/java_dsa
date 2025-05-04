package linkedlists;

public class InsertNodeAtPosInSLL {
    // Static nested Node class
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    static Node insert(Node head, int n, int pos, int val) {
        // Step 1: Create the new node
        Node newnode = new Node(val);

        // Step 2: Handle insertion at the beginning (pos == 0)
        if (pos == 0) {
            newnode.next = head;
            head = newnode;
            return head;
        }

        // Step 3: Traverse to the node just before the insertion position
        Node temp = head;
        // Traverse pos-1 steps or until the end of the list
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Step 4: Insert the new node
        if (temp != null) {
            newnode.next = temp.next;
            temp.next = newnode;
        }

        // Step 5: Return the head of the modified list
        return head;
    }
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        int n = 3; // Number of nodes in the list
        int pos = 1; // Position to insert the new node
        int val = 4; // Value of the new node

        head = insert(head, n, pos, val);

        // Print the modified linked list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}