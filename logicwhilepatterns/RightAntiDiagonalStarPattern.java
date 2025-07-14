package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a star pattern for n rows using nested loops. A star (*) is printed
in the following positions:
- The last column of every row (column index j == n-1).
- The last row (row index i == n-1).
- The anti-diagonal where the sum of the row and column indices equals n-1 (i + j == n-1).
All other positions are filled with spaces. For example, for n = 5, the output should be:
    *
   * *
  *  *
 *   *
*****
The program uses a static input for the number of rows (n).
*/

public class RightAntiDiagonalStarPattern {
    // Method to print the right-aligned anti-diagonal star pattern for a given number of rows
    public static void printRightAntiDiagonalStarPattern(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {
                // Print star if: last column (j == n-1), last row (i == n-1), or anti-diagonal (i + j == n-1)
                if (j == n - 1 || i == n - 1 || i + j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // Newline after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case 1: n = 5
        System.out.println("Test Case 1: n = 5");
        printRightAntiDiagonalStarPattern(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printRightAntiDiagonalStarPattern(3);
    }
}
