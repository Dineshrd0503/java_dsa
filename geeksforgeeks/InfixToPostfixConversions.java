package geeksforgeeks;

//You are given a string 'exp' which is a valid infix expression.
//
//
//
//Convert the given infix expression to postfix expression.
//
//
//
//Note:
//Infix notation is a method of writing mathematical expressions in which operators are placed between operands.
//
//For example, "3 + 4" represents the addition of 3 and 4.
//
//Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands.
//
//For example, "3 4 +" represents the addition of 3 and 4.
//
//Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’.
//
//
//Example:
//Input: exp = ‘3+4*8’
//
//Output: 348*+
//
//Explanation:
//Here multiplication is performed first and then the addition operation. Hence postfix expression is  3 4 8 * +.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        3^(1+1)
//
//
//Expected Answer:
//        311+^
//
//
//Output printed on console:
//        311+^
//
//
//Explanation of Sample Input 1:
//For this testcase, we will evaluate 'b' = (1+1) first.
//
//Hence it's equivalent postfix expression will be "11+".
//
//Next we will evaluate 3^b. It's equivalent postfix expression will be "3b^".
//
//Replacing 'b' with it's equivalent postfix we get "311+^".
//
//
//Sample Input 2:
//a+b+c+d-e
//
//
//Expected Answer:
//ab+c+d+e-
//
//
//Output printed on console:
//ab+c+d+e-
//
//
//Expected Time Complexity:
//Try to do this in O(n).
//
//
//Constraints:
//        1 <= 'n' <= 5000
//
//        ‘n’, is the length of EXP
//The expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’.
//
//Time Limit: 1 sec


import java.util.Stack;

public class InfixToPostfixConversions {
    public static String infixToPostfix(String s) {
        // Write your code here
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(c);
            else if(c=='(')
                stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty()&&stack.peek()!='(')
                    sb.append(stack.pop());
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
            }
            else{
                while(!stack.isEmpty()&&precedence(stack.peek())>=precedence(c))
                    sb.append(stack.pop());
                stack.push(c);
            }


        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
    private static int precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println("Infix to Postfix");
        String s="3+4*8";
        System.out.println(infixToPostfix(s));
    }
}
