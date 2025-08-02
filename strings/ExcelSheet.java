package strings;

/**
 * Problem Statement:
 * Given a string STR representing the column title in an Excel Sheet, find its
 * corresponding column number. For example: A corresponds to 1, B to 2, C to 3,
 * ..., Z to 26, AA to 27, and so on.
 *
 * Constraints:
 * - 1 ≤ T ≤ 50 (number of test cases)
 * - 1 ≤ |STR| ≤ 12 (length of the string)
 * - STR contains only uppercase English letters (A-Z)
 *
 * Time Limit: 1 sec
 *
 * Examples:
 * Example 1:
 * Input: STR = "A"
 * Output: 1
 * Explanation: A corresponds to column number 1.
 *
 * Input: STR = "AB"
 * Output: 28
 * Explanation: A = 1 * 26^1, B = 2 * 26^0, total = 1 * 26 + 2 = 28.
 *
 * Input: STR = "F"
 * Output: 6
 * Explanation: F corresponds to column number 6.
 *
 * Example 2:
 * Input: STR = "AZ"
 * Output: 52
 * Explanation: A = 1 * 26^1, Z = 26 * 26^0, total = 1 * 26 + 26 = 52.
 *
 * Input: STR = "COD"
 * Output: 2422
 * Explanation: C = 3 * 26^2, O = 15 * 26^1, D = 4 * 26^0, total = 3 * 676 + 15 * 26 + 4 = 2422.
 *
 * Input: STR = "ZZZ"
 * Output: 18278
 * Explanation: Z = 26 * 26^2, Z = 26 * 26^1, Z = 26 * 26^0, total = 26 * 676 + 26 * 26 + 26 = 18278.
 */
public class ExcelSheet{
    public static long titleToNumber(String str) {
        // Initialize result to store the column number
        long result = 0;

        // Process each character from left to right
        for (char c : str.toCharArray()) {
            // Multiply current result by 26 (base-26 place value shift)
            result *= 26;
            // Add value of current character (A=1, B=2, ..., Z=26)
            result += (c - 'A' + 1);
        }

        return result;
    }

    // Main method to test the solution with sample test cases
    public static void main(String[] args) {
        // Test cases from Sample Input 1
        String[] testCases1 = {"A", "AB", "F"};
        long[] expected1 = {1, 28, 6};

        System.out.println("Sample Input 1:");
        for (int i = 0; i < testCases1.length; i++) {
            System.out.println("Input: STR = \"" + testCases1[i] + "\"");
            System.out.println("Output: " + titleToNumber(testCases1[i]));
            System.out.println("Expected: " + expected1[i]);
            System.out.println();
        }

        // Test cases from Sample Input 2
        String[] testCases2 = {"AZ", "COD", "ZZZ"};
        long[] expected2 = {52, 2422, 18278};

        System.out.println("Sample Input 2:");
        for (int i = 0; i < testCases2.length; i++) {
            System.out.println("Input: STR = \"" + testCases2[i] + "\"");
            System.out.println("Output: " + titleToNumber(testCases2[i]));
            System.out.println("Expected: " + expected2[i]);
            System.out.println();
        }
    }
}