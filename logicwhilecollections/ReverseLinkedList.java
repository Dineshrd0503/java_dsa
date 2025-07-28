package logicwhilecollections;

//Complete the code.

// Linked List Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    /**
     *  Problem Statement:
     *  Given the head of a linked list, the task is to reverse this list and return the reversed head.
     *
     *  Examples:
     *  Input: head: 1 -> 2 -> 3 -> 4 -> NULL
     *  Output: head: 4 -> 3 -> 2 -> 1 -> NULL
     *  Explanation:
     *  (See the image in the problem description for visual explanations)
     *
     *  Input: head: 2 -> 7 -> 10 -> 9 -> 8 -> NULL
     *  Output: head: 8 -> 9 -> 10 -> 7 -> 2 -> NULL
     *  Explanation:
     *  (See the image in the problem description for visual explanations)
     *
     *  Input: head: 2 -> NULL
     *  Output: 2 -> NULL
     *  Explanation:
     *  (See the image in the problem description for visual explanations)
     *
     *  Constraints:
     *  1 <= number of nodes, data of nodes <= 10^5
     *
     *  Expected Time Complexity: O(n)
     *  Expected Auxiliary Space: O(1)
     *
     *  Sample Test Cases:
     *  Input 1: 1 2 3 4
     *  Output 1: 4 3 2 1
     *
     *  Input 2: 2 7 10 9 8
     *  Output 2: 8 9 10 7 2
     *
     *  Input 3: 2
     *  Output 3: 2
     *
     * Reverses a linked list.
     *
     * @param head The head of the linked list to reverse.
     * @return The new head of the reversed linked list.
     */
    Node reverseList(Node head) {
        // code here

        //Iterative Approach:
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current;      // Move pointers one position ahead
            current = next;
        }

        head = prev; // Update head to the last node, which is the new head
        return head;
    }
/*
    //Recursive Approach
    Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
*/ }

//Example usage of linked list reverse
public class ReverseLinkedList {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        Solution solution = new Solution();
        Node reversedHead = solution.reverseList(head);

        System.out.println("\nReversed Linked List:");
        printList(reversedHead);
    }

    // Utility method to print a linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


}