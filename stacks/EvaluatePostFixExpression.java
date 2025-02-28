package stacks;
import java.util.Stack;
public class EvaluatePostFixExpression {
        public static int evaluate(String[] arr) {
            Stack<Integer> stack = new Stack<>();
            for (String token : arr) {
                try {
                    int num = Integer.parseInt(token);
                    stack.push(num);
                } catch (NumberFormatException e) {
                    int a1 = stack.pop();
                    int a2 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(a2 + a1);
                            break;
                        case "-":
                            stack.push(a2 - a1);
                            break;
                        case "*":
                            stack.push(a2 * a1);
                            break;
                        case "/":
                            stack.push(a2 / a1);
                            break;
                    }
                }
            }
            return stack.pop();
        }

        public static void main(String[] args) {
            String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
            System.out.println(evaluate(arr)); // Output: -4
        }
    }
