package patterns;

/**
 * Problem Statement:
 * Ninja wants to build a star pattern for a given odd number N.
 * The pattern should have N rows with stars arranged in a symmetric pattern:
 * - Rows increase in stars until the middle row
 * - Rows decrease symmetrically after the middle row
 *
 * Example for N=7:
 * *
 * **
 * ***
 * ****
 * ***
 * **
 * *
 */

public class GalaxyofStars {

    public static String[] galaxyofStar(int n) {
        // Handle invalid input (even numbers)
        if(n % 2 == 0) {
            return new String[0];
        }

        String[] result = new String[n];
        int mid = n / 2;

        // Build upper half and middle row
        for(int i=0; i<=mid; i++) {
            String stars = "*".repeat(i+1);  // Java 11+ feature
            result[i] = stars;
            result[n-1-i] = stars;
        }

        return result;
    }

    public static void main(String[] args) {
        /* Test Case 1: N=7 (Standard Case)
         * Expected Output:
         * *
         * **
         * ***
         * ****
         * ***
         * **
         * *
         */
        System.out.println("Test Case 1 (N=7):");
        String[] pattern1 = galaxyofStar(7);
        for(String row : pattern1) {
            System.out.println(row);
        }

        /* Test Case 2: N=1 (Edge Case)
         * Expected Output:
         * *
         */
        System.out.println("\nTest Case 2 (N=1):");
        String[] pattern2 = galaxyofStar(1);
        for(String row : pattern2) {
            System.out.println(row);
        }

        /* Test Case 3: N=5 (Odd Number)
         * Expected Output:
         * *
         * **
         * ***
         * **
         * *
         */
        System.out.println("\nTest Case 3 (N=5):");
        String[] pattern3 = galaxyofStar(5);
        for(String row : pattern3) {
            System.out.println(row);
        }

        /* Test Case 4: N=4 (Even Number - Invalid Input)
         * Expected Output: []
         */
        System.out.println("\nTest Case 4 (N=4):");
        String[] pattern4 = galaxyofStar(4);
        System.out.println("Rows generated: " + pattern4.length);
    }
}

