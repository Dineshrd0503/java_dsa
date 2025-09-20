package stacks;

public class MinAddToMakeParenthesesValid {

    /**
     * You are given a string s consisting only of the characters '(' and ')'.
     * Your task is to determine the minimum number of parentheses (either '(' or ')')
     * that must be inserted at any positions to make the string s a valid parentheses string.
     *
     * A parentheses string is considered valid if:
     * 1. Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
     * 2. Every closing parenthesis ')' has a corresponding opening parenthesis '('.
     * 3. Parentheses are properly nested.
     *
     * Examples:
     * Input: s = "(()("
     * Output: 2
     * Explanation: There are two unmatched '(' at the end, so we need to add two ')' to make the string valid.
     *
     * Input: s = ")))"
     * Output: 3
     * Explanation: Three '(' need to be added at the start to make the string valid.
     *
     * Input: s = ")()()"
     * Output: 1
     * Explanation: The very first ')' is unmatched, so we need to add one '(' at the beginning.
     *
     * Constraints:
     * 1 <= s.size() <= 10^5
     * s[i] ∈ { '(' , ')' }
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static int minParentheses(String s) {
        int balance = 0;
        int addsNeeded = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    addsNeeded++;
                }
            }
        }

        return addsNeeded + balance;
    }

    public static void main(String[] args) {
        // Sample Test Cases
        String s1 = "(()(";
        String s2 = ")))";
        String s3 = ")()()";
        String s4 = "()";
        String s5 = ")((";
        String s6 = "";
        String s7 = "((((((((((((((((((((((((())))))))))))))))))))))))";

        System.out.println("Input: " + s1 + ", Output: " + minParentheses(s1)); // Expected: 2
        System.out.println("Input: " + s2 + ", Output: " + minParentheses(s2)); // Expected: 3
        System.out.println("Input: " + s3 + ", Output: " + minParentheses(s3)); // Expected: 1
        System.out.println("Input: " + s4 + ", Output: " + minParentheses(s4)); // Expected: 0
        System.out.println("Input: " + s5 + ", Output: " + minParentheses(s5)); // Expected: 2
        System.out.println("Input: " + s6 + ", Output: " + minParentheses(s6)); // Expected: 0
        System.out.println("Input: " + s7 + ", Output: " + minParentheses(s7)); //Expected: 0

    }
}