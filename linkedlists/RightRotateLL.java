package linkedlists;


//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]


public class RightRotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)
            return head;
        int len=1;
        ListNode temp=head;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0)
            return head;
        temp.next=head;
        temp=head;
        for(int i=1;i<len-k;i++){
            temp=temp.next;

        }
        head=temp.next;
        temp.next=null;
        return head;


    }
    public static void main(String[] args) {
        RightRotateLL obj=new RightRotateLL();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int k=2;
        ListNode res=obj.rotateRight(head,k);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
