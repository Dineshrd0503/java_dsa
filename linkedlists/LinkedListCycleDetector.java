package linkedlists;

public class LinkedListCycleDetector {
    /**
     * Detects whether a linked list has a cycle.
     *
     * @param head the head of the linked list
     * @return true if the linked list has a cycle, false otherwise
     */
    public boolean hasCycle(ListNode1 head) {
        if (head == null) {
            return false;
        }

        ListNode1 first = head;
        ListNode1 last = head;

        // Use Floyd's Tortoise and Hare algorithm to detect a cycle
        while (last.next != null && last.next.next != null) {
            last = last.next.next;
            first = first.next;

            if (first == last) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycleDetector detector = new LinkedListCycleDetector();

        // Create a sample linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle)
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = head.next.next; // Create a cycle


        boolean hasCycle = detector.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle);

        // Create another sample linked list without a cycle: 1 -> 2 -> 3 -> 4 -> 5
        head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);


        hasCycle = detector.hasCycle(head);

        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}

// Definition for singly-linked list.
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }
}