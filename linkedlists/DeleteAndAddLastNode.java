package linkedlists;

/**
 * ============================================================================
 * PROBLEM: Deleting and Adding the Last Node
 * ============================================================================
 *
 * Problem Statement:
 * You are provided with a singly linked list, all you have to do is to delete
 * the last node of the linked list and add it to the front of the linked list.
 *
 * Example:
 * Given Linked List: 2 -> 5 -> 3 -> 11 -> 1
 * After Deleting Last Node: 2 -> 5 -> 3 -> 11
 * After Adding Last Node to Front: 1 -> 2 -> 5 -> 3 -> 11
 *
 * Note: The linked list will only contain numeric values.
 *
 * Constraints:
 * - 1 <= T <= 10 (Number of test cases)
 * - 0 <= N <= 10000 (Number of nodes)
 * - -10^4 <= LIST[i] <= 10^4 (Node values)
 * - Time limit: 1 sec
 *
 * Sample Input 1:
 * 2
 * 2 5 3 11 1 -1
 * 2 -1
 *
 * Sample Output 1:
 * 1 2 5 3 11 -1
 * 2 -1
 *
 * Explanation:
 * Test Case 1: The new linked list after delete and add: 1 2 5 3 11
 * Test Case 2: Single node list remains the same: 2
 *
 * ============================================================================
 */

public class DeleteAndAddLastNode {

    /**
     * Node class representing a single node in the linked list
     */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Solution: Delete the last node and add it to the front
     *
     * Algorithm:
     * 1. Handle edge cases (empty list or single node)
     * 2. Find the second-last node using temp.next.next approach
     * 3. Extract the last node and remove it from the end
     * 4. Add the last node to the front
     * 5. Update and return the new head
     *
     * Time Complexity: O(n) - single pass through the list
     * Space Complexity: O(1) - only using pointers
     *
     * @param head - head of the linked list
     * @return - new head of the modified linked list
     */
    public static Node delAddLastNode(Node head) {
        // Edge case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Find the second last node
        // We use temp.next.next to stop at the second last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // temp.next is the last node
        Node lastNode = temp.next;

        // Remove the last node from the end
        temp.next = null;

        // Add the last node to the front
        lastNode.next = head;
        head = lastNode;

        return head;
    }

    /**
     * Helper method: Create a linked list from an array of integers
     *
     * @param arr - array of integers
     * @return - head of the created linked list
     */
    public static Node createLinkedList(int[] arr) {
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

    /**
     * Helper method: Print the linked list
     *
     * @param head - head of the linked list
     */
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Main method with multiple test cases
     */
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Delete and Add Last Node - Solution");
        System.out.println("========================================\n");

        // Test Case 1: Regular linked list with 5 nodes
        System.out.println("Test Case 1: Regular Linked List");
        System.out.println("Input:  2 -> 5 -> 3 -> 11 -> 1");
        int[] arr1 = {2, 5, 3, 11, 1};
        Node head1 = createLinkedList(arr1);
        System.out.print("Before: ");
        printLinkedList(head1);
        head1 = delAddLastNode(head1);
        System.out.print("After:  ");
        printLinkedList(head1);
        System.out.println("Expected: 1 -> 2 -> 5 -> 3 -> 11 -> null");
        System.out.println();

        // Test Case 2: Single node linked list
        System.out.println("Test Case 2: Single Node");
        System.out.println("Input:  2");
        int[] arr2 = {2};
        Node head2 = createLinkedList(arr2);
        System.out.print("Before: ");
        printLinkedList(head2);
        head2 = delAddLastNode(head2);
        System.out.print("After:  ");
        printLinkedList(head2);
        System.out.println("Expected: 2 -> null");
        System.out.println();

        // Test Case 3: Two nodes linked list
        System.out.println("Test Case 3: Two Nodes");
        System.out.println("Input:  4 -> 3");
        int[] arr3 = {4, 3};
        Node head3 = createLinkedList(arr3);
        System.out.print("Before: ");
        printLinkedList(head3);
        head3 = delAddLastNode(head3);
        System.out.print("After:  ");
        printLinkedList(head3);
        System.out.println("Expected: 3 -> 4 -> null");
        System.out.println();

        // Test Case 4: Linked list with negative numbers
        System.out.println("Test Case 4: Negative Numbers");
        System.out.println("Input:  -5 -> -10 -> -15");
        int[] arr4 = {-5, -10, -15};
        Node head4 = createLinkedList(arr4);
        System.out.print("Before: ");
        printLinkedList(head4);
        head4 = delAddLastNode(head4);
        System.out.print("After:  ");
        printLinkedList(head4);
        System.out.println("Expected: -15 -> -5 -> -10 -> null");
        System.out.println();

        // Test Case 5: Larger linked list
        System.out.println("Test Case 5: Larger List (6 nodes)");
        System.out.println("Input:  10 -> 20 -> 30 -> 40 -> 50 -> 60");
        int[] arr5 = {10, 20, 30, 40, 50, 60};
        Node head5 = createLinkedList(arr5);
        System.out.print("Before: ");
        printLinkedList(head5);
        head5 = delAddLastNode(head5);
        System.out.print("After:  ");
        printLinkedList(head5);
        System.out.println("Expected: 60 -> 10 -> 20 -> 30 -> 40 -> 50 -> null");
        System.out.println();

        // Test Case 6: Empty list (edge case)
        System.out.println("Test Case 6: Empty List");
        Node head6 = null;
        System.out.print("Before: ");
        printLinkedList(head6);
        head6 = delAddLastNode(head6);
        System.out.print("After:  ");
        printLinkedList(head6);
        System.out.println("Expected: null");
        System.out.println();

        System.out.println("========================================");
        System.out.println("All Test Cases Completed!");
        System.out.println("========================================");
    }
}
