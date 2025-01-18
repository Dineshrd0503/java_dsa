package geeksforgeeks;

//Given the head of a linked list, the task is to reverse this list and return the reversed head.
//
//        Examples:
//
//Input: head: 1 -> 2 -> 3 -> 4 -> NULL
//Output: head: 4 -> 3 -> 2 -> 1 -> NULL
//nput: head: 2 -> NULL
//Output: 2 -> NULL
//Explanation:

public class ReverseLinkedList {
    Node reverseList(Node head) {
        Node temp=null;
        Node next;
        while(head!=null){
            next=head.next;
            if(head==null){
                temp=head;
                temp.next=null;
            }
            else{
                head.next=temp;
                temp=head;
            }
            head=next;
        }
        return temp;
        // code here

    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        ReverseLinkedList obj=new ReverseLinkedList();
        Node res=obj.reverseList(head);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
