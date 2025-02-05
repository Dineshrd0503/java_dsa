package leetcode;

public class OddAndEvenPosLL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode odd=head,even=head.next;
        ListNode evenhead=head.next;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;


    }
    public static void main(String[] args) {
        OddAndEvenPosLL obj=new OddAndEvenPosLL();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode res=obj.oddEvenList(head);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
