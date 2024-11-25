package linkedlists;

public class PalindromeLinkedListChecker {
    private static final int[] array = new int[100_000];

    /**
     * Checks if a linked list is a palindrome.
     *
     * @param head the head of the linked list
     * @return true if the linked list is a palindrome, false otherwise
     */
    public boolean isLinkedListPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode h = head;
        final int[] array1 = array;
        int size = 0;

        // Store the linked list values in an array
        while (h != null) {
            array1[size++] = h.val;
            h = h.next;
        }

        int m = size / 2;
        for (int i = 0; i < m; i++) {
            if (array1[i] != array1[--size]) {
                return false;
            }
        }
        return true;
    }
    public static void print(ListNode head){
        System.out.println("Original Linked List:");
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println();

    }


    public static void main(String[] args) {
        PalindromeLinkedListChecker checker = new PalindromeLinkedListChecker();

        // Create a sample linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean isPalindrome = checker.isLinkedListPalindrome(head);
        // Print the original linked list
        print(head);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);

        // Create another sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        isPalindrome = checker.isLinkedListPalindrome(head);
        print(head);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
