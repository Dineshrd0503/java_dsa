package logicwhilecollections;

/**
 * Problem Statement:
 * Given the head of a singly linked list, determine if it is a palindrome.
 * A linked list is a palindrome if it reads the same forwards and backwards.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2,3,2,1]
 * Output: true
 *
 * Example 3:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 */
public class PalindromeLinkedList {

    /**
     * Definition for a singly-linked list node.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Main method to test the isPalindrome functionality.
     */
    public static void main(String[] args) {
        // Test Case 1: Odd-length palindrome list [1 -> 2 -> 3 -> 2 -> 1]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);
        System.out.println("Is the list [1,2,3,2,1] a palindrome? " + isPalindrome(head1)); // Expected: true

        // Test Case 2: Even-length palindrome list [1 -> 2 -> 2 -> 1]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println("Is the list [1,2,2,1] a palindrome? " + isPalindrome(head2)); // Expected: true

        // Test Case 3: Non-palindrome list [1 -> 2 -> 3]
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        System.out.println("Is the list [1,2,3] a palindrome? " + isPalindrome(head3)); // Expected: false

        // Test Case 4: Single-node list [1]
        ListNode head4 = new ListNode(1);
        System.out.println("Is the list [1] a palindrome? " + isPalindrome(head4)); // Expected: true
    }

    /**
     * Checks if a linked list is a palindrome.
     *
     * @param head The head of the linked list.
     * @return true if the list is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(ListNode head) {
        // An empty list or a single-node list is always a palindrome.
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list.
        // When the fast pointer reaches the end, the slow pointer will be at the middle.
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the list starting from the node after the middle.
        ListNode secondHalfHead = reverseList(middle.next);

        // Step 3: Compare the first half with the reversed second half.
        ListNode p1 = head; // Pointer for the first half
        ListNode p2 = secondHalfHead; // Pointer for the reversed second half
        boolean isPalindrome = true;
        while (p2 != null) {
            // If any values don't match, it's not a palindrome.
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // (Optional but good practice) Step 4: Restore the original list by reversing the second half again.
        // This connects the first half back to the now-restored second half.
        middle.next = reverseList(secondHalfHead);

        return isPalindrome;
    }

    /**
     * Reverses a linked list and returns the new head.
     *
     * @param head The head of the list to reverse.
     * @return The new head of the reversed list.
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev;              // Reverse the current node's pointer
            prev = current;                   // Move prev one step forward
            current = nextTemp;               // Move current one step forward
        }
        return prev; // `prev` is now the new head
    }

    /**
     * Finds the middle node of a linked list using the slow and fast pointer technique.
     *
     * @param head The head of the list.
     * @return The middle node of the list.
     */
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // The fast pointer moves two steps at a time, while the slow pointer moves one.
        // This ensures that when the fast pointer reaches the end, the slow pointer is at the middle.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
