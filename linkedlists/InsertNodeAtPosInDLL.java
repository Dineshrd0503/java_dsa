package linkedlists;

public class InsertNodeAtPosInDLL {
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

    public static Node insertNode(Node head, int pos, int data) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            if (head != null)
                head.prev = newNode;
            return newNode;
        }
        int count = 0;
        Node curr = head;
        while (curr != null && count < pos) {
            count++;
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        newNode.next = curr;
        newNode.prev = curr.prev;
        curr.prev = newNode;
        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }
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
        head = insertNode(head, 2, 25);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
    }
}
