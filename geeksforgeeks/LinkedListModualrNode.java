package geeksforgeeks;

//Given the head of a Singly Linked List and a number k, the task is to find the modular node of the linked list. If no such index is present return -1.
//
//A modular node is defined as the last node in the linked list whose index is divisible by k (i%k==0).
//
//Note: 1-based indexing is followed
//
//Examples :
//
//Input: LinkedList: 1->2->3->4->5->6->7 , k = 3
//
//Output: 6
//Explanation: Indexing of the linked list is same as the values of the Node. The maximum index which is divisble by 3 is 6 and the
//node value of the 6th index is 6.
//Input: LinkedList: 19->28->37->46->55 , k = 13
//
//Output: -1
//Explanation: Index start from 1 and end at 5. There is no index which can divisible by 13, so output is -1.
//Constraints:
//        1 <= number of nodes <= 105
//        1 <= node->data , k <= 105


public class LinkedListModualrNode {
    public int modularNode(Node head, int k) {
        // Code here//Position this line where user code will be pasted.
        int curr=-1;
        int i=1;
        if(k<=0||head==null)
            return 0;
        for(Node temp=head;temp!=null;temp=temp.next){
            if(i%k==0)
                curr=temp.data;
            i++;
        }
        return curr;
    }
    public static void main(String[] args) {
        System.out.println("modular node");
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        LinkedListModualrNode obj=new LinkedListModualrNode();
        System.out.println(obj.modularNode(head,3));
    }
}
