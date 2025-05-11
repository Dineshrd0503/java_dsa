package linkedlists;

public class ChangeStartNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node changeStartNode(Node head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        Node fast = head;
        Node slow = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // If fast is null, k == N, so the head is already at the right place
        if (fast == null) {
            return head;
        }

        // Move both pointers until fast.next is null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is at the node before the new head
        Node newHead = slow.next;
        slow.next = null;

        // Connect the tail of the new list to the old head
        fast.next = head;

        return newHead;
    }

    // Helper function to create a linked list from an array
    public static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print a linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("-1");
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] arr1 = {7, 11, 13, 17, 19, 23, 29};
        int k1 = 3;
        Node head1 = createLinkedList(arr1);
        Node newHead1 = changeStartNode(head1, k1);
        printLinkedList(newHead1); // Expected Output: 19 7 11 13 17 23 29 -1

        // Sample Input 2
        int[] arr2 = {13, 1, 19, 3, 9};
        int k2 = 5;
        Node head2 = createLinkedList(arr2);
        Node newHead2 = changeStartNode(head2, k2);
        printLinkedList(newHead2); // Expected Output: 13 1 19 3 9 -1
    }
}