package geeksforgeeks;

//Given a Doubly Linked list and a position. The task is to delete a node from a given position (position starts from 1) in a doubly linked list and return the head of the doubly Linked list.
//
//        Examples:
//
//Input: LinkedList = 1 <--> 3 <--> 4, x = 3
//Output: 1 <--> 3
//Explanation: After deleting the node at position 3 (position starts from 1),the linked list will be now as 1 <--> 3.
//
//Input: LinkedList = 1 <--> 5 <--> 2 <--> 9, x = 1
//Output: 5 <--> 2 <--> 9
//Explanation:
//
//Constraints:
//        2 <= size of the linked list <= 106
//        1 <= x <= size of the linked list
//1 <= node->data <= 104


public class DeleteANodeInDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public Node deleteNode(Node head, int k) {
        if(k==1){
            head=head.next;
            if(head!=null)
                head.prev=null;
            return head;
        }
        Node curr=head;
        int count=1;
        while(count<k&&curr!=null){
            count++;
            curr=curr.next;
        }
        if(curr==null)
            return head;
        if(curr.next!=null)
            curr.next.prev=curr.prev;
        if(curr.prev!=null)
            curr.prev.next=curr.next;
        return head;
    }
    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.prev=head;
        head.next.next=new Node(30);
        head.next.next.prev=head.next;
        head.next.next.next=new Node(40);
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next=new Node(50);
        head.next.next.next.next.prev=head.next.next.next;
        DeleteANodeInDLL obj=new DeleteANodeInDLL();
        Node res=obj.deleteNode(head,3);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
