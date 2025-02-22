package stacks;
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
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s)); // Output: 2
    }

}
