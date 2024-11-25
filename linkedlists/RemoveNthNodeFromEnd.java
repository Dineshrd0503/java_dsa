package linkedlists;
class LinkedListNode {
    int value;
    LinkedListNode next;
    LinkedListNode(int value) {
        this.value = value;
    }
}

// Define a class for the solution
public class RemoveNthNodeFromEnd {
    /**
     * Removes the nth node from the end of a linked list.
     *
     * @param head the head of the linked list
     * @param n the position of the node to remove from the end
     * @return the head of the modified linked list
     */
    public LinkedListNode removeNthNodeFromEnd(LinkedListNode head, int n) {
        // Handle edge case where the list only has one node
        if (head.next == null) {
            return null;
        }

        // Calculate the size of the linked list
        int size = 0;
        LinkedListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            size += 1;
        }

        // Handle edge case where n is equal to the size of the list
        if (n == size) {
            return head.next;
        }

        // Calculate the index of the node to remove
        int searchIndex = size - n;

        // Find the node before the one to remove
        int i = 1;
        LinkedListNode previousNode = head;
        while (i < searchIndex) {
            previousNode = previousNode.next;
            i += 1;
        }

        // Remove the node
        previousNode.next = previousNode.next.next;

        return head;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        LinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();

        // Remove the 2nd node from the end
        head = solution.removeNthNodeFromEnd(head, 2);

        // Print the modified linked list
        System.out.println("Modified Linked List:");
        currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}