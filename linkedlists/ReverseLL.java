package linkedlists;

import linkedlists.LLOpeartions1;

public class ReverseLL extends LLOpeartions1 {
    public static void main(String[] args) {
       ReverseLL list=new ReverseLL();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original List:");
        list.display();

        list.reverselist();

        System.out.println("\nReversed List:");
        list.display();
    }
}