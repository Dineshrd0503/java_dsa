package codingninjas;
import java.util.*;
//Given a matrix with ‘N’ rows and ‘M’ columns and an integer ‘K’. Your task is to find the “Kth” element which is obtained while traversing the matrix in spiral form.
//
//Spiral Traversing in the matrix:
//
//The below picture can clearly show how to traverse a matrix in spiral form.
//Sample Input 1:
//        2
//        3 4 8
//        1 2 3 4
//        5 6 7 8
//        7 9 2 1
//        4 4 10
//        1 2 3 4
//        5 6 7 8
//        9 10 11 12
//        13 14 15 16
//Sample Output 2:
//        9
//        13
//Spiral form traversal of given matrix is -
//        1=> 2=> 3=> 4=> 8=> 1=> 2=> 9=> 7 => 5=> 6 => 7
//
//Hence at the 8'th position element is ‘9’ in spiral form traversal of the given matrix so return the integer ‘9’.

public class SpiralMatrixKPos {

    // Method to find the Kth element in spiral order traversal
    public static int findKthElement(int[][] matrix, int k) {
        int m = matrix.length;    // number of rows
        int n = matrix[0].length; // number of columns

        // Initialize the boundaries of the matrix
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        int count = 0; // This will count the elements visited in spiral order

        // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {

            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                count++;
                if (count == k) return matrix[top][i];
            }
            top++;  // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                count++;
                if (count == k) return matrix[i][right];
            }
            right--;  // Move the right boundary left

            // Traverse from right to left along the bottom row (if still in bounds)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    count++;
                    if (count == k) return matrix[bottom][i];
                }
                bottom--;  // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left column (if still in bounds)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    count++;
                    if (count == k) return matrix[i][left];
                }
                left++;  // Move the left boundary right
            }
        }

        // If k is out of bounds of the matrix, return -1 as an error case
        return -1;
    }

    // Main method to test the code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading matrix dimensions and the matrix itself
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Reading k value
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // Finding the Kth element in spiral order
        int result = findKthElement(matrix, k);

        if (result != -1) {
            System.out.println("The " + k + "th element in spiral order is: " + result);
        } else {
            System.out.println("The value of k is out of bounds.");
        }

        sc.close();
    }
}
