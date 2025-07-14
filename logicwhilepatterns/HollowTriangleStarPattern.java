package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a star pattern for n rows using nested loops. A star (*) is printed
in the following positions:
- The first column of every row (column index j == 0).
- The diagonal where the row index equals the column index (i == j).
- The last row (row index i == n-1).
All other positions are filled with spaces. For example, for n = 5, the output should be:
*
**
* *
*  *
*****
The program uses a static input for the number of rows (n).
*/

public class HollowTriangleStarPattern {
    // Method to print the custom star pattern for a given number of rows
    public static void printCustomStarPattern(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {
                // Print star if: first column (j == 0), diagonal (i == j), or last row (i == n-1)
                if (j == 0 || i == j || i == n - 1) {
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
        printCustomStarPattern(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printCustomStarPattern(3);
    }
}
