package codingninjas;

//Problem statement
//You are given a linked list containing 'n' nodes, where every node in the linked list contains two pointers:
//
//
//
//        (1) ‘next’ which points to the next node in the list
//
//        (2) ‘random’ which points to a random node in the list or 'null'.
//
//
//
//Your task is to create a 'deep copy' of the given linked list and return its head.
//
//
//
//Note:
//A 'deep copy' of a linked list means we do not copy the references of the nodes of the original linked list, rather for each node in the original linked list, a new node is created.
//
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        5
//        1 2 3 4 5
//        2 0 4 4 1
//
//
//Sample Output 1:
//True
//
//
//Explanation of Sample Input 1:
//For the given test case, “True” will be printed if the linked list is successfully cloned.
//
//
//Sample Input 2:
//        2
//        1 2
//        1 0
//
//
//Sample Output 2:
//True
//
//
//Expected Time Complexity:
//Try to do this in O(n).
//
//
//Expected Space Complexity:
//Try to do this without using extra space.
//
//
//Constraints:
//        1 <= n <= 5 * 10^4
//        -10^5 <= Node.data <= 10^5
//        -1 <= ri < n
//        Where ‘n’ is the number of nodes in the linked list and ‘ri’ is the index of the random node.

public class CloneLLWithRandomPointers {
    public static Node cloneLL(Node head) {
        if(head==null)
            return null;
        // Write your code here.

        //1.insert nodes in b/w
        Node temp=head;

        while(temp!=null){
            Node newnode=new Node(temp.data);
            newnode.next=temp.next;
            temp.next=newnode;
            temp=newnode.next;
        }

        //2.atach pointers
        temp=head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random=temp.random.next;
            temp=temp.next.next;
        }

        //3.attach random pointer to copy of nodes
        Node dummy=new Node(-1);
        Node res=dummy;
        temp=head;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.random=head.next.next;
        head.next.random=head;
        head.next.next.random=head.next.next.next;
        head.next.next.next.random=head.next.next.next.next;
        head.next.next.next.next.random=head.next;
        Node res=cloneLL(head);
        while(res!=null){
            System.out.println(res.data+" "+res.random.data);
            res=res.next;
        }
    }


}
