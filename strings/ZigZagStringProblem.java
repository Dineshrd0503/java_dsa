package strings;


/*
 * Problem Statement:
 * Given a string STR and a number M (number of rows),
 * convert the string in a zig-zag (wave) pattern with M rows.
 * Then read the characters row by row to get the final string.
 *
 * Example:
 * Input: STR = "CODINGNINJAS", M = 3
 * Pattern:
 * C   N   N   J
 * O I G I J S
 * D     N     A
 * Output: "CNNOIGIJSDNA"
 */

public class ZigZagStringProblem {

    /**
     * Converts a given string into its Zig-Zag pattern and returns the row-wise concatenated result.
     * @param str: The input string to convert.
     * @param m: Number of rows for the zig-zag pattern.
     * @return The zig-zag converted string.
     */
    public static String zigZagString(String str, int m) {
        // Handle edge case: only one row or string is empty
        if (m <= 1 || str.length() == 0)
            return str;

        // Create an array of StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[m];
        for (int i = 0; i < m; i++)
            rows[i] = new StringBuilder();

        int curRow = 0;
        boolean goingDown = true;

        // Traverse the input string character by character
        for (char c : str.toCharArray()) {
            rows[curRow].append(c);
            // Change direction if we reach the first or last row
            if (curRow == 0)
                goingDown = true;
            else if (curRow == m - 1)
                goingDown = false;
            curRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows for the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);
        return result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String input1 = "CODINGNINJAS";
        int rows1 = 3;
        System.out.println("Zig-Zag result: " + zigZagString(input1, rows1));

        // Example 2
        String input2 = "ABCDEFG";
        int rows2 = 3;
        System.out.println("Zig-Zag result: " + zigZagString(input2, rows2));

        // Example 3
        String input3 = "NINJA";
        int rows3 = 2;
        System.out.println("Zig-Zag result: " + zigZagString(input3, rows3));
    }
}
