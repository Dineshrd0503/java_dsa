package queues;

public class QueueUsingLL {
    static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class queue{
        static node front, rear=null;
        public static boolean isempty(){
            return front==null&&rear==null;
        }
        public static void enqueue(int data){
            node newNode=new node(data);
            if(isempty()){
              front=newNode;
              rear=newNode;
              return;
        }
            rear.next=newNode;
            rear=newNode;
            newNode.next=null;

    }
    public static int dequeue(){
            if(isempty()){
                System.out.println("list is emty ");
                return -1   ;
            }
            int popped=front.data;
            front=front.next;
            return popped;
        }
        public static int peek(){
            if(isempty()){
                System.out.println("quue is empty");
                return -1;
            }
            return front.data;

        }
        public static void display(){
            node temp=front;
            if(isempty()){
                System.out.println("Queue is empty");
                return;
            }
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("impleemting quque isg linkedlist");
        queue q=new queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        System.out.println("dequeueing element is "+q.dequeue());
        q.display();
        System.out.println("peeking element is "+q.peek());
        q.enqueue(40);
        q.display();

    }
}
