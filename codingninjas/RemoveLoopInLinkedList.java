package codingninjas;

//Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).
//
//Custom Input format:
//
//A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.
//
//The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.
//
//Examples:
//
//Input: head = 1 -> 3 -> 4, pos = 2
//Output: true
//Explanation: The linked list looks like
//
//A loop is present in the list, and it is removed.
//Input: head = 1 -> 8 -> 3 -> 4, pos = 0
//Output: true
//Explanation:
//
//The Linked list does not contains any loop.
//Input: head = 1 -> 2 -> 3 -> 4, pos = 1
//Output: true
//Explanation: The linked list looks like
//
//A loop is present in the list, and it is removed.
//Constraints:
//        1 ≤ size of linked list ≤ 105




public class RemoveLoopInLinkedList {
    public static Node removeLoop(Node head) {
        // Write your code here.
        if(head==null)
            return head;
        Node fast=head,slow=head;
        Node prev=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
            if(slow==fast){
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    prev=slow;
                    slow=slow.next;
                }
                if(prev!=null)
                    prev.next=null;
                break;
            }
        }
        return head;
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=head.next.next;
        Node res=removeLoop(head);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
