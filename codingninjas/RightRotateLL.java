package codingninjas;

public class RightRotateLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        public static Node rotate (Node head,int k){
            int len = 1;
            Node temp = head;
            while (temp.next != null) {
                len++;
                temp = temp.next;

            }
            k = k % len;
            if (k == 0)
                return head;
            temp.next = head;
            temp = head;
            for (int i = 1; i < len - k; i++)
                temp = temp.next;
            head = temp.next;
            temp.next = null;
            return head;
            // Write your code here.
        }
        public static void main(String[] args) {
            System.out.println("right rotate linked list");
            Node head=new Node(1);
            head.next=new Node(2);
            head.next.next=new Node(3);
            head.next.next.next=new Node(4);
            head.next.next.next.next=new Node(5);
            Node temp=rotate(head,2);
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }

