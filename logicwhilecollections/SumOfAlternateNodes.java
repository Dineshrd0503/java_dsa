package logicwhilecollections;

public class SumOfAlternateNodes {
    static class Node{
        int data; // Data stored in the node
        Node next; // Reference to the next node in the list

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null; // Initially, the next node is null
        }

        public static void main(String[] args) {
            // Example usage
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);
            head.next.next.next.next.next = new Node(6);

            System.out.println("Original Linked List:");
            printLinkedList(head);

            System.out.println("Sum of adjacent nodes:");
            int sum=sumOfAlternateNodes(head);
            System.out.println("Total Sum: " + sum); // Print the total sum of adjacent nodes
            //test case 2

        }
        // Function to print the linked list
        public static void printLinkedList(Node head) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
        // Function to sum adjacent nodes and print the result
        public static int sumOfAlternateNodes(Node head) {
            int sum = 0;
            Node current = head;
            // Iterate through the list, advancing two nodes at a time.
            while (current != null) {
                // Add the data of the current node to the sum.
                sum += current.data;
                // Move to the next alternate node.
                // If current.next is null, this will correctly set current to null and end the loop.
                current = (current.next != null) ? current.next.next : null;
            }
            return sum;
        }
    }

}
