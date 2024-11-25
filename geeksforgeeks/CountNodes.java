package geeksforgeeks;

public class CountNodes {
    static node head=null;

    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public static int count() {
        int count = 0;
        for (node temp = head; temp != null; temp = temp.next)
            count += 1;
        return count;

    }
    public static int search(int val){
        node temp = head;
        int index = 0;
        while (temp!=null) {
            index+=1;
            if (temp.data == val)
                return index;
            temp = temp.next;
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println("creating a linked list");
        head=new node(1);
        head.next=new node(2);
        head.next.next=new node(3);
        head.next.next.next=new node(4);
        head.next.next.next.next=new node(5);
        System.out.println("Displaying the linked list");
        display();
        System.out.println("Number of nodes in the linked list is: "+count());
        System.out.println("Search for 3: "+search(3));

    }
}
