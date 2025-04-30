package linkedlists;

// Problem Statement:
// Given the head of a linked list, determine whether the list contains a loop. If a loop is present,
// return the number of nodes in the loop, otherwise return 0.
//
// Note: 'c' is the position of the node which is the next pointer of the last node of the linked list.
// If c is 0, then there is no loop.
//
// Sample Test Cases:
// Input: head: 1 → 2 → 3 → 4 → 5, c = 2
// Output: 4
// Explanation: There exists a loop in the linked list and the length of the loop is 4.
//
// Input: head: 25 → 14 → 19 → 33 → 10 → 21 → 39 → 90 → 58 → 45, c = 4
// Output: 7
// Explanation: The loop is from 33 to 45. So length of loop is 33 → 10 → 21 → 39 → 90 → 58 → 45 = 7.
//
// Input: head: 0 → 1 → 2 → 3, c = 0
// Output: 0
// Explanation: There is no loop.




public class LengthOfCycleInLL {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // If head is null or there's only one element, there's no loop
        if (head == null || head.next == null) {
            return 0;
        }

        Node slow = head; // Tortoise
        Node fast = head; // Hare

        // Detect if a loop exists using the Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow by 1
            fast = fast.next.next;   // Move fast by 2

            // If slow and fast meet, there's a loop
            if (slow == fast) {
                // Count the number of nodes in the loop
                int count = 1;
                Node current = slow.next;
                while (current != slow) {
                    count++;
                    current = current.next;
                }
                return count; // Return the number of nodes in the loop
            }
        }
        // No loop found
        return 0;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Creating a linked list for testing
        LengthOfCycleInLL solution = new LengthOfCycleInLL();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop for the first test case
        head.next.next.next.next.next = head.next; // creating a loop back to node 2

        int loopLength = solution.countNodesinLoop(head);
        System.out.println("Length of Loop: " + loopLength); // Should print 4

        // Creating a second linked list with a different loop
        Node head2 = new Node(25);
        head2.next = new Node(14);
        head2.next.next = new Node(19);
        head2.next.next.next = new Node(33);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(21);
        head2.next.next.next.next.next.next = new Node(39);
        head2.next.next.next.next.next.next.next = new Node(90);
        head2.next.next.next.next.next.next.next.next = new Node(58);
        head2.next.next.next.next.next.next.next.next.next = new Node(45);

        // Creating a loop for the second test case
        head2.next.next.next.next.next.next.next.next.next.next = head2.next.next.next.next; // creating a loop back to node 10

        loopLength = solution.countNodesinLoop(head2);
        System.out.println("Length of Loop: " + loopLength); // Should print 7

        // Creating a third linked list without a loop
        Node head3 = new Node(0);
        head3.next = new Node(1);
        head3.next.next = new Node(2);
        head3.next.next.next = new Node(3);

        loopLength = solution.countNodesinLoop(head3);
        System.out.println("Length of Loop: " + loopLength); // Should print 0
    }
}