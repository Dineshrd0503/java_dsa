package slidingwindow;

/*
Problem Statement:
Given the head of a Singly Linked List and an index, the task is to find the node at the given index (1-based index) of the linked list.
If no such index exists, then return -1.

Input:
- head: The head node of the singly linked list.
- index: The 1-based index of the node to find (index >= 1).

Output:
- Return the value (data) of the node at the given index.
- If the index does not exist (i.e., the list is shorter than the index), return -1.

Constraints:
- The list can be empty (head == null).
- Index is a positive integer (1-based).
- Node values are integers.

Sample Test Cases:

Test Case 1:
Input: List = 1 -> 2 -> 3 -> 4, index = 2
Output: 2
Explanation: The node at 1-based index 2 is 2 (list: 1 -> 2 -> 3 -> 4).

Test Case 2:
Input: List = 1 -> 2, index = 3
Output: -1
Explanation: The list has only 2 nodes, so index 3 does not exist.

Test Case 3:
Input: List = 1 -> 2 -> 3, index = 3
Output: 3
Explanation: The node at 1-based index 3 is 3 (list: 1 -> 2 -> 3).

Test Case 4:
Input: List = null (empty list), index = 1
Output: -1
Explanation: The list is empty, so index 1 does not exist.

Test Case 5:
Input: List = 1 -> 2 -> 3, index = 0
Output: -1
Explanation: Index 0 is invalid for 1-based indexing.
*/

public class GetNodeAtIndex {
    // Static nested Node class
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    public int GetNth(Node head, int index) {
        // Step 1: Handle invalid index (1-based, so index must be positive)
        if (index <= 0) {
            return -1;
        }

        // Step 2: Handle empty list
        if (head == null) {
            return -1;
        }

        // Step 3: Traverse the list to find the index-th node
        Node temp = head;
        int count = 1;

        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            count++;
            temp = temp.next;
        }

        // Step 4: If index is not found (list is too short), return -1
        return -1;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Create an instance of GetNodeAtIndex to call GetNth
        GetNodeAtIndex solution = new GetNodeAtIndex();

        // Test cases
        int index1 = 2;
        int result1 = solution.GetNth(head, index1);
        System.out.println("Value at index " + index1 + ": " + result1);

        int index2 = 5;
        int result2 = solution.GetNth(head, index2);
        System.out.println("Value at index " + index2 + ": " + result2);

        int index3 = 0;
        int result3 = solution.GetNth(head, index3);
        System.out.println("Value at index " + index3 + ": " + result3);

        // Test with empty list
        Node emptyHead = null;
        int index4 = 1;
        int result4 = solution.GetNth(emptyHead, index4);
        System.out.println("Value at index " + index4 + " (empty list): " + result4);
    }
}