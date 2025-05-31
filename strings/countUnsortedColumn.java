package strings;
        /*
 * Problem Statement:
 * You are given an array ‘STRINGS’ having ‘N’ number of strings. The strings are assumed to be arranged such that there is one string in one line.
 * You need to return the number of columns that are not sorted lexicographically.
 *
 * Note:
 * The length of all the strings in the array is the same.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 100
 * 1 <= L <= 10^3
 * Where ‘T’ is the number of test cases, ‘N’ is the number of strings, and ‘L’ is each string’s length.
 *
 * Sample Input 1:
 * 2
 * 3
 * bccde
 * dehrt
 * gabzy
 * 2
 * wr
 * yz
 *
 * Sample Output 1:
 * 2
 * 0
 *
 * Explanation of Sample Input 1:
 * Test Case 1: In the given strings -
 * Column 0 - b, d, g is sorted
 * Column 1 - c, e, a is not sorted
 * Column 2 - c, h, b is not sorted
 * Column 3 - d, r, z is sorted
 * Column 4 - e, t, y is sorted.
 * Column 1, column 2 are not sorted, so the required answer is ‘2’.
 *
 * Test Case 2: Both the columns (‘w’, ‘y’) and (‘r’, ‘z’) are sorted. So the answer is ‘0’.
 *
 * Sample Input 2:
 * 2
 * 4
 * u
 * e
 * y
 * b
 * 2
 * cterub
 * aybsgn
 *
 * Sample Output 2:
 * 1
 * 3
 */

// Main class to count unsorted columns in an array of strings
public class countUnsortedColumn {
    // Method to count the number of columns that are not lexicographically sorted
    public static int countColumns(String[] strings) {
        // Edge case: if the array is empty, return 0
        if (strings == null || strings.length == 0) {
            return 0;
        }

        int n = strings.length; // Number of strings
        int m = strings[0].length(); // Length of each string
        int result = 0;

        // Iterate over each column
        for (int col = 0; col < m; col++) {
            char[] seq = new char[n];
            // Extract characters in the current column
            for (int row = 0; row < n; row++) {
                seq[row] = strings[row].charAt(col);
            }

            // Check if the column is lexicographically sorted
            boolean issorted = true;
            for (int i = 1; i < n; i++) {
                if (seq[i] < seq[i - 1]) {
                    issorted = false;
                    break;
                }
            }

            // Increment result if the column is not sorted
            if (!issorted) {
                result++;
            }
        }

        return result;
    }

    // Main method to test the countColumns function with sample test cases
    public static void main(String[] args) {
        // Test Case 1
        String[] test1 = {"bccde", "dehrt", "gabzy"};
        System.out.println("Test Case 1:");
        System.out.println("Input: [\"bccde\", \"dehrt\", \"gabzy\"]");
        System.out.println("Output: " + countColumns(test1));

        // Test Case 2
        String[] test2 = {"wr", "yz"};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: [\"wr\", \"yz\"]");
        System.out.println("Output: " + countColumns(test2));

        // Test Case 3 (Sample Input 2, Test Case 1)
        String[] test3 = {"u", "e", "y", "b"};
        System.out.println("\nTest Case 3:");
        System.out.println("Input: [\"u\", \"e\", \"y\", \"b\"]");
        System.out.println("Output: " + countColumns(test3));

        // Test Case 4 (Sample Input 2, Test Case 2)
        String[] test4 = {"cterub", "aybsgn"};
        System.out.println("\nTest Case 4:");
        System.out.println("Input: [\"cterub\", \"aybsgn\"]");
        System.out.println("Output: " + countColumns(test4));
    }
}