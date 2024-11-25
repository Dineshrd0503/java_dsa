package stacks;
import java.util.*;
public class StackQ1 {
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        System.out.println("puhsing an elemnt at botto of stack");

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("original state ");
        display(s);

        System.out.println("pushning 4 at bottom");
        pushatbottom(4,s);
        display(s);
    }
    public static void display(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = s.pop();

        // Display the current top element
        System.out.println(top);

        // Recursively display the remaining elements
        display(s);

        // Push the element back after displaying, to maintain original stack state
        s.push(top);
    }
    public static void pushatbottom(int x, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int temp = s.pop();
        pushatbottom(x,s);
        s.push(temp);

    }

}
