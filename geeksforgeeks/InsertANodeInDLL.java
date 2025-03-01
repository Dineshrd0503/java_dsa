package geeksforgeeks;

//Given a doubly-linked list, a position p, and an integer x. The task is to add a new node with value x at the position just after pth node in the doubly linked list and return the head of the updated list.
//
//Examples:
//
//Input: LinkedList: 2<->4<->5, p = 2, x = 6
//Output: 2<->4<->5<->6
//Explanation: p = 2, and x = 6. So, 6 is inserted after p, i.e, at position 2 (0-based indexing).
//Input: LinkedList: 1<->2<->3<->4, p = 0, x = 44
//Output: 1<->44<->2<->3<->4
//Explanation: p = 0, and x = 44 . So, 44 is inserted after p, i.e, at position 0 (0-based indexing).
//Constraints:
//        0 <= p < size of doubly linked list <= 106
//        1 <= x <= 106



public class InsertANodeInDLL {
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node newnode=new Node(x);
        if(p==0){
            head.next=newnode;
            if(head!=null)
                head.prev=newnode;
            return newnode;
        }
        Node curr=head;
        int count=0;
        while(count<p&&curr!=null){
            count++;
            curr=curr.next;
        }
        if(curr==null)
            return head;
        newnode.next=curr.next;


        newnode.prev=curr;
        curr.next=newnode;
        if(newnode.next!=null)
            newnode.next.prev=newnode;
        return head;

    }
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
    public static void main(String[] args) {
        System.out.println("insert a node in doubly linked list");
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.prev=head;
        head.next.next=new Node(30);
        head.next.next.prev=head.next;
        head.next.next.next=new Node(40);
        head.next.next.next.prev=head.next.next;
        InsertANodeInDLL obj=new InsertANodeInDLL();
        Node res=obj.addNode(head,2,25);
        Node temp=res;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
