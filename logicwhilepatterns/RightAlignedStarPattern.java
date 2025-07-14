package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print a right-aligned triangular star pattern with n rows.
In the i-th row (0-based index), print n-i-1 spaces followed by i+1 stars to form a
right-aligned triangle. For example, for n = 5, the output should be:
    *
   **
  ***
 ****
*****
The program uses nested loops and a static input for the number of rows (n).
*/

public class RightAlignedStarPattern {
    // Method to print the right-aligned star pattern for a given number of rows
    public static void printRightAlignedStarPattern(int n) {
        // Outer loop for each row
        for (int i = 0; i < n; i++) {
            // Inner loop for spaces (n-i-1 spaces)
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars (i+1 stars)
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            // Newline after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case 1: n = 5
        System.out.println("Test Case 1: n = 5");
        printRightAlignedStarPattern(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printRightAlignedStarPattern(3);
    }
}
