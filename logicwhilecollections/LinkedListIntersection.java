package logicwhilecollections;

import java.util.HashSet;

// Definition for singly-linked list.




    /**
     * Given two linked lists head1 and head2, find the intersection of two linked lists.
     * Each of the two linked lists contains distinct node values.
     *
     * Note: The order of nodes in this list should be the same as the order
     * in which those particular nodes appear in input head1 and return null if no
     * common element is present.
     *
     * Examples:
     *
     * Input: LinkedList1: 9->6->4->2->3->8 , LinkedList2: 1->2->8->6
     * Output: 6->2->8
     * Explanation: Nodes 6, 2 and 8 are common in both of the lists and the order
     *              will be according to LinkedList1.
     *
     * Input: LinkedList1: 5->3->1->13->14 , LinkedList2: 3->13
     * Output: 3->13
     * Explanation: Nodes 3 and 13 are common in both of the lists and the order
     *              will be according to LinkedList1.
     *
     * Expected time complexity: O(m+n)
     * Expected auxiliary space: O(m+n)
     *
     * Constraints:
     * 1 <= no. of nodes in head1, head2 <= 10^4
     * 1 <= node->data <= 10^5
     */
    public class LinkedListIntersection {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public Node findIntersection(Node head1, Node head2) {
        // add your code here
        HashSet<Integer> set=new HashSet<>();
        for(Node temp=head2;temp!=null;temp=temp.next) {
            set.add(temp.data);
        }
        Node dummy=new Node(-1);
        Node newhead=dummy;
        Node temp=head1;

        while(temp!=null){
            if(set.contains(temp.data)){
                Node newnode=new Node(temp.data);
                newhead.next=newnode;
                newhead=newnode;
            }
            temp=temp.next;
        }

        return dummy.next;
    }




    public static void main(String[] args) {

        // Test case 1
        Node head1 = createLinkedList(new int[]{9, 6, 4, 2, 3, 8});
        Node head2 = createLinkedList(new int[]{1, 2, 8, 6});

        LinkedListIntersection solution = new LinkedListIntersection();
        Node intersection = solution.findIntersection(head1, head2);

        System.out.print("Intersection: ");
        printLinkedList(intersection); // Expected: 6->2->8

        // Test case 2
        head1 = createLinkedList(new int[]{5, 3, 1, 13, 14});
        head2 = createLinkedList(new int[]{3, 13});

        intersection = solution.findIntersection(head1, head2);

        System.out.print("Intersection: ");
        printLinkedList(intersection); // Expected: 3->13

        //Test case 3: No Intersection

        head1= createLinkedList(new int[]{1, 2, 3});
        head2= createLinkedList(new int[]{4,5,6});

        intersection = solution.findIntersection(head1, head2);

        System.out.print("Intersection: ");
        printLinkedList(intersection); // expected: null

        // Test case 4: Empty Linked list

        head1= createLinkedList(new int[]{});
        head2= createLinkedList(new int[]{4,5,6});

        intersection = solution.findIntersection(head1, head2);

        System.out.print("Intersection: ");
        printLinkedList(intersection); // expected: null


        // Test case 5: Single node intersection

        head1 = createLinkedList(new int[]{1});
        head2 = createLinkedList(new int[]{1});
        intersection = solution.findIntersection(head1, head2);

        System.out.print("Intersection: ");
        printLinkedList(intersection); // Expected: 1

    }

    // Helper function to create linked list from an array
    static Node createLinkedList(int[] arr) {
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

    // Helper function to print linked list
    static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
    }
