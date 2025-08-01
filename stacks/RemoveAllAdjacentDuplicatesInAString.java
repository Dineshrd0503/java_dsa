package stacks;
import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 *
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class RemoveAllAdjacentDuplicatesInAString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInAString s=new RemoveAllAdjacentDuplicatesInAString();
        String s1 = "abbaca";
        System.out.println("Input: " + s1 + ", Output: " + solution.removeDuplicates(s1)); // Expected: "ca"

        String s2 = "azxxzy";
        System.out.println("Input: " + s2 + ", Output: " + solution.removeDuplicates(s2)); // Expected: "ay"

        String s3 = "aaaaaaaaa";
        System.out.println("Input: " + s3 + ", Output: " + solution.removeDuplicates(s3)); // Expected: a

        String s4 = "aaaaaaaa";
        System.out.println("Input: " + s4 + ", Output: " + solution.removeDuplicates(s4)); // Expected: ""

        String s5 = "abbbabaaa";
        System.out.println("Input: " + s5 + ", Output: " + solution.removeDuplicates(s5)); // Expected: "ababa"
    }
}
