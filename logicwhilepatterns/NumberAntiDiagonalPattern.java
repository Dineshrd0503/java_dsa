package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a number pattern for n rows in a square grid of size n x n using nested loops.
The pattern places numbers as follows:
- The number 1 in the first column of each row (column index j == 0).
- The numbers 1 to n in the last row (row index i == n-1), where the j-th column has the number j+1.
- The number i+1 (row number, 1-based) on the anti-diagonal where the sum of row and column indices equals n-1 (i + j == n-1).
All other positions are filled with spaces. For example, for n = 5, the output should be:
    1
   12
  1  3
 1    4
12345
The program uses a static input for the number of rows (n).
*/

public class NumberAntiDiagonalPattern {
    // Method to print the number anti-diagonal pattern for a given number of rows
    public static void printNumberAntiDiagonalPattern(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {

                if(i==n-1)
                    System.out.print(j+1);
                else if(i+j==n-1)
                    System.out.print("1");
                else if(j==n-1)
                    System.out.print(i+1);
                else
                    System.out.print(" ");
            }
            // Newline after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case 1: n = 5
        System.out.println("Test Case 1: n = 5");
        printNumberAntiDiagonalPattern(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printNumberAntiDiagonalPattern(3);
    }
}