package queues;

import java.util.Scanner;

public class QueueUsingArray {
    private static class Queue {
        static int a[];
        static int rear = -1, size;
        static int front = -1;

        // Constructor
        Queue(int size) {
            a = new int[size];
            this.size = size;
        }

        // Check if the queue is empty
        public static boolean isEmpty() {
            return front == -1 || front > rear;
        }

        // Enqueue operation (add item to the queue)
        public static void enqueue(int item) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {
                front = 0;
                rear = 0;
            } else {
                rear++;
            }
            a[rear] = item;
        }

        // Dequeue operation (remove the front item)
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int frontElement = a[front];
            front++;

            // If all elements are dequeued, reset front and rear
            if (front > rear) {
                front = rear = -1; // Reset the queue
            }
            return frontElement;
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
            for (int i = front; i <= rear; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Implementing queue using arrays");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue:");
        int n = sc.nextInt();

        // Creating queue with size n
        Queue q = new Queue(n);

        // Enqueuing elements
        for (int i = 0; i < n; i++) {
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

        // Peek operation
        System.out.println("Peek element: " + q.peek());

        sc.close();
    }
}
