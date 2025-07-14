package linkedlists;

/*
Problem Statement:
Given a singly-linked list where each node's value is either 0 or 1, representing the binary digits
of a number, with the head node as the most significant bit, compute and return the decimal (base-10)
value of the number. For example:
- Input: head = [1,0,1] -> Binary: 101 -> Decimal: 5 (1*2^2 + 0*2^1 + 1*2^0 = 4 + 0 + 1 = 5).
- Input: head = [0] -> Binary: 0 -> Decimal: 0.
Constraints:
- The linked list is not empty.
- The number of nodes will not exceed 30.
- Each node's value is either 0 or 1.
*/



public class BinaryToDecimal {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    // Method to convert binary linked list to decimal value
    public static int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode current = head;

        // Traverse the list
        while (current != null) {
            // Shift result left (multiply by 2) and add current bit
            result = result * 2 + current.val;
            current = current.next;
        }

        return result;
    }

    // Utility method to create a linked list from an array
    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Utility method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: head = [1,0,1]
        int[] test1 = {1, 0, 1};
        System.out.println("Test Case 1:");
        System.out.print("Input: ");
        ListNode head1 = createList(test1);
        printList(head1);
        System.out.println("Output: " + getDecimalValue(head1));

        // Test Case 2: head = [0]
        int[] test2 = {0};
        System.out.println("\nTest Case 2:");
        System.out.print("Input: ");
        ListNode head2 = createList(test2);
        printList(head2);
        System.out.println("Output: " + getDecimalValue(head2));

        // Test Case 3: head = [1,0,0,1]
        int[] test3 = {1, 0, 0, 1};
        System.out.println("\nTest Case 3:");
        System.out.print("Input: ");
        ListNode head3 = createList(test3);
        printList(head3);
        System.out.println("Output: " + getDecimalValue(head3));

        // Test Case 4: head = [1,1,1,1]
        int[] test4 = {1, 1, 1, 1};
        System.out.println("\nTest Case 4:");
        System.out.print("Input: ");
        ListNode head4 = createList(test4);
        printList(head4);
        System.out.println("Output: " + getDecimalValue(head4));
    }
}
