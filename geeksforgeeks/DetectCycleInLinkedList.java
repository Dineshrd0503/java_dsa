package geeksforgeeks;

//You are given the head of a singly linked list. Your task is to determine if the linked list contains a loop. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.
//
//Custom Input format:
//A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.
//
//        Examples:
//
//Input: head: 1 -> 3 -> 4, pos = 2
//Output: true
//Explanation: There exists a loop as last node is connected back to the second node.
//
//Input: head: 1 -> 8 -> 3 -> 4, pos = 0
//Output: false
//Explanation: There exists no loop in given linked list.
//
//Input: head: 1 -> 2 -> 3 -> 4, pos = 1
//Output: true
//Explanation: There exists a loop as last node is connected back to the first node.
//
//
//Constraints:
//        1 ≤ number of nodes ≤ 104
//        1 ≤ node->data ≤ 103
//        0 ≤ pos ≤ Number of nodes in Linked List

public class DetectCycleInLinkedList {
    public static boolean detectLoop(Node head) {
        // Add code here\
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;
        System.out.println(detectLoop(head)); // Output: true
    }
}
