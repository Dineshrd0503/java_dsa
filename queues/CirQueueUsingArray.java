package queues;

import java.util.Scanner;

public class CirQueueUsingArray {
    private static class Queue {
        static int[] a;
        static int rear = -1, size;
        static int front = -1;

        // Constructor
        Queue(int size) {
            a = new int[size];
            this.size = size;
        }

        // Check if the queue is empty
        public static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // Check if the queue is full
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Enqueue operation (add item to the queue)
        public static void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) // first element to be inserted
                front = 0;

            rear = (rear + 1) % size;
            a[rear] = item;
        }

        // Dequeue operation (remove the front item)
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = a[front];
            if (front == rear) { // queue is now empty after this dequeue
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // Peek operation (view the front item without removing it)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return a[front];
        }

        // Display the elements in the queue
        public static void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(a[i] + " ");
                if (i == rear) // if we reach the rear, stop
                    break;
                i = (i + 1) % size; // increment i circularly
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Implementing Circular Queue using Arrays");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue:");
        int n = sc.nextInt();

        // Creating queue with size n
        Queue q = new Queue(n);

        // Enqueuing elements
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            int x = sc.nextInt();
            q.enqueue(x);
        }

        // Displaying the queue
        System.out.println("Displaying queue elements:");
        q.display();

        // Dequeue operation
        System.out.println("Removing front element: " + q.dequeue());

        // Display queue after dequeuing
        System.out.println("Queue after dequeue:");
        q.display();

        // Enqueue another element
        q.enqueue(34);
        System.out.println("After adding 34:");
        q.display();

        // Peek operation
        System.out.println("Peek element: " + q.peek());

        sc.close();
    }
}
