package linkedlists;


public class SingleLinkedListInsertion {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node insert(Node head, int n, int pos, int val) {
        Node newNode = new Node(val);

        // Case 1: Insert at head (position 0)
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }

        // Case 2: Insert in middle or end
        Node current = head;
        for (int i = 0; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    // Helper method to create linked list from array
    static Node createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Hard-coded test cases

        // Test Case 1
        int[] list1 = {1, 1, 2, 3, 4};
        Node head1 = createLinkedList(list1);
        System.out.println("Test Case 1:");
        System.out.print("Original list: ");
        printList(head1);
        head1 = insert(head1, 5, 1, 2);
        System.out.print("After insertion: ");
        printList(head1);

        // Test Case 2
        int[] list2 = {1};
        Node head2 = createLinkedList(list2);
       System.out.println("\nTest Case 2:");
        System.out.print("Original list: ");
        printList(head2);
        head2 = insert(head2, 1, 1, 3);
        System.out.print("After insertion: ");
        printList(head2);

        // Test Case 3
        int[] list3 = {1, 2};
        Node head3 = createLinkedList(list3);
        System.out.println("\nTest Case 3:");
        System.out.print("Original list: ");
        printList(head3);
        head3 = insert(head3, 2, 0, 3);
        System.out.print("After insertion: ");
        printList(head3);

        // Test Case 4
        int[] list4 = {3, 4};
        Node head4 = createLinkedList(list4);
        System.out.println("\nTest Case 4:");
        System.out.print("Original list: ");
        printList(head4);
        head4 = insert(head4, 2, 1, 5);
        System.out.print("After insertion: ");
        printList(head4);
    }
}