package linkedlists;

/*
LeetCode 3217: Delete Nodes From Linked List Present in Array

Problem Statement:
You are given the head of a linked list and an array of integers nums.
Delete every node from the linked list that has a value appearing in nums, and return the head of the modified linked list.

Example 1:
Input: nums = [1, 2, 3], head = [1, 2, 3, 4, 5]
Output: [4, 5]

Example 2:
Input: nums = [5], head = [1, 2, 3, 4]
Output: [1, 2, 3, 4]

Constraints:
- The number of nodes in the list is in the range [0, 10^4].
- -10^4 <= Node.val <= 10^4
- 1 <= nums.length <= 10^4
- nums[i] and Node.val are integers in the same range.
- Each value in nums is unique.

Below is the Java solution using two pointers, including a main method with static test cases.
*/

import java.util.*;


public class DeleteNodesFromLinkedListPresentInArray {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, linkedlists.ListNode next) { this.val = val; this.next = null; }
    }
    public static ListNode deleteNodes(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility function to create a ListNode from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility function to print ListNode
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3};
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = deleteNodes(nums1, head1);
        System.out.print("Test Case 1 Output: ");
        printList(result1); // Expected Output: 4 -> 5

        // Test Case 2
        int[] nums2 = {5};
        ListNode head2 = createList(new int[]{1, 2, 3, 4});
        ListNode result2 = deleteNodes(nums2, head2);
        System.out.print("Test Case 2 Output: ");
        printList(result2); // Expected Output: 1 -> 2 -> 3 -> 4

        // Test Case 3
        int[] nums3 = {1};
        ListNode head3 = createList(new int[]{1, 2, 1, 2, 1, 2});
        ListNode result3 = deleteNodes(nums3, head3);
        System.out.print("Test Case 3 Output: ");
        printList(result3); // Expected Output: 2 -> 2 -> 2
    }
}
