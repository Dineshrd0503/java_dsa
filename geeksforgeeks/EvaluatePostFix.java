package geeksforgeeks;
//Given string s which represents a postfix expression, the task is to evaluate the expression and find the final value. Operators include the basic arithmetic operators like *, /, + and -
//
//Examples:
//
//Input: s = "231*+9-"
//Output: -4
//Explanation: After solving the given expression, we have -4 as result.
//Input: s = "123+*8-"
//Output: -3
//Explanation: After solving the given postfix expression, we have -3 as result.

import java.util.Stack;
public class EvaluatePostFix {
    public static int evaluatePostFix(String s) {
        // Your code here
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48&&s.charAt(i)<=57)
                stack.push(s.charAt(i)-'0');
            else{
                int a1=stack.pop();
                int a2=stack.pop();
                switch(s.charAt(i)){
                    case '+' :
                        stack.push(a2 + a1);
                        break;
                    case '-' :
                        stack.push(a2 - a1);
                        break;
                    case '*' :
                        stack.push(a2 * a1);
                        break;
                    case '/':
                        stack.push(a2/a1);
                        break;

                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
    }
}
