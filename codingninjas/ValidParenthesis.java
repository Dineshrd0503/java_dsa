package codingninjas;
import java.util.*;
//You're given a string 'S' consisting of "{", "}", "(", ")", "[" and "]" .
//
//
//
//Return true if the given string 'S' is balanced, else return false.
//
//
//
//For example:
//        'S' = "{}()".
//
//There is always an opening brace before a closing brace i.e. '{' before '}', '(' before ').
//So the 'S' is Balanced.
//Sample Input 1 :
//        [()]{}{[()()]()}
//        Sample Output 1 :
//        Balanced
//        Explanation Of the Sample Input 1 :
//        There is always an opening brace before a closing brace i.e. '{' before '}', '(' before '), '[' before ']'.
//        So the 'S' is Balanced.
//        Sample Input 2 :
//        [[}[
//        Sample Output 2 :
//        Not Balanced
//        Constraints:
//        1 <= 'N' <= 10^5

public class ValidParenthesis {
    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='{'||c=='['||c=='(')
                stack.push(c);
            else if(c=='}'||c==']'||c==')'){
                if(stack.isEmpty())
                    return false;
                char top=stack.pop();
                if(c=='{'&&top!='}'||c=='['&&c!=']'||c=='('&&c!=')')
                    return false;
            }

        }
        return stack.isEmpty();

        // Write your code here.
    }
    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isValidParenthesis(s)); // Output: true
    }
}
