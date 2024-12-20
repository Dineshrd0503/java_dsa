package linkedlists;
//ou are given a linked list having ‘n’ nodes and an integer ‘k’.
//
//
//
//You have to rotate the linked list to the right by ‘k’ positions .
//
//
//
//        Example :
//Input: linked list = [1 2 3 4] , k = 2
//
//Output: 3 4 1 2
//
//Explanation:
//We have to rotate the given linked list to the right 2 times. After rotating it to the right once it becomes 4->1->2->3. After rotating it to the right again, it becomes 3->4->1->2.
public class RotateLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;

        }
    }

    public static Node rotate(Node head, int k) {
        if(head==null||head.next==null||k==0)
            return head;
        Node current=head;
        int length=1;
        while(current.next!=null){
            current=current.next;
            length++;
        }
        k=k%length;
        if(k==0)
            return head;
        current.next=head;
        int tailindex=length-k;
        Node newtail=head;
        for(int i=1;i<tailindex;i++)
            newtail=newtail.next;
        Node newhead=newtail.next;
        newtail.next=null;
        return newhead;

        // Write your code here.
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;
        Node rotatedHead = rotate(head, k);

        System.out.println("Rotated Linked List:");
        while (rotatedHead!= null) {
            System.out.print(rotatedHead.data + " ");
            rotatedHead = rotatedHead.next;
        }

    }

}
