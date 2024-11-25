import java.util.*;

public class MatrixCoverage {

    // Method to calculate the total coverage of all zeros in a binary matrix
    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {
        int N = mat.size();          // Number of rows in the matrix
        int M = mat.get(0).size();   // Number of columns in the matrix
        int totalCoverage = 0;       // Initialize total coverage counter

        // Directions array for checking adjacent cells (up, down, left, right)
        int[][] directions = {
                {-1, 0}, // Up
                {1, 0},  // Down
                {0, -1}, // Left
                {0, 1}   // Right
        };

        // Iterate through each cell in the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // Check if the current cell is zero
                if (mat.get(i).get(j) == 0) {
                    int coverage = 0; // Initialize coverage for this zero

                    // Check all four possible directions for adjacent ones
                    for (int[] dir : directions) {
                        int newRow = i + dir[0]; // Calculate new row index
                        int newCol = j + dir[1]; // Calculate new column index

                        // Check if new indices are within the bounds of the matrix
                        if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                            // If the adjacent cell is a 1, increment coverage
                            if (mat.get(newRow).get(newCol) == 1) {
                                coverage++;
                            }
                        }
                    }
                    // Add the coverage of this zero to the total coverage
                    totalCoverage += coverage;
                }
            }
        }

        return totalCoverage; // Return the total coverage
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of test cases from the user
        System.out.print("Enter number of test cases: ");
        int testCases = scanner.nextInt();

        // Process each test case
        for (int t = 0; t < testCases; t++) {
            // Get matrix dimensions
            System.out.print("Enter number of rows (N) and columns (M) for test case " + (t + 1) + ": ");
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            // Create a new matrix for the current test case
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

            // Input the matrix from user
            System.out.println("Enter the matrix row by row (0s and 1s): ");
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < M; j++) {
                    row.add(scanner.nextInt()); // Add each element to the row
                }
                mat.add(row); // Add the row to the matrix
            }

            // Calculate and print the coverage for the current matrix
            int result = coverageOfMatrix(mat);
            System.out.println("Total coverage of zeros in the matrix: " + result);
        }

        // Close the scanner
        scanner.close();
    }
}
