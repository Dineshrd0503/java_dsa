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

        public static Node deleteNode(Node head, int pos) {
            if (head == null || pos < 0) {
                return head;
            }

            Node current = head;
            int index = 0;

            // Traverse to the node at position `pos`
            while (current != null && index < pos) {
                current = current.next;
                index++;
            }

            // If the node to be deleted is found
            if (current != null) {
                // If the node to be deleted is the head node
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
            }

            return head;
        }

        public static void printList(Node head) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" <-> ");
                }
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Example usage
            Node head = new Node(1);
            head.next = new Node(1);
            head.next.prev = head;
            head.next.next = new Node(2);
            head.next.next.prev = head.next;
            head.next.next.next = new Node(3);
            head.next.next.next.prev = head.next.next;
            head.next.next.next.next = new Node(4);
            head.next.next.next.next.prev = head.next.next.next;

            int pos = 1;
            head = deleteNode(head, pos);
            printList(head); // Output: 1 <-> 2 <-> 3 <-> 4
        }
    }

