package stacks;

import java.util.ArrayList;

public class StackDemo2UsingAL {
    private static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private static class Stack{
        ArrayList<Integer> list=new ArrayList<>();
        public void display(){
            if(list.isEmpty()){
                System.out.println("Stack is empty");
                return;
            }
            for(int n:list)
                System.out.print(n+"_>");
        }
        public void push(int data){
            list.add(data);
        }
        public int pop(){
            if(list.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return list.remove(list.size()-1);
        }
        public int peek(){
            if(list.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return list.get(list.size()-1);
        }

    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        System.out.println("implemetingn stack using array list ");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        System.out.println();
        System.out.println("Top element is "+stack.peek());
        System.out.println("popped elmeent is"+stack.pop());
        stack.display();
        System.out.println();
        System.out.println("Top element is "+stack.peek());


    }
}
