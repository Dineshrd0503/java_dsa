package logicwhilecollections;

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

/**
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */

public class MergeTwoSortedLinkedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1,temp2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp=temp2;
                temp2=temp2.next;
            }

        }
        if(temp1!=null) temp.next=temp1;
        else temp.next=temp2;
        return dummy.next;

    }

    public static void main(String[] args) {
        // Test Case 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode mergedList1 = mergeTwoLists(list1, list2);
        System.out.print("Merged List 1: ");
        while (mergedList1 != null) {

            System.out.print(mergedList1.val + " ");
            mergedList1 = mergedList1.next;

        }
        System.out.println();
        // Test Case 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = mergeTwoLists(list3, list4);
        System.out.print("Merged List 2: ");
        while (mergedList2 != null) {
            System.out.print(mergedList2.val + " ");
            mergedList2 = mergedList2.next;
        }
        System.out.println();
        // Test Case 3
    }
}
