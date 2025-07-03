package stacks;



import java.util.Stack;

/*
 * Problem: Convert Infix Expression to Postfix
 * Convert an infix expression to its postfix (Reverse Polish Notation) equivalent using a stack.
 *
 * Input:
 * - e: String representing an infix expression
 *
 * Output:
 * - String representing the postfix expression
 *
 * Example:
 * Test Case 1: e = "A+B*(C-D)", Output = "ABCD-+*"
 * Test Case 2: e = "A+B*C", Output = "ABC*+"
 */
public class InfixToPostfix {
    public static String infixToPostfix(String e) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : e.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                sb.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    sb.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    private static int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] expressions = {"A+B*(C-D)", "A+B*C"};
        for (int t = 0; t < expressions.length; t++) {
            String result = infixToPostfix(expressions[t]);
            System.out.println("Test Case " + (t + 1) + ": e = " + expressions[t] + ", Output = " + result);
        }
    }
}
