package linkedlists;

//Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.
//
//        For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.
//
//Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
//
//Examples:
//
//Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
//Output:  3 -> 9 -> 0
//
//Explanation: Given numbers are 45 and 345. There sum is 390.
//Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7
//Output: 7 -> 0
//
//Explanation: Given numbers are 63 and 7. There sum is 70.
//Constraints:
//        1 <= size of both linked lists <= 106
//        0 <= elements of both linked lists <= 9

public class AddLinkedListsRightToLeft {
    static Node addTwoLists(Node num1, Node num2) {
        if(num1==null&&num2==null)
            return  null;
        // code here
        Node dummy=new Node(-1);
        num1=reverselist(num1);
        num2=reverselist(num2);
        Node curr=dummy;
        int carry=0;
        while(num1!=null||num2!=null||carry>0){
            int sum=carry;
            if(num1!=null){
                sum+=num1.data;
                num1=num1.next;
            }
            if(num2!=null){
                sum+=num2.data;
                num2=num2.next;
            }
            Node newnode=new Node(sum%10);

            curr.next=newnode;
            carry=sum/10;
            curr=curr.next;


        }
        if(carry>0){
            Node carrynode=new Node(carry);
            curr.next=carrynode;
        }
        Node result=checkzeros(reverselist(dummy.next));
        return result;
    }
    private static Node reverselist(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    private static Node checkzeros(Node head){
        if(head==null)
            return head;
        Node curr=head;
        int zeros=0;
        while(curr!=null&&curr.data==0){
            zeros++;
            curr=curr.next;
        }
        if(curr==null)
            return head;
        Node newhead=head;
        for(int i=0;i<zeros;i++)
            newhead=newhead.next;
        return newhead;
    }
    public static void main(String[] args) {
        Node head1=new Node(9);
        head1.next=new Node(9);
        head1.next.next=new Node(9);
        head1.next.next.next=new Node(9);
        head1.next.next.next.next=new Node(9);
        head1.next.next.next.next.next=new Node(9);
        head1.next.next.next.next.next.next=new Node(9);
        Node head2=new Node(9);
        head2.next=new Node(9);
        head2.next.next=new Node(9);
        head2.next.next.next=new Node(9);
        Node head=addTwoLists(head1,head2);
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
