package geeksforgeeks;

//Input: LinkedList = 2->5->8->9->6
//Output: 2->8->6 , 5->9
//Explanation: After forming two sublists of the given list as required, we have two lists as: 2->8->6 and 5->9.
//Input: LinkedList: 7
//Output: 7 , <empty linked list>

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class EvenOddListsLL {

    // Function to alternate split a linked list
    public static Node[] alternatingSplitList(Node head) {
        if (head == null) {
            return new Node[]{null, null}; // If list is empty, return two empty lists
        }

        // Initialize two dummy nodes for even and odd lists
        Node evenHead = new Node(0); // This is a dummy node for the even-indexed list
        Node oddHead = new Node(0);  // This is a dummy node for the odd-indexed list

        Node even = evenHead;
        Node odd = oddHead;
        Node curr = head;
        boolean isEven = true;  // This flag will toggle to keep track of even and odd indices

        // Traverse the original list and alternate nodes between even and odd lists
        while (curr != null) {
            if (isEven) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }

            curr = curr.next;
            isEven = !isEven;  // Toggle the flag
        }

        // End both lists by setting their last nodes' next pointers to null
        even.next = null;
        odd.next = null;

        // Return the heads of both lists (skipping the dummy nodes)
        return new Node[]{evenHead.next, oddHead.next};
    }

    // Helper method to print a linked list
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("<empty linked list>");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1: 2->5->8->9->6
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(6);

        // Call the alternatingSplitList method
        Node[] result = alternatingSplitList(head);

        // Print both sublists
        System.out.print("Even-indexed list: ");
        printList(result[0]);

        System.out.print("Odd-indexed list: ");
        printList(result[1]);

        // Test case 2: 7
        Node head2 = new Node(7);
        Node[] result2 = alternatingSplitList(head2);

        System.out.print("Even-indexed list: ");
        printList(result2[0]);

        System.out.print("Odd-indexed list: ");
        printList(result2[1]);
    }
}

