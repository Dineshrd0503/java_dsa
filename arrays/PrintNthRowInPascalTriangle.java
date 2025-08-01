package arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintNthRowInPascalTriangle{
    /**
     * Given a positive integer n, return the nth row of Pascal's triangle.
     * Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of the previous row.
     *
     * Examples:
     * Input: n = 4
     * Output: [1, 3, 3, 1]
     * Explanation: 4th row of pascal's triangle is [1, 3, 3, 1].
     *
     * Input: n = 5
     * Output: [1, 4, 6, 4, 1]
     * Explanation: 5th row of pascal's triangle is [1, 4, 6, 4, 1].
     *
     * Input: n = 1
     * Output: [1]
     * Explanation: 1st row of pascal's triangle is [1].
     *
     * Constraints:
     * 1 ≤ n ≤ 30
     *
     * @param n The row number (1-indexed)
     * @return The nth row of Pascal's triangle
     */
    public ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        long value = 1;

        row.add((int)value);

        for (int k = 1; k < n; k++) {
            value = value * (n - k);
            value = value / k;
            row.add((int)value);
        }

        return row;
    }

    public static void main(String[] args) {
       PrintNthRowInPascalTriangle solution=new PrintNthRowInPascalTriangle();
        // Test case 1
        int n1 = 1;
        ArrayList<Integer> result1 = solution.nthRowOfPascalTriangle(n1);
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + result1); // Output: [1]
        System.out.println("Expected: [1]");
        System.out.println();

        // Test case 2
        int n2 = 4;
        ArrayList<Integer> result2 = solution.nthRowOfPascalTriangle(n2);
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + result2); // Output: [1, 3, 3, 1]
        System.out.println("Expected: [1, 3, 3, 1]");
        System.out.println();


        // Test case 3
        int n3 = 5;
        ArrayList<Integer> result3 = solution.nthRowOfPascalTriangle(n3);
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + result3); // Output: [1, 4, 6, 4, 1]
        System.out.println("Expected: [1, 4, 6, 4, 1]");
        System.out.println();

        // Test case 4
        int n4 = 10;
        ArrayList<Integer> result4 = solution.nthRowOfPascalTriangle(n4);
        System.out.println("Input: n = " + n4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]");
        System.out.println();

        // Test case 5
        int n5 = 15;
        ArrayList<Integer> result5 = solution.nthRowOfPascalTriangle(n5);
        System.out.println("Input: n = " + n5);
        System.out.println("Output: " + result5);
		System.out.println("Expected: [1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1]");
        System.out.println();


        // Test case 6 (Boundary case)
        int n6 = 30;
        ArrayList<Integer> result6 = solution.nthRowOfPascalTriangle(n6);
        System.out.println("Input: n = " + n6);
        System.out.println("Output: " + result6);
		System.out.println("Expected: [1, 29, 406, 3192, 17503, 73628, 262957, 775204, 1960580, 4292145, 8164635, 13607725, 19612550, 24900450, 27405225, 27405225, 24900450, 19612550, 13607725, 8164635, 4292145, 1960580, 775204, 262957, 73628, 17503, 3192, 406, 29, 1]");
        System.out.println();


    }
}
