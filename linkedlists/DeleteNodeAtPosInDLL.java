package linkedlists;

public class DeleteNodeAtPosInDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node deleteNode(Node head, int k) {
        if (k == 0) {
            head = head.next;
            if (head != null)
                head.prev = null;
            return head;
        }
        int count = 0;
        Node curr = head;
        while (curr != null && count < k) {
            count++;
            curr = curr.next;
        }
        if (curr == null)
            return head;
        if (curr.next != null)
            curr.next.prev = curr.prev;
        if (curr.prev != null)
            curr.prev.next = curr.next;
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(40);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.prev = head.next.next.next;
        head = deleteNode(head, 2);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
    }
}

