package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a number pattern for n rows in a square grid of size n x n using nested loops.
The pattern places numbers as follows:
- The number 1 on the diagonal where the row index equals the column index (i == j).
- The numbers 1 to n in the first row (row index i == 0), where the j-th column has the number j+1.
- The number n-i in the last column (column index j == n-1), except where i == 0 (first row takes precedence).
All other positions are filled with spaces. For example, for n = 5, the output should be:
12345
 1  4
  1 3
   1 2
    1
The program uses a static input for the number of rows (n).
*/

public class AlphabeticDiagonalPattern {
    // Method to print the diagonal number pattern for a given number of rows
    public static void printDiagonalNumberPattern(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {
                // First row: print j+1
                if (i == 0) {
                    System.out.print((char)(j + 'A'));
                }
                // Diagonal: print 1
                else if (i == j) {
                    System.out.print('A');
                }
                // Last column: print n-i
                else if (j == n - 1) {
                    System.out.print((char)('A'+n - i-1));
                }
                // Other positions: print space
                else {
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
        printDiagonalNumberPattern(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printDiagonalNumberPattern(3);
    }
}

