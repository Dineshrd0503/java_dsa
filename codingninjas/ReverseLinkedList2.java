package codingninjas;
import java.util.Stack;


public class ReverseLinkedList2
{
    public static Node reverseLinkedList(Node head)
    {
        Stack<Integer> stack=new Stack();
        Node temp=head;
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(!stack.isEmpty()){
            temp.data=stack.pop();
            temp=temp.next;
        }
        return head;
        // Write your code here.
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void main(String[] args){
        System.out.println("reverse linked list");
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        Node temp=reverseLinkedList(head);
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
