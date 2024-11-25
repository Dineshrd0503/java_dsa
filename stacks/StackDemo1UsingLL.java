package stacks;
public class StackDemo1UsingLL {
    private static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private static class Stack{
        public static node head;
        public static boolean isempty(){
            return head==null;
        }
        public static void push(int data){
            node newNode=new node(data);
            if(isempty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public static int pop(){
            if(isempty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int popped=head.data;
            head=head.next;
            return popped;
        }
        public static int peek(){
            if(isempty()){
                System.out.println("stack is emoty");
                return -1;
            }
            return head.data;


        }
        public static void display(){
            node temp=head;
            if(isempty()){
                System.out.println("Stack is empty");
                return;
            }
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
        }





    }

    static public void main(String[] args) {
        System.out.println("stakc ddmo using linkedlist");
        Stack s=new Stack();
        s.push(90);
        s.push(89);
        s.push(2);
        System.out.println("intial sttae");
        s.display();
        System.out.println("popped e;lement is"+s.pop());
        s.display();


    }
}
