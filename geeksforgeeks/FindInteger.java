package geeksforgeeks;

//Given a singly linked list and a key, count the number of occurrences of the given key in the linked list.
//
//Examples:
//
//Input: Linked List: 1->2->1->2->1->3->1, key = 1
//
//Output: 4
//Explanation: 1 appears 4 times.
//        Input: Linked List: 1->2->1->2->1, key = 3
//
//Output: 0
//Explanation: 3 appears 0 times.

public class FindInteger {
    public static int count(Node head, int key) {
        int count=0;
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==key)
                count+=1;
        }
        return count;
        // code here
    }
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        System.out.println(count(head, 2)); // Output: 2
    }
}
