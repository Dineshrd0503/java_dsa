package codingninjas;

//Problem statement
//You are given two sorted linked lists. You have to merge them to produce a combined sorted linked list. You need to return the head of the final linked list.
//
//Note:
//
//The given linked lists may or may not be null.
//For example:
//
//If the first list is: 1 -> 4 -> 5 -> NULL and the second list is: 2 -> 3 -> 5 -> NULL
//
//The final list would be: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> NULL
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= L <= 10^5
//        1 ≤ data ≤ 10^6 and data != -1
//
//Where L is the number of nodes in either of the two Linked List.
//
//Time Limit: 1 sec
//Follow-up:
//
//Try to solve this problem in linear time complexity and constant space complexity.
//Sample Input 1:
//        7 8 -1
//        1 3 4 6 -1
//Sample Output 1:
//        1 3 4 6 7 8 -1
//Explanation of Input 1:
//In this testcase, the first list is: 7 -> 8 -> NULL
//The second list is: 1 -> 3 -> 4 -> 6 -> NULL
//The final list would be: 1 -> 3 -> 4 -> 6 -> 7 -> 8 -> NULL
//Sample Input 2:
//        5 -1
//        1 3 6 10 -1
//Sample Output 2
//        1 3 5 6 10 -1

public class MergeTwoSortedLinkedLists {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // Write your code here.
        LinkedListNode<Integer> dummy=new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp=dummy;
        LinkedListNode<Integer> t1=first;
        LinkedListNode<Integer> t2=second;
        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                temp.next=t1;
                temp=t1;
                t1=t1.next;
            }
            else{
                temp.next=t2;
                temp=t2;
                t2=t2.next;
            }
        }
        if(t1!=null)
            temp.next=t1;
        else
            temp.next=t2;
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
        LinkedListNode<Integer> res=sortTwoLists(head1,head2);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }

}
