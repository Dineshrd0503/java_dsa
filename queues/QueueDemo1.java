package queues;
import java.util.*;
public class QueueDemo1 {
    public static void main(String[] args) {
        System.out.println("implementing queueu using linkedlist");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("element sin queueu are ");
        for(Integer i:queue)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("Front element is "+queue.peek());
        System.out.println("Dequeued element is "+queue.poll());
        System.out.println("new quete si ");
        for(Integer i:queue)
            System.out.print(i+" ");
        System.out.println("implementing queue using arraydeque");
        Queue<Integer > q1=new ArrayDeque<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.println("element sin queueu are ");
        for(Integer i:q1)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("Front element is "+q1.peek());
        System.out.println("Dequeued element is "+q1.poll());
    }

}
