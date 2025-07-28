package logicwhilecollections;

public class LinkedListCycleDetection {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Problem Statement:
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again
     * by continuously following the next pointer.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * Constraints:
     * The number of the nodes in the list is in the range [0, 10^4].
     * -10^5 <= Node.val <= 10^5
     * pos is -1 or a valid index in the linked-list.
     *
     *
     * Example 1:
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     *
     * Example 2:
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
     *
     * Example 3:
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     * @param head The head of the linked list.
     * @return True if the linked list has a cycle, false otherwise.
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test case 1: Cycle exists
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // Cycle

        System.out.println("Test Case 1: " + hasCycle(head1)); // Output: true

        // Test case 2: Cycle exists at head
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head2.next = node22;
        node22.next = head2;

        System.out.println("Test Case 2: " + hasCycle(head2)); // Output: true

        // Test case 3: No cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test Case 3: " + hasCycle(head3)); // Output: false

        // Test case 4: Empty list
        ListNode head4 = null;
        System.out.println("Test Case 4: " + hasCycle(head4)); // Output: false

        // Test case 5 : Single element with cycle
        ListNode head5 = new ListNode(1);
        head5.next = head5;

        System.out.println("Test Case 5: " + hasCycle(head5));

        // Test case 6: Larger list with cycle

        ListNode head6 = new ListNode(1);
        ListNode node62 = new ListNode(2);
        ListNode node63 = new ListNode(3);
        ListNode node64 = new ListNode(4);
        ListNode node65 = new ListNode(5);
        ListNode node66 = new ListNode(6);

        head6.next = node62;
        node62.next = node63;
        node63.next = node64;
        node64.next = node65;
        node65.next = node66;
        node66.next = node63;

        System.out.println("Test Case 6: " + hasCycle(head6));




    }
}