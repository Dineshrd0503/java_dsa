package linkedlists;

/**
 * LeetCode 19 – Remove Nth Node From End of List
 *
 * Problem Statement:
 * Given the head of a singly linked list, remove the nth node from the end of the list and return its head.
 * The algorithm must operate in a single pass (O(N) time) with O(1) space.
 *
 * Sample Input 1:
 * head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Sample Input 2:
 * head = [1,2], n = 1
 * Output: [1]
 *
 * Sample Input 3:
 * head = [1], n = 1
 * Output: []
 */

public class RemoveNthFromEnd {

    // Definition for singly-linked list node.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Removes the nth node from the end of the list and returns the head of the modified list.
     * Uses a dummy node and two-pointer technique for O(N) time, O(1) space.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to head (handles edge case: removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Fast and slow pointer initialization
        ListNode first = dummy;
        ListNode second = dummy;

        // Advance 'first' pointer n+1 times so that the gap between first/second is n nodes
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move both pointers; when 'first' hits the end, 'second' is just before deletion node
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the node: 'second.next' is the target, skip it
        second.next = second.next.next;

        // Return new head (could be changed if head was removed)
        return dummy.next;
    }

    // Helper method to build linked list from int array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main with static test cases
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int n1 = 2;
        ListNode head1 = buildList(arr1);
        System.out.print("Input: ");
        printList(head1);
        System.out.println("n = " + n1);
        ListNode result1 = removeNthFromEnd(head1, n1);
        System.out.print("Output: ");
        printList(result1); // Expected: 1 -> 2 -> 3 -> 5
        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 2};
        int n2 = 1;
        ListNode head2 = buildList(arr2);
        System.out.print("Input: ");
        printList(head2);
        System.out.println("n = " + n2);
        ListNode result2 = removeNthFromEnd(head2, n2);
        System.out.print("Output: ");
        printList(result2); // Expected: 1
        System.out.println();

        // Test Case 3
        int[] arr3 = {1};
        int n3 = 1;
        ListNode head3 = buildList(arr3);
        System.out.print("Input: ");
        printList(head3);
        System.out.println("n = " + n3);
        ListNode result3 = removeNthFromEnd(head3, n3);
        System.out.print("Output: ");
        printList(result3); // Expected: (empty)
        System.out.println();
    }
}
