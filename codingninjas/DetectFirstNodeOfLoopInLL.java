package codingninjas;

import java.util.HashMap;

public class DetectFirstNodeOfLoopInLL {
//    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
//    Do not modify the linked list.
//
//
//
//    Example 1:
//
//
//    Input: head = [3,2,0,-4], pos = 1
//    Output: tail connects to node index 1
//    Explanation: There is a cycle in the linked list, where tail connects to the second node.
//    Example 2:
//
//
//    Input: head = [1,2], pos = 0
//    Output: tail connects to node index 0
//    Explanation: There is a cycle in the linked list, where tail connects to the first node.
//    Example 3:
//
//
//    Input: head = [1], pos = -1
//    Output: no cycle
//    Explanation: There is no cycle in the linked list.
//
//
//    Constraints:

//    The number of the nodes in the list is in the range [0, 104].
//            -105 <= Node.val <= 105
//    pos is -1 or a valid index in the linked-list.


    public static Node firstNode(Node head) {
        // Write your code here.
        HashMap<Node,Integer> map=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            if(map.containsKey(temp))
                return temp;
            map.put(temp,map.getOrDefault(temp,0)+1);
            temp=temp.next;
        }
        return null;
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;
        System.out.println(firstNode(head).data); // Output: 2
    }

}
