package linkedlists;

/*
 * ========================================
 * PROBLEM STATEMENT
 * ========================================
 *
 * Intersection in Y Shaped Linked Lists
 *
 * You are given the heads of two non-empty singly linked lists, head1 and head2,
 * that intersect at a certain point. Return that Node where these two linked lists intersect.
 *
 * Note: It is guaranteed that the intersected node always exists.
 *
 * Example 1:
 * Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
 * Output: 15
 * Explanation: The common part is 15 -> 30, whose starting point is 15.
 *
 * Example 2:
 * Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
 * Output: 1
 * Explanation: The common part is 1 -> 8 -> 5, whose starting point is 1.
 *
 * Constraints:
 * - 2 ≤ total number of nodes ≤ 2*10^5
 * - -10^4 ≤ node->data ≤ 10^4
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */



public class IntersectionInYShapedLinkedLists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to find the intersection point in Y shaped linked lists
    public static Node intersectPoint(Node head1, Node head2) {
        // Calculate the length of both lists
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        // Initialize pointers for both lists
        Node ptr1 = head1;
        Node ptr2 = head2;

        // Move the pointer of the longer list ahead by the difference
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                ptr1 = ptr1.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                ptr2 = ptr2.next;
            }
        }

        // Move both pointers until they meet at the intersection point
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1; // This is the intersection point
    }

    // Helper method to calculate the length of a linked list
    private static int getLength(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Helper method to print the linked list
    public static void printList(Node head, String listName) {
        System.out.print(listName + ": ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method with static inputs
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Intersection in Y Shaped Linked Lists");
        System.out.println("========================================\n");

        // TEST CASE 1:
        // head1: 10 -> 15 -> 30
        // head2: 3 -> 6 -> 9 -> 15 -> 30
        // Expected Output: 15
        System.out.println("TEST CASE 1:");
        Node common1 = new Node(15);
        common1.next = new Node(30);

        Node head1_case1 = new Node(10);
        head1_case1.next = common1;

        Node head2_case1 = new Node(3);
        head2_case1.next = new Node(6);
        head2_case1.next.next = new Node(9);
        head2_case1.next.next.next = common1;

        printList(head1_case1, "Head1");
        printList(head2_case1, "Head2");

        Node result1 = intersectPoint(head1_case1, head2_case1);
        System.out.println("Output: " + result1.data);
        System.out.println("Expected: 15");
        System.out.println();

        // TEST CASE 2:
        // head1: 4 -> 1 -> 8 -> 5
        // head2: 5 -> 6 -> 1 -> 8 -> 5
        // Expected Output: 1
        System.out.println("TEST CASE 2:");
        Node common2 = new Node(1);
        common2.next = new Node(8);
        common2.next.next = new Node(5);

        Node head1_case2 = new Node(4);
        head1_case2.next = common2;

        Node head2_case2 = new Node(5);
        head2_case2.next = new Node(6);
        head2_case2.next.next = common2;

        printList(head1_case2, "Head1");
        printList(head2_case2, "Head2");

        Node result2 = intersectPoint(head1_case2, head2_case2);
        System.out.println("Output: " + result2.data);
        System.out.println("Expected: 1");
        System.out.println();

        // TEST CASE 3:
        // head1: 2 -> 3 -> 7
        // head2: 4 -> 7
        // Expected Output: 7
        System.out.println("TEST CASE 3:");
        Node common3 = new Node(7);

        Node head1_case3 = new Node(2);
        head1_case3.next = new Node(3);
        head1_case3.next.next = common3;

        Node head2_case3 = new Node(4);
        head2_case3.next = common3;

        printList(head1_case3, "Head1");
        printList(head2_case3, "Head2");

        Node result3 = intersectPoint(head1_case3, head2_case3);
        System.out.println("Output: " + result3.data);
        System.out.println("Expected: 7");
        System.out.println();

        System.out.println("========================================");
        System.out.println("All test cases completed!");
        System.out.println("========================================");
    }
}
