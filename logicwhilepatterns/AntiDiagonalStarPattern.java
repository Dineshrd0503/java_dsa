package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a star pattern for n rows using nested loops. A star (*) is printed
in the following positions:
- The first column of every row (column index j == 0).
- The first row (row index i == 0).
- The anti-diagonal where the sum of the row and column indices equals n-1 (i + j == n-1).
All other positions are filled with spaces. For example, for n = 5, the output should be:
*****
*   *
*  *
* *
*
The program uses a static input for the number of rows (n).
*/

public class AntiDiagonalStarPattern {
    // Method to print the anti-diagonal star pattern for a given number of rows
    public static void printAntiDiagonalStarPattern(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {
                // Print star if: first column (j == 0), first row (i == 0), or anti-diagonal (i + j == n-1)
                if (j == 0 || i == 0 || i + j == n - 1) {
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
        printAntiDiagonalStarPattern(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printAntiDiagonalStarPattern(3);
    }
}
