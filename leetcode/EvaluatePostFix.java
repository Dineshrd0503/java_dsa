package leetcode;

import java.util.Stack;

//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.
//
//
//Example 1:
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//        = ((10 * (6 / (12 * -11))) + 17) + 5
//        = ((10 * (6 / -132)) + 17) + 5
//        = ((10 * 0) + 17) + 5
//        = (0 + 17) + 5
//        = 17 + 5
//        = 22
public class EvaluatePostFix {
    public int evaluateexp(String[] exp){
    Stack<Integer> stack = new Stack<>();

        for (String token : exp) {
        // Check if the token is an operator
        if (token.length() == 1 && "+-*/".contains(token)) {
            int a1 = stack.pop();
            int a2 = stack.pop();
            switch (token.charAt(0)) {
                case '+':
                    stack.push(a2 + a1);
                    break;
                case '-':
                    stack.push(a2 - a1);
                    break;
                case '*':
                    stack.push(a2 * a1);
                    break;
                case '/':
                    // Perform integer division, truncating towards zero
                    stack.push(a2 / a1);
                    break;
            }
        } else {
            // Parse the number and push it onto the stack
            stack.push(Integer.parseInt(token));
        }
    }
        return stack.pop();

}

    public static void main(String[] args) {
        String[] exp = {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluatePostFix().evaluateexp(exp)); // Output: 9
    }


}

