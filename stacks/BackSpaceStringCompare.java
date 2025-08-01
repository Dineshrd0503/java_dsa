package stacks;
// Problem Statement:
// Given two strings s and t, return true if they are equal when both are typed into empty text editors. 
// '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Example 3:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

public class BackSpaceStringCompare {
    /**
     * Compares two strings after applying backspace operations.
     *
     * @param s The first string.
     * @param t The second string.
     * @return {@code true} if the processed strings are equal, {@code false} otherwise.
     */
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    /**
     * Processes a string by applying backspace operations.
     *
     * @param str The string to process.
     * @return The processed string.
     */
    private String processString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c); // Append the character if it's not a backspace
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1); // Delete the last character if it is a backspace and stringbuilder is not empty
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        BackSpaceStringCompare solution=new BackSpaceStringCompare();

        // Test cases
        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println("Test Case 1: s = \"" + s1 + "\", t = \"" + t1 + "\" -> " + solution.backspaceCompare(s1, t1)); // Expected: true

        String s2 = "ab##";
        String t2 = "c#d#";
        System.out.println("Test Case 2: s = \"" + s2 + "\", t = \"" + t2 + "\" -> " + solution.backspaceCompare(s2, t2)); // Expected: true

        String s3 = "a#c";
        String t3 = "b";
        System.out.println("Test Case 3: s = \"" + s3 + "\", t = \"" + t3 + "\" -> " + solution.backspaceCompare(s3, t3)); // Expected: false

        String s4 = "xywrrmp";
        String t4 = "xywrrmu#p";
        System.out.println("Test Case 4: s = \"" + s4 + "\", t = \"" + t4 + "\" -> " + solution.backspaceCompare(s4, t4)); //Expected true Test case
    }
}
