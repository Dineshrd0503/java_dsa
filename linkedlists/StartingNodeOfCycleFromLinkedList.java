package linkedlists;

/**
 * Problem Statement:
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle,
 * return null. A cycle exists if following the next pointer leads back to a previously visited node.
 * Internally, pos denotes the index (0-based) where the tail connects, or -1 if no cycle. Note that
 * pos is not passed as a parameter. The solution must not modify the linked list and should use
 * O(1) memory.
 *
 * Examples:
 * - Input: [3,2,0,-4], pos = 1 -> Output: Node with value 2 (cycle starts at index 1)
 * - Input: [1,2], pos = 0 -> Output: Node with value 1 (cycle starts at index 0)
 * - Input: [1], pos = -1 -> Output: null (no cycle)
 *
 * Constraints:
 * - Number of nodes: 0 to 10^4
 * - Node values: -10^5 to 10^5
 * - pos is -1 or a valid index
 *
 * Date: 10:30 AM IST, Tuesday, July 29, 2025
 */

public class StartingNodeOfCycleFromLinkedList {
    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Detects the starting node of a cycle in a linked list using Floyd's Cycle-Finding Algorithm.
     *
     * @param head The head node of the linked list
     * @return The node where the cycle begins, or null if no cycle exists
     */
    public ListNode detectCycle(ListNode head) {
        // Handle edge cases: empty list or single node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head; // Moves 1 step at a time
        ListNode fast = head; // Moves 2 steps at a time

        // Phase 1: Detect if a cycle exists
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;              // Move slow pointer one step
            fast = fast.next.next;         // Move fast pointer two steps
            if (slow == fast) {            // If pointers meet, cycle detected
                hasCycle = true;
                break;
            }
        }

        // If no cycle, fast will reach null or fast.next will be null
        if (!hasCycle) {
            return null;
        }

        // Phase 2: Find the start of the cycle
        ListNode ptr1 = head; // Reset to head
        ListNode ptr2 = slow; // Start from meeting point
        while (ptr1 != ptr2) { // Move both pointers one step until they meet
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1; // Return the node where the cycle begins
    }

    /**
     * Main method to test the detectCycle method with static inputs.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        StartingNodeOfCycleFromLinkedList solution = new StartingNodeOfCycleFromLinkedList();
        // Test Case 1: [3,2,0,-4] with cycle at pos = 1 (node 2)
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Create cycle: -4 -> 2
        ListNode cycleStart1 = solution.detectCycle(head1);
        System.out.println("Test Case 1 - Cycle Start Value: " + (cycleStart1 != null ? cycleStart1.val : "null"));

        // Test Case 2: [1,2] with cycle at pos = 0 (node 1)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // Create cycle: 2 -> 1
        ListNode cycleStart2 = solution.detectCycle(head2);
        System.out.println("Test Case 2 - Cycle Start Value: " + (cycleStart2 != null ? cycleStart2.val : "null"));

        // Test Case 3: [1] with no cycle (pos = -1)
        ListNode head3 = new ListNode(1);
        ListNode cycleStart3 = solution.detectCycle(head3);
        System.out.println("Test Case 3 - Cycle Start Value: " + (cycleStart3 != null ? cycleStart3.val : "null"));

        // Test Case 4: [1,2] with no cycle (pos = -1)
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        ListNode cycleStart4 = solution.detectCycle(head4);
        System.out.println("Test Case 4 - Cycle Start Value: " + (cycleStart4 != null ? cycleStart4.val : "null"));
    }
}