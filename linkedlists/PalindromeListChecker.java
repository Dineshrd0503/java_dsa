package linkedlists;

/*
================================================================================
                    PALINDROME LINKED LIST PROBLEM
================================================================================

PROBLEM STATEMENT:
-------------------
You are given the head of a singly linked list of positive integers.
You have to check if the given linked list is a palindrome or not.

A palindrome linked list reads the same forwards and backwards.
For example: 1 -> 2 -> 1 -> 1 -> 2 -> 1 is a palindrome (true)
            10 -> 20 -> 30 -> 40 -> 50 is not a palindrome (false)

CONSTRAINTS:
- 1 ≤ number of nodes ≤ 10^5
- 50 ≤ node->data ≤ 10^3

EXAMPLES:
---------
Example 1:
Input: 1 -> 2 -> 1 -> 1 -> 2 -> 1
Output: true
Explanation: The linked list reads the same forwards and backwards

Example 2:
Input: 10 -> 20 -> 30 -> 40 -> 50
Output: false
Explanation: Not a palindrome

APPROACH: Reverse Second Half Method (Optimal O(1) space)
-----------------------------------------------------------
1. Find the middle of the linked list using slow and fast pointers
2. Reverse the second half of the linked list
3. Compare the first half with the reversed second half
4. If all elements match, it's a palindrome; otherwise, it's not

TIME COMPLEXITY: O(n) - We traverse the list 1.5 times
SPACE COMPLEXITY: O(1) - Only using pointers, no extra data structure

STEP-BY-STEP EXAMPLE:
--------------------
Original List: 1 -> 2 -> 1 -> 1 -> 2 -> 1

Step 1: Find Middle using Two Pointers
  Slow pointer moves 1 step, Fast moves 2 steps
  Final slow position: Second 1 (at position 3/4)

Step 2: Reverse Second Half (from position 3 onwards)
  Before: ... -> 1 -> 2 -> 1
  After:  ... -> 1 <- 2 <- 1

Step 3: Compare First Half with Reversed Second Half
  First:  1 -> 2 -> 1
  Second: 1 -> 2 -> 1
  All match? YES -> Return true

================================================================================
*/



public class PalindromeListChecker {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /*
     * Main function to check if a linked list is a palindrome
     * @param head: The head node of the linked list
     * @return: true if palindrome, false otherwise
     */
    public boolean isPalindrome(Node head) {

        // Base case: Empty list or single node is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // STEP 1: Find the middle of the linked list using slow and fast pointers
        // Slow pointer moves 1 step at a time
        // Fast pointer moves 2 steps at a time
        // When fast reaches end, slow will be at middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;              // Move slow by 1
            fast = fast.next.next;         // Move fast by 2
        }

        // STEP 2: Reverse the second half of the linked list
        // slow now points to the start of second half
        Node secondHalf = reverseList(slow);

        // STEP 3: Compare first half with reversed second half
        Node first = head;                 // Start from beginning
        Node second = secondHalf;          // Start from reversed second half

        // Iterate through both halves and compare node values
        while (second != null) {           // second half can be shorter in odd-length lists
            if (first.data != second.data) {
                return false;              // Mismatch found - not a palindrome
            }
            first = first.next;
            second = second.next;
        }

        // All elements matched - it's a palindrome
        return true;
    }

    /*
     * Helper function to reverse a linked list
     * Converts: A -> B -> C -> null  to  C -> B -> A -> null
     *
     * @param head: The head of the list to reverse
     * @return: The new head of the reversed list
     *
     * Algorithm:
     * - Use three pointers: prev, current, next
     * - prev tracks the previous node (for linking backwards)
     * - current tracks the current node being processed
     * - next stores the next node before we change current.next
     *
     * Steps in each iteration:
     * 1. Save current.next in 'next' variable (so we don't lose reference)
     * 2. Change current.next to point to 'prev' (reverse the link)
     * 3. Move 'prev' to current node
     * 4. Move 'current' to the next node
     */
    private Node reverseList(Node head) {
        Node prev = null;          // Previous node (initially null)
        Node current = head;       // Current node to process

        while (current != null) {
            // Step 1: Store the next node before we change current.next
            Node next = current.next;

            // Step 2: Reverse the link - make current point to previous
            current.next = prev;

            // Step 3: Move prev one step forward
            prev = current;

            // Step 4: Move current one step forward
            current = next;
        }

        // prev now points to the new head of reversed list
        return prev;
    }

    public static void main(String[] args) {
        PalindromeListChecker checker = new PalindromeListChecker();

        // Example 1: Palindrome
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(2);
        head1.next.next.next.next.next = new Node(1);
        System.out.println("List 1: 1 -> 2 -> 1 -> 1 -> 2 -> 1");
        System.out.println("Is Palindrome? " + checker.isPalindrome(head1)); // Expected: true

        // Example 2: Not a Palindrome
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);
        System.out.println("List 2: 10 -> 20 -> 30 -> 40 -> 50");
        System.out.println("Is Palindrome? " + checker.isPalindrome(head2)); // Expected: false

        // Example 3: Single node (Palindrome)
        Node head3 = new Node(100);
        System.out.println("List 3: 100");
        System.out.println("Is Palindrome? " + checker.isPalindrome(head3)); // Expected: true

        // Example 4: Two nodes, Palindrome
        Node head4 = new Node(5);
        head4.next = new Node(5);
        System.out.println("List 4: 5 -> 5");
        System.out.println("Is Palindrome? " + checker.isPalindrome(head4)); // Expected: true

        // Example 5: Two nodes, Not a Palindrome
        Node head5 = new Node(5);
        head5.next = new Node(6);
        System.out.println("List 5: 5 -> 6");
        System.out.println("Is Palindrome? " + checker.isPalindrome(head5)); // Expected: false
    }
}
