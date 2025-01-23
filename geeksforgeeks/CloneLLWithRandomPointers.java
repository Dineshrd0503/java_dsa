package geeksforgeeks;

//You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.
//
//Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//Return the head of the copied linked list.
//
//NOTE : Original linked list should remain unchanged.
//
//Examples:
//
//Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]]
//
//Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]]
//Explanation:
//Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
//        Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
//        Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
//Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.
//        Input: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
//
//
//Output: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
//Explanation:
//Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
//        Node 2 points to Node 3 as its NEXT and Node 1 as its RANDOM.
//        Node 3 points to Node 4 as its NEXT and Node 5 as its RANDOM.
//        Node 4 points to Node 5 as its NEXT and Node 3 as its RANDOM.
//        Node 5 points to NULL as its NEXT and Node 2 as its RANDOM.
//        Input: head = [[7, NULL], [7, NULL]]
//Output: head = [[7, NULL], [7, NULL]]
//Explanation:
//Node 1 points to Node 2 as its NEXT and NULL as its RANDOM.
//Node 2 points to NULL as its NEXT and NULL as its RANDOM.



public class CloneLLWithRandomPointers {
    public Node cloneLinkedList(Node head) {
        // code here

        //1.insert values in miidle o flist

        Node temp=head;
        while(temp!=null){
            Node newnode=new Node(temp.data);
            newnode.next=temp.next;

            temp.next=newnode;

            temp=newnode.next;
        }

        //2.arrane the pointers

        temp=head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random=temp.random.next;
            temp=temp.next.next;
        }

        //3.separte the mew linked list

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
            this.random=null;
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
        head.next.next.next.random=head.next.next.next;
        head.next.next.next.next.random=head.next;
        CloneLLWithRandomPointers obj=new CloneLLWithRandomPointers();
        Node res=obj.cloneLinkedList(head);
        while(res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
    }
}
