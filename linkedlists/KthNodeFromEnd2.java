package linkedlists;

public class KthNodeFromEnd2 {
    static class Node{
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
        Node second = new Node();
        second.data = 2;
        Node third = new Node();
        third.data = 3;
        Node fourth = new Node();
        fourth.data = 4;
        Node fifth = new Node();
        fifth.data = 5;

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        int k = 2;
        int result = getKthFromLast(head, k);
        System.out.println("The " + k + "th node from end is: " + result);
    }
}
