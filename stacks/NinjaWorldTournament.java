package stacks;

import java.util.*;

/*
    Problem Statement: Ninja World Tournament

    You are given a list of strings matchResult[] of length N, where each string can be:
    - An integer (score for this round)
    - "+" (sum the previous two valid scores and push)
    - "D" (double the previous valid score and push)
    - "C" (remove the previous valid score)

    Implement a function 'calculateScore' to return the total score after all operations are performed.

    Example Input:
    matchResult = ["5", "2", "C", "D", "+"]
    Output: 30

    Explanation:
    - "5" -> push 5   [5]
    - "2" -> push 2   [5, 2]
    - "C" -> pop      [5]
    - "D" -> push 10  [5, 10]
    - "+" -> push 15  [5, 10, 15]
    Final Sum = 5 + 10 + 15 = 30
*/

public class NinjaWorldTournament {
    public static int calculateScore(ArrayList<String> matchResult, int n) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : matchResult) {
            if (s.equals("+")) {
                int val2 = stack.pop();
                int val1 = stack.peek();
                int val = val1 + val2;
                stack.push(val2);    // Restore
                stack.push(val);     // Push sum
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                try {
                    stack.push(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    // Ignore invalid input
                }
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<String> matchResult = new ArrayList<>(Arrays.asList("5", "2", "C", "D", "+"));
        int n = matchResult.size();
        int result = calculateScore(matchResult, n);
        System.out.println("Final Score: " + result); // Output: Final Score: 30
    }
}
