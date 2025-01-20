package geeksforgeeks;

//Given the heads of two sorted linked lists, merge them into one sorted linked list. The merged linked list should be made by splicing together the nodes of the two given lists.
//      input:
//        1 -> 3 -> 5 -> 7 -> 9
//        2 -> 4 -> 6 -> 8 -> 10
//       output:
//
//1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10


public class MergeSortedLinkedLists {
    public static Node mergeLists(Node head1,Node head2){
        Node t1=head1;
        Node t2=head2;
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                temp.next=t1;
                temp=t1;
                t1=t1.next;
            }
            else{
                temp.next=t2;
                temp=t2;
                t2=t2.next;
            }
        }
        if(t1!=null)
            temp.next=t1;
        else
            temp.next=t2;
        return dummy.next;
    }
    public static void main(String[] args) {
        Node head1=new Node(1);
        head1.next=new Node(3);
        head1.next.next=new Node(5);
        head1.next.next.next=new Node(7);
        head1.next.next.next.next=new Node(9);
        Node head2=new Node(2);
        head2.next=new Node(4);
        head2.next.next=new Node(6);
        head2.next.next.next=new Node(8);
        head2.next.next.next.next=new Node(10);
        Node head=mergeLists(head1,head2);
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

}
