package stacks;
/**
 * Problem Statement:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Constraints:
 * - The number of nodes in each linked list is in the range [1, 100].
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros.
 * 
 * Examples:
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
import java.util.Stack;

public class AddTwoNumbersUsingStack {
    // Static ListNode class for linked list nodes
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize two stacks for storing digits
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        // Push digits of l1 to stack1
        ListNode temp1 = l1;
        while (temp1 != null) {
            stack1.push(temp1.val);
            temp1 = temp1.next;
        }
        
        // Push digits of l2 to stack2
        ListNode temp2 = l2;
        while (temp2 != null) {
            stack2.push(temp2.val);
            temp2 = temp2.next;
        }
        
        // Initialize result list and carry
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        
        // Process digits while either stack has elements
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // Get digits, use 0 if stack is empty
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            
            // Compute sum and carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            
            // Create new node and add to result (front insertion)
            ListNode newNode = new ListNode(digit);
            newNode.next = current.next;
            current.next = newNode;
        }
        
        // Handle remaining carry
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = current.next;
            current.next = newNode;
        }
        
        return dummy.next;
    }
    
    // Utility method to create a linked list from an array
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    
    // Utility method to print a linked list
    private static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        AddTwoNumbersUsingStack solution = new AddTwoNumbersUsingStack();
        
        // Example 1: l1 = [2,4,3], l2 = [5,6,4]
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);
        System.out.print("Example 1: l1 = ");
        printList(l1);
        System.out.print("           l2 = ");
        printList(l2);
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        System.out.print("       Output: ");
        printList(result1);
        
        // Example 2: l1 = [0], l2 = [0]
        arr1 = new int[]{0};
        arr2 = new int[]{0};
        l1 = createList(arr1);
        l2 = createList(arr2);
        System.out.print("\nExample 2: l1 = ");
        printList(l1);
        System.out.print("           l2 = ");
        printList(l2);
        result1 = solution.addTwoNumbers(l1, l2);
        System.out.print("       Output: ");
        printList(result1);
        
        // Example 3: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        arr1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        arr2 = new int[]{9, 9, 9, 9};
        l1 = createList(arr1);
        l2 = createList(arr2);
        System.out.print("\nExample 3: l1 = ");
        printList(l1);
        System.out.print("           l2 = ");
        printList(l2);
        result1 = solution.addTwoNumbers(l1, l2);
        System.out.print("       Output: ");
        printList(result1);
    }
}
