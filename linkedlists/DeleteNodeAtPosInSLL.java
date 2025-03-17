package linkedlists;

//Given a singly linked list and an integer, x. Delete the xth node (1-based indexing) from the singly linked list.
//
//Examples:
//
//Input: Linked list: 1 -> 3 -> 4, x = 3
//Output: 1 -> 3
//
//Explanation: After deleting the node at the 3rd position (1-base indexing), the linked list is as 1 -> 3.
//Input: Linked list: 1 -> 5 -> 2 -> 9, x = 2
//Output: 1 -> 2 -> 9
//Explanation: After deleting the node at 2nd position (1-based indexing), the linked list is as 1 -> 2 -> 9.
//Constraints:
//        2 <= size of linked list <= 106
//        1 <= x <= size of linked list


public class DeleteNodeAtPosInSLL {
    Node deleteNode(Node head, int x) {
        // code here
        if(x==1)
            return head.next;
        Node temp=head;
        for(int i=1;i<x-1;i++)
            temp=temp.next;
        temp.next=temp.next.next;
        return head;
    }
    public static void main(String[] args) {
        System.out.println("delete node at position in singly linked list");
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        DeleteNodeAtPosInSLL obj=new DeleteNodeAtPosInSLL();
        Node res=obj.deleteNode(head,2);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
