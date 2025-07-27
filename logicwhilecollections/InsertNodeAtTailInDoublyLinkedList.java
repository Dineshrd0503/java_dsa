package logicwhilecollections;

/*
Problem Statement:
A doubly-linked list is a data structure that consists of sequentially linked nodes,
and the nodes have references to both the previous and the next nodes in the sequence of nodes.

Given a doubly-linked list and a value ‘k’, insert a node having value ‘k’ at the end of the doubly linked list.

Note:
You need not print anything. You’re given the head of the linked list. Return the head of the modified list.

Example:
Input: Linked List: 4 <-> 10 <-> 3 <-> 5 and ‘k’ = 20
Output: Modified Linked List: 4 <-> 10 <-> 3 <-> 5 <-> 20
Explanation: A new node having value ‘k’ = 20 is inserted at the end of the linked list.

Input Format: The first line contains an integer ‘N’, the number of elements initially in the linked list.
The next line contains ‘N’ numbers, the linked list. The third line contains an integer ‘k’, the value to be added.

Output format: Return the head of the modified linked list.

Sample Input 1:
4
4 10 3 5
20

Sample Output 1:
4 10 3 5 20

Explanation Of Sample Input 1 : A new node having value ‘k’ = 20 is inserted at the end of the linked list.

Sample Input 2 :
0
5

Sample Output 2 :
5

Explanation Of Sample Input 2 : The linked list was empty. So the new node is the only node in the modified linked list.

Expected time complexity: The expected time complexity is O(N).

Constraints:
0 <= ‘N’ <= 100000
1 <= Value in linked list <= 10^9
1 <= ‘k’ <= 10^9
Time limit: 1 second
*/

// Definition of the Node class for a doubly linked list

public class InsertNodeAtTailInDoublyLinkedList {
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node
        Node prev; // Pointer to the previous node

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to insert a node at the end of a doubly linked list
    public static Node insertAtTail(Node head, int k) {
        // Create a new node with the given data
        Node newnode = new Node(k);

        // If the list is empty, make the new node the head
        if (head == null) {
            newnode.prev = null;
            newnode.next = null;
            return newnode; // Return the new node as the head
        }

        // Traverse to the end of the list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Insert the new node at the end
        newnode.prev = temp;
        newnode.next = null;
        temp.next = newnode; // Link the last node to the new node

        // Return the head of the list
        return head;
    }

    // Main method (for testing purposes)
    public static void main(String[] args) {
        // Example usage:  Create a doubly linked list: 4 <-> 10 <-> 3 <-> 5
        Node head = new Node(4);
        head.next = new Node(10);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;

        // Insert a new node with data 20 at the end
        int k = 20;
        head = insertAtTail(head, k);

        // Print the modified linked list: 4 <-> 10 <-> 3 <-> 5 <-> 20
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}