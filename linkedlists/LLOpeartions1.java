package linkedlists;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class LLOpeartions1 {
        Node head;
        public int size=0;
public void addFirst(int data){
    Node newnode=new Node(data);
    if(head==null) {
        size++;
        head = newnode;
        return;
    }
    size++;
    newnode.next=head;
    head=newnode;
}
public void reverselist() {
            if (head == null || head.next == null)
                return;

            Node prevnode = head;
            Node currentnode = head.next;
            while (currentnode != null) {
                Node nextnode = currentnode.next;
                currentnode.next = prevnode;
                prevnode = currentnode;
                currentnode = nextnode;
            }
            head.next = null;
            head = prevnode;

        }

public void addLast(int data){
        Node newnode=new Node(data);
        if(head==null) {
            size++;
            head = newnode;
            return;
        }
        size++;
        Node currnode=head;
        while(currnode.next!=null){
            currnode=currnode.next;
        }
    currnode.next = newnode;

}
//deleting at first
        public void deleteFirst(){
    if(head==null) {
                System.out.println("List is empty");
                return;

            }
    size--;
    head=head.next;


}

//deleting at last
        public void deleteLast(){
            if(head==null) {
                System.out.println("List is empty");
                return;

            }
            if(head.next==null) {
                size--;
                head=null;
                return;
            }
            size--;
            Node secondnode=head;
            Node lastnode=head.next;
            while(lastnode.next!=null){
                lastnode=lastnode.next;
                secondnode=secondnode.next;
            }
            secondnode.next=null;
}



public void display(){
            if(head==null){
                System.out.println("List is empty");
                return;
            }
            Node currnode=head;
            while(currnode!=null){
                System.out.print(currnode.data+" ");
                currnode=currnode.next;
            }
            System.out.println("NULL");

}
public int getsize(){
            return size;
}
        public Node reverseRecursive(Node currentNode) {
            if (currentNode == null || currentNode.next == null) {
                return currentNode;
            }

            Node reversedHead = reverseRecursive(currentNode.next);
            currentNode.next.next = currentNode;
            currentNode.next = null;

            return reversedHead;
        }


    public static void main(String[] args) {
        LLOpeartions1 list=new LLOpeartions1();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(5);
        list.addLast(3);
        list.addLast(4);
        list.display();
        System.out.println("deleting first element");
        list.deleteFirst();
        list.display();
        System.out.println("deleting last element");
        list.deleteLast();
        list.display();
        //to diplay size of linkedlist
        System.out.println("size of linked list is :"+list.getsize());
        list.reverselist();
        System.out.println("after revresing");
        list.display();
        list.head = list.reverseRecursive(list.head);
        System.out.println("After reversing using recursive method");
        list.display();


    }
    }
