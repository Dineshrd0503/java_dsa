package codingninjas;
//You are given two non-negative numbers 'num1' and 'num2' represented in the form of linked lists.
//
//
//
//The digits in the linked lists are stored in reverse order, i.e. starting from least significant digit (LSD) to the most significant digit (MSD), and each of their nodes contains a single digit.


//
//Calculate the sum of the two numbers and return the head of the sum list.
//
//
//
//Example :
//Input:
//        'num1' : 1 -> 2 -> 3 -> NULL
//'num2' : 4 -> 5 -> 6 -> NULL
//
//Output: 5 -> 7 -> 9 -> NULL
//
//Explanation: 'num1' represents the number 321 and 'num2' represents 654. Their sum is 975.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        3
//        1 2 3
//        3
//        4 5 6
//
//
//Sample Output 1 :
//        5 7 9
//
//
//Explanation for Sample Input 1 :
//        'num1' represents the number 321 and 'num2' represents 654. Their sum is 975.
//
//
//Sample Input 2 :
//        2
//        0 1
//        1
//        0
//
//
//Sample Output 2 :
//        0 1
//
//
//Explanation for Sample Input 2 :
//        'num1' represents 10 and 'num2' represents 0. Their sum is 10.
//
//
//Sample Input 3 :
//        1
//        2
//        2
//        9 9
//
//
//Sample Output 3 :
//        1 0 1
//
//
//Explanation for Sample Input 3 :
//        'num1' represents 2 and 'num2' represents 99. Their sum is 101.
//
//
//Expected Time Complexity :
//The expected time complexity is O('m' + 'n').
//
//
//Constraints :
//        1 <= 'm', 'n' <= 5 * 10^4
//        0 <= 'data' in any Linked List node <= 9
//
//The numbers do not contain any leading zeros.
//If the number is zero, then there is one node having 'data' = 0.
//
//Time Limit: 1 sec






public class AddTwoNumberedLinkedLists {
    static class LinkedListNode{
        int data;
        LinkedListNode next;
        LinkedListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {

        // Write your code here.
        LinkedListNode t1=head1;
        LinkedListNode t2=head2;
        LinkedListNode dummy=new LinkedListNode(-1);
        LinkedListNode curr=dummy;
        int carry=0;
        while(t1!=null||t2!=null){
            int sum=carry;
            if(t1!=null){
                sum+=t1.data;
                t1=t1.next;
            }
            if(t2!=null){
                sum+=t2.data;
                t2=t2.next;
            }
            LinkedListNode newnode=new LinkedListNode(sum%10);
            curr.next=newnode;
            curr=curr.next;
            carry=sum/10;

        }
        if(carry>0){
            LinkedListNode carrynode=new LinkedListNode(carry);
            curr.next=carrynode;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedListNode head1=new LinkedListNode(2);
        head1.next=new LinkedListNode(4);
        head1.next.next=new LinkedListNode(3);
        LinkedListNode head2=new LinkedListNode(5);
        head2.next=new LinkedListNode(6);
        head2.next.next=new LinkedListNode(4);
        LinkedListNode head=addTwoNumbers(head1,head2);
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
