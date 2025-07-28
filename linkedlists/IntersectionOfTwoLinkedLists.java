package linkedlists;

/**
 * Problem Statement:
 * Given the heads of two singly linked-lists, headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no intersection
 * at all, return null.
 *
 * It is guaranteed that there are no cycles in either list.
 * The solution should run in O(m + n) time and use only O(1) memory.
 *
 * Example 1:
 * Input: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 * The lists intersect at the node with value 8.
 * Output: The node with value 8.
 *
 * Example 2:
 * Input: listA = [2,6,4], listB = [1,5]
 * The lists do not intersect.
 * Output: null
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Definition for a singly-linked list node.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Main method to test the getIntersectionNode functionality.
     */
    public static void main(String[] args) {
        // --- Test Case 1: Lists that intersect ---
        // Create the common part of the lists
        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);

        // Create list A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commonNode;

        // Create list B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;

        System.out.println("--- Test Case 1: Intersecting Lists ---");
        ListNode intersection = getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("The lists intersect at node with value: " + intersection.val); // Expected: 8
        } else {
            System.out.println("The lists do not intersect.");
        }

        // --- Test Case 2: Lists that do not intersect ---
        // Create list C: 2 -> 6 -> 4
        ListNode headC = new ListNode(2);
        headC.next = new ListNode(6);
        headC.next.next = new ListNode(4);

        // Create list D: 1 -> 5
        ListNode headD = new ListNode(1);
        headD.next = new ListNode(5);

        System.out.println("\n--- Test Case 2: Non-Intersecting Lists ---");
        ListNode noIntersection = getIntersectionNode(headC, headD);
        if (noIntersection != null) {
            System.out.println("The lists intersect at node with value: " + noIntersection.val);
        } else {
            System.out.println("The lists do not intersect."); // Expected: The lists do not intersect.
        }
    }

    /**
     * Finds the node at which the intersection of two singly linked lists begins.
     * This method uses a clever two-pointer approach that is both time and space efficient.
     *
     * @param headA The head of the first linked list.
     * @param headB The head of the second linked list.
     * @return The intersecting node, or null if there is no intersection.
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case: if either list is empty, they can't intersect.
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers to the heads of the lists.
        ListNode pA = headA;
        ListNode pB = headB;

        // The loop will continue until the two pointers are equal.
        // This will be either the intersection node or null.
        while (pA != pB) {
            // When pointer pA reaches the end of its list, redirect it to the head of list B.
            // Otherwise, move it to the next node.
            pA = (pA == null) ? headB : pA.next;

            // When pointer pB reaches the end of its list, redirect it to the head of list A.
            // Otherwise, move it to the next node.
            pB = (pB == null) ? headA : pB.next;
        }

        // By the time the pointers meet, they will have traveled the same distance.
        // If the lists intersect, they will meet at the intersection node.
        // If they don't intersect, they will both be null when they meet,
        // because they will both have traversed listA + listB.
        return pA; // or pB, since they are equal
    }
}
