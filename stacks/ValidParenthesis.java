package stacks;

import java.util.Stack;


//Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
//An input string is valid if:
//
//        1. Open brackets must be closed by the same type of brackets.
//         2. Open brackets must be closed in the correct order.
//
//        Examples :
//
//Input: s = "[{()}]"
//Output: true
//Explanation: All the brackets are well-formed.
//        Input: s = "[()()]{}"
//Output: true
//Explanation: All the brackets are well-formed.
//        Input: s = "([]"
//Output: False
//Explanation: The expression is not balanced as there is a missing ')' at the end.
//        Input: s = "([{]})"
//Output: False
//Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
//Constraints:
//        1 ≤ s.size() ≤ 106
//s[i] ∈ {'{', '}', '(', ')', '[', ']'}



public class ValidParenthesis {
    static boolean isBalanced(String a) {
        // code here
        Stack<Character> stack=new Stack<>();
        for(char c:a.toCharArray()){
            if(c=='('||c=='['||c=='{')
                stack.push(c);
            else if(c=='}'||c==']'||c==')'){
                if(stack.isEmpty())
                    return false;
                char s=stack.pop();
                if((c=='}'&&s!='{')||(c==']'&&s!='[')||c==')'&&s!='(')
                    return false;
            }
        }

        return stack.isEmpty();

    }
    public static void main(String[] args) {
        System.out.println("valid parenthesis");
        System.out.println(isBalanced("{([])}"));
    }
}
