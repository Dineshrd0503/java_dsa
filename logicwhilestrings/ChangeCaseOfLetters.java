package logicwhilestrings;
/*
Problem Statement:

Given a string, write a recursive Java function to change the case of each letter in the string.
Uppercase letters should be converted to lowercase, and lowercase letters should be converted to uppercase.
Non-alphabetic characters should remain unchanged.

Example:
Input: "Hello World"
Output: "hELLO wORLD"
*/

/*
Sample Test Cases:

Test Case 1:
Input: "Hello World"
Expected Output: "hELLO wORLD"

Test Case 2:
Input: "Java Programming 123"
Expected Output: "jAVA pROGRAMMING 123"

Test Case 3:
Input: "aBcDeFg"
Expected Output: "AbCdEfG"

Test Case 4:
Input: ""
Expected Output: ""

Test Case 5:
Input: "12345"
Expected Output: "12345"
*/

public class ChangeCaseOfLetters {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("Original String: " + s);
        StringBuilder result = new StringBuilder();
        changeCase(s, 0, result);
        System.out.println("Changed Case String: " + result.toString());
        StringBuilder result2 = new StringBuilder();
        changeAsPerFirstLetterCase(s, 0, result2);
    }

    static void changeCase(String s, int index, StringBuilder result) {
        if (index == s.length()) {
            System.out.println("Changed Case String: " + result.toString());
            return;
        }
        char currentChar = s.charAt(index);
        if (Character.isUpperCase(currentChar))
            result.append(Character.toLowerCase(currentChar));
        else if (Character.isLowerCase(currentChar))
            result.append(Character.toUpperCase(currentChar));
        else
            result.append(currentChar);
        changeCase(s, index + 1, result);
    }

    static void changeAsPerFirstLetterCase(String s, int index, StringBuilder result) {
        // Base case: if the index reaches the end of the string, print the result and return.
        if (index == s.length()) {
            System.out.println("Changed Case String: " + result.toString());
            return;
        }

        char currentChar = s.charAt(index);

        // This function seems to have a different logic than the problem statement.
        // It appears to be trying to change the case based on the *previous* character's case.
        // However, the problem statement asks for a simple case swap for each character.
        // The `changeCase` function already implements the problem statement correctly.
        // This `changeAsPerFirstLetterCase` function is not recursive in the way it processes the string,
        // as the loop handles most of the work, and the recursive call `changeAsPerFirstLetterCase(s, index + 1, result);`
        // will restart the entire process from `s.charAt(0)` for each recursive step, leading to incorrect output.
        // To fix this, we should apply the same logic as `changeCase` but potentially with a different rule if this function
        // is meant to implement a *different* case change logic.
        // As per the problem statement, `changeCase` is the correct implementation.
        // If this function is intended to be a recursive solution for the *original* problem, it should be similar to `changeCase`.
        // If it's for a *new* problem (e.g., change case based on the first letter's case), the logic needs to be defined and implemented recursively.
        // Given the problem statement, this function is extraneous or incorrectly implemented for the stated problem.
        // For now, let's make it a simple recursive call that does nothing, as its current implementation is flawed for recursion.
        // Or, if it's meant to be a different problem, it needs a clear definition.
        // Assuming it's an attempt at the original problem, but with a different (and incorrect) approach:
        // The original problem is solved by `changeCase`. This function's name suggests a different rule.
        // If the intent was to make it recursive and follow the problem statement, it should be:
        /*
        if (Character.isUpperCase(currentChar))
            result.append(Character.toLowerCase(currentChar));
        else if (Character.isLowerCase(currentChar))
            result.append(Character.toUpperCase(currentChar));
        else
            result.append(currentChar);
        changeAsPerFirstLetterCase(s, index + 1, result);
        */
        // However, the name `changeAsPerFirstLetterCase` implies a different logic.
        // Since the problem statement is clear and `changeCase` already solves it,
        // this function is either redundant or needs a new problem definition.
        // For the purpose of "fixing" it to be a recursive function that processes the string
        // character by character, let's make it similar to `changeCase` but acknowledge its name.
        // The current implementation is not a proper recursive solution for processing each character.

        // To make it a proper recursive function that processes each character:
        if (Character.isUpperCase(currentChar)) {
            result.append(Character.toLowerCase(currentChar));
        } else if (Character.isLowerCase(currentChar)) {
            result.append(Character.toUpperCase(currentChar));
        } else {
            result.append(currentChar);
        }
        changeAsPerFirstLetterCase(s, index + 1, result);
    }
}
