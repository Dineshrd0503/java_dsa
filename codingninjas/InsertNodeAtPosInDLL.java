package codingninjas;

public class InsertNodeAtPosInDLL {
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
    static Node insert(int k, int val, Node head) {
        // Write your code here.
        Node newnode=new Node(val);
        if(k==0){
            newnode.next=head;
            if(head!=null)
                head.prev=newnode;
            return newnode;
        }

        int count=0;
        Node curr=head;
        while(count<k-1&&curr!=null){
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
    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.prev=head;
        head.next.next=new Node(30);
        head.next.next.prev=head.next;
        head.next.next.next=new Node(40);
        head.next.next.next.prev=head.next.next;
        head=insert(2,25,head);
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
    }


}
