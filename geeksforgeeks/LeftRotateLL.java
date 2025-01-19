package geeksforgeeks;

//Given the head of a singly linked list, your task is to left rotate the linked list k times.
//
//Examples:
//
//Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
//Output: 50 -> 10 -> 20 -> 30 -> 40
//Explanation:
//Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
//Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
//Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
//Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

public class LeftRotateLL {
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null||k==0)
            return head;
        int len=1;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
            len++;

        }
        k=k%len;
        if(k==0)
            return head;
        temp.next=head;
        temp=head;
        for(int i=1;i<k;i++)
            temp=temp.next;
        head=temp.next;
        temp.next=null;
        return head;


    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        LeftRotateLL obj=new LeftRotateLL();
        Node res=obj.rotate(head,2);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
