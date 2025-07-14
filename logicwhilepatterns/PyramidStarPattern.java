package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a right-aligned pyramid pattern with n = 5 rows using nested loops.
The pattern uses asterisks (*) to form the pyramid shape, with the number of asterisks increasing
by 2 per row (starting with 1). Leading spaces are used to align the pyramid to the right.
For example, for n = 5, the output should be:
    *
   ***
  *****
 *******
*********
The program uses a static input for the number of rows (n).
*/

public class PyramidStarPattern {
    // Method to print the pyramid star pattern for a given number of rows
    public static void printPyramidStarPattern(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            // Newline after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case: n = 5
        System.out.println("Test Case: n = 5");
        printPyramidStarPattern(5);
    }
}
