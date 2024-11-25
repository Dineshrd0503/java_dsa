package linkedlists;
import java.util.*;
public class LLOperations2 {
    public static void main(String[] args) {
        System.out.println("using collections to create linked list");
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("nserting data");
        list.addFirst(1);
        list.add(2);
        list.add(3);
        list.addLast(4);
        print(list);
        System.out.println("deleting elements");
        list.removeFirst();
        list.removeLast();
        print(list);
        list.remove(0);
        print(list);


    }

    public static void print(LinkedList<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + "->");
        }
        System.out.println("NULL");
    }
}
