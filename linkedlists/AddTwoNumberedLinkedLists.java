package linkedlists;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
//        Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//        0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.

public class AddTwoNumberedLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode t1=l1;
        ListNode t2=l2;
        int carry=0;
        while(t1!=null||t2!=null){
            int sum=carry;
            if(t1!=null){
                sum+=t1.val;
                t1=t1.next;
            }
            if(t2!=null){
                sum+=t2.val;
                t2=t2.next;
            }
            ListNode newnode=new ListNode(sum%10);
            curr.next=newnode;
            curr=curr.next;
            carry=sum/10;

        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return dummy.next;

    }
    public static void main(String[] args) {
        AddTwoNumberedLinkedLists obj=new AddTwoNumberedLinkedLists();
        ListNode head1=new ListNode(2);
        head1.next=new ListNode(4);
        head1.next.next=new ListNode(3);
        ListNode head2=new ListNode(5);
        head2.next=new ListNode(6);
        head2.next.next=new ListNode(4);
        ListNode res=obj.addTwoNumbers(head1,head2);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
