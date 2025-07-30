import java.util.ArrayList;
public class StackImplementation{
        static class ImplementStack<E>{
            private E[] array;
            int size;
            int top;
            ImplementStack(int s){
                this.size=s;
               this.array=(E[]) new Object[size];
               this.top=-1;
            }
            public boolean isFull(){
                return top==size-1;

            }
            public boolean isEmpty(){
                return top==-1;
            }
            public void push(E x){
                if(!isFull()){
                array[++top]=x;
                System.out.println("element pushed successfully");
                }
                else
                System.out.println("cant puysh array is full");


            }

       public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        E element = array[top];
        array[top--] = null; // Help garbage collection
        return element;
    }

      public E peek(){
        if(isEmpty()) System.out.println("stack is empoty");
        return array[top];
      }

        public int size(){
            return top+1;
        }


        }
        
    public static void main(String[] args) {
        ImplementStack<Integer> stack=new ImplementStack(5);
       stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After pushing 10, 20, 30: Top element = " + stack.peek());
        System.out.println("Size: " + stack.size());

        // Test pop
        int popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("After pop: Top element = " + stack.peek());

        // Test peek
        System.out.println("Peek without pop: " + stack.peek());

        // Test isEmpty and isFull
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());

        // Test push to full capacity
        stack.push(40);
        stack.push(50);
        System.out.println("After pushing 40, 50: Top element = " + stack.peek());
        try {
            stack.push(60); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Test pop all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
        System.out.println("Is stack empty after all pops? " + stack.isEmpty());

        // Test pop on empty stack
        try {
            stack.pop(); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
    }
}
