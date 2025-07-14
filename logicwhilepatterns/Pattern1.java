package logicwhilepatterns;

/*
Problem Statement:
Write a Java program to print two triangular star patterns using nested loops:
1. A right-angled triangle with n rows, where the i-th row (0-based index) contains i+1 stars,
   each separated by a space.
2. An inverted right-angled triangle with n rows, where the i-th row (0-based index) contains
   n-i stars, each separated by a space.
For example, for n = 5, the output should be:
*
* *
* * *
* * * *
* * * * *
* * * * *
* * * *
* * *
* *
*
The program uses a static input for the number of rows (n) and prints the patterns sequentially.
*/

public class Pattern1 {
    // Method to print the star patterns for a given number of rows
    public static void printStarPatterns(int n) {
        // First pattern: Right-angled triangle (increasing stars)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Second pattern: Inverted right-angled triangle (decreasing stars)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case 1: n = 5
        System.out.println("Test Case 1: n = 5");
        printStarPatterns(5);

        // Test Case 2: n = 3
        System.out.println("\nTest Case 2: n = 3");
        printStarPatterns(3);
    }
}