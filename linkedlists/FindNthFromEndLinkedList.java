package linkedlists;

/**
 * Problem Statement:
 * ------------------
 * Given the head of a singly-linked list, return the Nth node from the end of the list (1-indexed).
 * If N is 1, return the last node; if N equals the length, return the first node.
 * If N is greater than the length, behavior is undefined (assumes N is always valid).
 *
 * Sample Input/Output:
 * Input: head = [10, 20, 30, 40, 50], n = 2
 * Output: returns node with value 40
 *
 * Input: head = [1, 2, 3], n = 3
 * Output: returns node with value 1
 */

public class FindNthFromEndLinkedList {

    // Node definition
    public static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    // Returns the nth node from the end (1-indexed, so n=1 -> last node).
    public static Node nthNodeFromEnd(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy, second = dummy;
        // Move 'first' n+1 steps ahead (so 'second' will land just before nth-from-end)
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move both pointers till 'first' reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 'second.next' is the nth node from end
        return second.next;
    }

    // Utility to build list from array
    public static Node buildList(int[] arr) {
        Node dummy = new Node(-1), curr = dummy;
        for (int x : arr) {
            curr.next = new Node(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility to print an entire list (optional for debugging)
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        Node head1 = buildList(new int[]{10, 20, 30, 40, 50});
        int n1 = 2;
        System.out.print("Input list: ");
        printList(head1);
        System.out.println("n = " + n1);
        Node ans1 = nthNodeFromEnd(head1, n1);
        System.out.println("Nth node from end is: " + (ans1 != null ? ans1.data : "null"));
        System.out.println();

        // Example 2
        Node head2 = buildList(new int[]{1, 2, 3});
        int n2 = 3;
        System.out.print("Input list: ");
        printList(head2);
        System.out.println("n = " + n2);
        Node ans2 = nthNodeFromEnd(head2, n2);
        System.out.println("Nth node from end is: " + (ans2 != null ? ans2.data : "null"));
        System.out.println();

        // Example 3 (edge case, last node)
        Node head3 = buildList(new int[]{5, 6, 7});
        int n3 = 1;
        System.out.print("Input list: ");
        printList(head3);
        System.out.println("n = " + n3);
        Node ans3 = nthNodeFromEnd(head3, n3);
        System.out.println("Nth node from end is: " + (ans3 != null ? ans3.data : "null"));
    }
}
