package codingninjas;

public class KthNodeFromEnd2 {
    public static class Node {
        int data;
        Node next;
    }
    public static int getKthFromLast(Node head, int k) {
        Node temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(head==null||k<=0||k>size)
            return -1;
        Node first=head,second=head;
        for(int i=0;i<k;i++){
            if(first==null)
                return -1;
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        return second.data;
        // Your code here
    }
    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;
        head.next.next.next = new Node();
        head.next.next.next.data = 4;
        System.out.println(getKthFromLast(head, 2)); // Output: 3
    }
}
