package linkedlists;

//Problem statement
//You are given a singly linked list containing ‘N’ nodes, where every node in the linked list contains a pointer “next” which points to the next node in the list and having integer values. You are also given an integer ‘K’.
//
//You recently studied modular operation and you wanted to find out the last node in the linked list such that ‘x%K’ = 0 , where ‘x’ is the position of the node from the beginning.
//
//Return the last node that satisfies the above property.
//
//        Example :
//N = 7 , K = 3
//Linked List = 1 -> 3 -> 2 -> 4 -> 6 -> 5 -> 7
//
//Explanation :
//
//The first node has ‘x%K’ = 1%3 = 1.
//The second node has ‘x%K’ = 2%3 = 2.
//The third node has ‘x%K’ = 3%3 = 0.
//The fourth node has ‘x%K’ = 4%3 = 1.
//The fifth node has ‘x%K’ = 5%3 = 2.
//The sixth node has ‘x%K’ = 6%3 = 0.
//The seventh node has ‘x%K’ = 7%3 = 1.
//So, the last node which has ‘x%k’ = 0 is the sixth node with value 5.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 5
//        1 <= N <= 10^5
//        1 <= K <= N
//Sum of N over all Test cases <= 10^5
//
//Time Limit : 1 sec
//Sample Input 1 :
//        2
//        3 3
//        1 2 3 -1
//        5 2
//        3 7 1 9 8 -1
//Sample Output 1 :
//        3
//        9
//Explanation Of Sample Input 1 :
//For test case 1 we have,
//
//The linked list is 1 -> 2 -> 3.
//
//The last node with ‘x%3’ = 0 is with ‘x=3’.
//
//The third node has value 3.
//
//So, we output 3.
//
//For test case 2 we have,
//
//The linked list is 3 -> 7 -> 1 -> 9 -> 8.
//
//The last node with ‘x%2’ = 0 is with ‘x=4’.
//
//The fourth node has value 9.
//
//So, we output 9.
//Sample Input 2 :
//        2
//        3 2
//        6 5 2 -1
//        2 1
//        9 7 -1
//Sample Output 2 :
//        5
//        7


public class ModularNode {
    public static Node modularNode(int k,Node head) {
        // Write your code here.
        Node target=head;
        int i=1;
        if(k<=0||head==null)
            return head;
        for(Node temp=head;temp!=null;temp=temp.next){
            if(i%k==0)
                target=temp;
            i++;
        }
        return target;

    }
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        Node res=modularNode(3,head);
        System.out.println(res.data);
    }
}
