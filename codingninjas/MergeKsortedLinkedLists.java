package codingninjas;

import java.util.PriorityQueue;

///Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.
//
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

public class MergeKsortedLinkedLists {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data) {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] arr) {
        // Write your code here.
        if(arr.length==0||arr==null)
            return  null;
        PriorityQueue<LinkedListNode<Integer>> queue=new PriorityQueue<>((a, b)-> Integer.compare(a.data,b.data));
        for(LinkedListNode<Integer> node:arr){
            if(node!=null)
                queue.offer(node);
        }
        LinkedListNode<Integer> dummy=new LinkedListNode(-1);
        LinkedListNode<Integer> tail=dummy;
        while(!queue.isEmpty()){
            LinkedListNode<Integer> node=queue.poll();
            tail.next=node;
            tail=tail.next;
            if(node.next!=null)
                queue.offer(node.next);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedListNode<Integer> head1=new LinkedListNode<>(1);
        head1.next=new LinkedListNode<>(3);
        head1.next.next=new LinkedListNode<>(5);
        head1.next.next.next=new LinkedListNode<>(7);
        head1.next.next.next.next=new LinkedListNode<>(9);
        LinkedListNode<Integer> head2=new LinkedListNode<>(2);
        head2.next=new LinkedListNode<>(4);
        head2.next.next=new LinkedListNode<>(6);
        head2.next.next.next=new LinkedListNode<>(8);
        head2.next.next.next.next=new LinkedListNode<>(10);
        LinkedListNode<Integer> res=mergeKLists(new LinkedListNode[]{head1,head2});
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
