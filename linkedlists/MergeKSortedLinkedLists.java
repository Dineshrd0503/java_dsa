package linkedlists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.
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

public class MergeKSortedLinkedLists {
    Node mergeKLists(List<Node> arr) {
        if(arr==null||arr.size()==0)
            return null;
        // Add your code here.
        PriorityQueue<Node> queue=new PriorityQueue<>((a, b)-> Integer.compare(a.data,b.data));
        for(Node n:arr){
            if(n!=null)
                queue.offer(n);
        }
        Node dummy=new Node(-1);
        Node tail=dummy;
        while(!queue.isEmpty()){
            Node node=queue.poll();
            tail.next=node;
            tail=tail.next;
            if(node.next!=null)
                queue.offer(node.next);
        }
        return dummy.next;

    }
    public static void main(String[] args) {
        System.out.println("merge k sorted linked lists");
        Node head1=new Node(1);
        head1.next=new Node(4);
        head1.next.next=new Node(5);
        Node head2=new Node(1);
        head2.next=new Node(3);
        head2.next.next=new Node(4);
        Node head3=new Node(2);
        head3.next=new Node(6);
        List<Node> arr=new ArrayList<>();
        arr.add(head1);
        arr.add(head2);
        arr.add(head3);
        MergeKSortedLinkedLists obj=new MergeKSortedLinkedLists();
        Node res=obj.mergeKLists(arr);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
