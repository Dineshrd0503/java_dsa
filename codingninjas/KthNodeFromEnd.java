package codingninjas;

public class KthNodeFromEnd {
    static class Node{
        int value;
        Node next;
    }
    public static Node findKthFromLast(Node head, int k) {
        if(head==null||k<=0)
            return null;
        Node first=head,second=head;
        for(int i=0;i<k;i++){
            if(first==null)
                return null;
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }


        // Write your code here
        return second;
    }
    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;
        Node second = new Node();
        second.value = 2;
        Node third = new Node();
        third.value = 3;
        Node fourth = new Node();
        fourth.value = 4;
        Node fifth = new Node();
        fifth.value = 5;

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println(findKthFromLast(head, 2).value); // Output: 4
    }
}
