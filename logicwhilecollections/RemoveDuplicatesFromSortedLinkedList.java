package logicwhilecollections;

/**
 * Problem Statement:
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * Constraints:
 * - The number of nodes in the list is in the range [0, 300].
 * - -100 <= Node.val <= 100
 * - The list is guaranteed to be sorted in ascending order.
 */

/**
 * Definition for singly-linked list.
 */


public class RemoveDuplicatesFromSortedLinkedList {
    /**
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     *
     * @param //The head of the sorted linked list.
     * @return The head of the linked list with duplicates removed.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static boolean compareLinkedLists(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {1, 1, 2};
        ListNode head1 = createLinkedList(input1);
        RemoveDuplicatesFromSortedLinkedList solution = new RemoveDuplicatesFromSortedLinkedList();
        ListNode result1 = solution.deleteDuplicates(head1);
        int[] expected1 = {1, 2};
        ListNode expectedHead1 = createLinkedList(expected1);

        System.out.println("Test Case 1 Output:");
        printLinkedList(result1);

        if (compareLinkedLists(result1, expectedHead1)) {
            System.out.println("Test Case 1: Passed");
        } else {
            System.out.println("Test Case 1: Failed");
        }

        // Test Case 2
        int[] input2 = {1, 1, 2, 3, 3};
        ListNode head2 = createLinkedList(input2);
        ListNode result2 = solution.deleteDuplicates(head2);
        int[] expected2 = {1, 2, 3};
        ListNode expectedHead2 = createLinkedList(expected2);

        System.out.println("Test Case 2 Output:");
        printLinkedList(result2);


        if (compareLinkedLists(result2, expectedHead2)) {
            System.out.println("Test Case 2: Passed");
        } else {
            System.out.println("Test Case 2: Failed");
        }

        // Test Case 3 : empty list
        int[] input3 = {};
        ListNode head3 = createLinkedList(input3);
        ListNode result3 = solution.deleteDuplicates(head3);
        int[] expected3 = {};
        ListNode expectedHead3 = createLinkedList(expected3);

        System.out.println("Test Case 3 Output:");
        printLinkedList(result3);


        if (compareLinkedLists(result3, expectedHead3)) {
            System.out.println("Test Case 3: Passed");
        } else {
            System.out.println("Test Case 3: Failed");
        }

        // Test Case 4 : single element list
        int[] input4 = {1};
        ListNode head4 = createLinkedList(input4);
        ListNode result4 = solution.deleteDuplicates(head4);
        int[] expected4 = {1};
        ListNode expectedHead4 = createLinkedList(expected4);

        System.out.println("Test Case 4 Output:");
        printLinkedList(result4);


        if (compareLinkedLists(result4, expectedHead4)) {
            System.out.println("Test Case 4: Passed");
        } else {
            System.out.println("Test Case 4: Failed");
        }

        // Test Case 5 : all elements are same
        int[] input5 = {1,1,1,1};
        ListNode head5 = createLinkedList(input5);
        ListNode result5 = solution.deleteDuplicates(head5);
        int[] expected5 = {1};
        ListNode expectedHead5 = createLinkedList(expected5);

        System.out.println("Test Case 5 Output:");
        printLinkedList(result5);


        if (compareLinkedLists(result5, expectedHead5)) {
            System.out.println("Test Case 5: Passed");
        } else {
            System.out.println("Test Case 5: Failed");
        }
    }
}
