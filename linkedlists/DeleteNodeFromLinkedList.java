package linkedlists;

// Problem Statement:
// Given a singly linked list and an integer, x. Delete the xth node (1-based indexing) from the singly linked list.

// Examples:
// Input: Linked list: 1 -> 3 -> 4, x = 3
// Output: 1 -> 3
// Explanation: After deleting the node at the 3rd position (1-base indexing), the linked list is as 1 -> 3.

// Input: Linked list: 1 -> 5 -> 2 -> 9, x = 2
// Output: 1 -> 2 -> 9
// Explanation: After deleting the node at 2nd position (1-based indexing), the linked list is as 1 -> 2 -> 9.

// Constraints:
// 2 <= size of linked list <= 10^6
// 1 <= x <= size of linked list



public class DeleteNodeFromLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node deleteNode(Node head, int x) {
        // code here
        if (head == null) return null;

        if (x == 1) return head.next;

        int count = 1;
        Node temp = head;

        while (temp != null && count < x - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) // Corrected condition
            return head;

        temp.next = temp.next.next;
        return head;
    }

    // Helper function to create a linked list from an array
    static Node createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print a linked list
    static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteNodeFromLinkedList sol = new DeleteNodeFromLinkedList();

        // Test Case 1
        int[] arr1 = {1, 3, 4};
        int x1 = 3;
        Node head1 = createLinkedList(arr1);
        System.out.print("Input:  ");
        printLinkedList(head1);
        Node result1 = sol.deleteNode(head1, x1);
        System.out.print("x = " + x1 + ", Output: ");
        printLinkedList(result1); // Expected Output: 1 3
        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 5, 2, 9};
        int x2 = 2;
        Node head2 = createLinkedList(arr2);
        System.out.print("Input:  ");
        printLinkedList(head2);
        Node result2 = sol.deleteNode(head2, x2);
        System.out.print("x = " + x2 + ", Output: ");
        printLinkedList(result2); // Expected Output: 1 2 9
        System.out.println();

        // Test Case 3: Delete first element
        int[] arr3 = {7, 8, 9, 10};
        int x3 = 1;
        Node head3 = createLinkedList(arr3);
        System.out.print("Input:  ");
        printLinkedList(head3);
        Node result3 = sol.deleteNode(head3, x3);
        System.out.print("x = " + x3 + ", Output: ");
        printLinkedList(result3); // Expected Output: 8 9 10
        System.out.println();

        // Test Case 4:  x is out of range
        int[] arr4 = {1, 2, 3};
        int x4 = 5;
        Node head4 = createLinkedList(arr4);
        System.out.print("Input:  ");
        printLinkedList(head4);
        Node result4 = sol.deleteNode(head4, x4);
        System.out.print("x = " + x4 + ", Output: ");
        printLinkedList(result4); // Expected Output: 1 2 3  (no change)
        System.out.println();

        // Test Case 5: List is null
        Node head5 = null;
        int x5 = 1;
        System.out.print("Input:  ");
        printLinkedList(head5);
        Node result5 = sol.deleteNode(head5, x5);
        System.out.print("x = " + x5 + ", Output: ");
        printLinkedList(result5); // Expected Output:  (null, so prints nothing)
        System.out.println();

        // Test Case 6: List is one element
        int[] arr6 = {5};
        int x6 = 1;
        Node head6 = createLinkedList(arr6);
        System.out.print("Input:  ");
        printLinkedList(head6);
        Node result6 = sol.deleteNode(head6, x6);
        System.out.print("x = " + x6 + ", Output: ");
        printLinkedList(result6); // Expected Output:  (null, so prints nothing)
        System.out.println();

        // Test Case 7: Delete the last element
        int[] arr7 = {10, 20, 30};
        int x7 = 3;
        Node head7 = createLinkedList(arr7);
        System.out.print("Input:  ");
        printLinkedList(head7);
        Node result7 = sol.deleteNode(head7, x7);
        System.out.print("x = " + x7 + ", Output: ");
        printLinkedList(result7); // Expected Output: 10 20
        System.out.println();
    }
}