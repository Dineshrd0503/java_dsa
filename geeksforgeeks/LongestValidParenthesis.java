package geeksforgeeks;

import java.util.Stack;


//Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.
//
//A parenthesis string is valid if:
//
//For every opening parenthesis, there is a closing parenthesis.
//The closing parenthesis must be after its opening parenthesis.
//        Examples :
//
//Input: s = "((()"
//Output: 2
//Explanation: The longest valid parenthesis substring is "()".
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parenthesis substring is "()()".
//Input: s = "())()"
//Output: 2
//Explanation: The longest valid parenthesis substring is "()".
//Constraints:
//        1 ≤ s.size() ≤ 106
//s consists of '(' and ')' only

public class LongestValidParenthesis {
    static int maxLength(String s) {
        // code here
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    max=Math.max(max,i-stack.peek());
            }
        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println("longest valid parenthesis");
        System.out.println(maxLength(")()())"));
    }

}
