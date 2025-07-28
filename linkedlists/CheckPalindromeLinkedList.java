package linkedlists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class CheckPalindromeLinkedList {
    /**
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     *
     * Example 1:
     * Input: head = [1,2,2,1]
     * Output: true
     *
     * Example 2:
     * Input: head = [1,2]
     * Output: false
     *
     * Constraints:
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     *
     * Follow up: Could you do it in O(n) time and O(1) space?
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhalfhead=reverse(slow.next);
        ListNode firsthalfpointer=head;
        ListNode secondhalfpointer=secondhalfhead;
        while(secondhalfpointer!=null){
            if(firsthalfpointer.val!=secondhalfpointer.val)
                return false;
            firsthalfpointer=firsthalfpointer.next;
            secondhalfpointer=secondhalfpointer.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        CheckPalindromeLinkedList solution = new CheckPalindromeLinkedList();
        System.out.println("Is [1,2,2,1] a palindrome? " + solution.isPalindrome(head1)); // Output: true

        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println("Is [1,2] a palindrome? " + solution.isPalindrome(head2)); // Output: false

        ListNode head3 = new ListNode(1);
        System.out.println("Is [1] a palindrome? " + solution.isPalindrome(head3)); // Output: true

        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println("Is [1,2,3,2,1] a palindrome? " + solution.isPalindrome(head4)); // Output: true
    }
}

// Definition for singly-linked list.
