/**
 * Problem Statement:
 * Given a string s consisting of lowercase and uppercase English letters, 
 * a good string is one where there are no adjacent characters that are the 
 * same letter but differ in case (e.g., 'a' and 'A'). Remove all such adjacent 
 * pairs iteratively until the string is good, and return the resulting string.
 * 
 * Constraints:
 * - 1 <= s.length <= 100
 * - s contains only lowercase and uppercase English letters.
 * 
 * Examples:
 * Example 1:
 * Input: s = "Pp"
 * Output: ""
 * Explanation: 'P' and 'p' are the same letter with different cases, so they are removed.
 * 
 * Example 2:
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: 'e' and 'E' are adjacent and form a pair, so they are removed, resulting in "leetcode".
 * 
 * Example 3:
 * Input: s = "abBAcC"
 * Output: ""
 * Explanation: First, 'b' and 'B' are removed to get "aAcC", then 'a' and 'A' to get "cC", then 'c' and 'C' to get "".
 */
package stacks;
import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        // Initialize a StringBuilder to build the result string
        StringBuilder sb = new StringBuilder();
        // Initialize a stack to track characters
        Stack<Character> stack = new Stack<>();
        
        // Process each character in the input string
        for (char c : s.toCharArray()) {
            // Check if the stack is not empty and the top character forms a bad pair
            // A bad pair is when |stack.peek() - c| == 32 (ASCII difference for same letter, different case)
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop(); // Remove the top character (pair cancels out)
            } else {
                stack.push(c); // No pair formed, push current character
            }
        }
        
        // Build the result string from the stack
        for (Character c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
    
    // Main method to test the solution with example test cases
    public static void main(String[] args) {
      MakeTheStringGreat solution=new MakeTheStringGreat();
        
        // Test Case 1: s = "Pp"
        String s1 = "Pp";
        System.out.println("Test Case 1:");
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: \"" + solution.makeGood(s1) + "\"");
        System.out.println("Expected: \"\"");
        
        // Test Case 2: s = "leEeetcode"
        String s2 = "leEeetcode";
        System.out.println("\nTest Case 2:");
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Output: \"" + solution.makeGood(s2) + "\"");
        System.out.println("Expected: \"leetcode\"");
        
        // Test Case 3: s = "abBAcC"
        String s3 = "abBAcC";
        System.out.println("\nTest Case 3:");
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Output: \"" + solution.makeGood(s3) + "\"");
        System.out.println("Expected: \"\"");
    }
}
