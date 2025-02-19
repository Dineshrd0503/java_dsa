package geeksforgeeks;

import java.util.PriorityQueue;

///Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.
////
//        Examples:
//
//Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
//Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
//Explanation:
//The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
//        1st list: 1 -> 2-> 3
//        2nd list: 4 -> 5
//        3rd list: 5 -> 6
//        4th list: 7 -> 8
//The merged list will be:
//
//Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
//Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
//Explanation:
//The arr[] has 3 sorted linked list of size 2, 3, 1.
//        1st list: 1 -> 3
//        2nd list: 8
//        3rd list: 4 -> 5 -> 6
//The merged list will be:
//
//Constraints
//1 <= total no. of nodes <= 105
//        1 <= node->data <= 103


public class MergeKSortedLinkedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public ListNode mergeKLists(ListNode[] arr) {

        if(arr==null||arr.length==0)
            return null;
        // Add your code here.
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a, b)-> Integer.compare(a.val,b.val));
        for(ListNode n:arr){
            if(n!=null)
                queue.offer(n);
        }
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(!queue.isEmpty()){
            ListNode node=queue.poll();
            tail.next=node;
            tail=tail.next;
            if(node.next!=null)
                queue.offer(node.next);
        }
        return dummy.next;

    }
    public static void main(String[] args) {
        ListNode[] arr=new ListNode[3];
        arr[0]=new ListNode(1);
        arr[0].next=new ListNode(4);
        arr[0].next.next=new ListNode(5);
        arr[1]=new ListNode(1);
        arr[1].next=new ListNode(3);
        arr[1].next.next=new ListNode(4);
        arr[2]=new ListNode(2);
        arr[2].next=new ListNode(6);
        MergeKSortedLinkedLists obj=new MergeKSortedLinkedLists();
        ListNode result=obj.mergeKLists(arr);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}
