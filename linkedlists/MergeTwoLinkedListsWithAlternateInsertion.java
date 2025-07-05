package linkedlists;

// Problem Statement:
// You are given two LinkedList of length ‘N’. Your task is to insert the
// elements of the second LinkedList in the first LinkedList at the alternate
// positions.
//
// For example: Let 1 -> 3 -> 5 be the first LinkedList and 2 -> 4 -> 6 be
// the second LinkedList. Then after merging the first LinkedList will look
// like 1 -> 2 -> 3 -> 4 -> 5 -> 6.

// Input Format:
// First-line contains ‘T’, denoting the number of Test cases.
// For each Test case:
// The first line contains an integer, ‘N’.
// The following line contains ‘N + 1’ space-separated integers, which are the
// nodes of the first LinkedList, and each line ends with -1 to indicate that
// the LinkedList is over. Thus, -1 will never be a LinkedList element.
// The following line contains ‘N + 1’ space-separated integers, which are the
// nodes of the second LinkedList, and each line ends with -1 to indicate that
// the LinkedList is over. Thus, -1 will never be a LinkedList element.

// Output Format:
// For each test case, you have to print the modified first LinkedList,

// Note:
// You don’t need to print or return anything. Just implement the given
// function and modify the first LinkedList.

// Constraints:
// 1 <= ‘T’ <= 10
// 1 <= ‘N’ <= 10^5
// All the elements in both of the LinkedList lie in the range [-10^9, 10^9] -
// {1}.
// Note- the sum of ‘N’ over all test cases does not exceed 10^5.
//
// Time Limit: 1 sec

// Sample Input-1:
// 2
// 3
// 1 3 5 -1
// 2 4 6 -1
// 1
// 3 -1
// 6 -1

// Sample Output-1:
// 1 2 3 4 5 6
// 3 6

// Sample Input -2:
// 2
// 3
// 1 2 3 -1
// -5 -2 -3 -1
// 3
// 24 42 13 -1
// 91 42 13 -1

// Sample Output -2:
// 1 -5 2 -2 3 -3
// 24 91 42 42 13 13

import java.util.Scanner;



public class MergeTwoLinkedListsWithAlternateInsertion {
    static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public static void merge(Node head1, Node head2) {
            Node first = head1, second = head2;
            Node f_next = null, s_next = null;

            // Solving for each node in LinkedList.
            while (first != null && second != null) {
                // Storing the next pointers.
                f_next = first.next;
                s_next = second.next;

                // Inserting the node of the second LinkedList in the first LinkedList.
                second.next = f_next;
                first.next = second;

                // Updating references.
                first = f_next;
                second = s_next;
            }
            if (first == null) {
                first = head1;
                while (first != null && first.next != null) {
                    first = first.next;
                }
                if (first != null)
                    first.next = second;
            }
        }

        public static void printLinkedList(Node head) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Static Input for testing
            int T = 2;

            // Test Case 1
            int N1 = 3;
            Node head1_1 = new Node(1);
            head1_1.next = new Node(3);
            head1_1.next.next = new Node(5);

            Node head2_1 = new Node(2);
            head2_1.next = new Node(4);
            head2_1.next.next = new Node(6);

            // Test Case 2
            int N2 = 1;
            Node head1_2 = new Node(3);

            Node head2_2 = new Node(6);

            // Run the test cases
            System.out.println("Test Case 1:");
            merge(head1_1, head2_1);
            printLinkedList(head1_1); // Expected Output: 1 2 3 4 5 6

            System.out.println("Test Case 2:");
            merge(head1_2, head2_2);
            printLinkedList(head1_2); // Expected Output: 3 6

        }
    }
}
