package linkedlists;

public class DetectCycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode first=head;
        ListNode last=head;
        while(last.next!=null&&last!=null){
            last=last.next.next;
            first=first.next;
            if(first==last)
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        DetectCycleInLinkedList obj=new DetectCycleInLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        System.out.println(obj.hasCycle(head));
        System.out.println(true);// Output: true
    }
}
