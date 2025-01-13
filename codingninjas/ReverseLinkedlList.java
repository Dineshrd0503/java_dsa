package codingninjas;



public class ReverseLinkedlList
{
    static class LinkedListNode<T>
    {
        T data;
        LinkedListNode<T> next;
        public LinkedListNode(T data)
        {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head)
    {
        // Write your code here!
        LinkedListNode<Integer> prev=null;
        LinkedListNode<Integer> current=head;
        LinkedListNode<Integer> next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public static void main(String[] args){
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);

        LinkedListNode<Integer> reversedHead = reverseLinkedList(head);
        while(reversedHead!=null){
            System.out.print(reversedHead.data + " ");
            reversedHead = reversedHead.next;
        }
    }
}
